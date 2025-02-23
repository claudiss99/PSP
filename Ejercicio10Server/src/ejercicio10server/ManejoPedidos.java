/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio10server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ClaudissPerez
 */
public class ManejoPedidos extends Thread{
    private Restaurante restaurante;
    private ArrayList<Comensal> comensales;
    public static int numPedidos = 1;
    private HashMap<Integer, Comensal> pedidos;

    public ManejoPedidos(){
        comensales = new ArrayList<>();
        pedidos = new HashMap<>();
    }
    
    
    public void setRestaurante(Restaurante r){
        restaurante = r;
        r.start();
    }
    
    public void addComensal(Comensal c){
        comensales.add(c);
        c.start();
        
    }
    
    public int nuevoPedido(Comensal comensal, String productos){
        restaurante.nuevoPedido(numPedidos, productos);
        pedidos.put(numPedidos, comensal);
        return numPedidos++;
    }
    
    public void actualizaPedido(int idPedido, String estado) {
        //Busca al cliente
        Comensal comensal = pedidos.get(idPedido);
        comensal.sendMessage("ACTUALIZACION#"+estado);
    }

}
