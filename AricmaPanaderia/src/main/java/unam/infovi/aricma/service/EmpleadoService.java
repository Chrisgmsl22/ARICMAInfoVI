/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.infovi.aricma.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unam.infovi.aricma.interfaces.InterfazEmpleado;
import unam.infovi.aricma.model.Empleado;
import unam.infovi.aricma.model.Persona;


/**
 *
 * @author SantillanAngelica
 */
@Service
public interface EmpleadoService {
    
    //Metodos
    public List<Empleado> listarEmpleados();
    
    public void guardar(Empleado empleado);
    
    public void eliminar(Empleado empleado);
    
    public Empleado encontrarEmpleado(Empleado empleado);
}

