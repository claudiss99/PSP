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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author ClaudissPerez
 */
public class ClienteHandler implements Runnable {
    private Socket socket;
    private String[] palabras;
    private static final int MAX_FALLOS = 6;

    public ClienteHandler(Socket socket, String[] palabras) {
        this.socket = socket;
        this.palabras = palabras;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            Random random = new Random();

            String palabra = palabras[random.nextInt(palabras.length)];
            char[] huecos = new char[palabra.length()];
            Arrays.fill(huecos, '_');
            int vidas = MAX_FALLOS;

            // El cliente envia COMENZAR
            String mensaje = reader.readLine();
            if ("COMENZAR".equals(mensaje)) {
                // El servidor envía "PALABRA_ELEGIDA" y la palabra codificada
                System.out.println("Jugando con: "+palabra);
                writer.println("PALABRA_ELEGIDA");
                writer.println(String.join(" ", new String(huecos).split("")));

                //Guardar letras usadas para no contar dos veces
                Set<Character> letrasUsadas = new HashSet<>();
                while (vidas > 0 && new String(huecos).contains("_")) {
                    //Recibe letra o palabra del cliente
                    mensaje = reader.readLine(); 

                    if (mensaje.length() == 1) {
                        // Intento una letra
                        char letra = Character.toLowerCase(mensaje.charAt(0));
                        if (letrasUsadas.contains(letra)) {
                            writer.println("Ya has intentado esa letra.");
                            continue;
                        }
                        letrasUsadas.add(letra);

                        for (int i = 0; i < palabra.length(); i++) {
                            if (Character.toLowerCase(palabra.charAt(i)) == letra) {
                                huecos[i] = mensaje.charAt(0);
                            }
                        }

                    } else {
                        // Intento de una palabra
                        if (mensaje.equalsIgnoreCase(palabra)) {
                            huecos = palabra.toCharArray();
                            writer.println("COMPLETADO " + vidas);
                        } else {
                            vidas -= 2;
                        }
                    }
                    
                    //Se le comunica los fallos(muñequito)
                    if (vidas==6){
                        writer.println("------|\n" +
                        "|\n" +
                        "|\n" +
                        "|\n" +
                        "|\n" +
                        "=======");
                    }else if(vidas==5){
                        writer.println("");
                    }else if(vidas==4){
                        writer.println("");
                    }else if(vidas==3){
                        writer.println("");
                    }else if(vidas==2){
                        writer.println("");
                    }else if(vidas==1){
                        writer.println("");
                    }

                    // Enviar la palabra codificada al cliente
                    writer.println(String.join(" ", new String(huecos).split("")));
                }
                
                if(vidas==0){
                    writer.println("DERROTA " + vidas);
                    writer.println("La palabra era: " + palabra);
                }
                
                if (new String(huecos).equalsIgnoreCase(palabra)) {
                    writer.println("COMPLETADO " + vidas);
                }

                // Preguntar si quiere jugar de nuevo
                writer.println("¿Quieres jugar de nuevo? (si/no)");
                mensaje = reader.readLine();

                if ("si".equalsIgnoreCase(mensaje)) {
                    run();  // Reinicia el juego
                } else {
                    writer.println("SALIR");
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
