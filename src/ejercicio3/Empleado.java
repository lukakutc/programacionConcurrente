package ejercicio3;

public class Empleado extends Persona {
    //atributos
    private String legajo;
    private int antiguedad;

    //Mensajes
    public boolean antiguedad10Anios(){
        return antiguedad>=10;
    }

    public String toString(){
        return super.toString() + " Legajo: " + legajo +
        ". Antiguedad: " + antiguedad +" anios." ;
    }

    Empleado(int elDni, String elNombre, String laDireccion, String laFechaNacimiento, char elSexo, String elLegajo, int laAntiguedad){
        super(elDni, elNombre, laDireccion, laFechaNacimiento, elSexo);
        legajo = elLegajo;
        antiguedad = laAntiguedad;
    }
}
