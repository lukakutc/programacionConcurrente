package Tp4.Ejercicio7;

import java.util.concurrent.Semaphore;

public class Confiteria {
    //Recurso compartido
    //Rendez vous
    private Semaphore semEmpleado = new Semaphore(0);
    private Semaphore semComida = new Semaphore(0);
    private Semaphore semMesa = new Semaphore(1);


    //mozo
    //espera por empleado
    //le cocina al empleado
    //le avisa el empleado que se vaya

    //Empleado
    //se sienta en la mesa
    //le pide al mozo
    //Espera la comida del mozo y come

    //Mozo
    public void esperarEmpleado(){
       
        try {
            semEmpleado.acquire();
            System.out.println("El mozo recibe el pedido del empleado");
        } catch (InterruptedException e) {
           System.out.println("hilo interrumpido");
        }
        
    }
    public void comidaCocinada(){
        System.out.println("El mozo le entrega la comida al empleado");
        semComida.release();
    }
    //Empleado
    public void sentarse(){
        try {
            semMesa.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    public void pedirAlMozo(){
        //System.out.println("El empleado llama al mozo y le pide comida");
        semEmpleado.release();
    }
    public void comer(){
        try {
            semComida.acquire();
            //System.out.println("El empleado come la comida que le preparo el mozo");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void irse(){
        //System.out.println("el empleado ya comio y se va del lugar");
        semMesa.release();
        
    }
    

}
