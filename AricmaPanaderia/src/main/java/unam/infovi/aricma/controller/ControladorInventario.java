/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.infovi.aricma.controller;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import unam.infovi.aricma.model.Inventario;
import unam.infovi.aricma.model.Persona;
import unam.infovi.aricma.service.InventarioService;

/**
 *
 * @author SantillanAngelica
 */


@Controller
@Slf4j
@Service

public class ControladorInventario {
 
     @Autowired
      private InventarioService inventarioService;

      @RequestMapping("/inventario")
 
     public String inicioInventario(Model model, @AuthenticationPrincipal User user){ //Con esta clase agregamos la informacion que queremos compartir con nuestra vista
        
         List<Inventario> inventario = (List<Inventario>) inventarioService.listarInventario();
        log.info("usuario que hizo login: " + user);
        
        model.addAttribute("inventario", inventario);
        log.info("Ejecutando el controlador Spring MVC");
        return "inventario"; //Mandando a la pagina HTML
    }
    
    
    //Dentro del controlador agregamos el resto de rutas a donde el controlador
    //Dirigirá dependiendo el caso, a determinada vista
    
    //Agregamos el path de agregar
    @GetMapping("/agregarInventario")
    public String agregar(Inventario inventario){ //SPring inyecta un objeto de tipo persona, no tenemos que crealo
        return "inventario"; //Va a realizar las dos funciones
        //Solamente redirige hacia la vista
    }
    
    @PostMapping("/guardarInventario")
    public String guardar(@Valid Inventario inventario, Errors errores){ //Y recibimos el path de guardar, dentro de este metodo en automatico
        if (errores.hasErrors()) {
            //Si la peticion tiene errores, entonces
            return "modificarInventario";
        }
        
        inventarioService.guardar(inventario);
        return "redirect:/"; //Con esto redireccionamos a la pagina de inicio
        
        //Con @Valid indicamos que este Objeto esta sujeto a validacion
    }
    
    @GetMapping("/editarInventario/{idInventario}") //El valor del parametro debe de ser identico al atributo de la clase de Persona
    public String editar(Inventario inventario, Model model){
        inventario = inventarioService.encontrarInventario(inventario);
        
       model.addAttribute("inventario", inventario);
        return "modificarInventario";
    }
    
    @GetMapping("/eliminarInventario") //Ya no se le agrega el parametro denro del mapping
    public String eliminar(Inventario inventario){
        inventarioService.eliminar(inventario); //Con esta instruccion eliminamos un registro de la BD
        return "redirect:/";
    }
    
}
    
