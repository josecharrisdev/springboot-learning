package com.jose.ia.spring.capas.EjercicioCapas.integration;

import org.springframework.stereotype.Component;

@Component
public class NotificacionCliente {
    public void enviarNotificacion(String mensaje) {
        System.out.println("Notificación enviada: " + mensaje);
    }
}
