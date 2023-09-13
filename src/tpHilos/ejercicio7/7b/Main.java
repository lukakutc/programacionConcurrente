package tpHilos.ejercicio7.b;

import tpHilos.ejercicio7.b.Cliente;

public class Main {
    public static void main(String[] args) {
        Cajero cajero1 = new Cajero("Cajero 1",cliente1);
        Cajero cajero2 = new Cajero("Cajero 2",cliente1);
        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5,
                2, 3 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1,
                1 });
        

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
       
    }
}
