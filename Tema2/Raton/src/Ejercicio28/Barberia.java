/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio28;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author joseg
 */
public class Barberia {
    private Semaphore salaEspera;
    private Condition clienteCondition;
    private Condition barberoCondition;
    private Lock sillaBarbero;
    private int clientesEsperando;

    public Barberia(int nClientes) {
        clientesEsperando = 0;
        salaEspera = new Semaphore(5);
        sillaBarbero = new ReentrantLock(true);
        clienteCondition = sillaBarbero.newCondition();
        barberoCondition = sillaBarbero.newCondition();
    }
    
    public void barberoEsperandoClientes() throws InterruptedException{
        sillaBarbero.lock();
        try {
            while (clientesEsperando==0){
                System.out.println("El barbero se duerme, esperando a clientes");
                barberoCondition.await();
                System.out.println("El barbero ha sido despertado, pelando a cliente");
            }
        } finally {
            sillaBarbero.unlock();
        }
    }
    
    public void pelarCliente(){
        sillaBarbero.lock();
        try {
            clienteCondition.signal();
            clientesEsperando--;
            System.out.println("Se atiende a un cliente");
        } finally {
            sillaBarbero.unlock();
        }
    }
    
    public boolean haySitio(){
        return salaEspera.tryAcquire();
    }
    
    public void esperoTurno() throws InterruptedException{
        sillaBarbero.lock();
        clientesEsperando++;
        if(clientesEsperando==1){
            barberoCondition.signal();
        }
        clienteCondition.await();
    }
    
    public void clientePelandose(){
        salaEspera.release();
        sillaBarbero.unlock();
    }
    
}
