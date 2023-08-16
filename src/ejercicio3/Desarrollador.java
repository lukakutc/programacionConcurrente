package ejercicio3;

/**
 * Desarollador
 */
public class Desarrollador extends Empleado {

    //Atributos
    private String titulo;
    private String rol;
    
    //metodos
    public String toString(){
        return super.toString() + " Titulo: " +titulo+ " Rol: " + rol+".";
    }

    Desarrollador(int elDni, String elNombre, String laDireccion, String laFechaNacimiento, char elSexo, String elLegajo, int laAntiguedad, String elTitulo, String elRol){
        super(elDni, elNombre, laDireccion, laFechaNacimiento, elSexo, elLegajo, laAntiguedad);
        titulo = elTitulo;
        rol = elRol;
    }
}