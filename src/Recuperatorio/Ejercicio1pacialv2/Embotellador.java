package Recuperatorio.Ejercicio1pacialv2;

public class Embotellador implements Runnable{
    String tipo;
    Fabrica fabrica;

    public Embotellador(Recuperatorio.Ejercicio1parcialv3.Fabrica fabrica2, String tipo) {
        this.tipo = tipo;
        this.fabrica = fabrica2;
    }

    public void run() {
        while (true) {
            fabrica.ponerBotella(tipo);
        }
    }

}
