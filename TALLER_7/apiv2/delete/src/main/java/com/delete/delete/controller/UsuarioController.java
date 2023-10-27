package com.delete.delete.controller;

import com.delete.delete.entity.Usuario;
import com.delete.delete.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Borrar una categoría por su ID
    @DeleteMapping("/delete/{id}")
    public void deleteCategoria(@PathVariable Integer id) {
        usuarioService.deleteUser(id);
    }
}
