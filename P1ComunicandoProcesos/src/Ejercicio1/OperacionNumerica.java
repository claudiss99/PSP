/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ClaudissPerez
 */
public class OperacionNumerica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //java OperacionNumerica.java /-s/-m
        Scanner sc = new Scanner(System.in);
        String number =sc.nextLine();
        ArrayList<Integer> numbers = new ArrayList<>();
        int suma =0;
        int c = 0;
        
        while (Integer.parseInt(number)!= 0){
            if (Integer.parseInt(number)>0){
                if(args.length == 0) {
                    numbers.add(Integer.valueOf(number));
                }else if (args[0].equals("-s")){
                    suma +=Integer.valueOf(number);
                }else if (args[0].equals("-m")){
                    suma +=Integer.valueOf(number);
                    c ++;
                }else{
                    throw new AssertionError();
                }
            }
            number = sc.nextLine();
        }
        if(args.length == 0) {
            System.out.println(numbers);
        }else if (args[0].equals("-s")){
            System.out.println(suma);
        }else if (args[0].equals("-m")){
            System.out.println(suma/c);
        }
    }
    
}
