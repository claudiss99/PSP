/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filtroparimpar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Claudia
 */
public class FiltroParImpar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce -p para obtener par o -i para obtener impar: ");
        String filtro = teclado.nextLine();
        //Problema te pide un numero y despues te comprueba el filtro. Esta feo!
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Introduce numeros o 0 para terminar");
        int number = teclado.nextInt();
        
        while (number!=0){
            switch (filtro){
            case "-p":
                if (number %2 ==0){
                    numbers.add(number);
                }
                break;
            case "-i":
                if (number %2 !=0){
                    numbers.add(number);
                }
                break;
            case "":
                System.err.println("Filtro no válido, campo vacío");
                System.exit(1);
                break;
            default:
                System.err.println("Filtro no válido, cualquier otro valor");
                System.exit(2);   
            }
            System.out.println("Introduce numeros, cuando introduzcas 0, no se introducirá más");
            number = teclado.nextInt();
        }
        
        System.out.println("Números filtrados: " +numbers);
        
    }
}
