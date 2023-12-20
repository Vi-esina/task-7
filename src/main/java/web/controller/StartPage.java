package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.Person;
import web.service.PersonService;

import java.util.List;

@Controller
public class StartPage {

    @Autowired
    PersonService personService;


    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<Person> allPerson = personService.listPerson();
        model.addAttribute("messages", allPerson);
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("person", new Person());
        return "addPerson";
    }

    @PostMapping("/add")
    public String addPerson(@ModelAttribute Person person) {
        personService.add(person);
        return "addPerson";

    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("person", personService.getPerson(id));
        return "updatePerson";
    }

    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable Long id, @ModelAttribute Person person) {
        personService.updatePerson(person);
        return "updatePerson";

    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        personService.deletePerson(id);
        return "redirect:/";
    }


}