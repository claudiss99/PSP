/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author ClaudissPerez
 */
public class ClienteHandler implements Runnable {
    private Socket socket;

    public ClienteHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter escribir = new PrintWriter(socket.getOutputStream(), true);

            String mensaje;
            Random rand = new Random();
            int numero = rand.nextInt(100) + 1; // Número aleatorio entre 1 y 100
            boolean jugando = true;

            escribir.println("INICIAR");

            // Esperar a que el cliente envíe la palabra clave para empezar
            mensaje = reader.readLine();
            if ("INICIAR".equals(mensaje)) {
                escribir.println("NUMERO_ELEGIDO");
            }

            while (jugando) {
                // Leer el intento del cliente
                mensaje = reader.readLine();
                int intento = Integer.parseInt(mensaje);

                if (intento > numero) {
                    escribir.println("MAS_BAJO");
                } else if (intento < numero) {
                    escribir.println("MAS_ALTO");
                } else {
                    escribir.println("CORRECTO");
                    // Preguntar si quiere jugar de nuevo
                    escribir.println("¿Quieres jugar otra vez? (si/no)");
                    mensaje = reader.readLine();

                    if ("si".equalsIgnoreCase(mensaje)) {
                        numero = rand.nextInt(100) + 1; // Nuevo número aleatorio
                        escribir.println("INICIAR");
                        mensaje = reader.readLine();
                        if ("INICIAR".equals(mensaje)) {
                            escribir.println("NUMERO_ELEGIDO");
                        }
                    } else {
                        escribir.println("SALIR");
                        jugando = false;
                    }
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
