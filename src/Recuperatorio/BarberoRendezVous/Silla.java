package Recuperatorio.BarberoRendezVous;

import java.util.concurrent.Semaphore;

public class Silla {
    // Recurso compartido, por lo tanto tiene los semaforos
    // Rendez vous funciona con dos semaforos para la comunicacion entre los hilos
    // Ademas vamos a tener otro semaforo para hacer mutex, y que varios clientes
    // peudan soliicitar corte
    // Mientras el barbero esta trabajando se bloqueen y esperen.
    private Semaphore semCliente;
    private Semaphore semBarbero;
    private Semaphore semCorte;
    // Quien inicia la comunicacion? Cliente. barbero espera que lleguen

    public Silla() {
        semCliente = new Semaphore(0);
        semBarbero = new Semaphore(0);
        semCorte = new Semaphore(1);

    }

    // CLIENTE
    // solicita corte, espera que lo atiendan y le corten, se va
    public void pedirCorte() {
        try {
            semCorte.acquire();
            System.out.println("El cliente " + Thread.currentThread().getName() + " se sento para cortarse el pelo");
            semBarbero.release();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void irse() {
        try {
            semCliente.acquire();
            System.out.println("El cliente" + Thread.currentThread().getName() + "se va de la barberia");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // BARBERO
    public void cortarPelo() {
        try {
            semBarbero.acquire();
            System.out.println("El barbero le esta cortando el pelo al cliente");
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void terminarCorte() {
        System.out.println("El barbero termino el corte");
        semCliente.release();
        semCorte.release();
    }

}
