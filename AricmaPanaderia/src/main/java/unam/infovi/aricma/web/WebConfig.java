/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.infovi.aricma.web;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 *
 * @author Chris
 */

//Debemos configurar la clase de configuracion para que funcione la internacionalizacion


@Configuration
public class WebConfig implements WebMvcConfigurer{ //Vamos a IMPLEMENTAR mas metodos de esta interface
    
    @Bean //Creamos una instancia del objeto que nos interesa
    public LocaleResolver localeResolver(){
        
        SessionLocaleResolver slr = new SessionLocaleResolver(); //Clases del API de Spring
        slr.setDefaultLocale(new Locale("es")); //Asignamis un idioma al objeto de la clase Locale
        
        return slr;
    }
    
    //Configuramos un interceptor
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        
        //Especificamos el parametro a utilizar para poder cambiar de lenguaje
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang"); //Cuando apuntemos el parametro de lang, hace referencia al lenguaj
        
        return lci;
    }
    
    //registramos el interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());//Cambiamos dinamicamente el lenguaje
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registro){
        
        //Agregamos los paths sin necesidad de un controlador
        registro.addViewController("/").setViewName("index");
        registro.addViewController("/login");
        registro.addViewController("/errors/403").setViewName("/errors/403");
        
        //Este metodose encarga de mapear Paths
    }
}
