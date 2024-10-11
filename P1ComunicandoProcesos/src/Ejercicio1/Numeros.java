/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Numeros {
    public static void main(String[] args) throws IOException, InterruptedException {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una lista de numeros separados por espacios: ");
        
        //Se va a leer como una cadena de texto
        String input = sc.nextLine();
        
        //Dividir la cadena con espacios
        String[] numberInput = input.split(" ");
        
        ArrayList<Integer> listNumbers = new ArrayList<>();
        
        //Convertimos la cadena a numero
        for (String numString : numberInput){
            try{
                int number = Integer.parseInt(numString);
                listNumbers.add(number);
            } catch (NumberFormatException e){
                System.out.println("El valor '" +numString + "'no es un numero valido");
            }
        }
        
        // Ejecutar los procesos hijos
            Runtime runtime = Runtime.getRuntime();
            Process positiveNumbers = runtime.exec(new String[]{"java", "OperacionNumerica.java"});
            Process suma = runtime.exec(new String[]{"java", "OperacionNumerica.java", "-s"});
            Process media = runtime.exec(new String[]{"java", "OperacionNumerica.java", "-m"});
            // Crear los writers para enviar las numeros a los procesos hijos
            BufferedWriter writerPosNum= new BufferedWriter(new OutputStreamWriter(positiveNumbers.getOutputStream()));
            BufferedWriter writerSuma= new BufferedWriter(new OutputStreamWriter(suma.getOutputStream()));
            BufferedWriter writerMedia= new BufferedWriter(new OutputStreamWriter(media.getOutputStream()));

            
            for (int num: listNumbers){
                // Enviar todos los números a los procesos
                writerPosNum.write(String.valueOf(num)); 
                writerPosNum.newLine();
                writerSuma.write(String.valueOf(num)); 
                writerSuma.newLine();
                writerMedia.write(String.valueOf(num)); 
                writerMedia.newLine();

            }
       
            writerPosNum.write("0");
            writerPosNum.newLine();
            writerSuma.write("0");
            writerSuma.newLine();
            writerMedia.write("0");
            writerMedia.newLine();
            // Cerrar los flujos de escritura después de enviar todos los números
            writerPosNum.flush();
            writerPosNum.close();
            writerSuma.flush();
            writerSuma.close();
            writerMedia.flush();
            writerMedia.close();
            
            positiveNumbers.waitFor();
            suma.waitFor();
            media.waitFor();

            
            BufferedReader readerPosNum = new BufferedReader(new InputStreamReader(positiveNumbers.getInputStream()));
            BufferedReader readerSuma = new BufferedReader(new InputStreamReader(suma.getInputStream()));
            BufferedReader readerMedia= new BufferedReader(new InputStreamReader(media.getInputStream()));
            
            System.out.println("Números: " + readerPosNum.readLine());
            System.out.println("Suma: " + readerSuma.readLine());
            System.out.println("Media: " + readerMedia.readLine());
            //Para ver los errores
            //BufferedReader readerPosNumE = new BufferedReader(new InputStreamReader(media.getErrorStream()));
    }
}
