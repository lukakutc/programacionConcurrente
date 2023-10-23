package EjerciciosTeoria.Barbero;

public class Barbero implements Runnable {
    private Sillon sillon;
    
    public Barbero(Sillon sillon) {
        this.sillon = sillon;
    }

    public void cortarPelo(){
        System.out.println("El barbero le esta cortando el pelo al cliente");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void run(){
        sillon.esperarCliente();
        cortarPelo();
        sillon.terminarCorte();
    }
}
