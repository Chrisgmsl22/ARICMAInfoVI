/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.infovi.aricma.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Chris
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{ //Para poder configurar los usuarios que vamos a utilizar
    
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        //Personalizamos el metodo para agregar usuarios 
//        auth.inMemoryAuthentication().withUser("admin").password("{noop}123456789").roles("ADMIN", "USER")
//                .and().withUser("ChrisGMag22").password("{noop}#CheeriosBW4").roles("USER");
//    }
    @Autowired
    private UserDetailsService userDetailsService;
    
    //Definimos el tipo de encripcion que vamos a utilizar
    //@Bean TO-DO
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    //Implementamos la interfaz de userDetails y el BCrypt
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
        //De manera asutomatica ya podemos trabajar con nuestro objeto
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        //Podemos construir las URLS a restringir
        http.authorizeHttpRequests().antMatchers("/editar/**", "/agregar/**", "/eliminar").hasRole("ADMIN")
                .antMatchers("/").hasAnyRole("USER", "ADMIN").and().formLogin().loginPage("/login")
                .and().exceptionHandling().accessDeniedPage("/errors/403");
    }
    
}
/**
 * Esta clase es para modificar la seguridfad en la app
 */
