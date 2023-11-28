package TP6Monitroes.ProductorConsumidor.Ejercicio4;

public class Ejecucion {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(50);
        Thread productor = new Thread(new Productor(buffer));
        Thread consumidor = new Thread(new Consumidor(buffer));

        productor.start();
        consumidor.start();
    }
}
