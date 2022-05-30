package ary.ds.repositories;

import java.sql.SQLException;

import ary.ds.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario>{
    Usuario porUsername(String username) throws SQLException;
}
