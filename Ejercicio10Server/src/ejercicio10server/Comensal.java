/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio10server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Claudia
 */
public class Comensal extends Thread{
    private Socket socket;
    private ManejoPedidos manejo;
    
    private BufferedReader reader;
    private PrintWriter writer;

    public Comensal(Socket socket, ManejoPedidos manejo) {
        this.socket = socket;
        this.manejo = manejo;
        
        reader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream(socket), true);
    }
    
    
}
