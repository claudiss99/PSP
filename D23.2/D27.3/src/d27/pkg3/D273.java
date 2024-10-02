/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package d27.pkg3;

import java.io.IOException;

/**
 *
 * @author Claudia
 */
public class D273 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Runtime r = Runtime.getRuntime();
            
            // Create the command as a String array
            String[] cmd = {"java", "UpperCase", "hola"};
            
            // Execute the command
            Process process = r.exec(cmd);
            
            // Wait for the process to finish
            int code = process.waitFor();
            
            // Output the execution code
            System.out.println("El código de ejecución es: " + process.exitValue() + " - " + code);
        } catch (IOException e) {
            System.err.println("Error during execution: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Execution was interrupted: " + e.getMessage());
        }
    }
    
}
