package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferImportWrapperDto;
import softuni.exam.models.entity.ApartmentType;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static softuni.exam.models.Constants.*;

@Service
public class OfferServiceImpl implements OfferService {
    private static final String OFFERS_FILE_PATH = "src/main/resources/files/xml/offers.xml";
    private final OfferRepository offerRepository;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;
    private final XmlParser xmlParser;

    public OfferServiceImpl(OfferRepository offerRepository,
                            AgentRepository agentRepository,
                            ApartmentRepository apartmentRepository,
                            ModelMapper modelMapper,
                            ValidationUtils validationUtils,
                            XmlParser xmlParser) {
        this.offerRepository = offerRepository;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;

    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        final StringBuilder sb = new StringBuilder();
        this.xmlParser
                .fromFile(Path.of(OFFERS_FILE_PATH).toFile(), OfferImportWrapperDto.class)
                .getOffers()
                .stream()
                .filter(offerImportDto -> {
                    boolean isValid = validationUtils.isValid(offerImportDto);

                    boolean isAgentPresent = agentRepository.findByFirstName(offerImportDto.getAgent().getName()).isPresent();

                    if (!isAgentPresent) {
                        isValid = false;
                    }

                    sb.append(isValid
                                    ? String.format(SUCCESSFUL_FORMAT_OFFERS, OFFER,
                                    offerImportDto.getPrice())
                                    : String.format(INVALID_FORMAT, OFFER))
                            .append(System.lineSeparator());

                    return isValid;

                })
                .map(offerImportDto -> {
                    Offer offer = modelMapper.map(offerImportDto, Offer.class);
                    offer.setAgent(agentRepository.findByFirstName(offerImportDto.getAgent().getName())
                            .orElse(null));
                    offer.setApartment(apartmentRepository.getById(offerImportDto.getApartment().getId()));

                    return offer;
                })
                .forEach(offerRepository::save);

        return sb.toString().trim();
    }

    @Override
    public String exportOffers() {
        final StringBuilder sb = new StringBuilder();

        List<Offer> offersByApartmentType = offerRepository
                .findAllByApartment_ApartmentTypeOrderByApartment_AreaDescPriceAsc(ApartmentType.three_rooms);

        offersByApartmentType
                .forEach(offer -> sb.append(String.format("Agent %s %s with offer №%d:%n" +
                        "  -Apartment area: %.2f%n" +
                        "  --Town: %s%n" +
                        "  ---Price: %.2f$%n",
                        offer.getAgent().getFirstName(),
                        offer.getAgent().getLastName(),
                        offer.getId(),
                        offer.getApartment().getArea(),
                        offer.getApartment().getTown().getTownName(),
                        offer.getPrice()
                )));

        return sb.toString().trim();
    }
}
