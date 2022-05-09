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
    
    
    
    //Para tener un objeto de tipo PersonaDao ...
    @Autowired //Inyectamos la interface de tipo persona dao
    private PersonaService personaService;
    
    /*
        Inyectamos la clase de persona service dentro del controlador, para que este pueda
        hacer uso del mismo
    */

    //Para indicarle al navegador que este es el metodo al que se le va a acceder ...
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){ //Con esta clase agregamos la informacion que queremos compartir con nuestra vista
        
        List<Persona> personas = (List<Persona>) personaService.listarPersonas();
        log.info("usuario que hizo login: " + user);
        
        model.addAttribute("personas", personas);
        
        Double saldoTotal = 0D; //Variable temporal para ir almacenando el saldo de cada una de las personas
        
        for (var persona : personas) {
            saldoTotal += persona.getSaldo();
        } //Iteramos en cada uno del saldo de las personas
        
        
        //Compartimos la variable por medio del objeto model
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personas.size());
        
        
        log.info("Ejecutando el controlador Spring MVC");
        
        
        return "index"; //Mandando a la pagina HTML
    }
    
    
    //Dentro del controlador agregamos el resto de rutas a donde el controlador
    //Dirigirá dependiendo el caso, a determinada vista
    
    //Agregamos el path de agregar
    @GetMapping("/agregar")
    public String agregar(Persona persona){ //SPring inyecta un objeto de tipo persona, no tenemos que crealo
        return "modificar"; //Va a realizar las dos funciones
        //Solamente redirige hacia la vista
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){ //Y recibimos el path de guardar, dentro de este metodo en automatico
        if (errores.hasErrors()) {
            //Si la peticion tiene errores, entonces
            return "modificar";
        }
        
        personaService.guardar(persona);
        return "redirect:/"; //Con esto redireccionamos a la pagina de inicio
        
        //Con @Valid indicamos que este Objeto esta sujeto a validacion
    }
    
    @GetMapping("/editar/{idPersona}") //El valor del parametro debe de ser identico al atributo de la clase de Persona
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona); //Este objeto ya tiene el ID
        
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar") //Ya no se le agrega el parametro denro del mapping
    public String eliminar(Persona persona){
        personaService.eliminar(persona); //Con esta instruccion eliminamos un registro de la BD
        return "redirect:/";
    }
    
}


/**
 * En lugar de inyectar una clase concreta, lo que se hace es inyectar una clase de tipo servicio
 */