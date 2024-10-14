/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosrepaso;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Claudia
 */
public class GeneraTablas {
    public static void main(String[] args) throws InterruptedException {
        if (args.length == 0){
            System.err.println("No se ha encontrado parametro");
            System.exit(1);
        }
        
        Random random = new Random();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Numero sobre el que generar la tabla");
        int num = sc.nextInt();
        String fileName = args[0];
        
        Thread.sleep(random.nextInt(8000+2000));

            
        //Añadimos el final de linea
        System.out.println(""); 
        tMultiplicar(num, fileName);
              
    }
    
    private static void tMultiplicar(int num, String fileName){
        
        
        try (BufferedWriter wfile = new BufferedWriter(new FileWriter(fileName,true))){
           for (int i=1 ; i<11; i++){
            wfile.write(num+" "+"x"+" "+i+" "+"="+" "+(num*i));
            wfile.newLine();
           }
           wfile.flush();
           wfile.close();
            System.out.println("Datos guardados correctamente en el fichero: "+fileName);
        } catch (IOException e) {
            System.err.println("Ocurrio un error al guardar en el fichero: "+ e.getMessage());
        }
        
    }
}
