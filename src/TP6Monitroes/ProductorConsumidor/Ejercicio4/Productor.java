package TP6Monitroes.ProductorConsumidor.Ejercicio4;

public class Productor implements Runnable {
    private Buffer buffer;


    
    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }



    public void run(){
        int random = (int) (Math.random()*100);
        int i;

        for(i=0;i<random;i++){
            buffer.añadir("Producto "+i);
        }
        
    }

}
