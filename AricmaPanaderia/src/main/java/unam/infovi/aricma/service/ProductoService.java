/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unam.infovi.aricma.service;

import java.util.List;
import unam.infovi.aricma.model.Producto;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unam.infovi.aricma.dao.IProductoDao;

/**
 *
 * @author rodrigo
 */
public interface ProductoService {

    // Metodos
    public List<Producto> listarProductos();

    public void guardar(Producto producto);

    public void eliminar(Producto producto);

    public Producto encontrarProducto(Producto producto);

}