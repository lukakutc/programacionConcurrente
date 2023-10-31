package Tp5.Ejercicio3;

public class Ejecucion {
    public static void main(String[] args) {
        //Creamos un comedero
        Comedero comedero = new Comedero();
        //Creamos gatos y perros
        Thread animales[] = new Thread[24];
        int i;
        for(i=0;i<12;i++){
            animales[i] = new Thread(new Animal(comedero,"Gato"));
        }
        for(i=12;i<24;i++){
            animales[i] = new Thread(new Animal(comedero, "Perro"));
        }

        for(i=0;i<24;i++){
            animales[i].start();
        }
    }
}
