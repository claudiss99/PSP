/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package invertircadenafichero;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Claudia
 */
public class InvertirCadenaFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if (args.length > 0) {
            String nombreFichero = args[0];
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce una cadena: ");
            String cadena = scanner.nextLine();
            String cadenaInvertida = invertirCadena(cadena);
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreFichero, true))) {
                writer.write(cadenaInvertida);
                writer.newLine();
                System.out.println("La cadena invertida se ha escrito en el fichero: " + nombreFichero);
            } catch (IOException e) {
                System.out.println("Error al escribir en el fichero: " + e.getMessage());
            }
        } else {
            System.out.println("No se ha proporcionado un nombre de fichero.");
        }
    }

    public static String invertirCadena(String cadena) {
        return new StringBuilder(cadena).reverse().toString();
    }

}
