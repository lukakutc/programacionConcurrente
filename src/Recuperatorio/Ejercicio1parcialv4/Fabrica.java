package Recuperatorio.Ejercicio1parcialv4;

import java.util.concurrent.Semaphore;

public class Fabrica {
    private int botellasRestantesAgua, botellasRestantesVino, cajasAlmacen;
    private Semaphore mutexAgua, mutexVino, esperarCaja, semEmpaquetador, semTransportista,  mutexEmpaquetador;
    private String llamoEmpaquetador;
 
    

    public Fabrica() {
        this.botellasRestantesAgua = 10;
        this.botellasRestantesVino = 10;
        this.cajasAlmacen = 0;
        this.mutexAgua = new Semaphore(1);
        this.mutexVino = new Semaphore(1);
        this.esperarCaja = new Semaphore(0);
        this.semEmpaquetador = new Semaphore(0);
        this.semTransportista = new Semaphore(0);
        this.llamoEmpaquetador = "";
        this.mutexEmpaquetador = new Semaphore(1);
    }

    public void ponerVino(){
        try {
            mutexVino.acquire();
            botellasRestantesVino--;
            if(botellasRestantesVino==0){
                mutexEmpaquetador.acquire();
                llamoEmpaquetador = "V";
                mutexEmpaquetador.release();
                semEmpaquetador.release();
                esperarCaja.acquire();
                
            }

            mutexVino.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void ponerAgua(){
        try {
            mutexAgua.acquire();
            botellasRestantesAgua--;
            if(botellasRestantesAgua==0){
                mutexEmpaquetador.acquire();
                llamoEmpaquetador ="A";
                mutexEmpaquetador.release();
                
                semEmpaquetador.release();
                esperarCaja.acquire();
                
            }

            mutexAgua.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void almacenarCaja(){
        try {
            semEmpaquetador.acquire();
            System.out.println("El empaquetador esta almacenando la caja");
            Thread.sleep(2000);
            cajasAlmacen++;
            if(cajasAlmacen==10){
                semTransportista.release();
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void reponerCaja(){
        System.out.println("El embotellador repone la caja.");
        if(llamoEmpaquetador.equals("A")){
            botellasRestantesAgua=10;
        }else{
            botellasRestantesVino=10;
        }
        esperarCaja.release();
    }

    public void vaciarAlmacen(){
        try {
            semTransportista.acquire();
            System.out.println("El transportista vacia el almacen");
            cajasAlmacen=0;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void repartir(){
        System.out.println("El transportista reparte las cajas");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
