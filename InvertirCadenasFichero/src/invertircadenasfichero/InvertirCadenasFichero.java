/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package invertircadenasfichero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Claudia
 */
public class InvertirCadenasFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String nombreFichero = "cadenas_invertidas.txt";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Introduce una cadena (o 'FIN' para terminar): ");
            String cadena = scanner.nextLine();

            if (cadena.equals("FIN")) {
                break;
            }

            // Llamar al programa InvertirCadenaFichero
            try {
                Process process = Runtime.getRuntime().exec(new String []{"java", "C:\\Users\\Claudia\\Documents\\NetBeansProjects\\PSP", "cadenas_invertidas.txt"});
                BufferedReader bf = new BufferedReader(new InputStreamReader(out.getInputStream()));
                String linea;
                while( (linea=bf.readLine()) != null) {
                        System.out.println(linea);
                }
                // Para enviar la cadena al proceso
                try (var writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()))) {
                    writer.write(cadena);
                    writer.newLine();
                }

                process.waitFor();
            } catch (IOException | InterruptedException e) {
                System.out.println("Error al ejecutar el programa: " + e.getMessage());
            }
        }

        scanner.close();
    }   
}
