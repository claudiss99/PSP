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
public class Puesto {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 4000;
        try(Socket socket = new Socket(host, puerto)){
            
            Scanner sc = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            
            //Envio puesto
            System.out.println("Escribe 1 para PESCADERIA, 2 para CARNICERIA:");
            String teclado = sc.nextLine();

            if(teclado.equalsIgnoreCase("1")){
                writer.println("PUESTO#Pescaderia");
            }else if(teclado.equalsIgnoreCase("2")){
                writer.println("PUESTO#Carniceria");
            }
            
            while(true){
                System.out.println("ENVIA SIGUIENTE PARA COGER A OTRA PERSONA");
                //envio siguiente
                writer.println(sc.nextLine());
                writer.flush();
                System.out.println("He enviado siguiente");
                //recibo cliente o no cliente
                System.out.println(reader.readLine());
            }
          
            
        }catch(IOException e){
            System.err.println("Error en el puesto ");
        }
    }
}
