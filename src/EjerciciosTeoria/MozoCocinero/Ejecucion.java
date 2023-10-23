package EjerciciosTeoria.MozoCocinero;

public class Ejecucion {
    public static void main(String[] args) {
        //Creamos un recurso compartido comida
        Comida comida = new Comida();

        //creamos un mozo y un cocinero
        Mozo mozo = new Mozo(comida);
        Cocinero cocinero = new Cocinero(comida);

        //Creamos los hilos de mozo y cocinero

        Thread hiloMozo = new Thread(mozo);
        Thread hiloCocinero = new Thread(cocinero);

        hiloMozo.start();
        hiloCocinero.start();
    }
}
