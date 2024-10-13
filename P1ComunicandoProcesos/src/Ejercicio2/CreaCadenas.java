/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Usuario
 */
public class CreaCadenas {
    public static void main(String[] args) throws IOException {
        try{
            if (args.length == 0) {
                throw new IllegalArgumentException();
            }
            Integer.parseInt(args[0]);
        }catch(IllegalArgumentException e){
            System.err.println("Error: Debes proporcionar un número como parámetro.");
        }
        

        try {
            // Intentar convertir el argumento en un número entero
            int numCadenas = Integer.parseInt(args[0]);

            // Generar las cadenas
            for (int i = 1; i <= numCadenas; i++) {
                // Ejecutar los procesos hijos
            Runtime runtime = Runtime.getRuntime();
            Process cadena = runtime.exec(new String[]{"java", "GenerarCadena.java"});
            BufferedReader reader = new BufferedReader(new InputStreamReader(cadena.getInputStream()));
            System.out.println(reader.readLine());
            
            }

        } catch (NumberFormatException e) {
            // Si el argumento no es un número válido, mostrar mensaje de error
            System.err.println("Error: El parámetro debe ser un número válido.");
            System.exit(1);
        }
    }
}
