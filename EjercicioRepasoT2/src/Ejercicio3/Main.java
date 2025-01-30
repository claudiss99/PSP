/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Cuantos jugadores participaran?");
        Scanner sc = new Scanner(System.in);
        int nParticipantes= sc.nextInt();
        
        Juego juego = new Juego(nParticipantes);
        Arbitro arbitro = new Arbitro(juego);
        arbitro.setDaemon(true);
        arbitro.start();
        for(int i=0; i<nParticipantes; i++){
            new Jugador(i, juego).start();
        }
    }
}
