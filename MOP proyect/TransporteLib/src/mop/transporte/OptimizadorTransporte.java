package mop.transporte;

import jairosoft.mop.transporte.Asignacion;
import jairosoft.mop.transporte.ModeloTransporteOptimizado;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.FileDialog;
import java.io.*;
import java.util.*;

public class OptimizadorTransporte {

    JTextArea area;
    JTextArea salida;
    JScrollPane p, ps;
    JLabel tituloEditor, tituloSalida;
    Evento evento;
    //  datos de problema  *******
    int Fuentes, Destinos;
    double Suministros[], Demandas[];
    double Costos[][];
    double Var[][];
    int VB[][];
    JMenuBar menuBar;
    JMenu menuArchivo;
    JMenuItem itemAbrir, itemGuardar;
    JMenu menuTareas;
    JMenuItem itemEjecutar;
    JMenuItem itemGuardarResultados;
    boolean resCompilar;

    public OptimizadorTransporte() {
        /*Container c=getContentPane();
        agregarControles(c);
        setSize(600,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
    }

    public void agregarControles(Container c) {
        c.setLayout(null);



        tituloEditor = new JLabel("Editar programa");
        tituloEditor.setBounds(100, 10, 240, 30);
        tituloEditor.setFont(new Font("Arial", Font.BOLD, 14));
        tituloEditor.setForeground(Color.blue);
        c.add(tituloEditor);


        area = new JTextArea();
        p = new JScrollPane(area, p.VERTICAL_SCROLLBAR_ALWAYS, p.HORIZONTAL_SCROLLBAR_ALWAYS);
        p.setBounds(30, 40, 340, 400);
        area.setFont(new Font("Arial", Font.BOLD, 14));
        area.setText("");
        c.add(p);


        tituloSalida = new JLabel("Resultados");
        tituloSalida.setBounds(500, 10, 250, 30);
        tituloSalida.setForeground(Color.blue);
        c.add(tituloSalida);
        salida = new JTextArea();
        salida.setEditable(false);
        salida.setFont(new Font("Arial", Font.BOLD, 14));
        salida.setForeground(Color.blue);
        salida.setBackground(new Color(200, 200, 255));
        salida.setText("");
        ps = new JScrollPane(salida, ps.VERTICAL_SCROLLBAR_ALWAYS, ps.HORIZONTAL_SCROLLBAR_ALWAYS);
        ps.setBounds(380, 40, 340, 400);
        c.add(ps);


        evento = new Evento();




        menuBar = new JMenuBar();

        menuArchivo = new JMenu("  Archivo  ");
        itemAbrir = new JMenuItem("Abrir");
        itemGuardar = new JMenuItem("Guardar");
        menuArchivo.add(itemAbrir);
        menuArchivo.addSeparator();
        menuArchivo.add(itemGuardar);
        itemGuardar.addActionListener(evento);
        itemAbrir.addActionListener(evento);

        menuTareas = new JMenu("  Tareas  ");
        itemEjecutar = new JMenuItem("Resolve transporte");
        menuTareas.add(itemEjecutar);
        itemEjecutar.addActionListener(evento);
        itemGuardarResultados = new JMenuItem("Guardar resultados");
        menuTareas.addSeparator();
        menuTareas.add(itemGuardarResultados);
        itemGuardarResultados.addActionListener(evento);


        menuBar.add(menuArchivo);
        menuBar.add(menuTareas);

        //setJMenuBar(menuBar);

        resCompilar = false;

    }

    /*public static void main(String []a)
    {  new OptimizadorTransporte("Resolver problema de transporte");
    
    }*/
    /*void guardarArchivo()
    { String T=area.getText();
    if (T==null || T.equals("")) return;
    //FileDialog fdialog=new FileDialog(this,"Guardar Archivo",FileDialog.SAVE);
    fdialog.setVisible(true);
    String S=fdialog.getFile();
    if (S!=null)
    try
    { String D=fdialog.getDirectory();
    String Filename=D+S;
    FileOutputStream fileOutput=new FileOutputStream(Filename);
    fileOutput.write(T.getBytes());
    fileOutput.close();
    }
    catch (IOException ex)
    {  }
    return;
    
    }
     */

    /*void guardarResultados()
    { String T=salida.getText();
    if (T==null || T.equals("")) return;
    //System.out.println("["+T+"]");
    FileDialog fdialog=new FileDialog(this,"Guardar resultados",FileDialog.SAVE);
    fdialog.setVisible(true);
    String S=fdialog.getFile();
    if (S!=null)
    try
    { String D=fdialog.getDirectory();
    String Filename=D+S;
    FileOutputStream fileOutput=new FileOutputStream(Filename);
    fileOutput.write(area.getText().getBytes());
    fileOutput.write((byte)'\n');
    fileOutput.write(T.getBytes());
    fileOutput.close();
    }
    catch (IOException ex)
    {  }
    return;
    
    }*/
    /*void abrirArchivo()
    {
    FileDialog fdialog=new FileDialog(this,"Abrir Archivo",FileDialog.LOAD);
    fdialog.setVisible(true);
    String S=fdialog.getFile();
    
    
    if (S!=null)
    try
    {  String D=fdialog.getDirectory();
    String Filename=D+S;
    File  file=new File(Filename);
    FileInputStream fileInput=new FileInputStream(Filename);
    int size=(int)file.length();
    byte buffer[]=new byte[size];
    fileInput.read(buffer);
    fileInput.close();
    String T=new String(buffer);
    area.setText(T);
    }
    catch (IOException ex)
    { //System.out.println("IOException "+ex.toString());}
    
    return;
    }  // abrirArchivo*/
    public void obtenerDatos(String S) {
        String Token[];
        int numToken;
        StringTokenizer tokens = new StringTokenizer(S);
        numToken = tokens.countTokens();
        Token = new String[numToken];
        int i, j, pos;
        i = 0;
        while (tokens.hasMoreTokens()) {
            Token[i++] = tokens.nextToken();
        }

        if (!Token[0].equalsIgnoreCase("Fuentes")) {
            //System.out.println("error se espera la palabra Fuentes");
            return;
        }
        Fuentes = Integer.parseInt(Token[1]);
        //System.out.println("Fuentes=" + Fuentes);

        if (!Token[2].equalsIgnoreCase("Suministros")) {
            //System.out.println("error se espera la palabra Suministros");
            return;
        }

        Suministros = new double[Fuentes + 1];

        for (i = 1; i <= Fuentes; i++) {
            Suministros[i] = Double.parseDouble(Token[i + 2]);
        }
        for (i = 1; i <= Fuentes; i++) {
            //System.out.print(Suministros[i] + "  ");
        }
        pos = Fuentes + 4;

        Destinos = Integer.parseInt(Token[pos]);
        //System.out.println("\nDestinos=" + Destinos);
        pos++;
        if (!Token[pos].equalsIgnoreCase("Demandas")) {
            //System.out.println("error se espera la palabra Demandas");
            return;
        }

        Demandas = new double[Destinos + 1];

        for (i = 1; i <= Destinos; i++) {
            Demandas[i] = Double.parseDouble(Token[pos + i]);
        }
        for (i = 1; i <= Destinos; i++) {
            //System.out.print(Demandas[i] + "  ");
        }

        pos += Destinos + 1;

        if (!Token[pos].equalsIgnoreCase("Costos")) {
            //System.out.println("\nerror se espera la palabra Costos");
            return;
        }

        //System.out.println("\nCostos\n");
        Costos = new double[Fuentes + 1][Destinos + 1];
        for (i = 1; i <= Fuentes; i++) {
            for (j = 1; j <= Destinos; j++) {
                Costos[i][j] = Double.parseDouble(Token[pos + j]);
            }
            pos += Destinos;
        }

        for (i = 1; i <= Fuentes; i++) {
            for (j = 1; j <= Destinos; j++) {
                //System.out.print(Costos[i][j] + "  ");
            }
            //System.out.println();
        }



    }

    void hallarSolucionBasica() {
        int i, j;
        double MIN;
        int iMin, jMin;
        int iter;
        boolean FLibre[], CLibre[];
        int flibre, clibre;
        double suministros[], demandas[];

        // solucion basica inicial celda costo min


        Var = new double[Fuentes + 1][Destinos + 1];
        VB = new int[Fuentes + 1][Destinos + 1];
        for (i = 1; i <= Fuentes; i++) {
            for (j = 1; j <= Destinos; j++) {
                Var[i][j] = 0;
                VB[i][j] = 0;
            }
        }


        suministros = new double[Fuentes + 1];
        for (i = 1; i <= Fuentes; i++) {
            suministros[i] = Suministros[i];
        }
        demandas = new double[Destinos + 1];
        for (i = 1; i <= Destinos; i++) {
            demandas[i] = Demandas[i];
        }


        FLibre = new boolean[Fuentes + 1];
        for (i = 1; i <= Fuentes; i++) {
            FLibre[i] = true;
        }

        CLibre = new boolean[Destinos + 1];
        for (i = 1; i <= Destinos; i++) {
            CLibre[i] = true;
        }
        iMin = 0;
        jMin = 0;
        flibre = Fuentes;
        clibre = Destinos;
        iter = 0;

        while (true) {
            MIN = -1;
            iMin = -1;
            jMin = -1;
            for (i = 1; i <= Fuentes; i++) {
                if (!FLibre[i]) {
                    continue;
                }

                for (j = 1; j <= Destinos; j++) {
                    if (!CLibre[j]) {
                        continue;
                    }
                    if (MIN == -1 || MIN > Costos[i][j]) {
                        MIN = Costos[i][j];
                        iMin = i;
                        jMin = j;
                    }
                }

            }

            iter++;
            //System.out.print("iter=" + iter + " selecciona (" + iMin + "," + jMin + ")");

            if (suministros[iMin] < demandas[jMin]
                    || suministros[iMin] == demandas[jMin] && flibre > clibre) {
                FLibre[iMin] = false;
                flibre--;
                Var[iMin][jMin] = suministros[iMin];
                demandas[jMin] -= suministros[iMin];

                VB[iMin][jMin] = 1;
                //System.out.println(" fila marcada " + iMin + " var= " + Var[iMin][jMin]);
            } else {
                CLibre[jMin] = false;
                clibre--;
                suministros[iMin] -= demandas[jMin];
                Var[iMin][jMin] = demandas[jMin];
                VB[iMin][jMin] = 1;
                //System.out.println(" columna marcada " + jMin + " var= " + Var[iMin][jMin]);
            }


            if (iter >= Fuentes + Destinos - 1) {
                break;
            }
        }  // while


        // muestra variables basicas
        //System.out.println("\nVariables basicas\n");

        for (i = 1; i <= Fuentes; i++) {
            for (j = 1; j <= Destinos; j++) {
                if (VB[i][j] == 1) {
                    //System.out.println("(" + i + "," + j + ") valor " + Var[i][j]);
                }
            }

        }
    }

    class Nodo {

        int x;
        int y;

        public Nodo(int x1, int y1) {
            x = x1;
            y = y1;
        }
    }

    class NodoEB {

        int x;
        int y;
        char dir;  // puede ser 'H' o 'V'
        int anterior;

        public NodoEB(int x1, int y1, char d1) {
            x = x1;
            y = y1;
            dir = d1;
            anterior = 0;
        }
    }

    public void hallarCiclo(int i0, int j0) {
        char dir;
        NodoEB EB[] = new NodoEB[Fuentes + Destinos];
        int Primero;
        int Ultimo;
        int i, j;
        Nodo ciclo[];

        // sucesores verticales de nodo inicial

        Ultimo = 0;
        for (i = 1; i <= Fuentes; i++) {
            if (VB[i][j0] == 1) {
                EB[++Ultimo] = new NodoEB(i, j0, 'H');
                EB[Ultimo].anterior = -1;
            }

        }


        Primero = 1;

        while (true) {
            int x, y;

            NodoEB p = EB[Primero];
            //  //System.out.println("Primero="+Primero);
            x = p.x;
            y = p.y;
            dir = p.dir;

            if (dir == 'H' && x == i0) {
                break;
            }


            if (dir == 'V') {
                for (i = 1; i <= Fuentes; i++) {
                    if (i != x && VB[i][y] == 1) {
                        EB[++Ultimo] = new NodoEB(i, y, 'H');
                        EB[Ultimo].anterior = Primero;
                    }
                }
            } else {
                for (j = 1; j <= Destinos; j++) {
                    if (j != y && VB[x][j] == 1) {
                        EB[++Ultimo] = new NodoEB(x, j, 'V');
                        EB[Ultimo].anterior = Primero;
                    }
                }
            }


            //  //System.out.println("Ultimo="+Ultimo);
            Primero++;
        }

        // muestra EB
/*
        for (i=1;i<=Ultimo;i++)
        { int x,y,anterior;
        NodoEB p;
        p=EB[i];
        x=p.x; y=p.y; dir=p.dir; anterior=p.anterior;
        //System.out.println( i+" ("+x+","+y+","+dir+","+anterior+")");
        }
        
         */
        //  muestra ciclo


        int x, y, anterior, cuenta;
        NodoEB p;
        p = EB[Primero];
        cuenta = 2;


        while (true) {
            x = p.x;
            y = p.y;
            dir = p.dir;
            anterior = p.anterior;
            //   //System.out.println( " ***("+x+","+y+","+dir+","+p.anterior+")");

            if (anterior == -1) {
                break;
            }
            p = EB[anterior];
            cuenta++;

        }
        //   //System.out.println("*** cuenta="+cuenta);

        ciclo = new Nodo[cuenta + 1]; // 1 2 ... cuenta
        ciclo[1] = new Nodo(i0, j0);
        p = EB[Primero];
        cuenta = 2;

        while (true) {
            x = p.x;
            y = p.y;
            dir = p.dir;
            anterior = p.anterior;

            ciclo[cuenta] = new Nodo(x, y);

            if (anterior == -1) {
                break;
            }
            p = EB[anterior];
            cuenta++;
        }

        //System.out.print("ciclo de (" + i0 + "," + j0 + ") : ");
        for (i = 1; i <= cuenta; i++) {
            //System.out.print("(" + ciclo[i].x + "," + ciclo[i].y + ") ");
        }
        //System.out.println();


        {
            double min, v;
            int i1, j1, pos, posmin;


            min = -1;
            posmin = -1;
            for (pos = 2; pos <= cuenta; pos += 2) {
                i1 = ciclo[pos].x;
                j1 = ciclo[pos].y;
                v = Var[i1][j1];
                //System.out.println(pos + " " + v);
                if (min == -1 || min > v) {
                    min = v;
                    posmin = pos;
                }

            }


            VB[i0][j0] = 1;  // nueva variable b�sica


            for (pos = 1; pos <= cuenta; pos++) {
                i1 = ciclo[pos].x;
                j1 = ciclo[pos].y;
                v = Var[i1][j1];
                if (pos % 2 == 0) {
                    Var[i1][j1] -= min;
                } else {
                    Var[i1][j1] += min;
                }
                if (pos == posmin) {
                    VB[i1][j1] = 0;
                }
            }

        }




    } // hallar ciclo

    public void resolver(ModeloTransporteOptimizado modelo) //  ************ tarea principal *********
    {
        
        /****
        double  Var[][];
        int     VB[][];
        double  suministros[], demandas[];
        
         ***/
        String S=modelo.salidaOptimizadorTransporte();
        System.out.println(S);
        
        double c[][];
        double u[], v[];
        boolean us[], vs[];
        int i, j, cuenta;
        int i0, j0;
        double cm;
        int paso;

        obtenerDatos(S);
        hallarSolucionBasica();

        // costos reducidos u-v
        c = new double[Fuentes + 1][Destinos + 1];

        u = new double[Fuentes + 1];
        v = new double[Destinos + 1];

        us = new boolean[Fuentes + 1];
        vs = new boolean[Destinos + 1];
        paso = 0;
        while (true) // halla u-v, costos reducidos, etc    ************
        {
            paso++;
            //System.out.println("***  paso " + paso + " ****\n");
            for (i = 1; i <= Fuentes; i++) {
                us[i] = false;
            }
            for (i = 1; i <= Destinos; i++) {
                vs[i] = false;
            }
            u[1] = 0;
            us[1] = true;
            cuenta = Fuentes + Destinos - 1;

            while (cuenta > 0) {
                ////System.out.println("cuenta="+cuenta);
                for (i = 1; i <= Fuentes; i++) {
                    for (j = 1; j <= Destinos; j++) {
                        if (VB[i][j] == 1) {
                            if (!us[i] && vs[j]) {
                                us[i] = true;
                                u[i] = Costos[i][j] - v[j];
                                cuenta--;
                            }
                            if (us[i] && !vs[j]) {
                                vs[j] = true;
                                v[j] = Costos[i][j] - u[i];
                                cuenta--;
                            }

                        }

                    }
                }

            }  // while



            // muestra u y v
            //System.out.println("valores de u ");
            for (i = 1; i <= Fuentes; i++) {
                //System.out.print(u[i] + " ");
            }

            //System.out.println("\nvalores de v ");
            for (j = 1; j <= Destinos; j++) {
                //System.out.print(v[j] + " ");
            }

            // calcula c[i][j]

            i0 = -1;
            j0 = -1;
            cm = -1;

            //System.out.println("\n\ncostos reducidos\n");
            for (i = 1; i <= Fuentes; i++) {
                for (j = 1; j <= Destinos; j++) {
                    c[i][j] = Costos[i][j] - u[i] - v[j];
                    //System.out.print(c[i][j] + " ");
                    if (c[i][j] < 0) {
                        if (i0 == -1 || c[i][j] < cm) {
                            i0 = i;
                            j0 = j;
                            cm = c[i][j];
                        }

                    }
                }
                //System.out.println();
            }


            //System.out.println("i0=" + i0 + " j0=" + j0);
            if (i0 >= 1) {
                hallarCiclo(i0, j0);
            } else {
                break;
            }
        }  // while true        ***************

        double total = 0;
        //Esto es salida a sout
  /*//System.out.println("\nSolucion\n");
        for (i=1;i<=Fuentes;i++)
        for (j=1;j<=Destinos;j++)
        if (VB[i][j]==1)
        { //System.out.println("se envian de "+i+" a "+j+" : "+Var[i][j]+" unidades");
        total += Costos[i][j]*Var[i][j];
        }
        //System.out.println("minimo costo total = "+total);*/

        
        String res="\nSolucion\nenvios:";
        for (i = 1; i <= Fuentes; i++) {
            for (j = 1; j <= Destinos; j++) {
                Asignacion nuevaAsignacion = new Asignacion();
                nuevaAsignacion.setValor(Var[i][j]);
                nuevaAsignacion.setVariableBasica(VB[i][j]==1);
                
                modelo.setAsignacion(i-1, j-1, nuevaAsignacion);
                if (VB[i][j] == 1 && Var[i][j] > 0) {
                    res+="\nde fuente " + i + " a destino " + j + " :  " + Var[i][j] + " unidades";

                }
            }
        }
        
        modelo.setResumen(res);
    }

    class Evento implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Object o = e.getSource();

            if (o == itemEjecutar) {
                String S = area.getText();
                if (S == null || S.equals("")) {
                    return;
                }

                //resolver(S);
                return;
            }

            //if (o==itemGuardarResultados) { guardarResultados(); return; }

            //if (o==itemGuardar) { guardarArchivo(); return; }

            //if (o==itemAbrir) { abrirArchivo(); return; }

        }
    }
}
