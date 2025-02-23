/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Usuario extends Thread{
    private Socket socket;
    private Sala sala;
    private PrintWriter writer;
    private BufferedReader reader;
    private String nombre;

    public Usuario(Socket socket, Sala sala, String nombre) {
        try {
            this.socket = socket;
            this.sala = sala;
            this.nombre = nombre;
            this.writer = new PrintWriter(socket.getOutputStream(), true);
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void notificar(String mensaje){
        //Mandamos mensaje al cliente
        writer.println(mensaje);
    }
    
    @Override
    public void run(){
        while(true){
            try {
                
                //Se conecta --> mandamos notificacion 
                sala.mostrarMensaje("NOTIFICACION#"+this.nombre+" se ha unido al chat");
                
                //Esperamos a que llegue un mensaje
                String mensaje = reader.readLine();
                while(mensaje.startsWith("MENSAJE#")){
                    sala.mostrarMensaje(this.nombre+": "+mensaje.split("#")[1]);
                    mensaje = reader.readLine();
                }
                
                if(mensaje.startsWith("DESCONECTAR#")){
                    sala.mostrarMensaje(this.nombre+" ha salido del chat");
                    sala.liberar(this.nombre);
                }
            } catch (IOException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
