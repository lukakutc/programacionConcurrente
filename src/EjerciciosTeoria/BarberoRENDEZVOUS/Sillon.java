package EjerciciosTeoria.BarberoRENDEZVOUS;

import java.util.concurrent.Semaphore;

public class Sillon {
    // Recurso compartido: el que usa funcionamiento de monitor
    boolean llegoCliente = false;
    boolean corteTerminado = false;

    // BARBERO
    public synchronized void esperarCliente() {
        /// ESPERAR CLIENTE
        // WAIT
        while (!llegoCliente) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("El barbero empieza  el corte de pelo");
    }

    // BARBERO
    // AVISARLE AL CLIENTE: NOTIFY
    public synchronized void terminarCorte() {
        System.out.println("El barbero termina el corte de pelo");
        corteTerminado = true;
        notify();
    }

    // CLIENTE
    public synchronized void pedirCorte() {
        // AVISA AL BARBERO QUE QUIERE CORGTARSE: NOTIFY
        System.out.println("El cliente llego a la barberia y solicita el corte a el barbero");
        llegoCliente = true;
        notify();

    }

    // CLIENTE
    public synchronized void esperarCorteTerminado() {
        while (!corteTerminado) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("El cliente se va de la barberia");
            llegoCliente = false;
            corteTerminado = false;
        }

    }

}
