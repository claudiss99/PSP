/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebat3;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author Claudia
 */
public class TestURL {
    private static void analizar(URL url){
        System.out.println("\t URL completa: "+url.toString());
        System.out.println("\t getProtocol(): "+url.getProtocol());
        System.out.println("\t getHost(): "+url.getHost());
        System.out.println("\t getPort(): "+url.getPort());
        System.out.println("\t getFile(): "+url.getFile());
        System.out.println("\t getUserInfo: "+url.getUserInfo());
        System.out.println("\t getPath(): "+url.getPath());
        System.out.println("\t getAuthority(): "+url.getAuthority());
        System.out.println("\t getQuery(): "+url.getQuery());
        System.out.println("\t getDefaultPort(): "+url.getDefaultPort());  
    }
    
    public static void main(String[] args) {
        try{
            URL url;
            System.out.println("Constructor obsoleto para una URL: ");
            url = new URL("https://docs.oracle.com");
            analizar(url);
            
            System.out.println("Constructor para una URL usando la clase URI:");
            url = new URI("https://docs.oracle.com").toURL();
            analizar(url);
            
            System.out.println("---------------------------------------");
            
            System.out.println("Constructor simple para una URL usando la clase URI:");
            url= new URI("https://docs.oracle.com/en/java").toURL();
            analizar(url);
            
            System.out.println("Constructor completo para una URL usando la clase URI:");
            url = new URI("https://docs.oracle.com","/en/java", null).toURL();
            analizar(url);
        }catch(MalformedURLException | URISyntaxException e){
            e.printStackTrace();
        }
    }
}
