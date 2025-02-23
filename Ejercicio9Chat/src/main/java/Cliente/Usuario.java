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
public class Usuario {
    public static void main(String[] args) {
         String host = "localhost";
        int puerto = 4000;
        
        try (Socket socket = new Socket(host, puerto)) {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            
            System.out.println("Escribe CONECTAR#NOMBRE USUARIO");
            String mensaje = teclado.readLine();
            
            //Lo mando 
            writer.println(mensaje);
            
            //Envio al servidor --> Mientras que no devuelva conectado sigo
            String recibido = reader.readLine();
            System.out.println(recibido);
            while(!recibido.equalsIgnoreCase("CONECTADO")){
                System.out.println(mensaje.split("#")[1]+". Vuelva a introducir usuario");
                //SE ENVIA
                mensaje = teclado.readLine();
                writer.println(mensaje);
                recibido = reader.readLine();
            }
            
            //Si ya estoy conectado --> recibo mensajes del resto
            new UsuarioHilo(reader).start();
            
            while (true) {
                System.out.println("Si quiere mandar un mensaje escribe: MENSAJE#mensaje");
                System.out.println("Si quiere desconectar escriba: DESCONECTAR");
                mensaje = teclado.readLine();
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
