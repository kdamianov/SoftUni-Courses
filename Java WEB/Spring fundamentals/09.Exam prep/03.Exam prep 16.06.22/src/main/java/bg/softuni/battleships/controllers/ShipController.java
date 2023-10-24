package bg.softuni.battleships.controllers;

import bg.softuni.battleships.models.dto.CreateShipDTO;
import bg.softuni.battleships.service.ShipService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShipController {
    private ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @ModelAttribute("createShipDTO")
    public CreateShipDTO createShipDTO(){
        return new CreateShipDTO();
    }

    @GetMapping("/ships/add")
    public String addShip() {
        return "ship-add";
    }

    @PostMapping("/ships/add")
    public String addShip(@Valid  CreateShipDTO createShipDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()|| !this.shipService.create(createShipDTO)) {
            redirectAttributes
                    .addFlashAttribute("createShipDTO", createShipDTO)
                    .addFlashAttribute(
                            "org.springframework.validation.BindingResult.createShipDTO", bindingResult);

            return "redirect:/ships/add";
        }

        return "redirect:/home";
    }
}
