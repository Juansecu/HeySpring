package com.juansecu.HeySpring;

import java.util.List;
import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.juansecu.HeySpring.domain.Person;

import com.juansecu.HeySpring.services.IPersonService;

@Controller
@Slf4j
public class IndexController {
    @Value("${index.greeting}")
    private String greeting;
    @Autowired
    private IPersonService personService;

    @GetMapping("/")
    public String start(@AuthenticationPrincipal User user, Model model, Person person) {
        var message = "Hello World, with Thymeleaf!";
        Double totalBalanceDue = 0D;
        /* var person1 = new Person();
        var person2 = new Person();
        List<Person> people = Arrays.asList(person1, person2); */
        List<Person> people = this.personService.getPeople();

        /* person1.setFirstName("Juanse");
        person1.setLastName("Coder");
        person1.setEmail("not-reply@juansecu.com");
        person1.setPhone("5544332211");

        person2.setFirstName("Karla");
        person2.setLastName("Gomez");
        person2.setEmail("kgomez@yahoo.com");
        person2.setPhone("9988776655"); */

        log.info("Executing Spring MVC Controller.");
        log.info("User: " + user);
        model.addAttribute("message", message);
        model.addAttribute("greeting", this.greeting);
        // model.addAttribute("person1", person1);
        model.addAttribute("people", people);

        for(Person p : people) totalBalanceDue += p.getBalanceDue();

        model.addAttribute("totalBalanceDue", totalBalanceDue);
        model.addAttribute("totalClients", people.size());

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

    @GetMapping("/remove")
    public String remove(Person person) {
        this.personService.deletePerson(person);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String save(@Valid Person person, Errors errors) {
        if (errors.hasErrors()) return "modify";
        this.personService.savePerson(person);
        return "redirect:/";
    }
}
