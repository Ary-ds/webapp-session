package ary.ds.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import ary.ds.anotacion.ProductoServicePrincipal;
import ary.ds.anotacion.Service;
import ary.ds.models.Categoria;
import ary.ds.models.Producto;
import ary.ds.repositories.CrudRepository;
import jakarta.inject.Inject;

//@ApplicationScoped
@Service
@ProductoServicePrincipal
public class ProductoServiceJdbcImpl implements ProductoService{
	
	@Inject
    private CrudRepository<Producto> repositoryJdbc;
	
	@Inject
    private CrudRepository<Categoria> repositoryCategoriaJdbc;

//    public ProductoServiceJdbcImpl(Connection connection) {
//        this.repositoryJdbc = new ProductoRepositoryJdbcImpl(connection);
//        this.repositoryCategoriaJdbc = new CategoriaRepositoryImpl(connection);
//    }

    
    @Override
    public List<Producto> listar() {
        try {
            return repositoryJdbc.listar();
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbc.porId(id));
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());

        }
    }

    @Override
    public void guardar(Producto producto) {
        try {
            repositoryJdbc.guardar(producto);
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            repositoryJdbc.eliminar(id);
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public List<Categoria> listarCategoria() {
        try {
            return repositoryCategoriaJdbc.listar();
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        try {
            return Optional.ofNullable(repositoryCategoriaJdbc.porId(id));
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
