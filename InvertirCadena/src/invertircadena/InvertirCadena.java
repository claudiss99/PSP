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

       
        System.out.print("Introduce una cadena: ");
        String cadena = scanner.nextLine();

        
        String cadenaInvertida = invertirCadena(cadena);

        
        System.out.println("Cadena invertida: " + cadenaInvertida);

        
        scanner.close();
    }

    
    public static String invertirCadena(String cadena) {
        String cadenaInvertida = ""; 

        
        for (int i = cadena.length() - 1; i >= 0; i--) {
            // Concatenamos los caracteres en orden inverso
            cadenaInvertida += cadena.charAt(i);
        }

        return cadenaInvertida; 
    }
    
}
