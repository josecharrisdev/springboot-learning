package com.jose.curso.spring.app1_demo;

import org.springframework.stereotype.Component;

@Component
public class NotificacionService {
    
    private final MensajeService mensajeService;

    public NotificacionService(MensajeService mensajeService){
        this.mensajeService = mensajeService;
    }

    public String enviarNotificacion(){
        return mensajeService.obtenerMensaje();
    }
}
