/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Server {
    
    public static void main(String[] args) {
        int puerto = 4000;
        try(ServerSocket server = new ServerSocket(puerto)){
            Gestion gestion = new Gestion();
            ArrayList<String> jugadores;
            while(true){
                jugadores = gestion.getNombreJugadores();
                Socket socket = server.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                
                //Mientras que no sea valido el nombre no podemos conectarlo a la sala
                boolean correcto = false;
                String recibido;
                String nombre = null;

                while(!correcto){
                    recibido=reader.readLine();
                    nombre = recibido.split("#")[1];
                    
                    if(jugadores.contains(nombre)){
                        //si ya esta registrado ese usuario
                        writer.println("FALLO#USUARIO_DUPLICADO");
                    }else{
                        jugadores.add(nombre);
                        correcto = true;
                        writer.println("CONECTADO");
                    }
                }
               
                //Ya esta conectado
                gestion.newJugador(new Jugador(socket, nombre, gestion));
                
                
            }
        }catch(IOException e){
            System.err.println("Error en el server: "+e.getLocalizedMessage());
        }
    }    
}
