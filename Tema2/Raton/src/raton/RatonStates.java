package raton;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RatonStates extends Thread {
    private String nombre;
    private int tiempo;
    private static int comidaConsumida = 0;

    public RatonStates(String nombre, int tiempo) {
        super();
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    public void comer() throws InterruptedException {
        System.out.println("El ratón " + nombre + " ha empezado a comer");
        Thread.sleep(tiempo);
        comidaConsumida++;
        System.out.println("El ratón " + nombre + " ha terminado de comer");
    }

    @Override
    public void run() {
        try {
            this.comer();
        } catch (InterruptedException ex) {
            Logger.getLogger(RatonStates.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int getComidaConsumida() {
        return comidaConsumida;
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<State> estados = new ArrayList<>();
        RatonStates fievel = new RatonStates("Fievel", 6000);

        // Agregamos el estado inicial antes de iniciar el hilo
        State estadoActual = fievel.getState();
        estados.add(estadoActual);

        // Iniciamos el hilo
        fievel.start();

        // Bucle para capturar los estados mientras el hilo no esté terminado
        while (fievel.getState() != State.TERMINATED) {
            estadoActual = fievel.getState();
            if (!estados.contains(estadoActual)) {
                estados.add(estadoActual);
            }
        }

        // Esperamos a que el hilo termine para asegurarnos de tener el estado TERMINATED
        fievel.join();

        // Imprimimos los estados almacenados en el ArrayList
        System.out.println("Estados del hilo 'fievel': " + estados);

        // Mostramos la cantidad de comida consumida
        System.out.println("Comida consumida: " + RatonStates.getComidaConsumida());
    }
}
