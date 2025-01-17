/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Usuario
 */
public class Juego {
    private int numeroAAdivinar;
    private Lock lock;
    private boolean numeroAdivinado;

    public Juego(int numero) {
        this.numeroAAdivinar = numero;
        this.lock= new ReentrantLock();
        this.numeroAdivinado = false;
    }
    
    public boolean probarNumero(int idJugador, int numero){
        lock.lock();

        try {
            if(numeroAdivinado){
                return true;
            }
            System.out.println("Jugador "+idJugador+" dice "+numero);
            if (numeroAAdivinar == numero){
                System.out.println("El jugador "+idJugador+" ha acertado. ¡Enhorabuena!");
                numeroAdivinado = true;
                return true;
            }else{
                System.out.println("Ha fallado");
                return false;
            }
        } finally {
            lock.unlock();
        }
    }
    
    public boolean isNumeroAdivinado(){
        return numeroAdivinado;
    }
    
    
}
