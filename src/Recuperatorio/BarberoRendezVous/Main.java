package Recuperatorio.BarberoRendezVous;

public class Main {
    public static void main(String[] args) {
        Silla silla = new Silla();//silla
        Thread hiloBarbero = new Thread(new Barbero(silla),"barbero");//1 barbero
        
        //3 clientes
        Thread hiloCliente1 = new Thread(new Cliente(silla),"cliente1");
        Thread hiloCliente2 = new Thread(new Cliente(silla),"cliente2");
        Thread hiloCliente3 = new Thread(new Cliente(silla),"cliente3");

        hiloCliente1.start();
        hiloCliente2.start();
        hiloCliente3.start();
        hiloBarbero.start();
    }
}
