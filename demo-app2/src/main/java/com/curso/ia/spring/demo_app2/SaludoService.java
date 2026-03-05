package com.curso.ia.spring.demo_app2;

import org.springframework.stereotype.Service;

/* @Service le dice a Spring: "Oye, esta clase es un Bean, créala y adminístrala" */
/* Esto se convertiría en un Bean */
@Service
public class SaludoService {
    
    public String saludar(){
        return "Hola, bienvenido a Spring Boot";
    }

}
