package Tp5.Ejercicio1;

public class Persona implements Runnable {
    Piscina piscina;

    public Persona(Piscina piscina) {
        this.piscina = piscina;
    }

    public void entrarPileta(){
        piscina.entraPersona();
    }
    public void salirPileta(){
        piscina.salePersona();
    }
    public void bañarse(){ 
        System.out.println("La persona "+Thread.currentThread().getName()+" se esta bañando en la pileta");
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void run(){
        entrarPileta();
        bañarse();
        salirPileta();
    }
}
