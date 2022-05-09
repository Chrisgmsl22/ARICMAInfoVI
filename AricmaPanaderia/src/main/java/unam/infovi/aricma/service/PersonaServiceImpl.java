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
import unam.infovi.aricma.dao.IPersonaDao;
import unam.infovi.aricma.model.Persona;

/**
 *
 * @author Chris
 */

//Debemos indicarle al framework que esta es una clase de servicio

@Service
public class PersonaServiceImpl implements PersonaService{
    
    @Autowired
    private IPersonaDao personaDao; //Juntamos capa de servicio con la capa de datos

    //Indicamos que los objetos son transaccionales
    
    @Override
    @Transactional(readOnly = true) //Solo es de lectura
    public List<Persona> listarPersonas() {
        return (List<Persona>)personaDao.findAll();
    }

    @Override
    @Transactional //Si va a modificar su estado en la BD, por ende se deja vacio la anotacion de transaccional
    public void guardar(Persona persona) {
        personaDao.save(persona);

    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null);
        //En dado caso de que este metodo no encuentre a la persona por su ID
        //Va a retornar null

    }
    
}


/**
 * Cuando estamos trabajando con objetos DAO, se hace uso de las transacciones
 */