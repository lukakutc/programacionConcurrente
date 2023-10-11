package Tp3.Ejercicio2;

public class  EjecucionPrograma{
    public static void main(String[] args) {
        Energia energia = new Energia();
        
        Sanador sanador = new Sanador(energia);
        CriaturaOscura criatura = new CriaturaOscura(energia);

        Thread hiloSanador = new Thread(sanador, "Sanador");
        Thread hiloCriatura = new Thread(criatura, "Criatura");

        hiloSanador.start();
        hiloCriatura.start();

    }
    
}
