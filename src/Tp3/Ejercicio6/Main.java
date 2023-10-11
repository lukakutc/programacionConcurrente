package Tp3.Ejercicio6;

public class Main {
    public static void main(String[] args) {
        //Creamos un arreglo de 50000 elementos y lo cargamos con numeros random del 1 al 10
        int arreglo[] = new int[50000];
        int i;  
        Resultado resultado = new Resultado();
        for(i=0;i<50000;i++) {
            arreglo[i] = (int) (Math.random()*10) + 1;
        }

        //Creamos 5 hilos, cada uno sumara 10000 elementos. y una variable compartida resultado que es 
        //Donde todos los hilos sumaran el resultado
        
        

        
    
        
        

        Sumador sumador1 = new Sumador(arreglo, 0, resultado);
        Sumador sumador2 = new Sumador(arreglo, 10000, resultado);
        Sumador sumador3 = new Sumador(arreglo, 20000, resultado);
        Sumador sumador4 = new Sumador(arreglo, 30000, resultado);
        Sumador sumador5 = new Sumador(arreglo, 40000, resultado);

        sumador1.start();
        sumador2.start();
        sumador3.start();
        sumador4.start();
        sumador5.start();
//Duermo un poco el hilo main asi su ejecucion termina pos-ejecucion de los hilos
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());    
            
        }
        
        System.out.println("El resultado final de la suma resuelta por los hilos es: "+ resultado.getValor());
        System.out.print("El resultado final resuelto en una sola repetitiva es: ");
        int resultadoReal = 0;
        for(i=0;i<50000;i++){
            resultadoReal = resultadoReal + arreglo[i];
        }
        System.out.println(resultadoReal);
    }
}
