/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tsimulacro;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class OrdenaNumeros {
    public static void main(String[] args) {
        if(args.length != 2 && args.length !=3) {
            throw new IllegalArgumentException("No se han introducido correctamente los parametros");
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una serie de numeros separados por espacios: ");
        String input = sc.nextLine();

        String[] numberInput = input.split(" ");

        ArrayList<Integer> listNumbers = new ArrayList<>();


        for (String numString : numberInput){
            try{
                int number = Integer.parseInt(numString);
                listNumbers.add(number);
            } catch (NumberFormatException e){
                System.out.println("El valor '" +numString + "'no es un numero valido");
            }
        }

        System.out.println("Dame el nombre del fichero para guardar el resultado:");
        String fileName = sc.nextLine();

        String parametro = args[0];
        ArrayList<Integer> result = new ArrayList<>();
        int num, menor, mayor;

        switch (parametro) {
            case "-g":
                num = Integer.parseInt(args[1]);
                result = filtrarMayores(num, listNumbers);
                showAndSave(result, "Números mayores de " + num, fileName);
                break;
            case "-l":
                num = Integer.parseInt(args[1]);
                result = filtrarMenores(num, listNumbers);
                showAndSave(result, "Números menores de " + num, fileName);
                break;
            case "-b":
                menor = Integer.parseInt(args[1]);
                mayor = Integer.parseInt(args[2]);
                result = filtrarMedios(menor, mayor, listNumbers);
                showAndSave(result, "Números entre " + menor + " y " + mayor, fileName);
                break;
            default:
                System.out.println("Parametro desconocido");
        }
        
    }
    
    private static ArrayList<Integer> filtrarMayores(int menor, ArrayList<Integer> listNumbers){
        ArrayList<Integer> mayores = new ArrayList<>();
        
        for (int num : listNumbers){
            if (num > menor){
                mayores.add(num);
            }
        }
        return mayores;
        
    }
    
    private static ArrayList<Integer> filtrarMenores(int mayor, ArrayList<Integer> listNumbers){
       ArrayList<Integer> menores = new ArrayList<>();

       for (int num : listNumbers){
           if (num < mayor){
               menores.add(num);
           }
       }
       return menores;
        
    }
     
    private static ArrayList<Integer> filtrarMedios(int menor,int mayor, ArrayList<Integer> listNumbers){
       ArrayList<Integer> medios = new ArrayList<>();

       for (int num : listNumbers){
           if ((num > menor) && (num < mayor)){
               medios.add(num);
           }
       }
       return medios;
    }
    
    private static void showAndSave (ArrayList<Integer> result, String mensaje, String fileName){
       
        for (int i = 0; i < 10; i++) {
            System.out.print(".");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
        //Añadimos el final de linea
        System.out.println(""); 

        // Mostrar el resultado
        System.out.println(mensaje + " : " + result);

        // Guardar en el fichero
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(mensaje + " : " + result);
            writer.newLine();
            System.out.println("Datos guardados en el fichero: " + fileName);
        } catch (IOException e) {
            System.err.println("Ocurrió un error al guardar en el fichero: " + e.getMessage());
        }
    }
}
