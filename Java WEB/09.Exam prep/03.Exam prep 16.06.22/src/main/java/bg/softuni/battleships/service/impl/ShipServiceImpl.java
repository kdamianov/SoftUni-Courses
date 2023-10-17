package bg.softuni.battleships.service.impl;

import bg.softuni.battleships.models.dto.CreateShipDTO;
import bg.softuni.battleships.models.dto.ShipDTO;
import bg.softuni.battleships.models.entity.Category;
import bg.softuni.battleships.models.entity.Ship;
import bg.softuni.battleships.models.entity.User;
import bg.softuni.battleships.models.enums.CategoryNameEnum;
import bg.softuni.battleships.repository.CategoryRepository;
import bg.softuni.battleships.repository.ShipRepository;
import bg.softuni.battleships.repository.UserRepository;
import bg.softuni.battleships.service.ShipService;
import bg.softuni.battleships.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {

    private ShipRepository shipRepository;
    private CategoryRepository categoryRepository;
    private LoggedUser loggedUser;
    private UserRepository userRepository;

    public ShipServiceImpl(ShipRepository shipRepository,
                           CategoryRepository categoryRepository,
                           LoggedUser loggedUser,
                           UserRepository userRepository) {
        this.shipRepository = shipRepository;
        this.categoryRepository = categoryRepository;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    @Override
    public boolean create(CreateShipDTO createShipDTO) {

        //check if name is unique
        Optional<Ship> byName = this.shipRepository.findByName(createShipDTO.getName());

        if (byName.isPresent()) {
            return false;
        }

        CategoryNameEnum type = switch (createShipDTO.getCategory()) {
            case 0 -> CategoryNameEnum.BATTLE;
            case 1 -> CategoryNameEnum.CARGO;
            case 2 -> CategoryNameEnum.PATROL;
            default -> CategoryNameEnum.BATTLE;
        };

        Category category = this.categoryRepository.findByName(type);
        Optional<User> owner = this.userRepository.findById(loggedUser.getId());

        Ship ship = new Ship();
        ship.setName(createShipDTO.getName())
                .setPower(createShipDTO.getPower())
                .setHealth(createShipDTO.getHealth())
                .setCreated(createShipDTO.getCreated())
                .setCategory(category)
                .setUser(owner.get());

        this.shipRepository.save(ship);

        return true;
    }

    @Override
    public List<ShipDTO> getOwnShips(long loggedUserId) {
        return this.shipRepository.findByUserId(loggedUserId)
                .stream()
                .map(ShipDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipDTO> getOtherShips(long loggedUserId) {
        return this.shipRepository.findByUserIdNot(loggedUserId)
                .stream()
                .map(ShipDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipDTO> getAllSorted() {
        return this.shipRepository.findByOrderByHealthAscNameDescPowerAsc()
                .stream()
                .map(ShipDTO::new)
                .collect(Collectors.toList());
    }
}
