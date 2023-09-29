package com.rest.api.controller;

import com.rest.api.entity.Usuario;
import com.rest.api.service.UsuarioService;
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

    // Crear una nueva categoría
    @PostMapping("/create")
    public Usuario createCategoria(@RequestBody Usuario categoriaDTO) {
        return usuarioService.createUser(categoriaDTO);
    }

    // Obtener una categoría por su ID
    @GetMapping("getById/{id}")
    public Usuario getCategoriaById(@PathVariable Integer id) {
        return usuarioService.getUserById(id);
    }

    // Actualizar una categoría existente por su ID
    @PutMapping("update/{id}")
    public Optional<Usuario> updateCategoria(@PathVariable Integer id, @RequestBody Usuario usuarioDTO) {
        return usuarioService.updateUser(id, usuarioDTO);
    }

    // Borrar una categoría por su ID
    @DeleteMapping("delete/{id}")
    public void deleteCategoria(@PathVariable Integer id) {
        usuarioService.deleteUser(id);
    }
}
