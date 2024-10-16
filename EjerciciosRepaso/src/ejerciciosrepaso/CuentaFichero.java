/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosrepaso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ClaudissPerez
 */
public class CuentaFichero {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        if("-w".equals(args[0]) || "-l".equals(args[0])){
            String parametro=args[0];
            String file = args[1];
            File fileName = new File(file);
            switch (parametro) {
                case "-w":
                    ConteoPalabras(fileName);
                    break;
                case "-l":
                    ConteoLineas(fileName);
                    break;
                default:
                    throw new AssertionError();
            }
        }else {
            System.err.println("No se ha introducido el parametro correcto");
            System.exit(1);
        }
        
    }
    
    public static void ConteoLineas(File file) throws FileNotFoundException, IOException{
        String linea = "";
        int contLinea = 0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while((linea = reader.readLine())!=null){
                contLinea ++;
            }
        }catch (IllegalArgumentException e){
            System.err.println("Error al leer el archivo");
        }
        System.out.println("Hay "+contLinea+" lineas en el fichero");
    }
    
    public static void ConteoPalabras(File file) throws FileNotFoundException, IOException{
        String linea = "";
        int contWord= 0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while((linea = reader.readLine())!=null){
                contWord += linea.split(" ").length;
            }
        }catch (IllegalArgumentException e){
            System.err.println("Error al leer el archivo");
        }
        
        System.out.println("Hay "+contWord+" palabras en el fichero");
    }
}
