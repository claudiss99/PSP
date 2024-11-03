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
public class VerificaPosNeg extends Thread{
    private int number;

    public VerificaPosNeg(int number) {
        this.number = number;
    }
    
    @Override
    public void run(){
        //Comprobamos si es negativo o positivo (0 considerado positivo)
        if(number<0){
            System.out.println("El numero "+number+" es negativo");
        }else{
            System.out.println("El numero "+number+" es positivo");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Pedir una lista de numeros separados por espacios
        System.out.println("Introduzca una serie de numeros separados por espacios:");
        String input =sc.nextLine();
        String[] num = input.split(" ");
        for (String n:num){
            int number = Integer.parseInt(n);
            VerificaPosNeg vPN = new VerificaPosNeg(number);
            vPN.start();
        }
    }
}
