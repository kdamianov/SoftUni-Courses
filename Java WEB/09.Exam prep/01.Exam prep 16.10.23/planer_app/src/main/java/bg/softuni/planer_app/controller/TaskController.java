package bg.softuni.planer_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskController {

    @GetMapping("/tasks/add")
    public ModelAndView taskAdd(){
        return new ModelAndView("task-add");
    }
}
