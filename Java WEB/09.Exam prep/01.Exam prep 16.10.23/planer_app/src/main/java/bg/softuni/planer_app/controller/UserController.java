package bg.softuni.planer_app.controller;

import bg.softuni.planer_app.model.dto.UserLoginBindingModel;
import bg.softuni.planer_app.model.dto.UserRegisterBindingModel;
import bg.softuni.planer_app.service.UserService;
import bg.softuni.planer_app.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;
    private final LoggedUser loggedUser;

    public UserController(UserService userService,
                          LoggedUser loggedUser) {
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    @ModelAttribute("userRegisterBindingModel")
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute("userLoginBindingModel")
    public UserLoginBindingModel userLoginBindingModel(){
        return new UserLoginBindingModel();
    }

    @GetMapping("/login")
    public ModelAndView login() {
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("login");
    }


    @PostMapping("/login")
    public ModelAndView login(@Valid UserLoginBindingModel userLoginBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute(
                            "org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            return new ModelAndView("redirect:/login");
        }

        boolean hasSuccessfulLogin = userService.login(userLoginBindingModel);

        if (!hasSuccessfulLogin) {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("loginError", true);

            return modelAndView;
        }


        return new ModelAndView("redirect:/home");
    }


    @GetMapping("/register")
    public ModelAndView register() {
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute(
                            "org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return new ModelAndView("redirect:/register");
        }

        boolean hasSuccessfulRegistration = userService.register(userRegisterBindingModel);

        if (!hasSuccessfulRegistration) {
            ModelAndView modelAndView = new ModelAndView("register");
            modelAndView.addObject("registrationError", true);

            return modelAndView;
        }

        return new ModelAndView("redirect:/login");
    }


    @PostMapping("/logout")
    public ModelAndView logout() {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        this.userService.logout();

        return new ModelAndView("redirect:/");
    }
}
