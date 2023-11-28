package Recuperatorio.BarberoRendezVous;

public class Cliente implements Runnable{
    private Silla silla;

    public Cliente(Silla silla){
        this.silla = silla;
    }

    public void run(){
        silla.pedirCorte();
        silla.irse();
    }

}
