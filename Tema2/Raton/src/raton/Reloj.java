/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raton;


/**
 *
 * @author Claudia
 */
public class Reloj extends Thread{
    private int t =1;
    public Reloj() {
        super();
    }
    
    @Override
    public void run(){
        while(!isInterrupted()){
            try {
                Thread.sleep(1000);
                System.out.println("Reloj: "+t+" segundos");
                t++;
            } catch (InterruptedException ex) {
                this.interrupt();
            }

        }
    }
    
}
