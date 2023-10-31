package EjerciciosTeoria.BarberoRENDEZVOUS;

import java.util.concurrent.Semaphore;

public class Sillon {
    private Semaphore semBarbero = new Semaphore(0);
    private Semaphore semCorteTerminado = new Semaphore(0);
    
    //Barbero objeto pasivo/reactivo
    //Cliente objeto activo

    //BARBERO
    public void esperarCliente(){
        try {
            semBarbero.acquire();
            System.out.println("se ha despertado el barbero");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //BARBERO
    public void terminarCorte(){
        System.out.println("El barbero ha terminado de cortarle el pelo al cliente");
        semCorteTerminado.release();
    }
    //CLIENTE
    public void pedirCorte(){
        System.out.println("El cliente le avisa al barbero que quiere cortarse el pelo");
        semBarbero.release();
    }
    //CLIENTE
    public void dejarBarberia(){
        
        try {
            semCorteTerminado.acquire();
            System.out.println("El cliente deja la barberia");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
