package com.jose.ia.spring.capas.EjercicioCapas.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jose.ia.spring.capas.EjercicioCapas.model.Usuario;
import com.jose.ia.spring.capas.EjercicioCapas.service.UsuarioService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuarios() {
        return this.usuarioService.obtenerUsuarios();
    }
    
}
