/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio27;

/**
 *
 * @author ClaudissPerez
 */
public class Main {
    public static void main(String[] args) {
        //Creamos una mesa con 5 filosofos
        Mesa mesa = new Mesa(5);
        
        for(int i=0; i<5; i++){
            //Inicia 5 hilos, uno por cada filosofo
            new Filosofo(i, mesa).start();
        }
    }
}
