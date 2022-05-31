/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.infovi.aricma.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import unam.infovi.aricma.model.Empleado;


/**
 *
 * @author gonza
 * Terminado
 */
public interface IEmpleadoDao extends JpaRepository<Empleado, Long> {
    
     
    
    
}
