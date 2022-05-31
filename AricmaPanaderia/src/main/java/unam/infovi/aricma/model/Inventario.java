/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.infovi.aricma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author maddie
 */
@Data // Framework de Lombok genera el codigo necesario para hacerlo un JavaBean
@Entity // La convertimos en una clase de entidad
@Table(name = "inventario") // Para indicar el nombre exacto de la tabla en la base de datos (relacion)
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L; // Con esto se implementa la interfaz de serializable

    // Mapeo de la llave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventario;

    // Agregamos las notaciones dentro de la clase de entidad para indicar que no
    // son validos los valores nulos

    @NotEmpty
    private String nombre;

    @NotNull
    private Double cantidad;

    @NotEmpty
    private String unidad;

    // @JsonFormat(pattern="yyyy-MMM-dd")
    private String entrada;

    // @JsonFormat(pattern="yyyy-MMM-dd")
    private String salida;

}
