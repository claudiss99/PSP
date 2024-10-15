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
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Claudia
 */
public class GeneradorTablas2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce numeros con espacios:");
        String cadenaEspacios = sc.nextLine();
        String [] cadena = cadenaEspacios.split(" ");
        //Pide prefijo
        String file = sc.nextLine();
        ArrayList<Process> procesos = new ArrayList<>();
        for (String i:cadena){
             procesos.add(InitProcess(i, file));
        }
        for(Process p:procesos ){
            p.waitFor();
        }
        System.out.println("Tablas creadas");
        
    }
    
    public static Process InitProcess (String num, String file) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        String filename = file+"_"+num+".txt";
        Process tmultiplicar = runtime.exec(new String[]{"java", "GeneraTablas.java", filename});
        
        try (BufferedWriter writerMult = new BufferedWriter(new OutputStreamWriter(tmultiplicar.getOutputStream()))) {
            writerMult.write(num);
            writerMult.newLine();
            writerMult.flush();
            
        }
        return tmultiplicar;
    }
}
