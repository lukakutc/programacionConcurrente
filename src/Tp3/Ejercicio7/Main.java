package Tp3.Ejercicio7;

public class Main {
    public static void main(String[] args) {
        //creamos un turno y lo incializamos en "a"
        Turno turno = new Turno("a");

        //Creamos los 3 objetos y luego creamos los hilo

        HiloA hiloA = new HiloA(turno);
        HiloB hiloB = new HiloB(turno);
        HiloC hiloC = new HiloC(turno);

        Thread t1 = new Thread(hiloA, "hilo a");
        Thread t2 = new Thread(hiloB, "hilo b");
        Thread t3 = new Thread(hiloC, "hilo c");

        t1.start();
        t2.start();
        t3.start();
    }
}
