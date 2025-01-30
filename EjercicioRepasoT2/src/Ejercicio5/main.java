/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

/**
 *
 * @author Usuario
 */
public class main {
    public static void main(String[] args) {
        Laberinto laberinto = new Laberinto();
        
        for (int i =0; i<15; i++){
            new Persona("Persona "+String.valueOf(i), laberinto).start();
        }
    }
}
