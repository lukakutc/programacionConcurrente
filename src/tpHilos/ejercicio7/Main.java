package tpHilos.ejercicio7;

public class Main {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5,
                2, 3 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1,
                1 });
        Cajero cajero1 = new Cajero("Cajero 1");
        Cajero cajero2 = new Cajero("Cajero 2");
        cliente1.start();
        cliente2.start();

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        cajero1.procesarCompra(cliente1, initialTime);
        cajero2.procesarCompra(cliente2, initialTime);
    }
}
