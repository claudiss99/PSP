/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio6server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ClaudissPerez
 */
public class Ejercicio6Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int puerto = 4000;
        String[] palabras = {"Tortitas", "Bizcocho", "Magdalenas", "Galletas", "Cereales"};

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado. Esperando cliente...");

            while (true) {
                // Aceptar una nueva conexión de cliente
                Socket socket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado.");

                
                Juego clienteHandler = new Juego(socket, palabras);
                clienteHandler.start();
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getLocalizedMessage());
        }
    }
    
}
