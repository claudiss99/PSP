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
        try(Socket socket = new Socket(host, puerto)){
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            
            //Envia que es suscriptor y la ciudad
            System.out.println("Escribe SUSCRIPTOR#CIUDAD: ");
            String mensaje = teclado.readLine();
            writer.println(mensaje);
            writer.flush();
            
            //El resto del tiempo vamos a estra leyendo y mostrando
            while(true){
                System.out.println("Voy a recibir mensaje");
                System.out.println(reader.readLine()); 
            }
        }catch(IOException e){
            System.err.println("Error en el Cliente");
        }
    }
}
