package tpHilos.ejercicio4;

public class ThreadEjemploRun implements Runnable {
    //Atributo
    private String nombre;
    
    //constructor
    public ThreadEjemploRun(String nombre) {
        this.nombre = nombre;
    }


    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + Thread.currentThread().getClass());
        }
        System.out.println("Termina thread " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        
        
        //Estos son runnables y se los pasamos por parametro a hilos.

        Thread hilo1 = new Thread(new ThreadEjemploRun("Maria Jose"));
        Thread hilo2 = new Thread (new ThreadEjemploRun("Jose Maria"));
        hilo1.start();
        hilo2.start();
        System.out.println("Termina thread main");
    }
}
