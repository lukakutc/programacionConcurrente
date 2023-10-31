package EjerciciosTeoria.BarberoRENDEZVOUS;

public class Cliente implements Runnable {
    private Sillon sillon;
    
    public Cliente(Sillon sillon){
        this.sillon = sillon;
    }

    public void run(){
        while(true){
        sillon.pedirCorte();
        sillon.dejarBarberia();
        }
    }

}
