/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio10server;

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
public class Comensal extends Thread{
    private Socket socket;
    private ManejoPedidos manejo;
    
    private BufferedReader reader;
    private PrintWriter writer;
    
    private int idPedido;

    public Comensal(Socket socket, ManejoPedidos manejo) {
        this.socket = socket;
        this.manejo = manejo;
        
        
        try {
            reader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(Comensal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendMessage(String msg){
        writer.println(msg);
    }
    @Override
    public void run(){
        try {
            String mensaje = reader.readLine();
            if(mensaje.startsWith("NUEVO")){
                idPedido = manejo.nuevoPedido(this, mensaje.split("#", 2)[1]);
                writer.println("CONFIRMACION#"+idPedido);
            }
        }catch(IOException e){
            System.err.println("Error en el comensal servidor");
        }
    }
    
    
}
