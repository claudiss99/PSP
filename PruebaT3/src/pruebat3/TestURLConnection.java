/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebat3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Claudia
 */
public class TestURLConnection {
    public static void main(String[] args) {
        try{
            URL url = new URI("https://example.com").toURL();
            URLConnection conexion = url.openConnection();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            
            String line;
            while((line = reader.readLine()) !=null){
                System.out.println(line);
            }
            
            reader.close();
                    
        }catch(MalformedURLException | URISyntaxException e){
            e.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
