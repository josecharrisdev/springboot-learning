package com.jose.curso.spring.app1_demo;

import org.springframework.stereotype.Component;

/* Esto es mi primer componente */
/* @component: Crea un objeto de esta clase y adminístralo tú. Aquí empieza la Inversión de Control. */
@Component
public class MensajeService {
    
    public String obtenerMensaje(){
        return "Este es mi primer ejercicio aprendiendo lo que es la Inversión de Control";
    }
}
