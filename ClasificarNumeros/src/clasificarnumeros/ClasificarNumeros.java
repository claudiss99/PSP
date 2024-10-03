/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clasificarnumeros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class ClasificarNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Introduce numeros o 0 para terminar");
        int number = teclado.nextInt();
        
        while (number!=0){   
            numbers.add(number);
            System.out.println("Introduce numeros o 0 para terminar");
            number = teclado.nextInt();
        }
        
        // Ejecutar los procesos hijos
        Runtime runtime = Runtime.getRuntime();
        Process pares = runtime.exec(new String[]{"java", "FiltroParImpar.java", "-p"});
        Process impares = runtime.exec(new String[]{"java", "FiltroParImpar.java", "-i"});
        
        // Crear los writers para enviar los números a los procesos hijos
        BufferedWriter writerPares = new BufferedWriter(new OutputStreamWriter(pares.getOutputStream()));
        BufferedWriter writerImpares = new BufferedWriter(new OutputStreamWriter(impares.getOutputStream()));
    
        for (int num : numbers){
            // Enviar todos los números a los procesos
            
            //Lo he tenido que escribir como String sino da ERROR
            writerPares.write(Integer.toString(num)); 
            writerPares.newLine();

            writerImpares.write(Integer.toString(num)); 
            writerImpares.newLine(); 
        }
        
        // Cerrar los flujos de escritura después de enviar todos los números
        writerPares.flush();
        writerPares.close();

        writerImpares.flush();
        writerImpares.close();

        // Leer los resultados de los procesos hijos
        BufferedReader readerPares = new BufferedReader(new InputStreamReader(pares.getInputStream()));
        BufferedReader readerImpares = new BufferedReader(new InputStreamReader(impares.getInputStream()));

        System.out.println("Números pares: " + readerPares);
        System.out.println("Números impares: " + readerImpares);    
    }
    
}
