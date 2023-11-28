package Recuperatorio.Ejercicio1parcialv3;

public class Embotellador implements Runnable {
    private Fabrica fabrica;
    String tipo;

    public Embotellador(Fabrica fabrica, String tipo) {
        this.fabrica = fabrica;
        this.tipo = tipo;
        
    }

    public void run() {
        while (true) {
            fabrica.ponerBotella(tipo);
        }
    }

}
