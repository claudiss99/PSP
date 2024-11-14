/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio8;

import java.util.ArrayList;

/**
 *
 * @author ClaudissPerez
 */
public class ClasificaPrimos extends Thread{
    private ArrayList<Integer> numeros;
    private ArrayList<Integer> primos = new ArrayList<>();
    private ArrayList<Integer> noPrimos = new ArrayList<>();

    public ClasificaPrimos(ArrayList<Integer> numeros) {
        this.numeros = numeros;
    }

    @Override
    public void run() {
        for (int number : numeros) {
            if (isPrime(number)) {
                primos.add(number);
            } else {
                noPrimos.add(number);
            }
        }
    }

    private boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // Métodos para obtener los resultados
    public ArrayList<Integer> getPrimos() {
        return primos;
    }

    public ArrayList<Integer> getNoPrimos() {
        return noPrimos;
    }
}
