/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tsimulacro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class ClasificarNumeros {
    public static void main(String[] args) throws IOException {
        int limite;
        Scanner sc = new Scanner(System.in);
        
        if (args.length == 0){
            System.out.println("Cuantos numeros usarás de limite, 1 o 2:");
            limite = sc.nextInt();
            while (limite !=1 && limite !=2){
                System.out.println("Cuantos numeros usarás de limite, 1 o 2:");
                limite = sc.nextInt();
            }
        }else{
            limite = Integer.parseInt(args[0]);
        }
        
        
        int limite1;
        int limite2;
        
        //Se presupone que no hay error, o es uno o es 2
        if (limite == 1){
            System.out.println("Introduce el numero limite:");
            limite1 = sc.nextInt();
        }else{
            System.out.println("Introduce el primer numero limite:");
            limite1 = sc.nextInt();
            System.out.println("Introduce el segundo numero limite:");
            limite2 = sc.nextInt();
        }
        
        ArrayList<Integer> listNumbers = new ArrayList<>();
        System.out.println("introduzca numero, o fin para terminar");
        String  cadena = sc.nextLine();
        
        while (cadena.toLowerCase() != "fin"){
            int numero = Integer.parseInt(cadena);
            listNumbers.add(numero);
            System.out.println("introduzca numero, o fin para terminar");
            cadena = sc.nextLine();
        }
        
        System.out.println("Dame el nombre del fichero para guardar el resultado:");
        String fileName = sc.nextLine();
        
        if (limite == 1){
            procesoLimite1(limite1, listNumbers, fileName);
        }else{
            procesoLimite2(limite1, limite2, listNumbers, fileName);
        }
    }
    
    private static void procesoLimite1 (int limite1, ArrayList<Integer> listNumber, String fileName) throws IOException{
        Runtime runtime = Runtime.getRuntime();
        Process ordenaMayor = runtime.exec(new String[]{"java", "0rdenaNumeros.java", "-g"});
        Process ordenaMenor = runtime.exec(new String[]{"java", "0rdenaNumeros.java", "-l"});
        BufferedWriter writerMayor = new BufferedWriter(new OutputStreamWriter(ordenaMayor.getOutputStream()));
        BufferedWriter writerMenor = new BufferedWriter(new OutputStreamWriter(ordenaMenor.getOutputStream()));
        
        for (int num: listNumber){
            
            writerMayor.write(String.valueOf(num)); 
            writerMayor.newLine();
            writerMenor.write(String.valueOf(num)); 
            writerMenor.newLine();
        }
        
        writerMayor.write(fileName);
        
        writerMayor.flush();
        writerMayor.close();
        
        writerMenor.flush();
        writerMenor.close();
        
        BufferedReader readerMayor= new BufferedReader(new InputStreamReader(ordenaMayor.getInputStream()));

    }
}
