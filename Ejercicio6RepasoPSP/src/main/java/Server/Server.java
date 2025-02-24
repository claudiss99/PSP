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
 * @author Usuario
 */
public class Server {
    public static void main(String[] args) {
        int puerto = 4000;
        try(ServerSocket server = new ServerSocket(puerto)){
            Gestion gestion;
            while(true){
                Socket socket = server.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                
                //recibe mensaje identificativo
                
            }
        }catch(IOException e){
            System.err.println("Error en el server: "+e.getLocalizedMessage());
        }
    }
}
