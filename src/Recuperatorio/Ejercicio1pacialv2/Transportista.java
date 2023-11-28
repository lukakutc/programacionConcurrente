package Recuperatorio.Ejercicio1pacialv2;

public class Transportista implements Runnable{
    private Fabrica fabrica;

    public Transportista(Fabrica fabrica) {
        this.fabrica = fabrica;
    }

    public void run(){
        while(true){
            fabrica.repartir();
        }
    }
}
