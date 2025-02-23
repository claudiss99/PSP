/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class UsuarioHilo extends Thread{
    private BufferedReader reader;

    public UsuarioHilo(BufferedReader reader) {
        this.reader = reader;
    }
    
    @Override
    public void run(){
        while(true){
            try {
                System.out.println(reader.readLine());
            } catch (IOException ex) {
                Logger.getLogger(UsuarioHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
