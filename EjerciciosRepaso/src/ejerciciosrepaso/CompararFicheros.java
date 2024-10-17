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
            int mayorNumeroPalabras = 0;
            String filePalabras = "";
            int contLineas = 0;
            String fileLineas = "";
            ArrayList<Process> procPal = new  ArrayList<>();
            ArrayList<Process> procLin = new  ArrayList<>();
            for (int i=0; i<procPal.size(); i++){
                procPal.add(procesos(filesName.get(i), "-w"));
                
                procLin.add(procesos(filesName.get(i), "-l"));
                
                BufferedReader br = new BufferedReader(new InputStreamReader(procPal.get(i).getInputStream()));

                int numerosPalabras;
                String numero = br.readLine();
                //Esto me da 31 sin problemas
    //            System.out.println(numero);
                numerosPalabras = Integer.parseInt(numero);
                //Guardo el fichero que tenga el mayor numero de palabras.
                if (numerosPalabras > mayorNumeroPalabras) {
                    filePalabras = filesName.get(i);
                    mayorNumeroPalabras = numerosPalabras;
                }
                
                br = new BufferedReader(new InputStreamReader(procLin.get(i).getInputStream()));
                //Guardo el numero de lineas de este fichero
                int numeroLineas;
                numero = br.readLine();
    //            System.out.println(numero);
                numeroLineas = Integer.parseInt(numero);
                //Guardo el fichero que tenga el mayor numero de lineas.
                if (numeroLineas > contLineas) {
                    fileLineas = filesName.get(i);
                    contLineas = numeroLineas;
                }
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
