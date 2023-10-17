package bg.softuni.battleships.controllers;

import bg.softuni.battleships.models.dto.ShipDTO;
import bg.softuni.battleships.models.dto.StartBattleDTO;
import bg.softuni.battleships.service.ShipService;
import bg.softuni.battleships.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    private final ShipService shipService;
    private LoggedUser loggedUser;

    public HomeController(ShipService shipService, LoggedUser loggedUser) {
        this.shipService = shipService;
        this.loggedUser = loggedUser;
    }

    @ModelAttribute("startBattleDTO")
    public StartBattleDTO initBattleForm(){
        return new StartBattleDTO();
    }
    @GetMapping("/")
    public String loggedOutIndex() {
        return "index";
    }

    @GetMapping("/home")
    public String loggedInHome(Model model) {
        long loggedUserId = loggedUser.getId();
        List<ShipDTO> ownShips = this.shipService.getOwnShips(loggedUserId);
        List<ShipDTO> enemyShips = this.shipService.getOtherShips(loggedUserId);
        List<ShipDTO> sortedShips = this.shipService.getAllSorted();

        model.addAttribute("ownShips", ownShips);
        model.addAttribute("enemyShips", enemyShips);
        model.addAttribute("sortedShips", sortedShips);

        return "home";
    }
}
