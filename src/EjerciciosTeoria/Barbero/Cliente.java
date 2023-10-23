package EjerciciosTeoria.Barbero;

public class Cliente implements Runnable {
    private Sillon sillon;
    
    public Cliente(Sillon sillon){
        this.sillon = sillon;
    }

    public void run(){
        sillon.pedirCorte();
        sillon.dejarBarberia();
    }

}
