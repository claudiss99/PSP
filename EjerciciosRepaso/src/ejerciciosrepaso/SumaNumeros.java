/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosrepaso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 * @author ClaudissPerez
 */
public class SumaNumeros {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //Pide numero 
        int num = sc.nextInt();
        String cadena = "";
        while (num!=0){
            cadena += String.valueOf(num) + " ";
            num=sc.nextInt();
        }
        Runtime runtime = Runtime.getRuntime();
        
        Process suma = runtime.exec(new String[]{"java", "SumaNumerosLinea.java"});
        //Me aconseja meterlo en un try pero sin catch???
        try (BufferedWriter writerSuma = new BufferedWriter(new OutputStreamWriter(suma.getOutputStream()))) {
            writerSuma.write(cadena);
            writerSuma.newLine();
            writerSuma.flush();
            
            BufferedReader readerSuma = new BufferedReader(new InputStreamReader(suma.getInputStream()));
            //Se pone tantos readLine hasta que llegues al sout que quieras
            readerSuma.readLine();
            System.out.println(readerSuma.readLine());
            
            readerSuma.close();
            
        }
        
    }
}
