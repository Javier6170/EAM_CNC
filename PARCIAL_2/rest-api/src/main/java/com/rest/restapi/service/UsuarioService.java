package com.rest.restapi.service;


import com.rest.restapi.entity.Usuario;
import com.rest.restapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private  UsuarioRepository usuarioRepository;


    public List<Usuario> getAllUsers(){ return usuarioRepository.findAll(); }

    public Usuario createUser(Usuario user) { return usuarioRepository.save(user); }

    public Usuario getUserById(Integer id) { return usuarioRepository.getReferenceById(id); }

    public Optional<Usuario> updateUser(Integer id, Usuario usuario){
        Optional<Usuario> existsUserById =usuarioRepository.findById(id);
        if (existsUserById.isPresent()){
            usuario.setNombre(usuario.getNombre());
            usuario.setApellido(usuario.getApellido());
            usuario.setEdad(usuario.getEdad());
            usuario.setEmail(usuario.getEmail());
            usuario.setTelefono(usuario.getTelefono());
            usuario.setCedula(usuario.getCedula());
            usuario.setDireccion(usuario.getDireccion());

            return Optional.of(usuarioRepository.save(usuario));
        }
        return Optional.empty();
    }

    public void deleteUser(int id) { usuarioRepository.deleteById(id); }


}
