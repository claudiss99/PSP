/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio10server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author ClaudissPerez
 */
public class Ejercicio10Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int puerto = 4000;
        
        try (ServerSocket serverSocket = new ServerSocket(puerto)){
            ManejoPedidos manejo = new ManejoPedidos();
            boolean restaurante=false;
            BufferedReader reader;
            PrintWriter writer;
            String mensaje;
            //Quieor aceptar todo el rato clientes
            while(true){
                Socket socket = serverSocket.accept();
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
                //Recibo mensaje identificativo(COMENSAL O RESTAURANTE)
                mensaje = reader.readLine();
               //compruebo el mensaje
                if(mensaje.equalsIgnoreCase("RESTAURANTE")){
                    manejo.setRestaurante(new Restaurante(socket, gestion));
                    
                }else if(mensaje.equalsIgnoreCase("COMENSAL")){
                    manejo.addComensal(new Comensal(socket, gestion));
                }
              
                
            }
        }catch(IOException e){
            System.err.println("Error en el servidor: "+e.getLocalizedMessage());
        }
    }
    
}
