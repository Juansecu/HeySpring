package com.juansecu.HeySpring;

import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.juansecu.HeySpring.services.IPersonService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class IndexController {
    @Value("${index.greeting}")
    private String greeting;
    @Autowired
    private IPersonService personService;

    @GetMapping("/")
    public String start(Model model) {
        var message = "Hello World, with Thymeleaf!";
        /* var person1 = new Person();
        var person2 = new Person();
        List<Person> people = Arrays.asList(person1, person2); */
        Iterable<Person> people = this.personService.getPeople();

        /* person1.setFirstName("Juanse");
        person1.setLastName("Coder");
        person1.setEmail("not-reply@juansecu.com");
        person1.setPhone("5544332211");

        person2.setFirstName("Karla");
        person2.setLastName("Gomez");
        person2.setEmail("kgomez@yahoo.com");
        person2.setPhone("9988776655"); */

        log.info("Executing Spring MVC Controller.");
        model.addAttribute("message", message);
        model.addAttribute("greeting", this.greeting);
        // model.addAttribute("person1", person1);
        model.addAttribute("people", people);

        return "index";
    }

    @GetMapping("/add")
    public String add(Person person) {
        return "modify";
    }

    @GetMapping("/edit/{personId}")
    public String edit(Model model, Person person) {
        person = this.personService.getPerson(person.getPersonId());
        model.addAttribute("person", person);
        return "modify";
    }

    @PostMapping("/save")
    public String save(Person person) {
        this.personService.savePerson(person);
        return "redirect:/";
    }
}
