package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.CustomerImportDto;
import exam.model.entity.Customer;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
import exam.util.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static exam.model.Constants.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final String CUSTOMERS_FILE_PATH = "src/main/resources/files/json/customers.json";
    private final CustomerRepository customerRepository;
    private final TownRepository townRepository;
    private final ValidationUtils validationUtils;
    private final Gson gson;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               TownRepository townRepository,
                               ValidationUtils validationUtils,
                               Gson gson,
                               ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.townRepository = townRepository;
        this.validationUtils = validationUtils;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(Path.of(CUSTOMERS_FILE_PATH));
    }

    @Override
    public String importCustomers() throws IOException {
        final StringBuilder sb = new StringBuilder();
        Arrays.stream(gson.fromJson(readCustomersFileContent(), CustomerImportDto[].class))
                .filter(customerImportDto -> {
                    boolean isValid = this.validationUtils.isValid(customerImportDto);

                    boolean isCustomerPresent = this.customerRepository.findByEmail(customerImportDto.getEmail())
                            .isPresent();

                    if (isCustomerPresent) {
                        isValid = false;
                    }

                    sb.append(isValid
                            ? String.format(SUCCESSFUL_FORMAT_CUSTOMERS, CUSTOMER,
                                    customerImportDto.getFirstName(),
                                    customerImportDto.getLastName(),
                                    customerImportDto.getEmail())
                                    : String.format(INVALID_FORMAT, CUSTOMER))
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(customerImportDto -> {
                    Customer customer = this.modelMapper.map(customerImportDto, Customer.class);
                    customer.setTown(this.townRepository.findByName(customerImportDto.getTown().getName()).orElse(null));

                    return customer;
                })
                .forEach(this.customerRepository::save);

        return sb.toString().trim();

    }
}
