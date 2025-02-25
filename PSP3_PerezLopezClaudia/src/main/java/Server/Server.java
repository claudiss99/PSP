/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Claudia
 */
public class Server {
    public static void main(String[] args) {
        int puerto = 4000;
        try(ServerSocket server = new ServerSocket(puerto)){
            Gestion gestion = new Gestion();
            BufferedReader reader;
            String mensaje;
            Socket socket;
            while(true){
                socket = server.accept();
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //Compruebo 1º mensaje -->CONSUMIDOR O PUESTO
                mensaje = reader.readLine();
                
                if(mensaje.equalsIgnoreCase("CONSUMIDOR")){
                    gestion.addConsumidor(new Consumidor(socket, gestion));
                }else if(mensaje.startsWith("PUESTO#")){
                    System.out.println("ES UN PUESTO");
                    if(mensaje.split("#")[1].equalsIgnoreCase("Carniceria")){
                        System.out.println("es carnicero");
                        gestion.addCarniceria(new Puesto(socket, gestion, mensaje.split("#")[1]));
                    }else if(mensaje.split("#")[1].equalsIgnoreCase("Pescaderia")){
                        gestion.addPescaderia(new Puesto(socket, gestion, mensaje.split("#")[1]));
                    }
                }
                
            }
            
        }catch(IOException e){
            
            System.err.println("Error en el server");
        }
    }
}
