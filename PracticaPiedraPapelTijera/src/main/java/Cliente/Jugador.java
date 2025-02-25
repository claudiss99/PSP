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
            
            String mensaje;
            boolean conectado = false;

            while (!conectado) {
                System.out.println("Escribe LOGIN#NOMBRE_USUARIO:");
                mensaje = teclado.readLine();
                writer.println(mensaje);
                String respuesta = reader.readLine();

                if (respuesta.equalsIgnoreCase("CONECTADO")) {
                    conectado = true;
                } else {
                    System.out.println("Error: " + respuesta + ". Intenta de nuevo.");
                }
            }
            
            boolean again = true;
            while(again){
                //Si ya estoy conectado --> Comenzar
                writer.println("COMENZAR");
                // Recibir mensaje de espera o inicio de juego
                String respuesta = reader.readLine();
                System.out.println(respuesta);  // "ESPERANDO_JUGADORES" o "JUEGO_INICIADO"

                if (respuesta.equalsIgnoreCase("ESPERANDO_JUGADORES")) {
                    System.out.println("Esperando al segundo jugador...");
                    respuesta = reader.readLine();
                    System.out.println(respuesta);  // "JUEGO_INICIADO" cuando el segundo jugador se conecta
                }


                //Mientras que no reciba pierda o gana seguimos
                boolean fin = false;
                String eleccion;
                String recibido;
                while(!fin){
                    //leo y muestro ronda
                    System.out.println(reader.readLine());
                    //Juego
                    System.out.println("Elige 1:PIEDRA, 2:PAPEL o 3:TIJERAS:");
                    eleccion = teclado.readLine();
                    if(eleccion.equalsIgnoreCase("1")){
                        eleccion = "PIEDRA";
                    }else if(eleccion.equalsIgnoreCase("2")){
                        eleccion="PAPEL";
                    }else{
                        eleccion = "TIJERAS";
                    }
                    System.out.println("Se manda JUGAR#" +eleccion);
                    //Mandamos eleccion
                    writer.println("JUGAR#"+eleccion);
                    
                    //LEO RESULTADO
                    recibido=reader.readLine();
                    //Imprimimos
                    System.out.println(recibido);
                    
                    //comprobamos si hemos terminado
                    String puntos = recibido.split("#")[6];
                    String puntos1 = puntos.split("-")[0];
                    String puntos2 = puntos.split("-")[1];
                    if ((puntos1.equalsIgnoreCase("3")) || (puntos2.equalsIgnoreCase("3"))){
                        //recibo gana o pierde
                        recibido = reader.readLine();
                    }
                    //comprobamos resultado
                    if(recibido.equalsIgnoreCase("GANA") || recibido.equalsIgnoreCase("PIERDE") || recibido.equalsIgnoreCase("RIVAL_DESCONECTADO")){
                        System.out.println("hola");
                        fin=true;
                        //Si hemos acabado preguntamos si volver a jugar
                        System.out.println("¿Quierees volver a jugar SI|NO?");
                        mensaje = teclado.readLine();
                        
                        if(mensaje.equalsIgnoreCase("NO")){
                            again=false;
                            
                            //Enviamos al servidor logout
                            writer.println("LOGOUT");
                            socket.close();
                        }
                        //Si no, queremos continuar
                    }
                    //Si no, continuamos jugando
                }
            }
            
        }catch(IOException e){
            System.err.println("Error en el cliente: "+e.getLocalizedMessage());
        }
    }
}
