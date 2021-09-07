package com.juansecu.HeySpring;

import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.juansecu.HeySpring.daos.IPersonDao;

@Controller
@Slf4j
public class IndexController {
    @Value("${index.greeting}")
    private String greeting;
    @Autowired
    private IPersonDao personDao;

    @GetMapping("/")
    public String start(Model model) {
        var message = "Hola Mundo con Thymeleaf.";
        /* var person1 = new Person();
        var person2 = new Person();
        List<Person> people = Arrays.asList(person1, person2); */
        Iterable<Person> people = this.personDao.findAll();

        /* person1.setFirstName("Juanse");
        person1.setLastName("Coder");
        person1.setEmail("not-reply@juansecu.com");
        person1.setPhone("5544332211");

        person2.setFirstName("Karla");
        person2.setLastName("Gomez");
        person2.setEmail("kgomez@yahoo.com");
        person2.setPhone("9988776655"); */

        log.info("Ejecutando el controlador de tipo Spring MVC.");
        model.addAttribute("message", message);
        model.addAttribute("greeting", this.greeting);
        // model.addAttribute("person1", person1);
        model.addAttribute("people", people);

        return "index";
    }
}
