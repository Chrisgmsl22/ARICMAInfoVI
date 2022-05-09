/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.infovi.aricma.service;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unam.infovi.aricma.dao.IUsuarioDao;
import unam.infovi.aricma.model.Rol;
import unam.infovi.aricma.model.Usuario;

/**
 *
 * @author Chris
 */

//Indicamos que esta clase sera un bean de tipo servicio
@Service("userDetailsService")
@Slf4j //Para el manejo de logins
public class UsuarioService implements UserDetailsService{

    @Autowired
    private IUsuarioDao usuarioDao;
    
    
    @Override
    @Transactional(readOnly = true) //lOS METODOS DE LAS CLASES DE SERVICIO DEBEN DE SER TRANSACCIONALES
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Quer obtendra el ususario filtrado por un username
        //Agregamos la impl del metodo
        Usuario usuario = usuarioDao.findByUsername(username);
        
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        var roles = new ArrayList<GrantedAuthority>(); //Este tipo de dato necesita Spring para manejar los roles
        
        //Recorremos cada uno de los roles
        for (Rol rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        
        return new User(usuario.getUsername(), usuario.getPassword(), roles); //Regresamos un nuevo objeto de tipo user despues
        //de haberlo regresado
    }
    
}
