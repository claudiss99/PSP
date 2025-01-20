/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package socketejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Claudia
 */
public class SocketEjercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //String host = "192.168.18.103";
        String host = "localhost";
        int puerto = 4000;
        
        try (Socket socket = new Socket(host, puerto)){
            System.out.println("Conectado al servidor.");
            
            //Stremas para comunicarse con el servidor
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader servidorRespuesta = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensajeMayus ;
            String mensaje;
            
            do{
                System.out.println("Escribe un mensaje: ");
                mensaje= teclado.readLine();
                salida.println(mensaje);
                mensajeMayus = servidorRespuesta.readLine();
                System.out.println(mensajeMayus);
                
            }while (!mensaje.equalsIgnoreCase("salir"));
            
            System.out.println("Desconectado del servidor");
        }catch(IOException e){
            System.out.println("Error en el cliente: "+e.getMessage());
        }
    }
    
}
