/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author Usuario
 */
public class main {
    public static void main(String[] args) {
        Barca barca = new Barca();
        Barquero barquero= new Barquero(barca);
        barquero.start();
        //10 pasajeos
        for(int i =0; i<10; i++){
            new Pasajero(i, barca, barquero).start();
        }
    }
}
