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
public class Restaurante extends Thread{
    private Socket socket;
    private ManejoPedidos manejo;
    
    private BufferedReader reader;
    private PrintWriter writer;

    public Restaurante(Socket socket, ManejoPedidos manejo) {
        this.socket = socket;
        this.manejo = manejo;
        
        
        try {
            reader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(Comensal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void nuevoPedido(int idPedido, String productos) {
        writer.println("NUEVO#"+idPedido+"#"+productos);
    }
    
    @Override
    public void run(){
        while(true){
            try {
                String mensaje=reader.readLine();
                String[] parts = mensaje.split(("#"));
                manejo.actualizaPedido(Integer.parseInt(parts[1]), parts[0]);
            } catch (IOException ex) {
                Logger.getLogger(Restaurante.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    
    
}
