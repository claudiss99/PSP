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
public class VerificaParidad extends Thread{
    
    private int number;

    public VerificaParidad(int number) {
        super();
        this.number = number;
    }
    
    @Override
    public void run(){
        //Comprobamos e imprimimos si es par o impar
        if (number %2 == 0){
            System.out.println("El numero "+number+" es par");
        }else{
            System.out.println("El numero "+number+" es impar");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Pido al usuario lista de numeros
        System.out.println("Introduzca una serie de numeros separados por espacio: ");
        String input = sc.nextLine();
        String[] num = input.split(" ");
        //Por cada numero creo un proceso
        for (String n: num){
            int number = Integer.parseInt(n);
            VerificaParidad vP = new VerificaParidad(number);
            vP.start();
        }
    }

}
