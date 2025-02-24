/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Claudia
 */
public class Gestion {
    private ArrayList<Consumidor> consumidores;
    private ArrayList<Puesto> trabajadoresPescaderia;
    private ArrayList<Puesto> trabajadoresCarniceria;
    private HashMap<Integer, Consumidor> colaCarniceria;
    private HashMap<Integer, Consumidor> colaPescaderia;
    private int siguienteCarniceria;
    private int siguientePescaderia;
    private int turnoCarniceria;
    private int turnoPescaderia;
    
    public Gestion() {
        this.consumidores = new ArrayList<>();
        this.trabajadoresPescaderia = new ArrayList<>();
        this.trabajadoresCarniceria = new ArrayList<>();
        this.colaCarniceria = new HashMap<>();
        this.colaPescaderia = new HashMap<>();
        this.turnoCarniceria = 0;
        this.turnoPescaderia =0;
        this.siguienteCarniceria =0;
        this.siguientePescaderia = 0;
    }
    
    public void addConsumidor(Consumidor consumidor){
        consumidores.add(consumidor);
        consumidor.start();
    }
    
    public void addPescaderia(Puesto puesto){
        trabajadoresPescaderia.add(puesto);
        puesto.start();
    }
    
    public void addCarniceria(Puesto puesto){
        trabajadoresCarniceria.add(puesto);
        puesto.start();
    }
    
    public int recibePeticion (int opcion, Consumidor consumidor){
        System.out.println("Soy gestion recibo peticion");
        int turno;
        if(opcion == 1){
            //Añadir a la cola y darle el turno
            turnoPescaderia++;
            colaPescaderia.put(turnoPescaderia, consumidor);
            turno = turnoPescaderia;
        }else{
            //Añadir a la cola y darle el turno
            turnoCarniceria++;
            colaCarniceria.put(turnoCarniceria, consumidor);
            turno = turnoCarniceria;
        }
        
        return turno;
    }
    
    public String libre (String puesto){
        System.out.println("sOY gestion estas en la funcion libre. Este es el puesto libre: "+puesto);
        String mensaje = null;
        int cliente;
        if(puesto.equalsIgnoreCase("Carniceria")){
            System.out.println("El puesto era carniceria");
            //Miramos cola de carnicería
            if(colaCarniceria.isEmpty()){
                System.out.println("La cola esta vacia, no hay gente "+colaCarniceria);
                mensaje = "NO_CLIENTES";
            }else{
                System.out.println("El puesto era carniceria y si hay gente");
                cliente = siguienteCarniceria;
                System.out.println("Le toca a: "+cliente);
                mensaje = "CLIENTE#"+cliente;
                notificarTurno("TU_TURNO#Carniceria", colaCarniceria.get(cliente));
                colaCarniceria.remove(cliente);
                //Aumentamos el cliente que le tocaria siguiente
                siguienteCarniceria++;
            }
        }else if(puesto.equalsIgnoreCase("Pescaderia")){
            //Miramos cola de carnicería
            if(colaPescaderia.isEmpty()){
                mensaje = "NO_CLIENTES";
            }else{
                cliente = siguientePescaderia;
                mensaje = "CLIENTE#"+String.valueOf(cliente);
                notificarTurno("TU_TURNO#Pescaderia", colaCarniceria.get(cliente));
                colaPescaderia.remove(cliente);
                //Aumentamos el cliente que le tocaria siguiente
                siguientePescaderia++;
            }
        }
        return mensaje;
    }
    
    public void notificarTurno(String mensaje, Consumidor consumidor){
        for(Consumidor c:consumidores){
            if(c == consumidor){
                //Si es mi consumidor le enviamos mensaje 
                c.notificado(mensaje);
            }
        }
    }
    
}
