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
            boolean restaurante=false;
            BufferedReader reader;
            PrintWriter writer;
            String mensaje;
            Socket sitio = null;
            //Quieor aceptar todo el rato clientes
            while(true){
                Socket socket = serverSocket.accept();
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
                //Recibo mensaje identificativo(COMENSAL O RESTAURANTE)
                mensaje = reader.readLine();
                //Mientras no se conecte el restaurante --> No se lanza al cliente
                while(!restaurante){
                    //compruebo el mensaje
                    if(mensaje.equalsIgnoreCase("RESTAURANTE")){
                        restaurante=true;
                        sitio=socket;
                    }
                }
                
                //ya tengo restaurante --> ahora solo acepto clientes
                if(mensaje.equalsIgnoreCase("COMENSAL")){
                    ManejoPedidos manejo = new ManejoPedidos(socket, sitio);
                }
                
            }
        }catch(IOException e){
            System.err.println("Error en el servidor: "+e.getLocalizedMessage());
        }
    }
    
}
