/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio19;

/**
 *
 * @author ClaudissPerez
 */

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pasteleria {
    public static void main(String[] args) {
        // Crear Lock y Condition para sincronización
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        // Crear y lanzar proveedores
        Proveedor proveedorHarina = new Proveedor(1, lock, condition);
        Proveedor proveedorAzucar = new Proveedor(2, lock, condition);
        Proveedor proveedorHuevos = new Proveedor(3, lock, condition);

        proveedorHarina.start();
        proveedorAzucar.start();
        proveedorHuevos.start();

        // Repostero
        Thread repostero = new Thread(() -> {
            try {
                while (true) {
                    // Elegir dos ingredientes al azar
                    int ing1 = ThreadLocalRandom.current().nextInt(1, 4);
                    int ing2;
                    do {
                        ing2 = ThreadLocalRandom.current().nextInt(1, 4);
                    } while (ing1 == ing2);

                    // Determinar ingrediente faltante
                    int faltante = 6 - (ing1 + ing2);

                    System.out.println("Repostero tiene " + nombreIngrediente(ing1) + " y " + nombreIngrediente(ing2)
                            + ". Necesita " + nombreIngrediente(faltante));

                    // Bloquear y esperar al proveedor correspondiente
                    lock.lock();
                    try {
                        switch (faltante) {
                            case 1 -> proveedorHarina.entregarIngrediente();
                            case 2 -> proveedorAzucar.entregarIngrediente();
                            case 3 -> proveedorHuevos.entregarIngrediente();
                        }

                        // Esperar a que el proveedor termine
                        while (!ingredienteEntregado(faltante, proveedorHarina, proveedorAzucar, proveedorHuevos)) {
                            condition.await(); // Descansar hasta que el proveedor entregue
                        }
                    } finally {
                        lock.unlock();
                    }

                    // Simular descanso del repostero
                    System.out.println("Repostero está descansando...");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        repostero.start();
    }

    private static boolean ingredienteEntregado(int faltante, Proveedor... proveedores) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getId() == faltante) {
                return proveedor.isEntregado();
            }
        }
        return false;
    }

    private static String nombreIngrediente(int ingredienteId) {
        return switch (ingredienteId) {
            case 1 -> "HARINA";
            case 2 -> "AZÚCAR";
            case 3 -> "HUEVOS";
            default -> "DESCONOCIDO";
        };
    }
}
