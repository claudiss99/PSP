/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raton;

/**
 *
 * @author Claudia
 */
public class main {
    public static void main(String[] args) throws InterruptedException {
        RatonHilo fievel = new RatonHilo("Fievel", 4000);
        RatonHilo jerry = new RatonHilo("Jerry", 5000);
        RatonHilo pinky = new RatonHilo("Pinky", 3000);
        RatonHilo mickey = new RatonHilo("Mickey", 6000);
        
        RatonRunnable fievelR = new RatonRunnable("FievelR", 4000);
        RatonRunnable jerryR = new RatonRunnable("JerryR", 5000);
        RatonRunnable pinkyR = new RatonRunnable("PinkyR", 3000);
        RatonRunnable mickeyR = new RatonRunnable("MickeyR", 6000);
        
        fievel.start();
        jerry.start();
        pinky.start();
        mickey.start();
        
        new Thread(fievelR).start();
        new Thread(jerryR).start();
        new Thread(pinkyR).start();
        new Thread(mickeyR).start();
        
    }
}
