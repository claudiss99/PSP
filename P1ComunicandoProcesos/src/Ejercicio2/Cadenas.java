/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Cadenas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        ArrayList<String> ListCadenas = new ArrayList<>();
        
        while (!cadena.equalsIgnoreCase("FIN")){
            ListCadenas.add(cadena);
            cadena = sc.nextLine();
        }
        
        System.out.println("Introduce el nombre del fichero en el que desea guardar: ");
        String fileName = sc.nextLine();
        
        try{
            
            // Ejecutar los procesos hijos
            Runtime runtime = Runtime.getRuntime();
            Process contarVocal = runtime.exec(new String[]{"java", "Frecuencia.java", fileName});

            // Crear los writers para enviar las cadenas a los procesos hijos
            BufferedWriter writerCadena= new BufferedWriter(new OutputStreamWriter(contarVocal.getOutputStream()));

            for (String cad : ListCadenas){
                // Enviar todos los cadenas a los procesos
                writerCadena.write(cad); 
                writerCadena.newLine();

            }
            // Cerrar los flujos de escritura después de enviar todos los números
            writerCadena.flush();
            writerCadena.close();

        }catch (IOException e){
            System.err.println("Ha habido algun error ejecutando el proceso hijo");
        }finally{
            sc.close();
        }
    }
}
