package tpHilos.ejercicio3;

public class ThreadEjemplo extends Thread {
    public ThreadEjemplo(String str) {
        // Este super (str) es para definir el nombre del hilo.
        // Recordar que un constructor de la clase padre se utiliza solo con super, y
        // str es el parametro en este caso
        super(str);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            // no hace falta poner getName con puntos ya que es un metodo de clase
            System.out.println(i + " " + getName());
        }
        System.out.println("Termina thread " + getName());
    }

    public static void main(String[] args) {
        new ThreadEjemplo("Maria Jose").start();
        new ThreadEjemplo("Jose Maria").start();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Termina thread main");
    }
}
