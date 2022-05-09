/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.infovi.aricma.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author Chris
 */
@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    @NotEmpty
    @Column
    private String username;
    
    @NotEmpty
    @Column
    private String password;
    
    //Hacemos el mapeo entre la relacion de rol y usuario
    //un Usuario puede tener multiples roles
    
    
    @OneToMany //Primero especificamos el tipo de relacion que se hara
    @JoinColumn(name = "id_usuario")//Seguido se coloca el atributo en comun entre usuario y rol (la FK)
    private List<Rol> roles;//definimos el atributo que almacene los roles asociados a un usuario
    
    
}
