package Recuperatorio.Ejercicio1parcialv3;

public class Ejecucion {
    public static void main(String[] args) {
        Fabrica fabrica = new Fabrica();

        Thread embotelladorA1 = new Thread(new Embotellador(fabrica, "A"));
        Thread embotelladorA2 = new Thread(new Embotellador(fabrica, "A"));
        Thread embotelladorV1 = new Thread(new Embotellador(fabrica,"V"));
        Thread embotelladorV2 = new Thread(new Embotellador(fabrica,"V"));
    
        Thread empaquetador = new Thread(new Empaquetador(fabrica));
        Thread transportista = new Thread(new Transportista(fabrica));

        embotelladorA1.start();
        embotelladorA2.start();
        embotelladorV1.start();
        embotelladorV2.start();
        empaquetador.start();
        transportista.start();
    }

}
