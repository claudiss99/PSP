/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serversocketejercicio1;

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
public class ServerSocketEjercicio1 {

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
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
          
            String mensaje;
            
            do{
                mensaje= entrada.readLine();
                System.out.println("Cliente: "+mensaje);
                salida.println("Servidor: Recibido -> "+mensaje.toUpperCase());
                salida.flush();
                
            }while(!mensaje.equalsIgnoreCase("salir"));
            
            System.out.println("Cliente desconectado.");
                    
                    
        }catch(IOException e){
            System.out.println("Error en el servidos: "+e.getMessage());
        }
    }
    
}
