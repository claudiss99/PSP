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
        
        try (ServerSocket serverSocket = new ServerSocket(puerto)){
            Gestion gestion = new Gestion();
            BufferedReader reader;
            String mensaje;
            //Quieor aceptar todo el rato clientes
            while(true){
                Socket socket = serverSocket.accept();
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                gestion.newJugador(new Jugador(socket, gestion));
            }
        }catch(IOException e){
            System.err.println("Error en el servidor: "+e.getLocalizedMessage());
        }
    }
}
