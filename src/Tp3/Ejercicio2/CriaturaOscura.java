package Tp3.Ejercicio2;

public class CriaturaOscura implements Runnable {
    private Energia energia;

    public CriaturaOscura(Energia energia){
        this.energia = energia;
    }

    public void drenar(){
        if(energia.getValor()>=3){
            energia.drenar(3);
        }else{
            System.out.println("No tiene energia. no se puede drenar");
        }
        
    }

    public void run(){
        int i = 0;
        int hasta = (int) (Math.random()*15);
        for(i=0;i<hasta;i++){
            System.out.println(Thread.currentThread().getName() + "Esta drenando 3 de energia!");
            drenar();
            System.out.println("Energia actual: "+energia.getValor());
        }
    }
}
