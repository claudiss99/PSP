/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Claudia
 */
public class ClasificaNumeros1 extends Thread{
    private int number;
    private static ArrayList<Integer> pos = new ArrayList<>();
    private static ArrayList<Integer> neg = new ArrayList<>();
    private static ArrayList<Integer> par = new ArrayList<>();
    private static ArrayList<Integer> impar = new ArrayList<>();
    private static ArrayList<Integer> primo = new ArrayList<>();
    private static ArrayList<Integer> noPrimo = new ArrayList<>();
    
    public ClasificaNumeros1(int number) {
        super();
        this.number = number;
    }
    
    @Override
    public void run(){
        this.clasificar();
    }
    public void clasificar(){
        //Comprobamos si es negativo o positivo (0 considerado positivo)
        if(number<0){
            neg.add(number);
        }else{
            pos.add(number);
        }
        //Comprobamos e imprimimos si es par o impar
        if (number %2 == 0){
            par.add(number);
        }else{
            impar.add(number);
        }
        
        boolean pri = true;
        for (int i = 2; i<number; i++){
            if (number % i == 0){
                pri = false;
                break;
            }
        }
        if (pri && number>=2){
            primo.add(number);
        }else{
            noPrimo.add(number);
        }
    }
    
    
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        //Pedir una lista de numeros separados por espacios
        System.out.println("Introduzca una serie de numeros separados por espacios:");
        String input =sc.nextLine();
        String[] num = input.split(" ");
        ClasificaNumeros1 clasf = null;
        ArrayList<ClasificaNumeros1> hilos = new ArrayList<>();
        for (String n:num){
            int number = Integer.parseInt(n);
            clasf = new ClasificaNumeros1(number);
            clasf.start();
            hilos.add(clasf);
            
        }
        
        for (ClasificaNumeros1 c: hilos){
            c.join();
        }
        
        
        System.out.println("Números positivos: " + pos);
        System.out.println("Números negativos: " + neg);
        System.out.println("Números pares: " + par);
        System.out.println("Números impares: " + impar);
        System.out.println("Números primos: " + primo);
        System.out.println("Números no primos: " + noPrimo);
        
        
    }
}
