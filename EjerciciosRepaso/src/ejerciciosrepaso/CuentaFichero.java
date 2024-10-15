/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosrepaso;

import java.util.Scanner;

/**
 *
 * @author ClaudissPerez
 */
public class CuentaFichero {
    public static void main(String[] args) {
        String parametro= "-w";
        String file = "100palabras.txt";
        switch (parametro) {
            case "-w":
                ConteoPalabras(file);
                break;
            case "-l":
                ConteoLineas(file);
                break;
            default:
                throw new AssertionError();
        }
        
        /*if("-w".equals(args[0]) || "-l".equals(args[0])){
            String parametro=args[0];
            String file = args[1];
            switch (parametro) {
                case "-w":
                    ConteoPalabras(file);
                    break;
                case "-l":
                    ConteoLineas(file);
                    break;
                default:
                    throw new AssertionError();
            }
        }else {
            System.err.println("No se ha introducido el parametro correcto");
            System.exit(1);
        }*/
        
    }
    
    public static void ConteoLineas(String file){
        String linea = "";
        int contLinea = 0;
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                linea +=sc.nextLine();
                contLinea ++;
            }
        }catch (IllegalArgumentException e){
            System.err.println("Error al leer el archivo");
        }
        System.out.println("Hay "+contLinea+" lineas en el fichero");
    }
    
    public static void ConteoPalabras(String file){
        String linea = "";
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                linea +=sc.nextLine();
            }
        }catch (IllegalArgumentException e){
            System.err.println("Error al leer el archivo");
        }
        String[] palabras = linea.split(" ");
        System.out.println("Hay "+palabras.length+" palabras en el fichero");
    }
}
