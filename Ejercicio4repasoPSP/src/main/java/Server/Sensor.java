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
public class Sensor extends Thread{
    private Socket socket;
    private Gestion gestion;
    private String ciudad;
    
    private BufferedReader reader;

    public Sensor(Socket socket, Gestion gestion, String ciudad) {
        try {
            this.socket = socket;
            this.gestion = gestion;
            this.ciudad = ciudad;
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @Override
    public void run(){
        while(true){
            try {
                //Recibe los mensajes del sensor y Los envia al gestor
                String mensaje = reader.readLine();
                System.out.println(mensaje);
                gestion.recibeMensaje(mensaje, this.ciudad);
            } catch (IOException ex) {
                Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
}
