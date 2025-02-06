/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio4cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author ClaudissPerez
 */
public class Ejercicio4Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 4000;
        
        try(Socket socket = new Socket(host, puerto)){
            System.out.println("Iniciando juego...");
            
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            
            String recibido;
            
            while ((recibido = reader.readLine()) != null){
                System.out.println(recibido);

                System.out.println("Introduce letra o palabra: ");
                String intento = teclado.readLine();
                
                while(intento.contains(" ")){
                    System.out.println("Introduce letra o palabra");
                    intento = teclado.readLine();
                }
                
                writer.println(intento);
            }
            
        }catch(IOException e){
            System.out.println("Error en el cliente: "+e.getLocalizedMessage());
        }
    }
    
}
