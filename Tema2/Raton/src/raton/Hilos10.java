/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raton;

/**
 *
 * @author Claudia
 */
public class Hilos10 extends Thread{
    int n = 1;
    int div;
    public Hilos10(String nombre, int d) {
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
            //aqui se pondria el for de 90???
            try {
                this.mostrar();
                Thread.sleep(1000);
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
