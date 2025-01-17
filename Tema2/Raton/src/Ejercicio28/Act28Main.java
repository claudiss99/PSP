/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio28;

/**
 *
 * @author joseg
 */
public class Act28Main {
    public static void main(String[] args) {
        Barberia barberia = new Barberia(10);
        
        Barbero barbero = new Barbero(barberia);
        barbero.setDaemon(true);
        barbero.start();
        
        for (int i = 0; i < 10; i++) {
            new Cliente(i, barberia).start();
        }
    }
}
