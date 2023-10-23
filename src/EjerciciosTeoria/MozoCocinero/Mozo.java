package EjerciciosTeoria.MozoCocinero;

public class Mozo implements Runnable {
    private Comida comida;

    public Mozo(Comida comida) {
        this.comida = comida;
    }

    public void generarPedido(){
        System.out.println("El cliente le esta pidiendo al mozo");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void run() {
        while (true) {
            // Generar pedido
            // Pedir a cocinero que cocine
            // ESPERAR comida lista
            // Una vez que la comida este lista "se entrega al cliente"
            comida.generarPedido();
            comida.pedirComida();
            comida.entregarACliente();
        }
    }

}
