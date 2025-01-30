/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Usuario
 */
public class Juego {
    private int participantes;
    private Semaphore silla;
    private int jugadores;
    Lock lock = new ReentrantLock();
    Condition empezar = lock.newCondition();
    Condition sentar = lock.newCondition();
    Condition ronda = lock.newCondition();
    
    public Juego(int participantes) {
        this.participantes = participantes;
        this.jugadores =0;
    }
    
    public boolean participal(int idJugador) throws InterruptedException{
        System.out.println("Jugador "+idJugador+" preparado");
        lock.lock();
        jugadores ++;
        //Si soy el ultimo
        if(jugadores == participantes){
            silla = new Semaphore(participantes -1);
            empezar.signal();
        }
        //JUEGO y espero a que se pare la musica para sentarme
        sentar.await();
        boolean conseguido = silla.tryAcquire();
        if(conseguido){
            System.out.println("Jugador "+idJugador+" ha conseguido sentarse");
            //Espero a la siguiente ronda
            ronda.await();
            if(participantes == 1){
                //Ya he ganado, paro de jugar
                System.out.println("Jugador "+idJugador+" ha ganado");
                conseguido=false;
            }  
            silla.release();
        }else{
            System.out.println("Jugador "+idJugador+" no se ha sentado. ¡Eliminado!");
            System.out.println("*****************************************************");
            //El perdedor avisa que la ronda ha acabado y empieza la siguiente
            ronda.signalAll();
            jugadores =0;
            participantes--;
        }
       
        lock.unlock();
        return conseguido;
    }
    
    public void esperarJugadores() throws InterruptedException{
        //Espero a que esten listos para jugar
        lock.lock();
        empezar.await();
        System.out.println("Se inicia música");
        lock.unlock();
    }
    
    public void pararMusica() throws InterruptedException{
        lock.lock();
        Thread.sleep(new Random().nextInt(2, 5));
        System.out.println("Se para música");
        //Se pueden sentar
        sentar.signalAll();
        lock.unlock();
    }
    
    
}
