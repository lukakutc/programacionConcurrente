package Tp3.Ejercicio7;

public class HiloC implements Runnable {
    private Turno turno;
    private int cantVecesImprimir = 8;

    public HiloC(Turno turno) {
        this.turno = turno;
    }

    public void run() {
        int i = 0;
        for (i = 0; i < 50; i++) {
            while (!turno.getValor().equals("c")) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            escribir();
        }
    }

    public void escribir() {
        int i;
        for (i = 0; i < cantVecesImprimir; i++) {
            System.out.print("c");
        }
        turno.setValor("a");
    }
}
