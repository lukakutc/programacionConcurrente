package tpHilos.ejercicio1;

public class ejercicio1 {

    public class Recurso {
        static void uso() {
            Thread t = Thread.currentThread();
            System.out.println("en Recurso: Soy" + t.getName());
        }
    }

    public class testeoRecurso {
        public static void main(String[] args) {
            int i;
            // Hacemos un bucle para no andar que tocando ejecutar jajajaja, que se ejecute
            // solo unas pares de veces.

            for (i = 0; i < 40; i++) {
                Cliente juan = new Cliente();
                juan.setName("Juan Lopez");
                Cliente ines = new Cliente();
                ines.setName("Ines Garcia");
                juan.start();
                ines.start();
            }
        }
    }
}
