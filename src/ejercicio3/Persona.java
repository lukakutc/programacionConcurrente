package ejercicio3;


/**
 * Persona
 */
public class Persona {

    //Atributos
    private int dni;
    private String nombre;
    private String direccion;
    private String fechaNacimiento;
    private char sexo;

    //Constructor
    Persona(int elDni, String elNombre, String laDireccion, String laFechaNacimiento, char elSexo){
        dni = elDni;
        nombre = elNombre;
        direccion = laDireccion;
        fechaNacimiento = laFechaNacimiento;
        sexo = elSexo;
    }

    //Metodos
    public String toString() {
        return "Dni: " +dni+
        " Nombre: "+nombre+
        " Direccion; "+direccion+
        " Fecha nacimiento: "+fechaNacimiento+
        " Sexo: "+sexo;
    }
    
}

