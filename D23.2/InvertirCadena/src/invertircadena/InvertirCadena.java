/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package invertircadena;

import java.util.Scanner;

/**
 *
 * @author Claudia
 */
public class InvertirCadena {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca una cadena: ");
        String cadena = scanner.nextLine();
        System.out.println(cadena);
        String cadenaInversa = reverseInputString(cadena);
        System.out.println(cadenaInversa);
    }
    
    public static String reverseInputString (String cadena){
        //Se comprueba si es nula para evitar errores 
        if (cadena == null){
            return cadena;
        }
        //Inicializamos para guardar salida
        String reverseString = "";
        
        //Recorremos el string de derecha a izquierda y lo almacenamos 
        for (int i =cadena.length() -1; i>=0; i--){
            reverseString = reverseString + cadena.charAt(i);
        }
        
        return reverseString;
    }
}
