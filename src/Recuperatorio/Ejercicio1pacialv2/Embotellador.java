package Recuperatorio.Ejercicio1pacialv2;

public class Embotellador implements Runnable{
    String tipo;
    Fabrica fabrica;

    public Embotellador(Fabrica fabrica, String tipo) {
        this.tipo = tipo;
        this.fabrica = fabrica;
    }

    public void run() {
        while (true) {
            fabrica.ponerBotella(tipo);
        }
    }

}
