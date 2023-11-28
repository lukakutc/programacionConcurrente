package Recuperatorio.Ejercicio1pacialv2;

public class Ejecucion {
    public static void main(String[] args) {
        Fabrica fabrica = new Fabrica();

        Thread embotelladorV1 = new Thread(new Embotellador(fabrica, "V"), "Embotellador Vino 1");
        Thread embotelladorV2 = new Thread(new Embotellador(fabrica, "V"), "Embotellador vino 2");
        Thread embotelladorA1 = new Thread(new Embotellador(fabrica, "A"), "Embotellador agua 1");
        Thread embotelladorA2 = new Thread(new Embotellador(fabrica, "A"), "Embotellador agua 2");

        Thread empaquetador = new Thread(new Empaquetador(fabrica), "Empaquetador");

        Thread transportista = new Thread(new Transportista(fabrica), "Transportista");

        embotelladorA1.start();
        embotelladorA2.start();
        embotelladorV1.start();
        embotelladorV2.start();
        empaquetador.start();
        transportista.start();
    }
}
