package Tp5.ejercicio3por2;

public class Ejecucion {
    public static void main(String[] args) {
        // Creamos un comedor
        Comedor comedor = new Comedor();
        // Creamos animales, multiplos de 6 ya q los semaforos son de a 6
        int i;
        Thread animales[] = new Thread[24];
        for (i = 0; i < 24; i++) {
            if(i%2==0){
                animales[i] = new Thread(new Animal(comedor, "Perro"));
            }else{
                animales[i] = new Thread(new Animal(comedor, "Gato"));
            }     
        }
        for(i=0;i<24;i++){
            animales[i].start();
        }
    }
}
