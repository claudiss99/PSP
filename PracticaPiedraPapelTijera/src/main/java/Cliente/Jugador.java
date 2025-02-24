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
public class Jugador {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 4000;
        
        try (Socket socket = new Socket(host, puerto)) {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            
            System.out.println("EscribeLOGIN#NOMBRE_USUARIO:");
            String mensaje = teclado.readLine();
            //Envio el mensaje
            writer.println(mensaje);
            
            //Mientras no me envien conectado sigo pidiendo el nombre
            while(!reader.readLine().equalsIgnoreCase("CONECTADO") ){
                System.out.println("EscribeLOGIN#NOMBRE_USUARIO:");
                mensaje = teclado.readLine();
            }
            
            boolean again = true;
            while(again){
                //Si ya estoy conectado --> Comenzar
                writer.println("COMENZAR");

                //leo y muestro esperando
                System.out.println(reader.readLine());

                //leo y mustro juego_iniciado
                System.out.println(reader.readLine());

                //leo y muestro ronda
                System.out.println(reader.readLine());

                //Mientras que no reciba pierda o gana seguimos
                boolean fin = false;
                String eleccion;
                String recibido;
                while(fin){
                    //Juego
                    System.out.println("Elige 1:PIEDRA, 2:PAPEL o 3:TIJERAS:");
                    eleccion = teclado.readLine();
                    if(eleccion=="1"){
                        eleccion = "PIEDRA";
                    }else if(eleccion == "2"){
                        eleccion="PAPEL";
                    }else{
                        eleccion = "TIJERAS";
                    }
                    //Mandamos eleccion
                    writer.println("JUGAR#"+eleccion);
                    eleccion="";
                    recibido=reader.readLine();
                    //Imprimimos
                    System.out.println(recibido);
                    //comprobamos resultado
                    if(recibido.equalsIgnoreCase("GANA") || recibido.equalsIgnoreCase("PIERDE") || recibido.equalsIgnoreCase("RIVAL_DESCONECTADO")){
                        fin=true;
                        //Si hemos acabado preguntamos si volver a jugar
                        System.out.println("¿Quierees volver a jugar SI|NO?");
                        mensaje = teclado.readLine();
                        if(mensaje.equalsIgnoreCase("NO")){
                            again=false;
                            //Enviamos al servidor logout
                            writer.println("LOGOUT");
                        }
                        //Si no queremos continuar
                    }
                    //Si no continuamos jugando
                }
            }
            
        }catch(IOException e){
            System.err.println("Error en el cliente: "+e.getLocalizedMessage());
        }
    }
}
