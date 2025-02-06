/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio5server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author ClaudissPerez
 */

public class Ejercicio5Server {

    public static void main(String[] args) {
        int puerto = 4000;

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado. Esperando clientes...");
            
            while (true) {
                // Aceptar una nueva conexión de cliente
                Socket socket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado.");
                
                // Crear un hilo para manejar la conexión del cliente
                Thread clienteHandler = new Thread(new ClienteHandler(socket));
                clienteHandler.start();
            }

        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getLocalizedMessage());
        }
    }
}

