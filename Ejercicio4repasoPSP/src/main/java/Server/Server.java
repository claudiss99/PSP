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
        int puerto= 4000;
        try(ServerSocket server = new ServerSocket(puerto)){
            System.out.println("Estoy listo");
            Gestion gestion = new Gestion();
            String mensaje;
            BufferedReader reader;
            while(true){
                System.out.println("Esperando cliente...");
                Socket socket = server.accept();
                System.out.println("Cliente aceptado");
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("despues de inicializar el reader");
                mensaje = reader.readLine();
                System.out.println("Primer mensaje: "+mensaje);
                if(mensaje.startsWith("SENSOR#")){
                    System.out.println("Añadiendo sensor");
                    gestion.addSensor(new Sensor(socket, gestion, mensaje.split("#")[1]) );
                }else if(mensaje.startsWith("SUSCRIPTOR#")){
                    System.out.println("Añadiendo suscriptor");
                    gestion.addClientes(new Cliente(socket, gestion, mensaje.split("#")[1]));
                }
            }
        }catch(IOException e){
            System.err.println("Error en el server");
        }
    }
}
