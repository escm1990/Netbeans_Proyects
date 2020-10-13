
import java.io.*;

/*
 * Lee un archivo separado por comas que se encuentra dentro
 * del proyecto en la carpeta archivo con el nombre datos.cvs
 */

/**
 *
 * @author qmarqeva
 */
public class lectura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        String linea = null;

        try {
            //Cargamos el archivo de la ruta relativa
            archivo = new File("archivo\\datos.csv");
            //Cargamos el objeto FileReader
            fr = new FileReader(archivo);
            //Creamos un buffer de lectura
            br = new BufferedReader(fr);

            String[] datos = null;

            //Leemos hasta que se termine el archivo
            while ((linea = br.readLine()) != null) {

                //Utilizamos el separador para los datos
                datos = linea.split(";");
                //Presentamos los datos
                System.out.println("El día " + datos[0] + " has trabajado " + datos[1] + " horas.");

            }

            //Capturamos las posibles excepciones
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }
}
