/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio27;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author ClaudissPerez
 */
public class Mesa {
    //Candado para poder comer 
    private Lock tenedoresLock;
    //Array para verificar si los tenedores necesarios estan disponibles
    private boolean[] tenedoresLibres;
    //Para poder esperar si es necesario y notificar
    private Condition tenedoresCondition;
    
    public Mesa(int nFilosofos){
        tenedoresLock = new ReentrantLock(true);
        tenedoresCondition = tenedoresLock.newCondition();
        tenedoresLibres = new boolean[nFilosofos];
        //Inicializamos todos los tenedores como libres
        Arrays.fill(tenedoresLibres, true);
        
    }
    
    public void cogerTenedores(int id) throws InterruptedException{
        int tenedorIzq = id;
        //Para la posicion circular
        int tenedorDer = (id+1)%tenedoresLibres.length;
        
        tenedoresLock.lock();
        try{
            while(!tenedoresLibres[tenedorIzq] || !tenedoresLibres[tenedorDer]){
                //Espera a que ambos tenedores estén libres
                tenedoresCondition.await();
            }
            
            tenedoresLibres[tenedorIzq] = false;
            tenedoresLibres[tenedorDer] = false;
        }finally{
            tenedoresLock.unlock();
        }
    }
    
    public void soltarTenedores(int id){
        int tenedorIzq = id;
        int tenedorDer = (id+1)%tenedoresLibres.length;
        
        tenedoresLock.lock();
        try{
            tenedoresLibres[tenedorIzq] = true;
            tenedoresLibres[tenedorDer] = true;
            //Notifica a los filosofos que estan esperando
            tenedoresCondition.signalAll();
        }finally{
            tenedoresLock.unlock();
        }
    }
    
}
