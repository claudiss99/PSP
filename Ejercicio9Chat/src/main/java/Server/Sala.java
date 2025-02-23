/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Sala {
    private Socket socket;
    private ArrayList<Usuario> usuarios;

    public Sala() {
        this.usuarios = new ArrayList<>();
    }
    
    void addUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    
    public void mostrarMensaje(String mensaje){
        
        for(Usuario u:usuarios){
            u.notificar(mensaje);
        }
    }
    
    public void liberar(String nombre){
        for(Usuario u:usuarios){
           if (u.getNombre() == nombre){
               usuarios.remove(u);
            }
        }
        //borramos de los nombre
        Server.liberar(nombre);
    }
}
