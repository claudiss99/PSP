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
 * @author Claudia
 */
public class Suscriptor {
    private Socket socket;
    private Gestion gestion;
    private PrintWriter writer;

    public Suscriptor(Socket socket, Gestion gestion) {
        try {
            this.socket = socket;
            this.gestion = gestion;
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(Suscriptor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void notificado(String mensaje){
        //Recibe mensaje y lo envia al cliente
        writer.println(mensaje);
    }
}
