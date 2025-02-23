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

/**
 *
 * @author Usuario
 */
public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 4000;
        
        try (Socket socket = new Socket(host, puerto)) {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            
            System.out.println("Escribe DADO#numCaras o DADOS#numDados#numCaras:");
            String mensaje = teclado.readLine();
            while (true) {
                //Envio el mensaje
                writer.println(mensaje);

                //Leo y escribo por pantalla
                System.out.println(reader.readLine());
                
                System.out.println("Escribe DADO#numCaras o DADOS#numDados#numCaras:");
                mensaje  = teclado.readLine();
            }
        }catch(IOException e){
            System.err.println("Error en el cliente: "+e.getLocalizedMessage());
        }
    }
}
