package tpHilos.ejercicio2;

public class ejercico2join {
    public static void main(String[] args) {
        Thread miHilo = new MiEjecucion();
        miHilo.start();
        try {
            miHilo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("En el main");
    }
}
