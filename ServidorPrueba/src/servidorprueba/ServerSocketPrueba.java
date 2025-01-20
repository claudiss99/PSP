/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servidorprueba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.ServerSocket;

/**
 *
 * @author Claudia
 */
public class ServerSocketPrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Puerto donde esccuchará el servidor
        int puerto=4000;
        
        try(ServerSocket serverSocket = new ServerSocket(puerto)){
            System.out.println("Servidor iniciado. Esperando cliente...");
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado.");
            
            //Strems para comunicarse con el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            String mensaje;
            
            do{
                mensaje= entrada.readLine();
                System.out.println("Cliente: "+mensaje);
                
            }while(!mensaje.equalsIgnoreCase("salir"));
            
            System.out.println("Cliente desconectado.");
                    
                    
        }catch(IOException e){
            System.out.println("Error en el servidos: "+e.getMessage());
        }
    }
    
}
