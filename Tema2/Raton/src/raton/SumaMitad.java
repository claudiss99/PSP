/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raton;

/**
 *
 * @author ClaudissPerez
 */
public class SumaMitad extends Thread{
    private int[] numeros;
    private int inicio;
    private int fin;
    private int suma = 0;

    // Constructor
    public SumaMitad(int[] numeros, int inicio, int fin) {
        this.numeros = numeros;
        this.inicio = inicio;
        this.fin = fin;
    }

    // Método que realiza la suma parcial de los números en el rango [inicio, fin)
    @Override
    public void run() {
        for (int i = inicio; i < fin; i++) {
            suma += numeros[i];
        }
    }

    // Obtener la suma calculada por el hilo
    public int getSuma() {
        return suma;
    }
}

