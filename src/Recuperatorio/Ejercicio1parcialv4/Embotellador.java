package Recuperatorio.Ejercicio1parcialv4;

public class Embotellador implements Runnable {
    private Fabrica fabrica;
    String tipo;

    public Embotellador(Fabrica fabrica, String tipo) {
        this.fabrica = fabrica;
        this.tipo = tipo;
        
    }

    public void run() {
        while (true) {
            if(tipo.equals("A")){
                fabrica.ponerAgua();
            }else{
                fabrica.ponerVino();
            }
        }
    }

}
