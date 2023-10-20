package bg.softuni.planer_app.controller;

import bg.softuni.planer_app.model.dto.TaskAddBindingModel;
import bg.softuni.planer_app.model.entity.TaskEntity;
import bg.softuni.planer_app.service.TaskService;
import bg.softuni.planer_app.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class TaskController {
    private final TaskService taskService;
    private final LoggedUser loggedUser;


    public TaskController(TaskService taskService,
                          LoggedUser loggedUser) {
        this.taskService = taskService;
        this.loggedUser = loggedUser;
    }


    @ModelAttribute("taskAddBindingModel")
    public TaskAddBindingModel taskAddBindingModel() {
        return new TaskAddBindingModel();
    }

    @GetMapping("/tasks/add")
    public ModelAndView taskAdd(){
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("task-add");
    }

    @PostMapping("/tasks/add")
    public ModelAndView taskAdd(@Valid TaskAddBindingModel taskAddBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("taskAddBindingModel", taskAddBindingModel)
                    .addFlashAttribute(
                            "org.springframework.validation.BindingResult.taskAddBindingModel", bindingResult);

            return new ModelAndView("task-add");
        }


        taskService.add(taskAddBindingModel);

        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/tasks/return/{id}")
    public ModelAndView taskReturn(@PathVariable("id") Long id){
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        taskService.assign(id, null);

        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/tasks/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        taskService.remove(id);

        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/tasks/assign/{id}")
    public ModelAndView assignReturn(@PathVariable("id") Long id){
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        taskService.assign(id, loggedUser.getUsername());

        return new ModelAndView("redirect:/home");
    }
}
