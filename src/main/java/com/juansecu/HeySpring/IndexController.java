package com.juansecu.HeySpring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class IndexController {
    @GetMapping("/")
    public String start() {
        log.info("Ejecutando el controlador rest.");
        log.debug("Más detalles del controlador");
        return "Hey World with Spring!!!";
    }
}
