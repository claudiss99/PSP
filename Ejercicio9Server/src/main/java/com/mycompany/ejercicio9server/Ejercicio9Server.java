/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio9server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Claudia
 */
public class Ejercicio9Server {

    public static void main(String[] args) {
        int puerto = 4000;
        
        try (ServerSocket serverSocket = new ServerSocket(puerto)){
            System.out.println("Servidor iniciado. Esperando cliente...");
            
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado");
            }
        }catch(IOException e){
            System.err.println("Error en el servidor: "+e.getLocalizedMessage());
        }
    }
}
