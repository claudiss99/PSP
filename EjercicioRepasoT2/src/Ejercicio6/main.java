/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

/**
 *
 * @author Usuario
 */
public class main {
    public static void main(String[] args) {
        Gasolinera gasolinera = new Gasolinera();
    
        for(int i =0; i<30;i++){
            new Vehiculo("Vehiculo "+String.valueOf(i), gasolinera).start();
        }
    }
}
