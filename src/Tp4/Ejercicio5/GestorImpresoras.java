package Tp4.Ejercicio5;

public class GestorImpresoras {
    private Impresora[] impresoras;

    public GestorImpresoras(Impresora[] impresoras){
        this.impresoras = impresoras;

    }
    public void imprimir(String tipoImpresion){
        boolean seImprimio = false;
        int i = 0;
        while(!seImprimio){
            if(impresoras[i].imprimir(tipoImpresion)){
                //Si se pudo imprimir con la impresora i
                seImprimio = true;
            }else{
                //Si no se pudo imprimir recorremos el arreglo de impresoras.
                //Hasta que se pueda volver a imprimir
                if(i==impresoras.length-1){
                    i=0;
                }else{
                    i++;
                }
            }
        }
    }
}
