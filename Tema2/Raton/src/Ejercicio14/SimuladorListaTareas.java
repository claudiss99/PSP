/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio14;

import java.util.Scanner;

/**
 *
 * @author ClaudissPerez
 */
public class SimuladorListaTareas {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantas tareas se quiere crear:");
        int nTareas= sc.nextInt();
        
        ListaTareas tareas = new ListaTareas();
        Planificador planificador = new Planificador(nTareas);
        Desarrollador desarrollador = new Desarrollador(nTareas);
        
        planificador.start();
//        planificador.join();
        desarrollador.start();
        
        
        desarrollador.join();
        
        System.out.println("Ya no quedan tareas por leer");
    }
}
