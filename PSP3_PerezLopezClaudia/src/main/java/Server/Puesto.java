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
 * @author Claudia
 */
public class Puesto extends Thread{
    private Socket socket;
    private Gestion gestion;
    BufferedReader reader;
    PrintWriter writer;
    private String puesto;

    public Puesto(Socket socket, Gestion gestion, String puesto) {
        try {
            this.socket = socket;
            this.gestion = gestion;
            this.puesto = puesto;
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(Puesto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run(){
        while(true){
            
            try {
                //Recibo SIGUIENTE
                String recibido = reader.readLine();
                System.out.println("He recibido "+recibido);
                if(recibido.equalsIgnoreCase("SIGUIENTE")){
                    //Estoy libre y soy carnicero o soy pescadero
                    System.out.println("Soy el puesto  --> Estoy libre");
                    String mensaje = gestion.libre(this.puesto);
                    //Envio el mensaje NO_CLIENTES O CLIENTE#NUM
                    writer.println(mensaje);
                }
            } catch (IOException ex) {
                try{
                    socket.close();
                }catch(IOException e){
                    System.err.println("Error al cerrar sesion");
                }
                Logger.getLogger(Puesto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
