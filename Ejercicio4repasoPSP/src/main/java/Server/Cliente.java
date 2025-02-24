/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Cliente {
    private Socket socket;
    private Gestion gestion;
    private String ciudad;
    private PrintWriter writer;
    
    public Cliente(Socket socket, Gestion gestion, String ciudad) {
        try {
            this.socket = socket;
            this.gestion = gestion;
            this.ciudad = ciudad;
            writer = new PrintWriter(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getCiudad(){
        return this.ciudad;
    }
    
    public void enviarMensaje(String mensaje){
        System.out.println("Soy el cliente del server: envio mensaje: "+mensaje);
        writer.println(mensaje);
        writer.flush();
    }
    
}
