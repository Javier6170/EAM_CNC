package com.list.list.controller;

import com.list.list.entity.Usuario;
import com.list.list.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    // Obtener todas las categorías
    @GetMapping("/list")
    public List<Usuario> getAllCategorias() {
        return usuarioService.getAllUsers();
    }
}
