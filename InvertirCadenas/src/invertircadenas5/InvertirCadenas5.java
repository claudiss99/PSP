/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package invertircadenas5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class InvertirCadenas5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);

        // Lista para almacenar todas las cadenas introducidas
        ArrayList<String> cadenas = new ArrayList<>();

        String cadena;
        do {
            System.out.print("Introduce una cadena (o 'FIN' para terminar): ");
            cadena = scanner.nextLine();

            //Tanto minuscula como mayuscula
            if (!cadena.equalsIgnoreCase("FIN")) {
                cadenas.add(cadena);
            }
        } while (!cadena.equalsIgnoreCase("FIN"));

        // Procesar cada cadena y mostrarla invertida
        System.out.println("\nCadenas invertidas:");
        for (String c : cadenas) {
            
        }

        // Cerrar el escáner
        scanner.close();
    }

  
    
}
