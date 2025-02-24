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
import java.util.Scanner;

/**
 *
 * @author Claudia
 */
public class Consumidor {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 4000;
        try(Socket socket = new Socket(host, puerto)){
            
            Scanner sc = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            
            //ENVIO CONSUMIDOR
            writer.println("CONSUMIDOR");
            
            while(true){
                //ENVIO PEDIR TURNO
                System.out.println("Escribe 1 para PESCADERIA, 2 para CARNICERIA:");
                String teclado = sc.nextLine();

                if(teclado.equalsIgnoreCase("1")){
                    writer.println("PEDIR_TURNO#Pescaderia");
                }else if(teclado.equalsIgnoreCase("2")){
                    writer.println("PEDIR_TURNO#Carniceria");
                }
            
                //Recibo turno
                String turno = reader.readLine();
                System.out.println(turno);
            }
            
        }catch(IOException e){
            System.err.println("Error en el consumidor ");
        }
    }
}
