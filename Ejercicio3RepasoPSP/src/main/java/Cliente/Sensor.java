/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Sensor {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 4000;
        
        try (Socket socket = new Socket(host, puerto)) {
       
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            
           writer.println("SENSOR");
            while (true) {
                //Envio el mensaje temperatura
                writer.println("TEMPERATURA#"+new Random().nextInt(20, 30));
                
                //Envio mensaje humedad
                writer.println("HUMEDAD#"+new Random().nextInt(70, 90)+"%");
                
                //eSPERO 2S
                Thread.sleep(2000);
               
            }
        }catch(IOException e){
            System.err.println("Error en el cliente: "+e.getLocalizedMessage());
        } catch (InterruptedException ex) {
            Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
