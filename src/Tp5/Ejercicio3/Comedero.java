package Tp5.Ejercicio3;

import java.util.concurrent.Semaphore;

public class Comedero {
    //Recurso compartido
    private Semaphore mutexEntrada = new Semaphore(1);
    private Semaphore mutexSalida = new Semaphore(1);
    private Semaphore mutexTurnos = new Semaphore(1);
    private Semaphore semPlatos = new Semaphore(3);
    private Semaphore semEspecie = new Semaphore(1);
    private String turno="";
    private int cantAlimentados = 0;

    public  void comer(String tipo){
        try {
            mutexEntrada.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(turno.isEmpty()){
            //si no hay turno designado
            //el animal que pide comer designa el turno
            turno = tipo;
            try {
                //semComedero.acquire();
                semPlatos.acquire();
                System.out.println("Ingresan solo "+tipo+"s al comedero");
                
                System.out.println("Ingreso un "+tipo+" al comedero");
            } catch (InterruptedException e) {}

        }else if(turno.equals(tipo)){
            //Si es el turno de los gatos, solo los gatos pueden comer
            //Si es el turno de los perros solo los perros pueden comer
            try {
                semPlatos.acquire();
                System.out.println("Ingreso un "+tipo+" al comedero");
            } catch (InterruptedException e) {}
        }
        mutexEntrada.release();
    }

    public void terminaComer(String tipo){
        System.out.println("El "+tipo+" sale del comedero");
        semPlatos.release();
        try {
            mutexTurnos.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cantAlimentados++;
        if(cantAlimentados==6){
            cambiarTurno();
            cantAlimentados=0;
        }
        mutexTurnos.release();
    
    }

    public  void cambiarTurno(){

        if (turno.equals("Gato")){
            turno = "Perro";
            System.out.println("CAMBIO DE TURNO. AHORa INGRESAN PERROS");
        }else if(turno.equals("Perro")){
            turno = "Gato";
            System.out.println("CAMBIO DE TURNO AHORA INGRESAN GATOS");
        }

    }
    
}
