package ejercicio3;

public class EjecucionEjercicio {

    public static void main(String[] args) {
        
        //Creamos la empresa
        Empresa empresa = new Empresa("Lktc enterprises");
        //creamos empleados
        Desarrollador desarollador = new Desarrollador(43792826, "Luca Tocce", "Suecia 1861", "23/02/02", 'M',  "Fai-2995", 0, "Licenciado en Cs. de la Computacion", "Supervisor");
        Administrativo administrativo = new Administrativo(43545454, "Lucas Fernandez", "Maipu 1500", "17/07/2003", 'M', "Fai-3143", 3, "FullStack developer", 4);
        
        //Cargamos empleados
        empresa.añadirEmpleado(desarollador);
        empresa.añadirEmpleado(administrativo);

        //Mostramos los datos de los empleados de la empresa
        empresa.mostrarDatosEmpleados();
    }

}