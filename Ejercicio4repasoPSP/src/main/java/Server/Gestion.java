/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class Gestion {
    private ArrayList<Cliente> clientes;
    private ArrayList<Sensor> sensores;

    public Gestion() {
        clientes = new ArrayList<>();
        sensores = new ArrayList<>();
    }
    
    public void addClientes(Cliente cliente){
        clientes.add(cliente);
    }
    
    void addSensor(Sensor sensor){
        sensores.add(sensor);
        sensor.start();
    }

    public void recibeMensaje(String mensaje, String ciudad){
        //Recibe y los envia a los Clientes
        System.out.println("Recibo mensaje del sensor: "+mensaje);
        System.out.println("El sensor es de esta ciudad: "+ciudad);
        //Enviar a clientes suscritos a esa ciudad
        for(Cliente c:clientes){
            System.out.println("El cliente es de: "+c.getCiudad());
            //Comprobar la ciudad
            if(c.getCiudad().equalsIgnoreCase(ciudad)){
                //Envio mensaje
                System.out.println("Envio el mensaje al suscripptor");
                c.enviarMensaje(mensaje);
            }
        }
        
    }
}
