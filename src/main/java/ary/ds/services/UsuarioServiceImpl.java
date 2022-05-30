package ary.ds.services;

import java.sql.SQLException;
import java.util.Optional;

import ary.ds.anotacion.Service;
import ary.ds.models.Usuario;
import ary.ds.repositories.UsuarioRepository;
import jakarta.inject.Inject;

//@ApplicationScoped
@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Inject
    private UsuarioRepository usuarioRepository;

//    public UsuarioServiceImpl(Connection connection) {
//        this.usuarioRepository = new UsuarioRepositoryImpl(connection);
//    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username)).filter(u -> u.getPassword().equals(password));
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
