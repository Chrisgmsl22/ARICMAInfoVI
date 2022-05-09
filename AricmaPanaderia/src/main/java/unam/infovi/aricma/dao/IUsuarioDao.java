/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.infovi.aricma.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import unam.infovi.aricma.model.Usuario;

/**
 *
 * @author Chris
 */
public interface IUsuarioDao extends JpaRepository<Usuario, Long>{
    //Necesitamos definir un metodo necesario
    Usuario findByUsername(String username);
}


/**
 * Vamos a utilzar una inrterfaz que tenga los metodos abstractos de JpaRepository, donde se deben agregar 
 * la clase que se va a trabajar, seguido del tipo de dato de la llave primaria del atributo en su tabla considerando
 * que esta en una BD
 * 
 * debe EXTENDER de JpaRepository y no de CrudRepository como se queria hacer antes, ya que este tiene mejoras en el trabajo
 * 
 * para que una clase pueda extender de una interfaz, entonces debe ser una interfa igualmente
 */