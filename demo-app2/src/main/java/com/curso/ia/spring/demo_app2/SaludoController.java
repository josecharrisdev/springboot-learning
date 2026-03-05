package com.curso.ia.spring.demo_app2;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/* @RestController → también es un Bean */
@RestController
public class SaludoController {

    /* Spring inyecta automáticamente el Bean SaludoService */
    @Autowired
    private SaludoService saludoService;

    @GetMapping("/saludar")
    public String saludar() {
        return this.saludoService.saludar();
    }
    
}
