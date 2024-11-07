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
public class ClasificaParImpar extends Thread{
    private ArrayList<Integer> numeros;
    private ArrayList<Integer> pares = new ArrayList<>();
    private ArrayList<Integer> impares = new ArrayList<>();

    public ClasificaParImpar(ArrayList<Integer> numeros) {
        this.numeros = numeros;
    }

    @Override
    public void run() {
        for (int number : numeros) {
            if (number % 2 == 0) {
                pares.add(number);
            } else {
                impares.add(number);
            }
        }
    }

    // Métodos para obtener los resultados
    public ArrayList<Integer> getPares() {
        return pares;
    }

    public ArrayList<Integer> getImpares() {
        return impares;
    }
}
