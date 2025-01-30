/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

/**
 *
 * @author Usuario
 */
public class main {
    public static void main(String[] args) {
        Aparcamiento parking = new Aparcamiento();
        
        for(int i=0; i<20;i++){
            new Moto("Moto "+String.valueOf(i), parking).start();
            new Coche("Coche "+String.valueOf(i), parking).start();
        }
    }
}
