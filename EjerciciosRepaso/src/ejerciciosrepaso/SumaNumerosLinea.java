/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosrepaso;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ClaudissPerez
 */
public class SumaNumerosLinea {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        //Lo de los espacios no va a haber que contrarlo no?
        System.out.println("Numeros separados por espacios:");
        String cadena = sc.nextLine();
        String[] cadenaSpace = cadena.split(" ");
        
        int suma = 0;
        
        for (String num : cadenaSpace){
            suma += Integer.parseInt(num);
        }
        
        System.out.println(suma);
        
    }
    
}
