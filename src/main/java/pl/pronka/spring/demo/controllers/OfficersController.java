package pl.pronka.spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pronka.spring.demo.Repo.OfficerRepo;
import pl.pronka.spring.demo.models.Officer;
import pl.pronka.spring.demo.models.Person;

@Controller
@RequestMapping("/officers")
public class OfficersController {
    private OfficerRepo officerRepo;

    @Autowired
    public OfficersController(OfficerRepo officerRepo) {
        this.officerRepo = officerRepo;
    }
    @GetMapping()
    public String index(Model model) {

        model.addAttribute("officer", officerRepo.findAll());

        return "/officers/index";
    }
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("officer") Officer officer){

        return "/officers/new";
    }
    @PostMapping("/add")
    public String create(@ModelAttribute("officer") Officer officer, Model model){
        model.addAttribute("officer",officer);
        officerRepo.save(officer);
        return "redirect:/officers";


    }
    @GetMapping("/delete")
    public String deletePerson(@RequestParam("id") Integer id, Model model){
        officerRepo.deleteById(id);
        model.addAttribute("officer", officerRepo.findAll());

        return "redirect:/officers";
    }
    @GetMapping("/search")
    public String searchPerson(@RequestParam("search") String search, Model model){
        model.addAttribute("officer",officerRepo.findAllBymail(search));
        return "/officers/index";
    }
    @GetMapping("/przekieruj")
    public String przekieruj(@RequestParam("id") Integer id, Model model){
        model.addAttribute("officer", officerRepo.findById(id));
        return "/officers/update";
    }

    @GetMapping("/update")
    public String update(@ModelAttribute("officer") Officer officer, Model model){
        model.addAttribute("officer",officer);
        officerRepo.save(officer);
        return "redirect:/officers";
    }
    @GetMapping("/info")
    public String info(@RequestParam("id") Integer id, Model model){
        model.addAttribute("officer", officerRepo.findById(id));
        return "/officers/addInfo";
    }
    @GetMapping("/addInfo")
    public String addInfo(@ModelAttribute("officer") Officer officer, Model model){
        model.addAttribute("officer", officer);
        officerRepo.save(officer);
        return "redirect:/officers";
    }
}
