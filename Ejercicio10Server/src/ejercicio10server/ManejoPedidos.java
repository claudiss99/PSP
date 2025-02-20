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

/**
 *
 * @author ClaudissPerez
 */
public class ManejoPedidos extends Thread{
    private Restaurante restaurante;
    private ArrayList<Comensal> comensales;
    public static int numPedidos = 1;
    

    public ManejoPedidos(){
        comensales = new ArrayList<>();
    }
    
    
    public void setRestaurante(Restaurante r){
        restaurante = r;
        r.start();
    }
    
    public void addComensal(Comensal c){
        comensales.add(c);
        c.start();
        
    }
    
    public int nuevoPedido(String productos){
        restaurante.nuevoPedido(numPedidos, productos);
        return numPedidos++;
    }
    
    
    
//    @Override
//    public void run(){
//        try{
//            BufferedReader readerComensal = new BufferedReader(new InputStreamReader(comensal.getInputStream()));
//            PrintWriter writerComensal = new PrintWriter(comensal.getOutputStream(), true);
//            
//            BufferedReader readerRestaurante= new BufferedReader(new InputStreamReader(restaurante.getInputStream()));
//            PrintWriter writerRestaurante = new PrintWriter(restaurante.getOutputStream(), true);
//            
//            String mensajeComensal;
//            String mensajeRestaurante;
//            int pedido=1;
//            //Recibe pedido del comensal --> NUEVO#pedido con comas
//            mensajeComensal = readerComensal.readLine();
    //          if(mensaje.startwith("NUEVO")
                    gestion.nuevoPedido()
//            //Envia a comensal
//            writerComensal.println("CONFIRMACION#"+String.valueOf(pedido));
//            //Envia a restaurante
//            writerRestaurante.println("NUEVO#"+String.valueOf(pedido)+mensajeComensal);
//            //Se aumenta pedido --> ¿Se podría aumentar antes?
//            pedido++;
//           
//            
//            //Lo siguiente es igual --> puede estar en un while no entregado
//            //si uso esa variable booleana seria concurrente???
//            
//            //Recibe de restaurante --> compruebo que sea preparando??
//            /*
//            if(readerRestaurante.readLine().startwith== "preparando")
//            */
//            mensajeRestaurante = readerRestaurante.readLine();
//            //Envia mensaje al comensal
//            writerComensal.println("ACTUALIZACION#PREPARANDO");
//            //Recibe de restaurante
//            mensajeRestaurante = readerRestaurante.readLine();
//            //Envia mensaje al comensal
//            writerComensal.println("ACTUALIZACION#LISTO");
//            //Recibe de restaurante
//            mensajeRestaurante = readerRestaurante.readLine();
//            //Envia mensaje al comensal
//            writerComensal.println("ACTUALIZACION#ENTREGADO");
//            
//            /*OPCION COMENTADA CON EL WHILE BOOLEANO
//             boolean entregado = false;
//            while(!entregado){
//                //recibo
//                mensajeRestaurante = readerRestaurante.readLine();
//                if(mensajeRestaurante.startsWith("ENTREGADO")){
//                    entregado=true;
//                }
//                String comienzo=mensajeRestaurante.split("#")[0];
//                //envio mensaje
//                writerComensal.println("ACTUALIZACION#"+comienzo);
//            }
//            
//            
//            */
//           
//            
//        }catch(IOException e){
//            System.err.println("Error en el manejo: "+e.getLocalizedMessage());
//        }finally{
//            try{
//                comensal.close();
//                restaurante.close();
//                        
//            }catch(IOException e){
//                System.out.println("Error al cerrar el el cliente: "+e.getLocalizedMessage());
//            }
//        }
//    }

    public ManejoPedidos(ArrayList<Comensal> comensales) {
        this.comensales = comensales;
    }
}
