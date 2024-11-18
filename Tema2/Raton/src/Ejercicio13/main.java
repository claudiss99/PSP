/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio13;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ClaudissPerez
 */
public class main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce cuantos ratones hay:");
        int nRatones = sc.nextInt();
        ArrayList<RatonHilo> ratones = new ArrayList<>();
        Comedero comedero = new Comedero(0);
        for(int i=0; i<nRatones; i++){
            String nombre = "Raton "+Integer.toString(i);
            RatonHilo raton = new RatonHilo(nombre, 3, comedero);
            raton.start();
            ratones.add(raton);
        }
        
        for(RatonHilo rH: ratones){
            rH.join();
        }
        
        
        System.out.println("Total comida consumida: "+comedero.getComidaConsumida());
    }
}
