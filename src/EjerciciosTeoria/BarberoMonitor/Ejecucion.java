package EjerciciosTeoria.BarberoMonitor;

public class Ejecucion {
    public static void main(String[] args) {
        SillonMonitor sillon = new SillonMonitor();
        Thread cliente = new Thread(new Cliente(sillon));
        Thread barbero = new Thread(new Barbero(sillon));
        Thread cliente2 = new Thread(new Cliente(sillon));

        cliente.start();
        cliente2.start();
        barbero.start();

    }
}
