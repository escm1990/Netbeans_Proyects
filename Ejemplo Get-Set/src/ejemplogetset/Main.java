package ejemplogetset;

import Receptor.Datos_Empleado;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Datos_Empleado datos = new Datos_Empleado();
        JOptionPane.showMessageDialog(null, "Ficha del Empleado\n\n" + "Nombre: " + datos.getNombre()
                + "\n" + "Edad: " + datos.getEdad() + "\n" + "Sexo: " + datos.getSexo() + "\n"
                + "Dirección: " + datos.getDireccion() + "\n" + "Teléfono: " + datos.getTelefono() +
                "\n" + "Nº de DUI: " + datos.getDUI() + "\n" + "E-mail: " + datos.getEmail() + "\n" +
                "Cargo que desempeña: " + datos.getCargo() + "\n" + "Sueldo Neto: $" + datos.getSueldoneto()
                + "\n" + "Sueldo Líquido: $" + datos.getSueldoliquido());
    }
}
