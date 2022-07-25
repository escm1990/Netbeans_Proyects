package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Figura> figuras = new ArrayList<>();
        figuras.add(new Figura(1, "Triangulo"));
        figuras.add(new Figura(2, "Cuadrado"));
        figuras.add(new Figura(3, "Rectangulo"));
        figuras.add(new Figura(4, "Rombo"));
        figuras.add(new Figura(5, "Romboide"));
        figuras.add(new Figura(6, "Trapecio"));
        figuras.add(new Figura(7, "Poligono Regular"));
        figuras.add(new Figura(8, "Circulo"));
        figuras.add(new Figura(9, "Triangulo"));
        figuras.add(new Figura(10, "Cuadrado"));
        figuras.add(new Figura(11, "Rectangulo"));
        figuras.add(new Figura(12, "Triangulo"));
        figuras.add(new Figura(13, "Cuadrado"));
        figuras.add(new Figura(14, "Rectangulo"));
        figuras.add(new Figura(15, "Rombo"));
        figuras.add(new Figura(16, "Romboide"));

        int contadorTriangulo = 0;
        int contadorCuadrado = 0;
        int contadorRectangulo = 0;
        int contadorRombo = 0;
        int contadorRomboide = 0;
        int contadorTrapecio = 0;
        int contadorPoligonoRegular = 0;
        int contadorCirculo = 0;

        for (int i = 0; i < figuras.size(); i++) {
            switch (figuras.get(i).getNombre()) {
                case "Triangulo":
                    contadorTriangulo = contadorTriangulo + 1;
                    break;
                case "Rectangulo":
                    contadorRectangulo = contadorRectangulo + 1;
                    break;
                case "Cuadrado":
                    contadorCuadrado = contadorCuadrado + 1;
                    break;
                case "Rombo":
                    contadorRombo = contadorRombo + 1;
                    break;
                case "Romboide":
                    contadorRomboide = contadorRomboide + 1;
                    break;
                case "Trapecio":
                    contadorTrapecio = contadorTrapecio + 1;
                    break;
                case "Poligono Regular":
                    contadorPoligonoRegular = contadorPoligonoRegular + 1;
                    break;
                case "Circulo":
                    contadorCirculo = contadorCirculo + 1;
                    break;
                default:
                    break;
            }
        }

        System.out.println("Triangulo: "+contadorTriangulo+"\n"+
                            "Cuadrado: "+contadorCuadrado+"\n"+
                            "Rectangulo: "+contadorRectangulo+"\n"+
                            "Rombo: "+contadorRombo+"\n"+
                            "Romboide: "+contadorRomboide+"\n"+
                            "Trapecio: "+contadorTrapecio+"\n"+
                            "Poligono Regular: "+contadorPoligonoRegular+"\n"+
                            "Circulo: "+contadorCirculo+"\n"
                            );
        
    }

}
