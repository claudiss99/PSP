/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raton;

import java.util.ArrayList;

/**
 *
 * @author ClaudissPerez
 */
public class ClasificaPosNeg extends Thread{
    private ArrayList<Integer> numeros;
    private ArrayList<Integer> positivos = new ArrayList<>();
    private ArrayList<Integer> negativos = new ArrayList<>();

    public ClasificaPosNeg(ArrayList<Integer> numeros) {
        this.numeros = numeros;
    }

    @Override
    public void run() {
        for (int number : numeros) {
            if (number < 0) {
                negativos.add(number);
            } else {
                positivos.add(number);
            }
        }
    }

    // Métodos para obtener los resultados
    public ArrayList<Integer> getPositivos() {
        return positivos;
    }

    public ArrayList<Integer> getNegativos() {
        return negativos;
    }
}
