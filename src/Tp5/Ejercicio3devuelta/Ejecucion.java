package Tp5.Ejercicio3devuelta;

public class Ejecucion {
    public static void main(String[] args) {
        //Creamos un comedor
        Comedor comedor = new Comedor();
        //Creamos animales
        Thread animales[] = new Thread[18];
        int i;
        for(i=0;i<9;i++){
            animales[i] = new Thread(new Animal("Gato",comedor));
        }
        for(i=9;i<18;i++){
            animales[i] = new Thread(new Animal("Perro",comedor));
        }
        for(i=0;i<18;i++){
            animales[i].start();
        }


    }
}
