/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio9server;

import java.net.Socket;

/**
 *
 * @author Claudia
 */
public class Chat extends Thread{
    private Socket socket;

    public Chat(Socket socket) {
        this.socket = socket;
    }
    
    
}
