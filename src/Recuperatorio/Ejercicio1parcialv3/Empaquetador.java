package Recuperatorio.Ejercicio1parcialv3;

public class Empaquetador implements Runnable {
    private Fabrica fabrica;

    public Empaquetador(Fabrica fabrica) {
        this.fabrica = fabrica;
    }

    public void run(){
        while(true){
            fabrica.almacenarCaja();
            fabrica.reponerCaja();
        }
    }
    
    
}
