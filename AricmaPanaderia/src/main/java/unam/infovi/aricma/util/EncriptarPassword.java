/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.infovi.aricma.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Chris
 */
public class EncriptarPassword {
     //Esta clase es un metodo main
    public static void main(String[] args) {
       
        
        String password = "#hhh22";
        System.out.println("password sin encryptar= " + password);
        System.out.println("password encriptado= " + encriptarPassword(password));
    }
    
    //Metodo para encriptar
    public static String encriptarPassword(String password){
        
         //Alrogitmo a usar de Spring
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
