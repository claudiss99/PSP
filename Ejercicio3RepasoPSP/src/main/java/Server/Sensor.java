/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Claudia
 */
public class Sensor extends Thread{
    private Socket socket;
    private Gestion gestion;
    private BufferedReader reader;

    public Sensor(Socket socket, Gestion gestion) {
        try {
            this.socket = socket;
            this.gestion = gestion;
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void run(){
        //Recibe mensajes del sensor
        while(true){
            try {
                String mensaje = reader.readLine();
                //Recibe mensaje y lo envia
                gestion.recibir(mensaje);
                
            } catch (IOException ex) {
                Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
