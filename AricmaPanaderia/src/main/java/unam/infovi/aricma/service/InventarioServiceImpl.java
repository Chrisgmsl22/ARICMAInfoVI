/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.infovi.aricma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unam.infovi.aricma.dao.InventarioDao;
import unam.infovi.aricma.model.Inventario;

/**
 *
 * @author Chris
 */

//Debemos indicarle al framework que esta es una clase de servicio

@Service
public class InventarioServiceImpl implements InventarioService{
    
    @Autowired
    private InventarioDao inventarioDao; //Juntamos capa de servicio con la capa de datos

    //Indicamos que los objetos son transaccionales
    
    @Override
    @Transactional(readOnly = true) //Solo es de lectura
    public List<Inventario> listarInventario() {
        
        return (List<Inventario>)inventarioDao.findAll();
    }

    @Override
    @Transactional //Si va a modificar su estado en la BD, por ende se deja vacio la anotacion de transaccional
    public void guardar(Inventario inventario) {
        inventarioDao.save(inventario);

    }

    @Override
    @Transactional
    public void eliminar(Inventario inventario) {
        inventarioDao.delete(inventario);
    }

    @Override
    @Transactional(readOnly = true)
    public Inventario encontrarInventario(Inventario inventario) {
        return inventarioDao.findById(inventario.getIdInventario()).orElse(null);
        //En dado caso de que este metodo no encuentre a la persona por su ID
        //Va a retornar null

    }
    
}


/**
 * Cuando estamos trabajando con objetos DAO, se hace uso de las transacciones
 */