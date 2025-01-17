/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebat3;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Claudia
 */
public class TestInetAddress {

    public static void metodos(InetAddress dir) {
        System.out.println("\t Método getByName(): "+dir);
        try{
            InetAddress dir2 = InetAddress.getLocalHost();
            System.out.println("\t Método getLocalHost(): " +dir2);
            
        }catch(UnknownHostException e){
            e.printStackTrace();
        }
        
        System.out.println("\t Método getHostName(): "+dir.getCanonicalHostName());
        System.out.println("\t Método getHostAddress(): "+dir.getHostAddress());
        System.out.println("\t Método toString(): "+dir.toString());
        System.out.println("\t Método getCanonicalHostName(): "+dir.getCanonicalHostName());
        
        try{
            //Array de tipo InetAddress con todas las direcciones IP asignadas a ese hostname
            System.out.println("\t Direcciones IP para: "+dir.getHostName());
            InetAddress[] direccionesIP = InetAddress.getAllByName(dir.getHostName());
            for (InetAddress dirIP: direccionesIP){
                System.out.println("\t\t" +dirIP.toString());
            }
        }catch(UnknownHostException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        InetAddress dir = null;
        try{
            System.out.println("Salida para localhost");
            dir= InetAddress.getByName("localhost");
            metodos(dir);
            
            System.out.println("--------------------------");
            
            System.out.println("Salida para la url");
            dir= InetAddress.getByName("www.google.es");
            metodos(dir);
        }catch(UnknownHostException e){
            e.printStackTrace();
        }
    }
    
}
