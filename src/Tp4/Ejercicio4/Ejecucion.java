package Tp4.Ejercicio4;

public class Ejecucion {
    public static void main(String[] args) {
        
        //Creamos una coleccion de impresoras para el gestor

        Impresora impresora1 = new Impresora("Impresora 1");
        Impresora impresora2 = new Impresora("Impresora 2");
        Impresora impresora3 = new Impresora("Impresora 3");
        Impresora impresora4 = new Impresora("Impresora 4");
        Impresora impresora5 = new Impresora("Impresora 5");
        
        Impresora[] colImpresoras = {impresora1, impresora2, impresora3, impresora4, impresora5};

        //creanmos un gestor de impresoras
        GestorImpresoras gestor = new GestorImpresoras(colImpresoras);
        
        //Creamos clientes
        Thread cliente1 = new Thread(new Cliente(gestor), "Cliente 1");
        Thread cliente2 = new Thread(new Cliente(gestor), "Cliente 2");
        Thread cliente3 = new Thread(new Cliente(gestor), "Cliente 3");
        Thread cliente4 = new Thread(new Cliente(gestor), "Cliente 4");
        Thread cliente5 = new Thread(new Cliente(gestor), "Cliente 5");
        Thread cliente6 = new Thread(new Cliente(gestor), "Cliente 6");
        Thread cliente7 = new Thread(new Cliente(gestor), "Cliente 7");
        Thread cliente8 = new Thread(new Cliente(gestor), "Cliente 8");

        //Iniciamos los hilos clientes
        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();
        cliente6.start();
        cliente7.start();
        cliente8.start();

        
    }
}
