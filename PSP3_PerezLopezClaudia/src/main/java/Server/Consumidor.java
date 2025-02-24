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
public class Consumidor extends Thread{

    private Socket socket;
    private Gestion gestion;
    private BufferedReader reader;
    private PrintWriter writer;
    
    public Consumidor(Socket socket, Gestion gestion) {
        try {
            this.socket = socket;
            this.gestion = gestion;
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void notificado (String mensaje){
        
        writer.println(mensaje);
    }
    
    @Override
    public void run(){
        while(true){
            try {
                System.out.println("esperando mensaje");
                //Recibe pedir_turno
                String recibido = reader.readLine();
                int enviar =0;
                int turno = 0;
                System.out.println("Pido turno: "+recibido);
                if(recibido.equalsIgnoreCase("PEDIR_TURNO#Pescaderia")){
                    turno = gestion.recibePeticion(1, this);
                }else if(recibido.equalsIgnoreCase("PEDIR_TURNO#Carniceria")){
                    turno = gestion.recibePeticion(2, this);
                }
                
                //Envia el turno recibido
                writer.println("TURNO#"+turno);
                
                //FUNCION --> Ha esperando notificado y Envia cuando le toca
                
                
            } catch (IOException ex) {
                 try{
                    socket.close();
                }catch(IOException e){
                    System.err.println("Error al cerrar sesion");
                }
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
