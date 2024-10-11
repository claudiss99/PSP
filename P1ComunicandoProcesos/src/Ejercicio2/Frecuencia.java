/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ClaudissPerez
 */
public class Frecuencia {
    public static void main(String[] args) {
        //java Frecuencia resultado.
        //Comprobamos que se ha introducido el nombre del fichero
        if (args.length<1){
            System.err.println("Debe proporcionar el nombre del fichero como argumento");
            System.exit(1);
        }
        
        String fileName = args[0];
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una cadena: ");
        String cadena = sc.nextLine().toLowerCase();
        
        //Incializamos contador para cada vocal
        int contA = 0;
        int contE = 0;
        int contI = 0;
        int contO = 0;
        int contU = 0;
        
        //Recorremos letra a letra la cadena
        
        for (char ch: cadena.toCharArray()){
            switch (ch) {
                case 'a':
                    contA ++;
                    break;
                case 'e':
                    contE ++;
                    break;
                case 'i':
                    contI ++;
                    break;
                case 'o':
                    contO ++;
                    break;
                case 'u':
                    contU ++;
                    break;
                default:
                    break;
            }
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            writer.write(cadena+": "+contA+" "+contE+" "+contI+" "+contO+" "+contU);
            writer.newLine();
        }catch (IOException e){
            System.err.println("Ocurrio un error al escribir el archivo");
        }
       
    }
}
