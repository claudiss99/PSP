/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio11;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ClaudissPerez
 */

public class SumarNumeros {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que introduzca una lista de números separados por espacios
        System.out.println("Introduce una lista de números separados por espacios: ");
        String input = scanner.nextLine();
        
        String[] num = input.split(" ");
        ArrayList<Integer> numeros = new ArrayList<>();
            for (String n: num) {
            numeros.add(Integer.valueOf(n));
        }

        int mitad = numeros.size() / 2;
        SumaMitad suma1 = new SumaMitad(numeros, 0, mitad);
        SumaMitad suma2 = new SumaMitad(numeros, mitad, numeros.size());

        suma1.start();
        suma2.start();

        suma1.join();
        suma2.join();

        int sumaTotal = suma1.getSuma() + suma2.getSuma();
        
        // Mostrar el resultado final
        System.out.println("La suma total es: " + sumaTotal);
    }
}
