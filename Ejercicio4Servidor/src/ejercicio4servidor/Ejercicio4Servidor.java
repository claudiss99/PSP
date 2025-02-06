/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio4servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author ClaudissPerez
 */
public class Ejercicio4Servidor {
    
    public static void main(String[] args) {
        // TODO code application logic here
        int puerto = 4000;
        String [] palabras = {"Tortitas", "Bizcocho", "Magdalenas", "Galletas", "Cereales"};
        
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado. Esperando cliente...");
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado");
                
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter escribir = new PrintWriter(socket.getOutputStream(), true);

                String palabra = palabras[new Random().nextInt(palabras.length)];
                char[] huecos= new char[palabra.length()];
                Arrays.fill(huecos, '_');
                int vidas = 5;
                System.out.println("Jugando con la palabra: "+palabra);
                //Escribimos los huecos al cliente
                escribir.println(String.join(" ", new String(huecos).split("")));
                escribir.println("Vidas: "+vidas);
                
                String intento;
                
                while(vidas >0 && new String(huecos).contains("_")){
                    intento = reader.readLine();
                    if(intento.length() ==1){
                        //Intenta 1 letra
                        boolean acierto = false;
                        //Cojo la letra sin espacios y en minus
                        char letra = Character.toLowerCase(intento.charAt(0));
                        //Recorro palabra
                        for(int i=0; i<palabra.length(); i++){
                            //Si coincide
                            if(Character.toLowerCase(palabra.charAt(i)) == letra){
                                //Relleno hueco con la letra
                                huecos[i] = intento.charAt(0);
                                acierto = true;
                            }
                        }
                        
                        if(!acierto){
                            vidas--;
                        }
                    }else if(intento.length()>1){
                        //Intenta palabra
                        if(intento.equalsIgnoreCase(palabra)){
                            huecos= palabra.toCharArray();
                        }else{
                            vidas -=2;
                        }
                    }
                    escribir.println(String.join(" ", new String(huecos).split("")));
                    escribir.println("Vidas: " + vidas);
                }
                
                if(vidas == 0){
                    escribir.println("Ha perdido. La palabra era: "+palabra);
                }else{
                    System.out.println("Palabra acertada, esperando otro cliente...");
                    escribir.println("Muy bien! Has acertado la palabra");
                }

                System.out.println("Cliente desconectado. Cerrando servidor...");
            }


        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getLocalizedMessage());
        }
    }
    
}
