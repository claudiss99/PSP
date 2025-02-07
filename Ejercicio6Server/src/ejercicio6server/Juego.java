/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio6server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author ClaudissPerez
 */
public class Juego extends Thread{
    private Socket socket;
    private String[] palabras;

    public Juego(Socket socket, String[] palabras) {
        this.socket = socket;
        this.palabras = palabras;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Recibido comenzar
            String mensaje = reader.readLine();
            boolean again=true;
            
            //Que pasa si no manda ni salir ni comenzar????????
            
            while (again) {
                /*
                String mensaje = reader.readLine();
                if(mensaje.equalsIgnoreCase("SALIR")){
                    break;
                }
                
                
                */
                //Elijo palabra
                String palabra = palabras[new Random().nextInt(palabras.length)];
                char[] huecos = new char[palabra.length()];
                //Relleno de guiones
                Arrays.fill(huecos, '_');
                int fallos = 0;
                boolean usada = false;
                // El servidor envía "PALABRA_ELEGIDA" y la palabra codificada
                System.out.println("Jugando con: "+palabra);
                writer.println("PALABRA_ELEGIDA");
                writer.println(String.join(" ", new String(huecos).split("")));

                //Guardar letras usadas para no contar dos veces
                ArrayList<Character> letrasUsadas = new ArrayList<>();
                while (fallos < 6 && new String(huecos).contains("_")) {
                    //Recibe letra o palabra del cliente
                    mensaje = reader.readLine(); 

                    if (mensaje.length() == 1) {
                        // Intento una letra
                        char letra = Character.toLowerCase(mensaje.charAt(0));
                        //Si la letra no se ha usado se contabiliza
                        if (!letrasUsadas.contains(letra)) {
                            letrasUsadas.add(letra);
                        }else{
                            //Si ya se ha usado
                            usada = true;
                        }
                        boolean contiene = false;
                        //Si mi palabra contiene la letra relleno
                        for (int i = 0; i < palabra.length(); i++) {
                            if (Character.toLowerCase(palabra.charAt(i)) == letra) {
                                huecos[i] = mensaje.charAt(0);
                                contiene = true;
                            }
                        }
                        
                        if(!contiene){
                            if(!usada){
                                    //Si no se ha usado resto
                                    fallos ++;
                            }else{
                                //Reseteo variable
                                usada = false;
                            }
                            
                            //Si tengo 6 fallos
                            if(fallos==6){
                                writer.println("DERROTA "+fallos);
                                writer.println("Perdiste. La palabra era "+palabra);
                            }else{
                                //He fallado uno
                                writer.println("FALLO "+fallos);
                                writer.println(String.join(" ", new String(huecos).split("")));
                            }
                        }else{
                            //Si ha acertado, miro si ya he acertado entero
                                if(!new String(huecos).contains("_")){
                                    writer.println("COMPLETADO "+fallos);
                                    writer.println("ENHORABUENA! GANASTE");
                                }else{
                                    //He acertado la letra
                                    writer.println("ACIERTO "+fallos);
                                    writer.println(String.join(" ", new String(huecos).split("")));
                                }
                        }

                    } else {
                        // Intento de una palabra
                        if (mensaje.equalsIgnoreCase(palabra)) {
                            //Si acierto palabra
                            huecos = palabra.toCharArray();
                            writer.println("COMPLETADO " + fallos);
                            writer.println("ENHORABUENA! GANASTE");
                        } else {
                            fallos += 2;
                            if(fallos==6){
                                writer.println("DERROTA "+fallos);
                                writer.println("Perdiste. La palabra era "+palabra);
                            }else{
                                //He fallado dos
                                writer.println("FALLO "+fallos);
                                writer.println(String.join(" ", new String(huecos).split("")));
                            }
                        }
                    }
                }
                
                // Recibido comenzar o recibido salir
                mensaje = reader.readLine();
                if("SALIR".equals(mensaje)){
                    again=false;
                }
                
            }
        } catch (IOException e) {
            System.out.println("Error en el manejo de cliente: " + e.getLocalizedMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el socket: " + e.getLocalizedMessage());
            }
        }
    }
}
