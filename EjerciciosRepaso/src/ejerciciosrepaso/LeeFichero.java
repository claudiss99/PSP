/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosrepaso;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Claudia
 */
public class LeeFichero {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        if(args.length == 0){
            System.err.println("No se ha encontrado fichero");
            System.exit(1);
        }else{
            String fileName = args[0];
            String linea = "";
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
                while ((linea = reader.readLine())!= null){
                    System.out.println(linea);
                }
            }
        }
    }
}
