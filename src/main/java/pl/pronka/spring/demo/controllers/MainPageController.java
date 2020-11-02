package pl.pronka.spring.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/policeDepartment")
public class MainPageController {
    @GetMapping("")
    public String mainPage(){
        return "/mainPage/startPage";
    }
}
