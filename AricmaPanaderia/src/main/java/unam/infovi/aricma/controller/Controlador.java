/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.infovi.aricma.controller;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import unam.infovi.aricma.model.Persona;
import unam.infovi.aricma.service.PersonaService;

/**
 *
 * @author Chris
 */

//Para que Spring reconozca esta clase se tiene que agregar la anotacion
@Controller
@Slf4j
public class Controlador { //Ya no es necesario extender de servlet
    
   
    
    /*
        Inyectamos la clase de persona service dentro del controlador, para que este pueda
        hacer uso del mismo
    */

    //Para indicarle al navegador que este es el metodo al que se le va a acceder ...
    @RequestMapping("/index")
    public String display(){ //Con esta clase agregamos la informacion que queremos compartir con nuestra vista
        
        
        return "index"; //Mandando a la pagina HTML
    }
    
}
    
   