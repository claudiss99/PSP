/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raton;

import java.util.Scanner;

/**
 *
 * @author ClaudissPerez
 */
public class VerificaPrimos extends Thread{
    private int number;

    public VerificaPrimos(int number) {
        this.number = number;
    }
    
    @Override
    public void run(){
        //Comprobamos e imprimimos si es primo o no
        boolean primo = true;
        for (int i = 2; i<number; i++){
            if (number % i == 0){
                primo = false;
                break;
            }
        }
        if (primo){
            System.out.println("El numero "+number+" es primo");
        }else{
            System.out.println("El numero "+number+" no es primo");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca numeros separados por espacio");
        String input = sc.nextLine();
        String[] num = input.split(" ");
        for(String n: num){
            int number = Integer.parseInt(n);
            VerificaPrimos vPri = new VerificaPrimos(number);
            vPri.start();
        }
    }
}
