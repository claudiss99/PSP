/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio9cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Claudia
 */
public class Ejercicio9Cliente {

    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 4000;
        
        try(Socket socket = new Socket(host, puerto)){
            System.out.println("Conectado al servidor");
            
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            
            
            
        }catch(IOException e){
            System.err.println("Error al conectar cliente "+e.getLocalizedMessage());
        }
    }
}
