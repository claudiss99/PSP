/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raton;
import java.util.Scanner;

/**
 *
 * @author ClaudissPerez
 */

public class SumarNumeros {
    public static void main(String[] args) throws InterruptedException {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese una lista de números separados por espacios
        System.out.println("Introduce una lista de números separados por espacios: ");
        String input = scanner.nextLine();
        
        // Convertir la entrada en un arreglo de números enteros
        String[] inputArray = input.split(" ");
        int[] numeros = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            numeros[i] = Integer.parseInt(inputArray[i]);
        }

        // Crear dos objetos de hilos para la suma concurrente
        int mitad = numeros.length / 2;
        SumaMitad suma1 = new SumaMitad(numeros, 0, mitad);
        SumaMitad suma2 = new SumaMitad(numeros, mitad, numeros.length);

        // Iniciar los hilos
        suma1.start();
        suma2.start();

        // Esperar a que ambos hilos terminen
        suma1.join();
        suma2.join();

        // Calcular la suma total combinando los resultados de ambos hilos
        int sumaTotal = suma1.getSuma() + suma2.getSuma();
        
        // Mostrar el resultado final
        System.out.println("La suma total es: " + sumaTotal);
    }
}
