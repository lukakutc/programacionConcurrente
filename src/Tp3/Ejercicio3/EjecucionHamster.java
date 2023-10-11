package Tp3.Ejercicio3;

public class EjecucionHamster {
    public static void main(String[] args) {

        // creamosm una jaula
        Jaula jaula = new Jaula();

        // Creamos los hamster.

        Hamster hamster1 = new Hamster(jaula);
        Hamster hamster2 = new Hamster(jaula);

        Thread h1 = new Thread(hamster1, "Hamster#1");
        Thread h2 = new Thread(hamster2, "Hamster#2");

        h1.start();
        h2.start();
    }
}
