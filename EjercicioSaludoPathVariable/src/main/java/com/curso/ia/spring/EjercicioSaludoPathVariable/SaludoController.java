package com.curso.ia.spring.EjercicioSaludoPathVariable;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class SaludoController {

    @GetMapping("/saludar/{name}")
    public String saludar(@PathVariable String name) {
        return "Hola : " + name;
    }
    

}
