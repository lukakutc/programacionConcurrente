package EjerciciosTeoria.Barbero;

public class Ejecucion {
    public static void main(String[] args) {
        //Creamos un sillon
        Sillon sillon = new Sillon();
        //creamos los runnable de barbero y cliente
        Barbero barbero = new Barbero(sillon);
        Cliente cliente = new Cliente(sillon);
        //Creamos los hilos de los runnables
        Thread hiloBarbero = new Thread(barbero);
        Thread hiloCliente = new Thread(cliente);

        hiloBarbero.start();
        hiloCliente.start();
    }
}
