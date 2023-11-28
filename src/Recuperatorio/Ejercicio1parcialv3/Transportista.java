package Recuperatorio.Ejercicio1parcialv3;

public class Transportista implements Runnable {
    private Fabrica fabrica;

    public Transportista(Fabrica fabrica) {
        this.fabrica = fabrica;
    }
    
    public void run(){
        while(true){
            fabrica.vaciarAlmacen();
            fabrica.repartir();
        }
    }
    
}
