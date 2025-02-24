/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.net.Socket;

/**
 *
 * @author Usuario
 */
public class Medico {
    private Socket socket;
    private Gestion gestion;

    public Medico(Socket socket, Gestion gestion) {
        this.socket = socket;
        this.gestion = gestion;
    }
    
    
}
