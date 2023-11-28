package EjerciciosTeoria.BarberoMonitor;

public class Barbero implements Runnable {
    private SillonMonitor sillon;

    public Barbero(SillonMonitor sillon) {
        this.sillon = sillon;
    }

    public void run() {
        while (true) {
            sillon.esperarCliente();
            System.out.println("El barbero le esta cortando el pelo a cliente  . . .");
            try {
                Thread.sleep(3500);
            } catch (Exception e) {
                // TODO: handle exception
            }
            sillon.terminarCorte();
        }
    }

}
