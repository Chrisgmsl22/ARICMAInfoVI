package unam.infovi.aricma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Notacion que hace referencia a que es una aplicacion de Spring Boot
public class PanaderiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PanaderiaApplication.class, args);
	}
        /**
         *  Esta es el "main" de la aplicación Spring Boot, aqui se cargará
         * la misma de manera que se va a ejecutar en el momento que se levante 
         * la aplicación.
         * 
         * EL namespace llamado "unam.infovi.aricma" hace referencia al Group ID
         * que se pide con el initializer de Spring, es decir que este es el nombre
         * del grupo del equipo o la organizacion con el que estamos trabajando
         * 
         * Y lo seccionamos en unam, mismo que dentro tiene la asignatura infoVi
         * y que dentro contiene al equipo de aricma, el cual contiene el resto de 
         * paquetes / capas
         */

}
