package Tp5.ejercicio3por2;

public class Animal implements Runnable{
    private Comedor comedor;
    private String tipo;

    
    
    public Animal(Comedor comedor, String tipo) {
        this.comedor = comedor;
        this.tipo = tipo;
    }

    public void comer(){
        System.out.println("Un "+tipo+" esta comiendo . . .");
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){}
    }

    public void run(){
        comedor.entrarAnimal(tipo);
        comer();
        comedor.saleAnimal(tipo);
    }
}
