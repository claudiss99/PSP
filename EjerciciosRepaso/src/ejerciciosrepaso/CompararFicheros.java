/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosrepaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ClaudissPerez
 */
public class CompararFicheros {
    public static void main(String[] args) throws IOException {
        try{
            Scanner sc = new Scanner(System.in);
            int nFicheros;
            ArrayList<String> filesName = new ArrayList<>();
            String files;
            if(args.length == 0){
                //Pedir numero de ficheros
                nFicheros = sc.nextInt();
                while (nFicheros<0){
                   nFicheros = sc.nextInt();
                }
                filesName = pedirNomF(nFicheros);
            }else if(args[0].equals("-n")) {
                nFicheros = Integer.parseInt(args[1]);
                filesName = pedirNomF(nFicheros);
            }else if(args[0].equals("-f")){
                for(int i=1; i<args.length;i++){
                    filesName.add(args[i]);
                }
                // numero de ficheros
                nFicheros = args.length-2;
            }
            //Lanzar 2 procesos por cada file(Uno para las lineas y otro para las palabras)
            int contPalabras = 0;
            String filePalabras = "";
            int contLineas = 0;
            String fileLineas = "";
            ArrayList<Process> procPal = new  ArrayList<>();
            ArrayList<Process> procLin = new  ArrayList<>();
            for (String f: filesName){
                procPal.add(procesos(f, "-w"));
                
                procLin.add(procesos(f, "-l"));
                /*Tendría que recorrer los arrays para quedarme con el que tenga mayor 
                palabras o lineas, como quiero guardar el fichero me quedo con f, cambiar 
                por un for normal/
                /*
                if(contP>contPalabras){
                    filePalabras = f;
                    contPalabras=contP;
                }
                if(contL>contLineas){
                    fileLineas = f;
                    contLineas=contL;
                } 
                */
            }
            System.out.println("Fichero con más palabras: "+filePalabras);
            System.out.println("Fichero con más líneas: "+fileLineas);
        }catch (IllegalArgumentException e){
            System.err.println("Ha ocurrido un error con los argumentos introducidos");
        }
    }
    
    public static Process procesos (String fileName, String parametro) throws IOException{
        Runtime runtime = Runtime.getRuntime();
        Process palabras = runtime.exec(new String[]{"java", "CuentaFichero.java", parametro, fileName});
        return palabras;
        /*
        BufferedReader rPalabras = new BufferedReader(new InputStreamReader(palabras.getInputStream()));
        int contPalabras = Integer.valueOf(rPalabras.readLine());
        System.out.println(contPalabras);
        return contPalabras;
        */
    }
    
    public static ArrayList<String> pedirNomF (int nFicheros){
        ArrayList<String> filesName = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String files;
        for (int n=0; n<nFicheros; n++){
            //Pide nombre de ficheros
            files = sc.nextLine();
            filesName.add(files); 
        }
        return filesName;
        
    }
            
}
