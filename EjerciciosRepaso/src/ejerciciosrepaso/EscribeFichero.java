/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosrepaso;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Claudia
 */
public class EscribeFichero {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.err.println("No se ha encontrado fichero");
            System.exit(1);
        }else{
            String fileName = args[0];
            Scanner sc = new Scanner(System.in);
            //Se lee la linea
            String linea = sc.nextLine();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))){
                while (linea.equalsIgnoreCase("fin")){
                    writer.write(linea);
                    writer.newLine();
                    linea=sc.nextLine();
                }
                writer.flush();
                writer.close();
            }
        }
    }
          
}
