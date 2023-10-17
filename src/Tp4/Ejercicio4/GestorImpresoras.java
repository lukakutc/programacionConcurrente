package Tp4.Ejercicio4;

public class GestorImpresoras {
    int cantImpresoras;
    private Impresora[] colImpresoras;

    //La coleccion de impresoras se pasa por parametro en la construccion del gestor
    public GestorImpresoras(Impresora[] colImpresoras ){
        this.colImpresoras  = colImpresoras;
    }

    public void imprimir(){ 
        boolean seImprimio = false;
        int i=0;
        //Intentamos imprimir 
        while(!seImprimio){
            //intentamos imprimr. si se imprimio lo indicamos para que no siga intentandose imprimir
            if(colImpresoras[i].imprimir()){
                seImprimio = true;
            }else{
                //Si no se pudo imprmir con la impresora en posicion I de la coleccion
                //Iteramos para intentar con la proxima
                if(i==colImpresoras.length-1){
                    i=0;
                }else{
                    i++;
                }
            }
        }

    }
}
