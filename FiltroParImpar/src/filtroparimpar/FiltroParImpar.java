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
        System.out.println("Introduce -p para obtener par o -i para obtener impar: ");
        String filtro;
        Scanner teclado = new Scanner(System.in);
        filtro = teclado.nextLine();
        
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Introduce numeros o 0 para terminar");
        int number = teclado.nextInt();
        
        while (number!=0){
            switch (filtro){
            case "-p":
                addNumber(number);
                break;
            case "-i":
                addNumber(number);
                break;
            case "":
                System.exit(1);
                break;
            default:
                System.exit(2);   
            }
        System.out.println("Introduce numeros, cuando introduzcas 0, no se introducirá más");
        int number = teclado.nextInt();
        }
        
    }
}
