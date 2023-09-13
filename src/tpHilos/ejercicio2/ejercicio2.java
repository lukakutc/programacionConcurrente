package tpHilos.ejercicio2;

public class ejercicio2 {
    
        public static void main(String[] args) {
            Thread miHilo = new MiEjecucion();
            miHilo.start();
            System.out.println("En el main");
        }
    
}
