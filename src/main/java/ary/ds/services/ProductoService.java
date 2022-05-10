package ary.ds.services;

import java.util.List;
import java.util.Optional;

import ary.ds.models.Categoria;
import ary.ds.models.Producto;

public interface ProductoService {
    List<Producto> listar();

    Optional<Producto> porId(Long id);

    void guardar(Producto producto);

    void eliminar(Long id);

    List<Categoria> listarCategoria();

    Optional<Categoria> porIdCategoria(Long id);
}
