/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio3servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Claudia
 */
public class Ejercicio3Servidor {

    public static void main(String[] args) {
        int puerto = 4000;

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado. Esperando cliente...");
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter escribir = new PrintWriter(socket.getOutputStream(), true);

            String mensaje;

            do {
                //operación del cliente
                mensaje = reader.readLine();
                //Si no pongo este if entra en el catch
                if (!mensaje.equalsIgnoreCase("salir")) {
                    String[] operacion = mensaje.split(" ");
                    if (operacion.length == 3) {
                        try {
                            int operando1 = Integer.parseInt(operacion[0]);
                            String operador = operacion[1];
                            int operando2 = Integer.parseInt(operacion[2]);
                            double resultado = 0;

                            switch (operador) {
                                case "+":
                                    resultado = operando1 + operando2;
                                    break;
                                case "-":
                                    resultado = operando1 - operando2;
                                    break;
                                case "*":
                                    resultado = operando1 * operando2;
                                    break;
                                case "/":
                                    if (operando2 != 0) {
                                        resultado = operando1 / operando2;
                                    } else {
                                        escribir.println("Error: División por cero");
                                        continue;
                                    }
                                    break;
                                default:
                                    escribir.println("Error: Operador no válido");
                                    
                            }
                            
                            escribir.println("El resultado es: " + resultado);
                        } catch (NumberFormatException e) {
                            //Si no mete numeros
                            escribir.println("Error: Formato de número inválido");
                        }
                    }
                }
            } while (!mensaje.equalsIgnoreCase("salir"));

            System.out.println("Cliente desconectado. Cerrando servidor...");

        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getLocalizedMessage());
        }
    }
}
