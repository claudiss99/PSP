/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Server;

import com.sun.net.httpserver.Authenticator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Usuario
 */
public class Server {

    public static void main(String[] args) {
        int puerto = 4000;
        
        try (ServerSocket serverSocket = new ServerSocket(puerto)){
            Gestion gestion = new Gestion();
            BufferedReader reader;
            String mensaje;
            //Quieor aceptar todo el rato clientes
            while(true){
                Socket socket = serverSocket.accept();
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //Recibo mensaje identificativo(SENSOR O SUSCRIPTOR)
                mensaje = reader.readLine();
               //compruebo el mensaje
                if(mensaje.equalsIgnoreCase("SENSOR")){
                    gestion.setSensor(new Sensor(socket, gestion));
                    
                }else if(mensaje.startsWith("SUSCRIPTOR#")){
                    if(mensaje.split("#")[1].equalsIgnoreCase("TEMPERATURA")){
                        gestion.addSuscriptorTemp(new Suscriptor(socket,gestion));
                    }else if(mensaje.split("#")[1].equalsIgnoreCase("HUMEDAD")){
                        System.out.println("Soy el server llamando al añadir suscriproe");
                        gestion.addSuscriptorHum(new Suscriptor(socket, gestion));
                    }else{
                        gestion.addSuscriptorTemp(new Suscriptor(socket, gestion));
                        gestion.addSuscriptorHum(new Suscriptor(socket, gestion));
                    }
                }
              
                
            }
        }catch(IOException e){
            System.err.println("Error en el servidor: "+e.getLocalizedMessage());
        }
    }
}
