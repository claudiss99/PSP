/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Server {
    private static ArrayList<String> usuarios = new ArrayList<>();
    public static void main(String[] args) {
        int puerto = 4000;
        try(ServerSocket server = new ServerSocket(puerto)){
            
            Sala sala = new Sala();
            while(true){
                
                Socket socket = server.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                
                //Mientras que no sea valido el nombre no podemos conectarlo a la sala
                boolean correcto = false;
                String recibido;
                String nombre = null;

                while(!correcto){
                    recibido=reader.readLine();
                    nombre = recibido.split("#")[1];
                    if(!formato(nombre)){
                        //Si no es correcto
                        writer.println("FALLO#Nombre de usuario no válido");
                    }else if(usuarios.contains(nombre)){
                        //si ya esta registrado ese usuario
                        writer.println("FALLO#Nombre de usuario ya existente");
                    }else{
                        
                        usuarios.add(nombre);
                        System.out.println(usuarios);
                        correcto = true;
                        writer.println("CONECTADO");
                    }
                }
               
                //Ya esta conectado --> lo meto en la sala
                Usuario usuario = new Usuario(socket, sala, nombre);
                usuario.start();
                sala.addUsuario(usuario);
                
            }
        }catch(IOException e){
            System.err.println("Error en el cliente: "+e.getLocalizedMessage());
        }
    }
    
    public static boolean formato(String nombre){
        System.out.println("Comprobando formato");
        return nombre.matches("^[a-zA-Z0-9_-]{3,10}$");
    }
    
    public static void liberar(String nombre){
        for(String u:usuarios){
            if(u == nombre){
                usuarios.remove(u);
            }
        }
    }
}
