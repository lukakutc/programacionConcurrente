package Recuperatorio.BarberoRendezVous;

public class Barbero implements Runnable {
    private Silla silla;

    public Barbero(Silla silla) {
        this.silla = silla;
    }

    public void run() {
        while (true) {
            silla.cortarPelo();
            silla.terminarCorte();
        }

    }

}
