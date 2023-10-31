package Tp4.Ejercicio7;

public class Mozo implements Runnable {
    // Hilo
    private Confiteria confiteria;

    public Mozo(Confiteria confiteria) {
        this.confiteria = confiteria;
    }

    public void cocinar() {
        System.out.println("El cocinero esta cocinando la comida...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            confiteria.esperarEmpleado();
            cocinar();
            confiteria.comidaCocinada();
        }

    }
}
