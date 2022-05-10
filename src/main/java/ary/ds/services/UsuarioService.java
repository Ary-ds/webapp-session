package ary.ds.services;

import java.util.Optional;

import ary.ds.models.Usuario;

public interface UsuarioService {
    Optional<Usuario> login(String username, String password);
}
