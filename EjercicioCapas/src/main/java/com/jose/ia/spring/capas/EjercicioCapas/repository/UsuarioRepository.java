package com.jose.ia.spring.capas.EjercicioCapas.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jose.ia.spring.capas.EjercicioCapas.model.Usuario;

@Repository
public class UsuarioRepository {
    
    public List<Usuario> obtenerUsuarios(){
        return Arrays.asList(
            new Usuario(1L, "Juan"),
            new Usuario(2L, "Ana"),
            new Usuario(3L, "Carlos")
        );
    }
}
