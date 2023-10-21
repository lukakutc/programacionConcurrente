package EjerciciosTeoria.MozoCocinero;

public class Mozo implements Runnable {
    private Comida comida;

    public Mozo(Comida comida) {
        this.comida = comida;
    }

    public void pedirComida() {
        comida.pedirComida();
        System.out.println("Mozo esperando a que algun cliente le pida una comida");
        System.out.println("------------------------------------------------------");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void entregarComida() {
        comida.entregarComida();
        System.out.println("El mozo le esta entregando la comida lista al cliente");
    }

    public void run() {
        while (true) {
            pedirComida();
            entregarComida();
        }
    }

}
