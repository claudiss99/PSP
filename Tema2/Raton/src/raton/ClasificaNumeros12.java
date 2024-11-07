package raton;
import java.util.ArrayList;
import java.util.Scanner;

public class ClasificaNumeros12 {
    // Listas finales donde se guardarán los resultados
    public static ArrayList<Integer> pos = new ArrayList<>();
    public static ArrayList<Integer> neg = new ArrayList<>();
    public static ArrayList<Integer> par = new ArrayList<>();
    public static ArrayList<Integer> impar = new ArrayList<>();
    public static ArrayList<Integer> primo = new ArrayList<>();
    public static ArrayList<Integer> noPrimo = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        // Pedir una lista de numeros separados por espacios
        System.out.println("Introduzca una serie de numeros separados por espacios:");
        String input = sc.nextLine();
        String[] numStrings = input.split(" ");
        ArrayList<Integer> numeros = new ArrayList<>();

        for (String n : numStrings) {
            numeros.add(Integer.parseInt(n));
        }

        // Crear hilos para cada tipo de clasificación
        ClasificaPosNeg hiloPosNeg = new ClasificaPosNeg(numeros);
        ClasificaParImpar hiloParImpar = new ClasificaParImpar(numeros);
        ClasificaPrimos hiloPrimo = new ClasificaPrimos(numeros);

        // Iniciar los hilos
        hiloPosNeg.start();
        hiloParImpar.start();
        hiloPrimo.start();

        // Esperar a que todos los hilos terminen
        hiloPosNeg.join();
        hiloParImpar.join();
        hiloPrimo.join();

        // Combinar resultados de los hilos en las listas finales
        pos.addAll(hiloPosNeg.getPositivos());
        neg.addAll(hiloPosNeg.getNegativos());
        par.addAll(hiloParImpar.getPares());
        impar.addAll(hiloParImpar.getImpares());
        primo.addAll(hiloPrimo.getPrimos());
        noPrimo.addAll(hiloPrimo.getNoPrimos());

        // Imprimir los resultados
        System.out.println("Números positivos: " + pos);
        System.out.println("Números negativos: " + neg);
        System.out.println("Números pares: " + par);
        System.out.println("Números impares: " + impar);
        System.out.println("Números primos: " + primo);
        System.out.println("Números no primos: " + noPrimo);
    }
}
