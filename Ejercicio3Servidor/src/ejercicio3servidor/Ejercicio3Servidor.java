/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio3servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Claudia
 */
public class Ejercicio3Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int puerto = 400;
        
        try(ServerSocket serverSocket = new ServerSocket(puerto)){
            System.out.println("Servidor iniciado. Esperando cliente...");
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado");
            
            BufferedReader reader = new  BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter escribir = new PrintWriter(socket.getOutputStream(), true);
            
            String mensaje;
            String operacion = null;
            do{
                escribir.print("Dime la operación a realizar");
                //Leo respuesta
                mensaje = reader.readLine();
                //Hago operacion
                
                //le doy respuesta
                escribir.println("El resultado es: "+operacion);
            }while (!mensaje.equalsIgnoreCase("salir"));
            
        }catch(IOException e){
            System.out.println("Error en el servidor. "+e.getLocalizedMessage());
        }
    }
    
}
