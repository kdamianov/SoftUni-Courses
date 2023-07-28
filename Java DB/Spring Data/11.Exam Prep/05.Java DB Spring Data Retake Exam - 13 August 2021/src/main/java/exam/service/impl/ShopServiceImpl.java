package exam.service.impl;

import exam.model.dto.ShopImportWrapperDto;
import exam.model.entity.Shop;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
import exam.util.ValidationUtils;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static exam.model.Constants.*;

@Service
public class ShopServiceImpl implements ShopService {
    private static final String SHOPS_FILE_PATH = "src/main/resources/files/xml/shops.xml";
    private final ShopRepository shopRepository;
    private final TownRepository townRepository;
    private final ValidationUtils validationUtils;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public ShopServiceImpl(ShopRepository shopRepository,
                           TownRepository townRepository,
                           ValidationUtils validationUtils,
                           ModelMapper modelMapper,
                           XmlParser xmlParser) {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOPS_FILE_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        final StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(Path.of(SHOPS_FILE_PATH).toFile(), ShopImportWrapperDto.class)
                .getShops()
                .stream()
                .filter(shopImportDto -> {
                    boolean isValid = validationUtils.isValid(shopImportDto);

                    boolean isShopPresent = shopRepository.findByName(shopImportDto.getName()).isPresent();

                    if (isShopPresent) {
                        isValid = false;
                    }

                    sb.append(isValid
                                    ? String.format(SUCCESSFUL_FORMAT_SHOPS, SHOP,
                                    shopImportDto.getName(), shopImportDto.getIncome())
                                    : String.format(INVALID_FORMAT, SHOP))
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(shopImportDto -> {
                    Shop shop = modelMapper.map(shopImportDto, Shop.class);
                    shop.setTown(townRepository.findByName(shopImportDto.getTown().getName()).orElse(null));

                    return shop;
                })
                .forEach(shopRepository::save);

        return sb.toString().trim();
    }
}
