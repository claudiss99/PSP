/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio10;

/**
 *
 * @author Claudia
 */
public class Hilos10 extends Thread{
    int n = 0;
    int div;
    public Hilos10(String nombre, int d) {
        super(nombre);
        this.div = d;
    }
    
    public void mostrar(){
       

    }
    
    @Override
    public void run(){
        boolean interrumpir = false;
        
        while(!interrumpir){
            if (isInterrupted()){
                if (n%div == 0){
                    interrumpir=true;
                }
            }
            if(!interrumpir){
                n++;
                try {
                     System.out.println(this.getName()+": "+n);

                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    this.interrupt();
                }
            }
            
           
        }
    }
}
