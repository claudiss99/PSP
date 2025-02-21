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
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Gestion {
    private Socket socket;
    private Sensor sensor;
    private ArrayList<Suscriptor> suscriptoresTemp;
    private ArrayList<Suscriptor> suscriptorsHum;
    
    public Gestion() {
        suscriptoresTemp = new ArrayList<>();
        suscriptorsHum = new ArrayList<>();
    }
    
    public void setSensor(Sensor sensor){
        sensor=sensor;
        sensor.start();
    }
    
    public void addSuscriptorTemp(Suscriptor suscriptor){
        suscriptoresTemp.add(suscriptor);
    }
    
    public void addSuscriptorHum(Suscriptor suscriptor){
        suscriptorsHum.add(suscriptor);
    }
    
    public void mandar(ArrayList<Suscriptor> suscriptores, String mensaje){
        for(Suscriptor s:suscriptores){
            System.out.println("Mando el mensaje de temperatura");
            s.notificado(mensaje);
        }
    }
    
    public void recibir(String mensaje){
        //Recibe datos del sensor --> Y los envia a los suscriptores
        System.out.println("Soy recibir en el gestor, el mensaje es: "+mensaje);
        if(mensaje.startsWith("TEMPERATURA")){
            mandar(suscriptoresTemp, mensaje);
        }else if(mensaje.startsWith("HUMEDAD")){
            System.out.println("Gente en humedad: "+suscriptorsHum.size());
            mandar(suscriptorsHum, mensaje);
        }else{
            mandar(suscriptoresTemp, mensaje);
            mandar(suscriptorsHum, mensaje);
        }
        
        
    }
    
    
}
