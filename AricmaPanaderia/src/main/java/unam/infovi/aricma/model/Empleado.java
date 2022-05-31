/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ItzelGonzalez
 * Terminado
 */
package unam.infovi.aricma.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    
//Mapeo llave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
    private Long idEmpleado;
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String apellido;
   
    @NotEmpty
    private String numCelular;
    
    private String numCasa;
    
    @NotEmpty
    private String direccion;
   
    
    private String contactoEmergencia;
   
    @NotEmpty
    private String puesto;
    
    @NotNull
    double salario;

    
}
