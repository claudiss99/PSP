/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author ClaudissPerez
 */
public class Jugador extends Thread{
    private Socket cliente;
    private Sala sala;

    public Jugador(Socket cliente, Sala sala) {
        this.cliente = cliente;
        this.sala = sala;
    }

    @Override
    public void run() {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter writer = new PrintWriter(cliente.getOutputStream(), true);
            
            
        }catch (IOException e) {
            System.out.println("Error en el manejo de cliente: " + e.getLocalizedMessage());
        } finally {
            try {
                cliente.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el socket: " + e.getLocalizedMessage());
            }
        }
    }
    
    
}
