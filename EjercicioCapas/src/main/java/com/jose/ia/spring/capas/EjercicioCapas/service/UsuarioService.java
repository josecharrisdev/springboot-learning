package com.jose.ia.spring.capas.EjercicioCapas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jose.ia.spring.capas.EjercicioCapas.integration.NotificacionCliente;
import com.jose.ia.spring.capas.EjercicioCapas.model.Usuario;
import com.jose.ia.spring.capas.EjercicioCapas.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepository;
    private final NotificacionCliente notificacionCliente;

    public UsuarioService(UsuarioRepository usuarioRepository, NotificacionCliente notificacionCliente){
        this.usuarioRepository = usuarioRepository;
        this.notificacionCliente = notificacionCliente;
    }

    public List<Usuario> obtenerUsuarios(){
        List<Usuario> usuarios = this.usuarioRepository.obtenerUsuarios();
        this.notificacionCliente.enviarNotificacion("Consulta de usuarios realizada");
        return usuarios;
    }
}
