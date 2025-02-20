/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Usuario
 */
public class Server {

    public static void main(String[] args) {
        int puerto = 4000;
        try(ServerSocket server = new ServerSocket(puerto)){
            
            //Instanciamos la clase Gestion
            Gestion gestion;
            while(true){
                Socket socket = server.accept();
                gestion = new Gestion(socket);
                gestion.start();
            }
        }catch(IOException e){
            System.err.println("Error en el cliente: "+e.getLocalizedMessage());
        }
    }
}
