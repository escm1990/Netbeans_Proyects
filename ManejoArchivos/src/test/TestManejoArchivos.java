package test;

import static manejoarchivos.ManejoArchivos.*;

public class TestManejoArchivos {

    public static void main(String[] args) {
        var nombreArchivo = "Prueba.txt";
        //crearArchivo(nombreArchivo);
        //escribirArchivo(nombreArchivo, "Hola desde Java");
        //anexarArchivo(nombreArchivo, "Adios desde Java");
        leerArchivo(nombreArchivo);
    }
}
