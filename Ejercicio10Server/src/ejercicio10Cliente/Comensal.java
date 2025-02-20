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

/**
 *
 * @author Claudia
 */
public class Comensal {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 4000;
        
        try(Socket server = new Socket(host, puerto)){
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
            PrintWriter writer = new PrintWriter(server.getOutputStream(), true);

            writer.println("COMENSAL");
            String pedido = teclado.readLine();
            //Envio pedido
            writer.println(pedido);
            //Mejor mientras mensaje sea diferente de entregado
            for(int i=0; i<4; i++){
                System.out.println(reader.readLine());
            }
            
        }catch(IOException e){
            System.err.println("Error en el cliente: "+e.getLocalizedMessage());
        }
    }
}
