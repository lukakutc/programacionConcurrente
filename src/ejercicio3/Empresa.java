package ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    // atributos
    private String nombre;
    private List<Empleado> colEmpleados;
    private int longitudColEmpleados;

    //constructor
    Empresa (String elNombre){
        nombre = elNombre;
        colEmpleados = new ArrayList<Empleado>();
        longitudColEmpleados = 0;
    }

    // metodos
    public List<Empleado> obtenerEmpleadosAntiguedad10Anios() {
        int i = 0;
        List<Empleado> colEmpleadosAntiguos = new ArrayList<Empleado>();
        for (i = 0; i < longitudColEmpleados; i++) {
            if (colEmpleados.get(i).antiguedad10Anios()) {
                colEmpleadosAntiguos.add(colEmpleados.get(i));
            }
        }
        return colEmpleadosAntiguos;
    }

    public void mostrarDatosEmpleados() {
        for (int i = 0; i < longitudColEmpleados; i++) {
            System.out.println(colEmpleados.get(i).toString());
        }
    }

    public void añadirEmpleado(Empleado elEmpleado){
        colEmpleados.add(elEmpleado);
        longitudColEmpleados++;
    }
}
