package ejercicio3;

public class Administrativo extends Empleado {
    // atributos
    private String categoria;
    private int asistencia;

    // metodos
    public String toString(){
        return super.toString() + " Categoria: " + categoria + " Asistencia: " + asistencia;
    }

    Administrativo(int elDni, String elNombre, String laDireccion, String laFechaNacimiento, char elSexo, String elLegajo, int laAntiguedad, String laCategoria, int laAsistencia){
        super(elDni, elNombre, laDireccion, laFechaNacimiento, elSexo, elLegajo, laAntiguedad);
        categoria = laCategoria;
        asistencia = laAsistencia;
    }
}
