/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.infovi.aricma.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import lombok.Data;

//Nuevas importaciones
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Chris
 */
@Data //Framework de Lombok genera el codigo necesario para hacerlo un JavaBean
@Entity//La convertimos en una clase de entidad
@Table(name = "persona") //Para indicar el nombre exacto de la tabla en la base de datos (relacion)
public class Persona implements Serializable{
    
    private static final long serialVersionUID = 1L; //Con esto se implementa la interfaz de serializable
    
    //Mapeo de la llave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    
    //Agregamos las notaciones dentro de la clase de entidad para indicar que no son validos los valores nulos
    
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String apellido;
    
    @NotEmpty
    @Email
    private String email;
    
    @NotEmpty //Para cadenas
    private String telefono;
    
    @NotNull //Para números
    
    private Double saldo;
}

/**
 * Nos encargamos de hacer una clase de Entidad, con sus anotaciones referentes
 * 
 * agregaremos el concepto de validaciones
 */
