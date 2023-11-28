package Recuperatorio.Ejercicio1pacialv2;

import java.util.concurrent.Semaphore;

public class Fabrica {
    // Recurso compartido
    private int cantBotellasAgua, cantBotellasVino, cantCajasAlmacen; // se puede con semaforos
    private String llamoEmpaquetador;
    private Semaphore semTransportista, semEmpaquetador, mutexAgua, mutexVino, embotelladorAguaEsperar, embotelladorVinoEsperar;

    public Fabrica() {
        cantBotellasAgua = 10;
        cantBotellasVino = 10;
        cantCajasAlmacen = 0;
        semTransportista = new Semaphore(0);
        semEmpaquetador = new Semaphore(0,true);
        mutexVino = new Semaphore(1);
        mutexAgua = new Semaphore(1);
        llamoEmpaquetador = "";
        embotelladorAguaEsperar = new Semaphore(0);
        embotelladorVinoEsperar = new Semaphore(0);
    }

    public void ponerBotella(String tipo) {
        if (tipo.equals("A")) {
            try {
                mutexAgua.acquire();
                System.out.println("Se pone una botella de agua en la caja");
                cantBotellasAgua--;
                System.out.println("Quedan "+cantBotellasAgua+" por poner en la caja");
                if (cantBotellasAgua == 0) {
                    llamoEmpaquetador = tipo;
                    semEmpaquetador.release();
                    embotelladorAguaEsperar.acquire();
                }
                mutexAgua.release();
            } catch (InterruptedException e) {
            }

        } else {
            try {
                mutexVino.acquire();
                System.out.println("Se pone una botella de vino en la caja");
                cantBotellasVino--;
                System.out.println("Quedan "+cantBotellasVino+" por poner en la caja");
                if (cantBotellasVino == 0) {
                    llamoEmpaquetador = tipo;
                    semEmpaquetador.release();
                    embotelladorVinoEsperar.acquire();
                }
                mutexVino.release();
            } catch (InterruptedException e) {
            }
        }
    }

    // EMPAQUETADOR ALMACENA CAJA Y REPONE CAJA
    public void almacenarCaja() {
        // Empaquetador
        // No hace faltam utex porque hay un solo hilo que modifica cantCajasAlmacen
        try {
            semEmpaquetador.acquire();

            System.out.println("empaquetador almacenando la caja");
            Thread.sleep(2000);
            cantCajasAlmacen++;
            if (cantCajasAlmacen == 10) {
                semTransportista.release();
            }

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void reponerCaja() {
        System.out.println("Empaquetador repone la caja");
        if (llamoEmpaquetador.equals("A")) {
            cantBotellasAgua = 10;
            embotelladorAguaEsperar.release();
        } else {
            cantBotellasVino = 10;
            embotelladorVinoEsperar.release();
        }
    }

    // Transportista vacia almacen y reparte
    public void repartir() {
        try {
            semTransportista.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("El transportista guarda las cajas del almacen en camion y empieza a repartir");
        cantCajasAlmacen = 0;
        try {
            Thread.sleep(3500);
            System.out.println("Transportista termina de repartir");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
