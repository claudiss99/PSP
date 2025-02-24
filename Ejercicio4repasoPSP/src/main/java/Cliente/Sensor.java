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
        
        try(Socket socket = new Socket(host, puerto)){
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            
            //Manda que es un sensor y la ciudad
            System.out.println("Escribe SENSOR#CIUDAD");
            String mensaje = teclado.readLine();
            System.out.println("Enviando: "+mensaje);
            writer.println(mensaje);
            writer.flush();
            
            //eL RESTO DEL TIEMPO ENVIA DATOS
            while(true){
                System.out.println("Enviando: ");
                writer.println("DATOS#"+new Random().nextInt(20, 30)+"#"+new Random().nextInt(70, 90)+"%");
                writer.flush();
                Thread.sleep(2000);
            }
        }catch(IOException e){
            System.err.println("Error en el sensor del cliente");
        } catch (InterruptedException ex) {
            Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
