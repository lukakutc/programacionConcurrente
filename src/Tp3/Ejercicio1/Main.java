package Tp3.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        //Es confuso. Pero la cuenta banco es el recurso que utiliza el hilo
        //Lo creamos una sola vez y lo comparten los hilos
        //Los hilos son creados a partir del Runnable VerificarCuenta. 
        //O sea que la clase VerificarCuenta es la que trabaja con el recurso cuenta banco
        
        //Asi como esta actualmente, no se va a compartir una cuenta de banco entre los dos hilos
        //Cada uno tiene una cuenta de banco independiente
        VerificarCuenta vc = new VerificarCuenta();
        Thread Luis = new Thread(vc, "Luis");
        Thread Manuel = new Thread(vc, "Manuel");
        Luis.start();
        Manuel.start();
    }
}