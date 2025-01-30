/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio7;

/**
 *
 * @author Usuario
 */
public class Principal {
    public static void main(String[] args) {
        //Socorrista es un demonio
        Piscina piscina = new Piscina();
        Socorrista socorrista = new Socorrista(piscina);
        socorrista.setDaemon(true);
        socorrista.start();
        for(int i=0; i<10; i++){
            new Persona("Persona "+String.valueOf(i), piscina).start();
        }
    }
}
