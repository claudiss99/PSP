/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raton;

/**
 *
 * @author Claudia
 */
public class HiloInfinito extends Thread{

    public HiloInfinito(String nombre) {
        super(nombre);
    }
    
    @Override
    public void run(){
        while(!isInterrupted()){
            System.out.println(this.getName());
            
        }
    }
    
}
