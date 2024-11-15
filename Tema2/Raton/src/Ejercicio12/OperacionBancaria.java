/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio12;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class OperacionBancaria {
    public static void main(String[] args) {
        int aleat = new Random().nextInt(30,61);
        //Se ha introducido aquí el saldo, porque no sabía si estaba bien introducirlo en cuenta, y como asignarlo
        Cuenta c = new Cuenta(aleat);
        Persona p1 = new Persona("Claudia", c);
        Persona p2 = new Persona("Adrían", c);
        
        p1.start();
        p2.start();
        
        
        
    }
    
}
