package Recuperatorio.Ejercicio1parcialv3;

import java.util.concurrent.Semaphore;

public class Fabrica {
    // Recurso compartido
    private int botellasRestantesVino, botellasRestantesAgua, cajasAlmacen;
    private String llamaEmpleado;
    private Semaphore esperarCajaAgua, esperarCajaVino, mutexAgua, mutexVino, semEmpaquetador, semTransportista,
            mutexCambioCaja;

    public Fabrica() {
        this.botellasRestantesVino = 10;
        this.botellasRestantesAgua = 10;
        this.cajasAlmacen = 0;
        this.llamaEmpleado = "";
        this.esperarCajaAgua = new Semaphore(0);
        this.esperarCajaVino = new Semaphore(0);
        this.mutexAgua = new Semaphore(1);
        this.mutexVino = new Semaphore(1);
        this.semEmpaquetador = new Semaphore(0);
        this.semTransportista = new Semaphore(0);
        this.mutexCambioCaja = new Semaphore(1);
    }

    public void ponerBotella(String tipo) {
        if (tipo.equals("A")) {
            try {
                mutexAgua.acquire();
                botellasRestantesAgua--;
                System.out.println(
                        "Un embotellador puso botella de agua en la caja. Quedan por poner: " + botellasRestantesAgua);
                if (botellasRestantesAgua == 0) {
                    //mutexCambioCaja.acquire();

                    llamaEmpleado = tipo;
                    semEmpaquetador.release();
                    esperarCajaAgua.acquire();

                    //mutexCambioCaja.release();
                }

                mutexAgua.release();
            } catch (InterruptedException e) {
            }
        } else {
            try {
                mutexVino.acquire();
                botellasRestantesVino--;
                System.out.println(
                        "Un embotellador puso botella de vino en la caja. Quedan por poner: " + botellasRestantesVino);
                if (botellasRestantesVino == 0) {
                    //mutexCambioCaja.acquire();

                    llamaEmpleado = tipo;
                    semEmpaquetador.release();
                    esperarCajaVino.acquire();

                    //mutexCambioCaja.release();
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void almacenarCaja() {
        try {
            semEmpaquetador.acquire();

            System.out.println("El empaquetador esta almacenando la caja");
            Thread.sleep(3000);
            System.out.println("El empleado almacena la caja.");
            cajasAlmacen++;
            if (cajasAlmacen == 10) {
                semTransportista.release();
            }

        } catch (InterruptedException e) {
        }
    }

    public void reponerCaja() {
        System.out.println("El empleado repone la caja");
        if (llamaEmpleado.equals("A")) {
            botellasRestantesAgua = 10;
            esperarCajaAgua.release();
        } else {
            botellasRestantesVino = 10;
            esperarCajaVino.release();
        }
    }

    public void vaciarAlmacen() {
        try {
            semTransportista.acquire();
            System.out.println("El transportista vacia el almacen");
            Thread.sleep(1500);
            cajasAlmacen = 0;
        } catch (InterruptedException e) {
        }
    }

    public void repartir() {
        System.out.println("El transportista reparte las cajas");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
