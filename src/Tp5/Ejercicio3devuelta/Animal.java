package Tp5.Ejercicio3devuelta;

public class Animal implements Runnable {
    private String tipo;
    private Comedor comedor;

    public Animal (String tipo, Comedor comedor){
        this.tipo = tipo;
        this.comedor = comedor;
    }

    public void comer(){
        System.out.println("Un "+tipo+" esta comiendo! . . .");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {}
    }
    public void run(){
        comedor.entrarComedor(tipo); //Adquirir permiso de lugar
        //Comer
        comedor.salirComedor(tipo);//Liberar semaforo de lugar

    }
}
