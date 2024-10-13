/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

import java.util.Random;

public class GenerarCadena {
    public static void main(String[] args) {
        // Definir los caracteres válidos
        String caracteresValidos = "abcdefghijklmnopqrstuvwxyz";
        
        // Crear un objeto Random
        Random random = new Random();
        
        // Generar una longitud aleatoria entre 1 y 20
        int longitud = random.nextInt(20) + 1; // nextInt(20) genera un número entre 0 y 19, así que sumamos 1
        
        // Generar la cadena aleatoria
        String cadenaAleatoria = "";
 
        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(caracteresValidos.length());
            char caracter = caracteresValidos.charAt(indice);
            cadenaAleatoria +=caracter;

        }
        
        // Mostrar la cadena generada
        System.out.println(cadenaAleatoria);
    }
}

