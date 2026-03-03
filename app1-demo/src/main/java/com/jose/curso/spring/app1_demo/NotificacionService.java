package com.jose.curso.spring.app1_demo;

import org.springframework.stereotype.Service;

/* Si contiene lógica de negocio se utiliza Service */
@Service
public class NotificacionService {
    
    /* El contenedor IoC se encarga de construir la instancia desde el constructor */
    /* La inyección de realiza por el constructor */
    private final MensajeService mensajeService;

    public NotificacionService(MensajeService mensajeService){
        this.mensajeService = mensajeService;
    }

    public String enviarNotificacion(){
        return mensajeService.obtenerMensaje();
    }
}
