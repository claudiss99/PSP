/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author Claudia
 */
public class Ejercicio2Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int puerto = 4000;
        
        try(ServerSocket serverSocket = new ServerSocket(puerto)){
            System.out.println("Servidor iniciado. Esperando cliente...");
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado.");
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter escribir = new PrintWriter(socket.getOutputStream(), true);
            
            String mensaje;
            int numero = new Random().nextInt(1, 101);
            int intento;
            escribir.println("Adivina numero entre 1 y 100: "+numero); 
            do{
                
                mensaje = reader.readLine();
                intento = Integer.parseInt(mensaje);
                if(intento>numero){
                    escribir.println("Más bajo");
                }else if(intento<numero){
                    escribir.println("Más alto");
                }else{
                    escribir.println("Correcto");
                }
            }while(intento!=numero);
            
        }catch(IOException e){
            System.out.println("Error en el servidor: "+e.getLocalizedMessage());
        }
    }
    
}
