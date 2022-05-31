
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.infovi.aricma.controller;

import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import unam.infovi.aricma.model.Empleado;
import unam.infovi.aricma.model.Producto;
import unam.infovi.aricma.service.EmpleadoService;
import unam.infovi.aricma.service.ProductoService;

/**
 *
 * @author Rodrigo
 */

@Controller
@Slf4j
@Service

public class ControladorProductos {
    // Para tener un objeto de tipo PersonaDao ...
    @Inject // Inyectamos la interface de tipo persona dao
    private ProductoService productoService;

    @RequestMapping("/producto")

    public String inicioProducto(Model model, @AuthenticationPrincipal User user) { // Con esta clase agregamos la
                                                                                    // informacion que queremos
                                                                                    // compartir con nuestra vista

        List<Producto> productos = (List<Producto>) productoService.listarProductos();
        log.info("usuario que hizo login: " + user);

        model.addAttribute("productos", productos);

        model.addAttribute("totalProductos", productos.size());

        log.info("Ejecutando el controlador Spring MVC");

        return "producto"; // Mandando a la pagina HTML
    }

    // Dentro del controlador agregamos el resto de rutas a donde el controlador
    // Dirigirá dependiendo el caso, a determinada vista

    // Agregamos el path de agregar
    @GetMapping("/agregarProducto")
    public String agregar(Producto producto) { // SPring inyecta un objeto de tipo persona, no tenemos que crealo
        return "producto"; // Va a realizar las dos funciones
        // Solamente redirige hacia la vista
    }

    @PostMapping("/guardarProducto")
    public String guardar(@Valid Producto producto, Errors errores) { // Y recibimos el path de guardar, dentro de este
                                                                      // metodo en automatico
        if (errores.hasErrors()) {
            // Si la peticion tiene errores, entonces
            return "modificarProducto";
        }

        productoService.guardar(producto);
        return "redirect:/"; // Con esto redireccionamos a la pagina de inicio

        // Con @Valid indicamos que este Objeto esta sujeto a validacion
    }

    @GetMapping("/editarProducto/{idProducto}") // El valor del parametro debe de ser identico al atributo de la clase
                                                // de Persona
    public String editar(Producto producto, Model model) {
        producto = productoService.encontrarProducto(producto); // Este objeto ya tiene el ID

        model.addAttribute("producto", producto);
        return "modificarProducto";
    }

    @GetMapping("/eliminarProducto") // Ya no se le agrega el parametro denro del mapping
    public String eliminar(Producto producto) {
        productoService.eliminar(producto); // Con esta instruccion eliminamos un registro de la BD
        return "redirect:/";
    }

}
