/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio6cliente;

/**
 *
 * @author ClaudissPerez
 */
import java.io.*;
import java.net.*;

public class Ejercicio6Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 4000;

        try (Socket socket = new Socket(host, puerto)) {
            System.out.println("Conectado al servidor. Iniciando juego...");

            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String recibido;
            while (true) {
                // Enviar "COMENZAR" para iniciar una nueva partida
                writer.println("COMENZAR");

                // Recibir "PALABRA_ELEGIDA" y la palabra codificada
                recibido = reader.readLine();
                System.out.println(recibido); 
                recibido = reader.readLine();
                System.out.println("Palabra codificada: " + recibido);

                int fallos = 0;
                boolean juegoActivo = true;

                while (juegoActivo) {
                    System.out.println("Introduce una letra o una palabra:");
                    String intento = teclado.readLine();
                    
                    //Escrube letra o palabra
                    writer.println(intento);
                    
                    recibido = reader.readLine();
                    System.out.println(recibido);

                    recibido = reader.readLine();
                    System.out.println("Palabra codificada: " + recibido);

                    if (recibido.startsWith("COMPLETADO") || recibido.startsWith("DERROTA")) {
                        System.out.println("¿Quieres jugar de nuevo? (si/no)");
                        String respuesta = teclado.readLine();
                        writer.println(respuesta);
                        if ("no".equalsIgnoreCase(respuesta)) {
                            writer.println("SALIR");
                            juegoActivo = false;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getLocalizedMessage());
        }
    }
}

