package EjerciciosTeoria.BarberoMonitor;

public class Cliente implements Runnable {
    private SillonMonitor sillon;

    public Cliente(SillonMonitor sillon) {
        this.sillon = sillon;
    }

    public void run(){
        sillon.llegaCliente();
        sillon.esperarCorteTerminado();
    }
    
}
