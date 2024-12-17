/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime cuantos jugadores van a jugar");
        int jugadores = sc.nextInt();
        
        int numero = new Random().nextInt(1, 11);
        System.out.println("Número a adivinar: "+numero);
        Juego juego = new Juego(numero);
        for(int i=0; i<jugadores; i++){
            new Jugadores(i, juego).start();
        }
    }
}
