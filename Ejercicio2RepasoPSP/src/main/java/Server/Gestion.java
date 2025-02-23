/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Gestion extends Thread{
    private Socket socket;
    private Random random;
    
    public Gestion(Socket socket) {
        this.socket = socket;
    }
    
    public int lanzar(String caras){
        return new Random().nextInt(Integer.parseInt(caras));
    }
    @Override
    public void run(){
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            
            String mensaje = null;
            //Leo primera vez
            mensaje = reader.readLine();
            //Quiero jugar hasta que Cliente no conteste
            while(mensaje != null){
               ArrayList<Integer> numeros = new ArrayList<>();
               //comprobamos si tenemos DADO O DADS
               if(mensaje.startsWith("DADO#")){
                   System.out.println("Tengo un dado");
                   //SACAMOS NUM CARAS --> 2ºPARTE #
                   String caras = mensaje.split("#")[1];
                   
                   //Llamamos a lanzar
                   numeros.add(lanzar(caras));
                   
               }else if(mensaje.startsWith("DADOS#")){
                   System.out.println("Tengo mas de un dado");
                   //Sacamos num dados
                   String dados = mensaje.split("#")[1];
                   //Sacamos num caras
                   String [] caras = mensaje.split("#")[2].split(" ");
                   
                   //LLamamos a la funcion tantos dados tengamos
                   for(int i=0; i<caras.length; i++){
                       System.out.println("Caras: "+caras[i]);
                       //la funcion le metemos cara
                       numeros.add(lanzar(caras[i]));
                   }   
               }
                //Devolvemos resultado
                writer.println("RESULTADO#"+numeros);
                //Leo al terminar para ver si salgo
                mensaje = reader.readLine();
            }
        }catch(IOException e){
            try {
                socket.close();
            } catch (IOException ex) {
                System.err.println("Errpr en la gestion");
            }
            System.err.println("Error en la gestion: "+e.getLocalizedMessage());
        }
    }
}
