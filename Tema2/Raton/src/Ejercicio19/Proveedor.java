/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio19;

/**
 *
 * @author ClaudissPerez
 */
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Proveedor extends Thread {
    private final int ingredienteId;
    private final Lock lock;
    private final Condition condition;
    private boolean entregado = false;

    public Proveedor(int ingredienteId, Lock lock, Condition condition) {
        this.ingredienteId = ingredienteId;
        this.lock = lock;
        this.condition = condition;
    }

    public void entregarIngrediente() {
        lock.lock();
        try {
            Random random = new Random();
            int tiempoEntrega = random.nextInt(2000, 4000);
            System.out.println("Proveedor de " + nombreIngrediente() + " está entregando (tardará " + tiempoEntrega + "ms)");
            Thread.sleep(tiempoEntrega);
            entregado = true;
            System.out.println("Proveedor de " + nombreIngrediente() + " ha entregado.");
            condition.signal(); // Notifica al repostero
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public boolean isEntregado() {
        lock.lock();
        try {
            return entregado;
        } finally {
            lock.unlock();
        }
    }

    private String nombreIngrediente() {
        return switch (ingredienteId) {
            case 1 -> "HARINA";
            case 2 -> "AZÚCAR";
            case 3 -> "HUEVOS";
            default -> "DESCONOCIDO";
        };
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000); // Simula estar disponible
            } catch (InterruptedException e) {
                System.out.println("Proveedor de " + nombreIngrediente() + " interrumpido.");
                break;
            }
        }
    }

    public int getIngredienteId() {
        return ingredienteId;
    }

    public void resetEntregado() {
        lock.lock();
        try {
            entregado = false; // Resetear el estado después de cada entrega
        } finally {
            lock.unlock();
        }
    }
}
