package Tp3.Ejercicio7;

public class HiloA implements Runnable{
    private Turno turno;
    private int cantVecesImprimir = 3;

    public HiloA(Turno turno){
        this.turno = turno;
    }

    public void run(){
        int i=0;
        for(i=0;i<50;i++){
        while(!turno.getValor().equals("a")){
            //ESTO ES PARA LIBERAR EL LOCK ya que si no se produce deadlock si agarra el lock el incorrecto
            try { 
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }   
        escribir();
    }
    }

    public void escribir(){
        int i;
        for(i=0;i<cantVecesImprimir;i++){
            System.out.print("a");
        }
        turno.setValor("b");
    }

    
}
