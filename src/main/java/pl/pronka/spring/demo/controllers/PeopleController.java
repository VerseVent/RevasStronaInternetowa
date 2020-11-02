package pl.pronka.spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pronka.spring.demo.Repo.PersonRepo;
import pl.pronka.spring.demo.dao.PersonDAO;
import pl.pronka.spring.demo.models.Person;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {
//    final PersonDAO personDAO;
    private PersonRepo personRepo;

//    @Autowired
//    public PeopleController(PersonDAO personDAO) {
//        this.personDAO = personDAO;
//    }
    @Autowired
    public PeopleController(PersonRepo personRepo){
        this.personRepo=personRepo;
    }

    @GetMapping()
    public String index(Model model){

            model.addAttribute("person", personRepo.findAll());

        return "/people/index";
    }
    @GetMapping("/allPeople")
    public String allPeople(Model model){
        int i=0;
        for (Person people : personRepo.findAll()) {
            System.out.println(people);
        }

        model.addAttribute("people", personRepo.findAll());

        return "/people/allPeople";
    }
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id,Model model){
//        model.addAttribute("person",personRepo.findById(id));
//        return "/people/show";
//    }
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){

        return "/people/new";
    }
    @PostMapping("/add")
    public String create(@ModelAttribute("person") Person person, Model model){
        model.addAttribute("person",person);
//        if(checkNotEmpty(person)){
            personRepo.save(person);
            return "redirect:/people";
       // }
        // else{
        //   return "/maciej/error";
        //}

    }
    @GetMapping("/delete")
    public String deletePerson(@RequestParam("id") Integer id, Model model){
        personRepo.deleteById(id);
        model.addAttribute("person", personRepo.findAll());

        return "redirect:/people";
    }
    @GetMapping("/search")
    public String searchPerson(@RequestParam("search") String search, Model model){
        model.addAttribute("person",personRepo.findAllBymail(search));
        return "/people/index";
    }
    @GetMapping("/przekieruj")
    public String przekieruj(@RequestParam("id") Integer id, Model model){
        model.addAttribute("person", personRepo.findById(id));
        return "/people/update";
   }
//    @GetMapping("/update")
//    public String update(
//        @RequestParam("id") Integer id,
//        @RequestParam("name") String name,
//        @RequestParam("surname") String surname,
//        @RequestParam("phone") String phone,
//        @RequestParam("mail") String mail,
//        @RequestParam("description") String description, Model model)
//       throws Exception {
//            Person person = new Person(id, name, surname, phone, mail, description, true);
//            System.out.println(person);
//            personRepo.save(person);
//            model.addAttribute("person", person);
//            return "redirect:/people";
//
//        }
@GetMapping("/update")
public String update(@ModelAttribute("person") Person person, Model model){
    model.addAttribute("person",person);
    personRepo.save(person);
    return "redirect:/people";
    }

    @GetMapping("/test")
        public String test(Model model){
        model.addAttribute("test","!Test Thymeleaf!");
        return "/maciej/test";
    }
   private boolean checkNotEmpty(Person person) {
       return (person.getName()!=null && person.getName().length()>2) &&( person.getPhone()!=null && person
               .getPhone().length()>5)&&(person.getMail()!=null && person
               .getMail().length()>5)&&(person.getDescription()!=null && person.getDescription().length()<2048);
   }

}
