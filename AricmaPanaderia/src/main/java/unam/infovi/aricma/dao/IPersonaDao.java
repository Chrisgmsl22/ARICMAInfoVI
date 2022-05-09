/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.infovi.aricma.dao;

import unam.infovi.aricma.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Chris
 */


public interface IPersonaDao extends JpaRepository<Persona, Long>{ //Ya tiene los metodos CRUD, especificamos la clase y el tipo de dato
    //De la llave primaria
    
    
}

/**
 * El extender de CrudRepository hace que podamos acceder a los metodos mas comunes para la las consultas
 * o modificaciones al base de datos Create Read Update Delete
 *
 */
