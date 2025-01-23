/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.PrintWriter;

/**
 *
 * @author Claudia
 */
public class Ejercicio2Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String host = "localhost";
        int puerto = 4000;
        
        try(Socket socket = new Socket(host, puerto)){
            System.out.println("Conectado al servidor");
            
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            
            String recibido;
            recibido = reader.readLine();
            //Muestro mensaje del servidor
            System.out.println(recibido);
            do{
                
                //Respondemos con el teclado
                writer.println(teclado.readLine());
                
                recibido = reader.readLine();
                //Muestro mensaje del servidor
                System.out.println(recibido);
                
                
            }while(!recibido.equalsIgnoreCase("correcto"));
                    
        }catch(IOException e){
            System.out.println("Error en el cliente. "+e.getLocalizedMessage());
        }
    }
    
}
