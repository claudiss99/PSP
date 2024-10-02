/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lanzarnotepad;

import java.io.IOException;

/**
 *
 * @author Claudia
 */
public class LanzarNotepad {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] note = {"Notepad.exe"};
        Process p = Runtime.getRuntime().exec(note);
        System.out.println("El proceso ha sido lanzado");
        int waitFor = p.waitFor();
        if (waitFor==0){
            System.out.println("El programa se ha ejecutado correctamente. El código de respuesta es: "+waitFor);
        }else{
            System.out.println("Ha ocurrido un error.El código de respuesta es: "+waitFor);
        }
    }
    
}
