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

            String respuesta;
            String recibido;
            boolean again = true;
            while (again) {
                // Enviar "COMENZAR" para iniciar una nueva partida
                writer.println("COMENZAR");

                // Recibir "PALABRA_ELEGIDA" y la palabra codificada
                recibido = reader.readLine();
                System.out.println(recibido); 
                recibido = reader.readLine();
                System.out.println(recibido);

                int fallos = 0;
                boolean juegoActivo = true;

                while (juegoActivo) {
                    System.out.println("Introduce una letra o una palabra:");
                    String intento = teclado.readLine();
                    
                    //Escrube letra o palabra
                    writer.println(intento);
                    
                    // Recibe acierto, fallo, completado o derrota
                    recibido = reader.readLine();
                    //Hay que quedarse con la segunda parte del mensaje: fallos
                    String[] partes = recibido.split(" ");
                    fallos = Integer.parseInt(partes[1]);
                    //Si completado o derrota --> juegoActivo a false
                    if(recibido.startsWith("COMPLETADO") || recibido.startsWith("DERROTA")){
                        juegoActivo= false;
                    }
                    
                    if (fallos == 0){
                        System.out.println("------|\n" +
                        "|\n" +
                        "|\n" +
                        "|\n" +
                        "|\n" +
                        "=======\n" +
                        "");
                    }else if(fallos == 1){
                        System.out.println("------|\n" +
                        "|     O\n" +
                        "|\n" +
                        "|\n" +
                        "|\n" +
                        "=======\n" +
                        "");
                    }else if(fallos == 2){
                        System.out.println("------|\n" +
                        "|     O\n" +
                        "|     |\n" +
                        "|\n" +
                        "|\n" +
                        "=======\n" +
                        "");
                    }else if(fallos == 3){
                        System.out.println("------|\n" +
                        "|     O\n" +
                        "|    /|\n" +
                        "|\n" +
                        "|\n" +
                        "=======");
                    }else if(fallos == 4){
                        System.out.println("------|\n" +
                        "|     O\n" +
                        "|    /|\\\n" +
                        "|\n" +
                        "|\n" +
                        "=======");
                    }else if(fallos == 5){
                        System.out.println("------|\n" +
                        "|     O\n" +
                        "|    /|\\\n" +
                        "|    /\n" +
                        "|\n" +
                        "=======");
                    }else if(fallos == 6){
                        System.out.println("------|\n" +
                        "|     O\n" +
                        "|    /|\\\n" +
                        "|    / \\\n" +
                        "|\n" +
                        "=======");
                    }
                    
                    
                    
                    //Recibido mensaje: palabra codificada(aciero o fallo), mensaje enhorabuena o la palabra era esta
                    recibido = reader.readLine();
                    System.out.println(recibido);
                    
                    

                    //Si comienza por acierto o fallo envio letra otra vez (No hago nada)
                }
                //Si juego activo a false --> ¿Quiero jugar otra vez?
                System.out.println("¿Quieres jugar otra vez? Escribe: si/no");
                respuesta = teclado.readLine();
                if(respuesta.equalsIgnoreCase("no")){
                    again=false;
                    writer.println("SALIR");
                    //Si es que si no se hace nada si volvemos a "COMENZAR"
                }
            }
        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getLocalizedMessage());
        }
    }
}

