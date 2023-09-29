package com.rest.api.service;



import com.rest.api.entity.Usuario;
import com.rest.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Usuario> getAllUsers(){ return usuarioRepository.findAll(); }

    public Usuario createUser(Usuario user) { return usuarioRepository.save(user); }

    public Usuario getUserById(Integer id) { return usuarioRepository.getReferenceById(id); }

    public Optional<Usuario> updateUser(Integer id, Usuario usuario){
        Optional<Usuario> existsUserById = usuarioRepository.findById(id);

        if (existsUserById.isPresent()){
            Usuario user = existsUserById.get();
            user.setNombre(usuario.getNombre());
            user.setApellido(usuario.getApellido());
            user.setEdad(usuario.getEdad());
            user.setTelefono(usuario.getTelefono());
            user.setCedula(usuario.getCedula());
            user.setDireccion(usuario.getDireccion());

            return Optional.of(usuarioRepository.save(user));
        }
        return Optional.empty();
    }

    public void deleteUser(int id) { usuarioRepository.deleteById(id); }


}
