/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio10clientecomensal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ClaudissPerez
 */
public class Ejercicio10ClienteComensal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // TODO code application logic here
        String host = "localhost";
        int puerto = 4000;
        try(Socket socket = new Socket(host, puerto)){
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            
            String mensajeServidor;
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio10ClienteRestaurante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
