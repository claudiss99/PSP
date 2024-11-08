/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raton;

/**
 *
 * @author Claudia
 */
public class Hilo1 extends Thread{
    int n = 1;
    int div;
    public Hilo1(String nombre, int d) {
        super(nombre);
        this.div = d;
    }
    
    public void mostrar(){
        System.out.println(this.getName()+": "+n);
        n++;

    }
    
    @Override
    public void run(){
        boolean interrumpir = false;
        
        while(!interrumpir){
            try {
                Thread.sleep(1000);
                this.mostrar();
            } catch (InterruptedException ex) {
                this.interrupt();
            }
            if (isInterrupted()){
                if (n%div == 0){
                    interrumpir = true;
                }
            }
        }
    }
}
