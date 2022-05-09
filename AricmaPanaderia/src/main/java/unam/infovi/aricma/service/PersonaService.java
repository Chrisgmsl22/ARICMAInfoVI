/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.infovi.aricma.service;

import java.util.List;
import unam.infovi.aricma.model.Persona;

/**
 *
 * @author Chris
 */
public interface PersonaService {
    
    //Metodos
    public List<Persona> listarPersonas();
    
    public void guardar(Persona persona);
    
    public void eliminar(Persona persona);
    
    public Persona encontrarPersona(Persona persona);
}

/**
 * Esta es una interfaz
 */
