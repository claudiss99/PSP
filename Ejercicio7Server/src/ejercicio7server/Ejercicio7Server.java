/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio7server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author ClaudissPerez
 */
public class Ejercicio7Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int puerto = 4000;
        String[] palabras = {"Tortitas", "Bizcocho", "Magdalenas", "Galletas", "Cereales"};
        
        try(ServerSocket serverSocket = new ServerSocket(puerto)){
            int completado=0;
            //Tengo un array de salas
            ArrayList<Sala> salas = new ArrayList<>();
            
            while(true){
                //Acepto conexion de cliente
                Socket cliente = serverSocket.accept();
                
                
                
            }
        }catch(IOException e){
            System.out.println("Error en el servidor: "+e.getLocalizedMessage());
        }
    }
    
}
