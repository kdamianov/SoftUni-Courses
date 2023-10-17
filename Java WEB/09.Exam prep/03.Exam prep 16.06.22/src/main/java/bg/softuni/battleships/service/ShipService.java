package bg.softuni.battleships.service;

import bg.softuni.battleships.models.dto.CreateShipDTO;
import bg.softuni.battleships.models.dto.ShipDTO;

import java.util.List;

public interface ShipService {
    boolean create(CreateShipDTO createShipDTO);

    List<ShipDTO> getOwnShips(long loggedUserId);

    List<ShipDTO> getOtherShips(long loggedUserId);

    List<ShipDTO> getAllSorted();
}
