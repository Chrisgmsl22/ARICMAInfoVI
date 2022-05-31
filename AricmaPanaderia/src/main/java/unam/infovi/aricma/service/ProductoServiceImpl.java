/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.infovi.aricma.service;

import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unam.infovi.aricma.dao.IProductoDao;
import unam.infovi.aricma.model.Producto;
/**
 *
 * @author gonza
 * Terminado
 */
@Service
public class ProductoServiceImpl implements ProductoService {
    @Inject
     private IProductoDao productoDao; //Juntamos capa de servicio con la capa de datos

    @Override
    @Transactional(readOnly = true) //Solo es de lectura
    public List<Producto> listarProductos() {
        return (List<Producto>)productoDao.findAll();

        
    }

    @Override
    @Transactional
    public void guardar(Producto producto) {
         productoDao.save(producto);
    }

    @Override
    @Transactional
    public void eliminar(Producto producto) {
        productoDao.delete(producto);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Producto encontrarProducto(Producto producto) {
      return productoDao.findById(producto.getIdProducto()).orElse(null);    
    }

}