package excepciones;

public class PruebaExcep {

    // Escriba un método que ingrese la edad de una persona y dispare una excepción
    // si la persona es menor de edad.

    // Metodo que lanza la excepcion
    public static String escribirSiMayor(int edad) throws MenorDeEdadExcepcion {
        String res = " es mayor.";
        if (edad < 18) {
            throw new MenorDeEdadExcepcion("MENOR DE EDAD. ALERTA");
        }
        return res;
    }

    public static void main(String[] args) {
        //Probamos MenorDeEdadExcepcion
        try {
            System.out.println(escribirSiMayor(15));   
            
        }catch (MenorDeEdadExcepcion e) {
            System.out.println(e.getMessage());
        }


    }

}

