/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ClaudissPerez
 */
public class Ejercicio1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un numero entre 10 y 20");
        int num = sc.nextInt();

        while (num<10 || num>20){
            num = sc.nextInt();
        }
        
        sc.nextLine();
        System.out.println("Nombre del fichero");
        String fileName = sc.nextLine();
        
        proceso("java", "CreaCadenas.java", fileName, num);
       
    }
    
    public static void proceso (String java, String programa, String fileName, int num) throws IOException{
        
        Runtime runtime = Runtime.getRuntime();
        Process proceso = runtime.exec(new String[]{java, programa, String.valueOf(num)});
        ArrayList<String> cadenas = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
        for (int i=0; i<num; i++){    
            cadenas.add(reader.readLine());
        }
        reader.close();
        cadenas.add("fin");
        Process proceso2 = runtime.exec(new String[]{java, "Cadenas.java"});
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(proceso2.getOutputStream()));
        for(String c: cadenas){
            writer.write(c);
            writer.newLine();
        }
        writer.write(fileName);
        writer.flush();
        writer.close();
    }
}
