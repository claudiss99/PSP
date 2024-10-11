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
        
        //porque limite 2 tiene que estar igualado a 0
        int limite1;
        int limite2 = 0;
        
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
        
        
        System.out.println("introduzca numero, o fin para terminar");
        String  cadena = sc.nextLine();
        String cadenaEspacios = "";
        
        while (cadena.toLowerCase() != "fin"){
            cadenaEspacios.concat(cadena + " ");
            System.out.println("introduzca numero, o fin para terminar");
            cadena = sc.nextLine();
        }
        
        System.out.println("Dame el nombre del fichero para guardar el resultado:");
        String fileName = sc.nextLine();
        
        if (limite == 1){
            procesoLimite1(limite1, cadenaEspacios, fileName);
        }else{
            procesoLimite2(limite1, limite2, cadenaEspacios, fileName);
        }
    }
    
    private static void procesoLimite1 (int limite1, String cadenaEspacios, String fileName) throws IOException{
        Runtime runtime = Runtime.getRuntime();
        Process ordenaMayor = runtime.exec(new String[]{"java", "0rdenaNumeros.java", "-g", String.valueOf(limite1)});
        Process ordenaMenor = runtime.exec(new String[]{"java", "0rdenaNumeros.java", "-l", String.valueOf(limite1)});
        BufferedWriter writerMayor = new BufferedWriter(new OutputStreamWriter(ordenaMayor.getOutputStream()));
        BufferedWriter writerMenor = new BufferedWriter(new OutputStreamWriter(ordenaMenor.getOutputStream()));
        
        writerMayor.write(cadenaEspacios);
        writerMenor.write(cadenaEspacios);
        
        writerMayor.write(fileName);
        writerMenor.write(fileName);
        
        writerMayor.flush();
        writerMayor.close();
        
        writerMenor.flush();
        writerMenor.close();
    }
    
        private static void procesoLimite2 (int limite1, int limite2, String cadenaEspacios, String fileName) throws IOException{
        Runtime runtime = Runtime.getRuntime();
        Process ordenaMayor = runtime.exec(new String[]{"java", "0rdenaNumeros.java", "-g", String.valueOf(limite1)});
        Process ordenaMenor = runtime.exec(new String[]{"java", "0rdenaNumeros.java", "-l", String.valueOf(limite2)});
        Process ordenaMedio = runtime.exec(new String[]{"java", "0rdenaNumeros.java", "-b", String.valueOf(limite1), String.valueOf(limite2)});
        
        BufferedWriter writerMayor = new BufferedWriter(new OutputStreamWriter(ordenaMayor.getOutputStream()));
        BufferedWriter writerMenor = new BufferedWriter(new OutputStreamWriter(ordenaMenor.getOutputStream()));
        BufferedWriter writerMedio = new BufferedWriter(new OutputStreamWriter(ordenaMedio.getOutputStream()));
        
        writerMayor.write(cadenaEspacios);
        writerMenor.write(cadenaEspacios);
        writerMedio.write(cadenaEspacios);
        
        writerMayor.write(fileName);
        writerMenor.write(fileName);
        writerMedio.write(fileName);
        
        writerMayor.flush();
        writerMayor.close();
        
        writerMenor.flush();
        writerMenor.close();
        
        writerMedio.flush();
        writerMedio.close();
    }
}
