/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clasificarnumeroscompleto;

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
public class ClasificarNumerosCompleto {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Introduce numeros o 0 para terminar");
        int number = teclado.nextInt();
        
        while (number!=0){   
            numbers.add(number);
            System.out.println("Introduce numeros, cuando introduzcas 0, no se introducirá más");
            number = teclado.nextInt();
        }
        
        // Ejecutar los procesos hijos
        Runtime runtime = Runtime.getRuntime();
        Process pares = runtime.exec(new String[]{"java", "FiltroParImpar.java", "-p"});
        Process impares = runtime.exec(new String[]{"java", "FiltroParImpar.java", "-i"});
        Process positivos = runtime.exec(new String[]{"java", "FiltroPosNeg.java", "-pos"});
        Process negativos = runtime.exec(new String[]{"java", "FiltroPosNeg.java", "-neg"});
        
        // Preparar la  salida para enviar los números a los procesos hijos
        BufferedWriter writerPares = new BufferedWriter(new OutputStreamWriter(pares.getOutputStream()));
        BufferedWriter writerImpares = new BufferedWriter(new OutputStreamWriter(impares.getOutputStream()));
        BufferedWriter writerPositivos = new BufferedWriter(new OutputStreamWriter(positivos.getOutputStream()));
        BufferedWriter writerNegativos = new BufferedWriter(new OutputStreamWriter(negativos.getOutputStream()));
        
        for (int num : numbers){
            
            // Escribir todos los números a los procesos hijos
            writerPares.write(num);
            writerPares.newLine();


            writerImpares.write(num);
            writerImpares.newLine();


            writerPositivos.write(num);
            writerPositivos.newLine();


            writerNegativos.write(num);
            writerNegativos.newLine();
                
        }
        
        // Cerrar los procesos de escritura
        
        writerPares.flush();
        writerPares.close();
        
        writerImpares.flush();
        writerImpares.close();
            
        writerPositivos.flush();
        writerPositivos.close();
        
        writerNegativos.flush();
        writerNegativos.close();
        
        // Leer las salidas de los procesos hijos 
        BufferedReader readerPares = new BufferedReader(new InputStreamReader(pares.getInputStream()));
        BufferedReader readerImpares = new BufferedReader(new InputStreamReader(impares.getInputStream()));
        BufferedReader readerPositivos = new BufferedReader(new InputStreamReader(positivos.getInputStream()));
        BufferedReader readerNegativos = new BufferedReader(new InputStreamReader(negativos.getInputStream()));

        System.out.println("Números pares: " + readerPares);
        System.out.println("Números impares: " + readerImpares);
        System.out.println("Números positivos: " + readerPositivos);
        System.out.println("Números negativos: " + readerNegativos);
        
        // Cerrar los flujos de lectura
        readerPares.close();
        readerImpares.close();
        readerPositivos.close();
        readerNegativos.close();
    }
    
}
