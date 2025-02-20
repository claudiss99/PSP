/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class Gestion extends Thread{
    private Socket socket;
    
    public Gestion(Socket socket) {
        this.socket = socket;
    }
    
    public int suma(ArrayList<String> cadena){
        int suma =0;
        for(String c:cadena){
            suma += Integer.parseInt(c);
        }
        return suma;
    }
    
    public int media(ArrayList<String> cadena){
        //LLamamos a suma y calculamos media
        return suma(cadena)/cadena.size();
    }
    
    public int contar(ArrayList<String> cadena){
        return cadena.size();
    }
    
    public int max(ArrayList<String> cadena){
        return max(cadena);
    }
    
    public int min(ArrayList<String> cadena){
        return min(cadena);
    }
    
    @Override
    public void run(){
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            
            String mensaje = null;
            //Leo primera vez
            mensaje = reader.readLine();
            //Quiero jugar hasta que Cliente diga "SALIR"
            while(!mensaje.equalsIgnoreCase("SALIR")){
               //Guardo la lista de numeros --> 2º Parte(Desoues de #)
               ArrayList<String> numeros = new ArrayList<>(Arrays.asList(mensaje.split("#")[1].trim().split(" ")));
                //¿Qué operacion hay que hacer?
                String operacion = mensaje.split("#")[0];
                int resultado=0;
                switch (operacion) {
                    case "SUMA":
                        resultado = suma(numeros);
                        break;
                    case "MEDIA":
                        resultado = media(numeros);
                        break;
                    case "CONTAR":
                        resultado = contar(numeros);
                        break;
                    case "MAXIMO":
                       resultado = max(numeros);
                        break;
                    case "MINIMO":
                        resultado = min(numeros);
                        break;
                    case "TODO":
                        writer.println(operacion+"#"+suma(numeros));
                        writer.println(operacion+"#"+media(numeros));
                        writer.println(operacion+"#"+contar(numeros));
                        writer.println(operacion+"#"+max(numeros));
                        writer.println(operacion+"#"+min(numeros));
                        break;
                }
                if(!operacion.startsWith("TODO")){
                    writer.println(operacion+"#"+resultado);
                }
               
                //Leo al terminar para ver si salgo
                mensaje = reader.readLine();
            }
        }catch(IOException e){
            System.err.println("Error en la gestion: "+e.getLocalizedMessage());
        }
    }
    
}
