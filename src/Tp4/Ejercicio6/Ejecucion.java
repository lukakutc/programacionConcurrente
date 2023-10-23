package Tp4.Ejercicio6;

public class Ejecucion {
    public static void main(String[] args) {
        //Creamos un taxi.
        Taxi taxi = new Taxi();

        //creamos un taxista y un pasajero
        Taxista taxista = new Taxista(taxi);
        Pasajero pasajero = new Pasajero(taxi);

        //Creamos los hilos del pasajero y el taxista
        Thread hiloTaxi = new Thread (taxista);
        Thread hiloPasajero = new Thread(pasajero);

        hiloTaxi.start();
        hiloPasajero.start();
    }
}
