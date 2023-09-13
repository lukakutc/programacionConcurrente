package excepciones;

import java.util.Scanner;
import java.util.Random;

public class PruebaExcep {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);
    // Escriba un método que ingrese la edad de una persona y dispare una excepción
    // si la persona es menor de edad.

    // Metodo que lanza la excepcion
    public static String escribirSiMayor(int edad) throws MenorDeEdadExcepcion {
        String res = " es mayor.";
        if (edad < 18) {
            throw new MenorDeEdadExcepcion();
        }
        return res;
    }
    /*
     * //Probamos MenorDeEdadExcepcion
     * System.out.println("Ingrese la edad de la minita");
     * scanner = new Scanner(System.in);
     * int edad = scanner.nextInt();
     * try {
     * System.out.println(escribirSiMayor(edad));
     * 
     * }catch (MenorDeEdadExcepcion e) {
     * System.out.println(e.getMessage());
     * }
     * 
     */

    // Escriba un método que ingrese un numero de la ruleta y dispare una excepción
    // cuando al jugar no salga dicho número.
    // Los numeros de la ruleta son del 0 al 33, habria que usar una funcion random
    // para eso
    public static void ruleta() {
        int numeroRuleta = random.nextInt(34);
        System.out.println("Ingrese un numero de la ruleta");
        int numeroJugador = scanner.nextInt();

        try {
            if (numeroJugador == numeroRuleta) {
                System.out.println("Felicitaciones. haz ganado");
            } else {
                throw new NoEsNumeroExcepcion(
                        "No haz ganado. tu numero es " + numeroJugador + " y salio: " + numeroRuleta);
            }
        } catch (NoEsNumeroExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            escribirSiMayor(14);
        } catch (MenorDeEdadExcepcion e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
