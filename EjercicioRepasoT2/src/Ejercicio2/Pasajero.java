/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author Usuario
 */
public class Pasajero extends Thread{
    private int id;
    private Barca barca;
    private Barquero barquero;

    public Pasajero(int id, Barca barca, Barquero barquero) {
        this.id = id;
        this.barca = barca;
        this.barquero = barquero;
    }
    
    @Override
    public void run(){
        barca.subePasajero(id);
    }
    
}
