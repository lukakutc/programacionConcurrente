package TP6Monitroes.ProductorConsumidor.Ejercicio4;

public class Consumidor implements Runnable{
    private Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }
    
    public void run(){
        while(true){
            buffer.quitar();
        }
    }
}
    
