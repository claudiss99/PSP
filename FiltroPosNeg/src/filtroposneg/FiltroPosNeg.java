/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filtroposneg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */


public class FiltroPosNeg {
    
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce -pos para obtener positivo o -neg para obtener negativo: ");
        String filtro = teclado.nextLine();
        
        if ((!"-neg".equals(filtro)) && (!"-pos".equals(filtro))){
            System.err.println("Filtro no válido");
            System.exit(2); 
        }
        // Lista para almacenar los números que cumplan con el filtro
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Introduce números o 0 para terminar:");
        
        int number = teclado.nextInt();
        
        // Leer números hasta que se introduzca un 0
        while (number != 0) {
            switch (filtro) {
                case "-pos":
                    if (number > 0) {
                        numbers.add(number);
                    }
                    break;
                case "-neg":
                    if (number < 0) {
                        numbers.add(number);
                    }
                    break;
            }

            // Pedir el siguiente número
            System.out.println("Introduce números (0 para terminar):");
            number = teclado.nextInt();
        }
        
        // Mostrar los números filtrados
        System.out.println("Números filtrados: " + numbers);
        
        // Cerrar el escáner
        teclado.close();
    }
}
