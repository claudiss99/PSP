/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package d23;

/**
 *
 * @author Claudia
 */
public class D23 {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        //Hay que ejecutarlo desde consola (Mirar que hay que poner para ejecutarlo)
        // Verifica si no hay argumentos
        if (args.length == 0) {
            System.out.println("Error: Se necesita un parámetro.");
            System.exit(1); // Termina el programa con código de error 1
        } else {
            // Convierte el argumento en mayúsculas y lo imprime
            String parametro = args[0].toUpperCase();
            System.out.println(parametro);
            System.exit(0); // Termina el programa sin error (código 0)
        }
    }
    
}
