/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.infovi.aricma.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unam.infovi.aricma.interfaces.InterfazEmpleado;
import unam.infovi.aricma.model.Inventario;


/**
 *
 * @author Chris
 */


public interface InventarioService {
   // public class EmpleadoService implements IpersonaService
     
    //Metodos
    public List<Inventario> listarInventario();
    
    public void guardar(Inventario inventario);
    
    public void eliminar(Inventario inventario);
    
    public Inventario encontrarInventario(Inventario inventario);
}

/**
 * Esta es una interfaz
 */