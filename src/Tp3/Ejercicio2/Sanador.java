package Tp3.Ejercicio2;

public class Sanador implements Runnable{
    private Energia energia;

    public Sanador(Energia energia){
        this.energia = energia;
    }

    public void curar(){
        energia.curar(3);
    }

    public void run(){
        int i;
        int hasta = (int) (Math.random()*10);
        for (i=0;i<hasta;i++){
            System.out.println(Thread.currentThread().getName()+ "Cura 3 de energia");
            curar();
            System.out.println("Energia actual " + energia.getValor());
        }
    }

}
