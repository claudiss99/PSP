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
public class Jugador{
    public Socket socket;
    public Gestion gestion;
    private PrintWriter writer;
    private BufferedReader reader;

    public Jugador(Socket socket, Gestion gestion) {
        try {
            this.socket = socket;
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            try{
                socket.close();
            }catch(IOException e){
                System.err.println("Error al cerrar sesion");
            }
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getNombre(){
        String nombre = null;
        try {
            
            //LEO 1º MENSAJE
            nombre= reader.readLine();
            
        } catch (IOException ex) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre;
    }
    
    public void enviarMensaje(String mensaje){
        //Doy el mensaje
        writer.println(mensaje);
    }
    
}
