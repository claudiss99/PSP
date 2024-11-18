/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio12;

/**
 *
 * @author Usuario
 */
public class Cuenta {
    private int saldo;

    public Cuenta(int aleat) {
        this.saldo = aleat;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    public synchronized void retirar(int cantidad, String nombre) throws InterruptedException{
        if (cantidad <= saldo){
            System.out.println(nombre+" va a retirar "+cantidad+"€. Saldo actual: "+saldo+"€.");
            Thread.sleep(500);
            saldo = saldo - cantidad;
            System.out.println(nombre+" ha retirado: "+cantidad+"€. Saldo actual: "+saldo+"€.");
        }else{
            System.out.println(nombre+" no puede retirar "+cantidad+"€. Saldo actual: "+saldo+"€.");
        }
       
    }
}
