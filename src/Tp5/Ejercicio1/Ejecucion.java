package Tp5.Ejercicio1;

public class Ejecucion {
    public static void main(String[] args) {
        //Creamos una piscina y personas
        Piscina piscina = new Piscina();
        int i;
        Thread personas[] = new Thread[25];
        for(i=0;i<personas.length;i++){
            personas[i] = new Thread(new Persona(piscina),"Persona "+i);
        }
        //iniciamos todos los hilos
        for(i=0;i<25;i++){
            personas[i].start();
        }
    }
}
