/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio10Cliente;

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
    private BufferedReader reader;

    public Restaurante(BufferedReader reader) {
        this.reader = reader;
    }
    
    @Override
    public void run(){
        while(true){
            try {
                System.out.println(reader.readLine());
            } catch (IOException ex) {
                Logger.getLogger(Restaurante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 4000;
        
        try(Socket server = new Socket(host, puerto)){
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
            PrintWriter writer = new PrintWriter(server.getOutputStream(), true);
            
            writer.println("RESTAURANTE");
            //Recibimos pedido --> imprimimos
            System.out.println(reader.readLine());
            while(true){
                String pedido = teclado.readLine();
            }
            
            //Mandamos mensajes
            
        }catch(IOException e){
            System.err.println("Error en el cliente: "+e.getLocalizedMessage());
        }
    }
}
