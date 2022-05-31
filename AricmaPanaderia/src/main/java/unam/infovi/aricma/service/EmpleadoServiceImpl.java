/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.infovi.aricma.service;

import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unam.infovi.aricma.dao.IEmpleadoDao;
import unam.infovi.aricma.dao.IPersonaDao;
import unam.infovi.aricma.model.Empleado;
import unam.infovi.aricma.model.Persona;

/**
 *
 * @author gonza
 * Terminado
 */
@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Inject
     private IEmpleadoDao empleadoDao; //Juntamos capa de servicio con la capa de datos

    @Override
    @Transactional(readOnly = true) //Solo es de lectura
    public List<Empleado> listarEmpleados() {
        return (List<Empleado>)empleadoDao.findAll();
        
    }

    @Override
    @Transactional
    public void guardar(Empleado empleado) {
         empleadoDao.save(empleado);
    }

    @Override
    @Transactional
    public void eliminar(Empleado empleado) {
        empleadoDao.delete(empleado);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Empleado encontrarEmpleado(Empleado empleado) {
        return empleadoDao.findById(empleado.getIdEmpleado()).orElse(null);
        //En dado caso de que este metodo no encuentre a la persona por su ID
        //Va a retornar null

    }

}