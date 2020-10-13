package controlador;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import modelo.modelo;
import vista.acercade;
import vista.login;
import vista.principal;
import vista.programacion;
/**
 * @web http://www.jc-mouse.net/
 * @author Mouse
 */
public class controlador implements ActionListener{

    private principal view;
    private modelo model;    
    //formularios hijos
    login frmlogin;
    programacion frmprogramacion;
    programacion frmimpresion;
    acercade wtf;
//___________________________________________________________________________________ Soy una barra separadora :)
   //En el constructor inicializamos nuestros objetos
   public controlador( principal vista , modelo modelo ){
       this.view = vista;
       this.model = modelo;
       iniciar();
   }
//___________________________________________________________________________________ Soy una barra separadora :)
/* INICIA */
    private void iniciar()
    {
        view.setTitle( "Programación de Materias [ Patrón MVC - by Mouse ]" );
        view.setLocationRelativeTo(null);//centrado en pantalla
        view.setExtendedState(principal.MAXIMIZED_BOTH);//estado maximizado
        //se añade las acciones a los controles del formulario padre
        this.view.cmdIdentificacion.setActionCommand("Abrir Sesion");
        this.view.cmdExit.setActionCommand("Cerrar Sesion");
        this.view.cmdProgramar.setActionCommand("Programar Asignaturas");
        this.view.cmdImprimir.setActionCommand("Ver Programacion");
        this.view.cmdAcercade.setActionCommand("Acerca de");
        //Se pone a escuchar las acciones del usuario
        view.cmdIdentificacion.addActionListener(this);
        view.cmdExit.addActionListener(this);
        view.cmdProgramar.addActionListener(this);
        view.cmdImprimir.addActionListener(this);
        view.cmdAcercade.addActionListener(this);
    }
//___________________________________________________________________________________ Soy una barra separadora :)
/* muestra la vista al usuario */
    public void go()
    {
        this.view.setVisible(true);
    }
//___________________________________________________________________________________ Soy una barra separadora :)
    /* ATENTO A LAS ACCIONES DEL USUARIO */
    public void actionPerformed(ActionEvent e) {
        //Captura en String el comando accionado por el usuario
        String comando = e.getActionCommand();
        //..........................................................................................
        /* Acciones del formulario padre */
        if( comando.equals("Abrir Sesion"))
        {
            form_logueo();
        }else if( comando.equals("Cerrar Sesion"))
        {
            //deshabilita/habilita controles según sea necesario
            this.view.cmdIdentificacion.setEnabled(true);
            this.view.cmdExit.setEnabled(false);
            this.view.cmdProgramar.setEnabled(false);
            this.view.cmdImprimir.setEnabled(false);
            //Cierra formularios hijos abiertos
            cerrar_todo();
        }
        else if( comando.equals("Programar Asignaturas"))
        {
            //Comprueba que universitario ya este programado
            if( this.model.esta_programado( this.model.univ.getCU() ) )
                JOptionPane.showMessageDialog(this.view,"Usted ya esta programado.\n N° Matricula: " + this.model.univ.getMatricula() );
            else
                form_programacion();//Formulario para programacion
        }
        else if( comando.equals("Ver Programacion"))
        {
            //Comprueba que universitario este programado
            if( this.model.esta_programado( this.model.univ.getCU() ) )
                form_Imprimir();
            else
                JOptionPane.showMessageDialog(this.view,"Lo siento. Usted NO está programado" );
        }
        else if( comando.equals("Acerca de"))
        {
            wtf = new acercade();
            this.view.jCDesktopPane1.add(wtf);
            wtf.setTitle("Acerca de...");                
            //centrado de formulario
            wtf.setLocation(centradoXY(wtf));
            wtf.setVisible(true);
        }

        //..........................................................................................
        /* Acciones formulario login */
        if( comando.equals("Ingresar"))
        {            
            if( this.model.ingresar( this.frmlogin.txtCU.getText() , this.frmlogin.txtCI.getText()) )
            {//si los datos de acceso son correctos
                cerrar(frmlogin);//cierra frmlogin
                //habilita/deshabilita controles segun corresponda
                this.view.cmdIdentificacion.setEnabled(false);
                this.view.cmdExit.setEnabled(true);
                this.view.cmdProgramar.setEnabled(true);
                this.view.cmdImprimir.setEnabled(true);
            }
            else
                JOptionPane.showMessageDialog(this.view,"Error: Los datos son incorrectos");
        }
        else if( comando.equals("Cancelar") )
        {
            cerrar(frmlogin);            
        }
        //..........................................................................................
        /* Acciones de formulario de programacion */
        if( comando.equals("Programar"))
        {
            //Solicita confirmación
            int confirmacion = JOptionPane.showConfirmDialog(this.view,"Revise cuidadosamente las materias que se programa.\n Se procedera a la programación de las materias seleccionadas\n ¿Desea continuar?");
            if (JOptionPane.OK_OPTION == confirmacion)//si presiono OK
            {
                //Se obtiene en un array la lista de asignaturas seleccionadas
                String[] m = this.frmprogramacion.TablaAsignaturas.getFilasSeleccionadas();
                //Se obtiene en un array los grupos seleccionados por asignatura
                String[] g = this.frmprogramacion.TablaAsignaturas.getGruposSeleccionados();
                //Procede a la programacion
                if( this.model.Programar_Asignaturas( m , g ) )
                {
                    JOptionPane.showMessageDialog(this.view,"Programación Finalizada");
                    cerrar(frmprogramacion);//ciera formulario de programacion
                    form_Imprimir();//Muestra vista impresion
                }
                else
                    JOptionPane.showMessageDialog(this.view,"Error: No se pudo completar. Intente nuevamente...");
            }
        }else if( comando.equals("Salir Programacion"))
        {
            cerrar(frmprogramacion);
        }
        //..........................................................................................
        /* Acciones vista impresion */
        if( comando.equals("Ver Reporte"))
        {
            this.model.imprimir();
        }
        else if( comando.equals("Salir Impresion"))
        {
            cerrar(frmimpresion);
        }
        //..........................................................................................
    }
//___________________________________________________________________________________ Soy una barra separadora :)
//METODO QUE DEVUELVE UN VALOR BOOLEAN PARA SABER SI UN JINTERNALFRAME ESTA ABIERTO O NO
private boolean estacerrado(Object obj){
    JInternalFrame[] activos=this.view.jCDesktopPane1.getAllFrames();
    boolean cerrado=true;
    int i=0;
    while (i<activos.length && cerrado){
	if(activos[i]==obj)
            cerrado=false;
	i++;
    }
    return cerrado;
}
//___________________________________________________________________________________ Soy una barra separadora :)
// CIERRA TODOS LOS JInternalFrame QUE ESTEN ABIERTOS
private void cerrar_todo(){
    JInternalFrame[] activos=this.view.jCDesktopPane1.getAllFrames();
    //boolean cerrado=true;
    int i=0;
    while ( i<activos.length ){	
        cerrar(activos[i]);          
	i++;
    }    
}
//___________________________________________________________________________________ Soy una barra separadora :)
// CIERRA UN JInternalFrame
private void cerrar(JInternalFrame jif)
{ 
    try {
        jif.setClosed(true);
    } catch (PropertyVetoException ex) {}
}
//___________________________________________________________________________________ Soy una barra separadora :)
//funcion que dado un JInternalFrame calcula la posicion de centrado respecto a su contenedor, retorna las coordenadas en una variable de tipo POINT
    private Point centradoXY(JInternalFrame jif)
    {
        Point p = new Point(0,0);
        //se obtiene dimension del contenedor
        Dimension pantalla = this.view.jCDesktopPane1.getSize();
        //se obtiene dimension del JInternalFrame
        Dimension ventana = jif.getSize();
        //se calcula posición para el centrado
        p.x = (pantalla.width - ventana.width) / 2;
        p.y = (pantalla.height - ventana.height) / 2;
        return p;
    }
//___________________________________________________________________________________ Soy una barra separadora :)
    private String FechaActual()
    {
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fechaActual);
    }
//___________________________________________________________________________________ Soy una barra separadora :)
/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/    
/*::::::::::::::: FORMULARIOS  ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/    
/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
//___________________________________________________________________________________ Soy una barra separadora :)
/* ABRE EL FORMULARIO PARA IDENTIFICARSE EN EL SISTEMA */
private void form_logueo()
{
    if(estacerrado(frmlogin)){//se crea nuevo
        frmlogin = new login();
        this.view.jCDesktopPane1.add(frmlogin);
        frmlogin.setTitle("Identificate");
        //Se añaden las acciones a los controles
        this.frmlogin.cmdIngresar.setActionCommand("Ingresar");
        this.frmlogin.cmdCancelar.setActionCommand("Cancelar");
        //Se pone a escuchar
        frmlogin.cmdIngresar.addActionListener(this);
        frmlogin.cmdCancelar.addActionListener(this);
        //centrado de formulario
        frmlogin.setLocation(centradoXY(frmlogin));
        frmlogin.setVisible(true);
    }
    else{
        JOptionPane.showMessageDialog(this.view,"La ventana de 'Identificación' ya esta abierta.");
    }
}
//___________________________________________________________________________________ Soy una barra separadora :)
/* FORMULARIO PARA PROGRAMAR MATERIAS */
private void form_programacion()
{
    if(estacerrado(frmprogramacion)){//se crea nuevo
        frmprogramacion = new programacion();
        frmprogramacion.setTitle("Programación de Asignaturas [jc-Mouse]");
        this.view.jCDesktopPane1.add(frmprogramacion);
        //se llenan datos de universitario
        this.frmprogramacion.txtCU.setText( this.model.univ.getCU() );
        this.frmprogramacion.txtCI.setText( this.model.univ.getCI() );
        this.frmprogramacion.txtNombre.setText( this.model.univ.getNombre() );
        this.frmprogramacion.txtFecha.setText( FechaActual() );
        this.frmprogramacion.txtMatricula.setText( "PENDIENTE" );
        //Se llenan datos en la tabla asignaturas
        Object[][] datos = this.model.getAsignaturas();
        if(datos!=null)
        {
            int limite = (datos.length>=10)?10 : datos.length;
            for(int i=0; i<this.frmprogramacion.TablaAsignaturas.getNumFilas();i++)
            {
                if(i<limite)
                {
                    this.frmprogramacion.TablaAsignaturas.getFila(i).setNum(String.valueOf(i+1));
                    this.frmprogramacion.TablaAsignaturas.getFila(i).setSigla(datos[i][0].toString());
                    this.frmprogramacion.TablaAsignaturas.getFila(i).setNombre(datos[i][1].toString());
                    this.frmprogramacion.TablaAsignaturas.getFila(i).setCurso(datos[i][2].toString());
                    this.frmprogramacion.TablaAsignaturas.getFila(i).setTipo(datos[i][3].toString());
                }
                else
                {
                    this.frmprogramacion.TablaAsignaturas.getFila(i).setHabilitar(false);
                    this.frmprogramacion.TablaAsignaturas.getFila(i).setNum("");
                    this.frmprogramacion.TablaAsignaturas.getFila(i).setSigla("");
                    this.frmprogramacion.TablaAsignaturas.getFila(i).setNombre("");
                    this.frmprogramacion.TablaAsignaturas.getFila(i).setCurso("");
                    this.frmprogramacion.TablaAsignaturas.getFila(i).setTipo("");
                }
            }
        }
        //se colocan las acciones y se pone a escuchar
        this.frmprogramacion.cmdProcesar.setActionCommand("Programar");
        this.frmprogramacion.cmdSalirP.setActionCommand("Salir Programacion");
        this.frmprogramacion.cmdProcesar.addActionListener(this);
        this.frmprogramacion.cmdSalirP.addActionListener(this);
        //centrado de formulario
        frmprogramacion.setLocation(centradoXY(frmprogramacion));
        frmprogramacion.setVisible(true);
    }
    else{
        JOptionPane.showMessageDialog(this.view,"La ventana de 'Programación' ya esta abierta.");
    }
}
//___________________________________________________________________________________ Soy una barra separadora :)
/* FORMULARIO PARA VER PROGRAMACION DE MATERIA E IMPRIMIR */
    private void form_Imprimir()
    {
     if(estacerrado(frmimpresion)){//se crea nuevo
        frmimpresion = new programacion();
        frmimpresion.setTitle("Asignaturas Programadas [jc-Mouse]");
        this.view.jCDesktopPane1.add(frmimpresion);
        //se llenan datos de universitario
        this.frmimpresion.txtCU.setText( this.model.univ.getCU() );
        this.frmimpresion.txtCI.setText( this.model.univ.getCI() );
        this.frmimpresion.txtNombre.setText( this.model.univ.getNombre() );
        this.frmimpresion.txtFecha.setText( FechaActual() );
        this.frmimpresion.txtMatricula.setText( this.model.univ.getMatricula() );
        //Se obtiene materias programadas
         Object[][] datos = this.model.getMateriasProgramadas( this.model.univ.getCU() );
         if(datos!=null)
         {
            int limite = (datos.length>=10)?10 : datos.length;
            for(int i=0; i<this.frmimpresion.TablaAsignaturas.getNumFilas();i++)
            {
                if(i<limite)
                {
                    this.frmimpresion.TablaAsignaturas.getFila(i).setNum(String.valueOf(i+1));
                    this.frmimpresion.TablaAsignaturas.getFila(i).setSigla(datos[i][0].toString());
                    this.frmimpresion.TablaAsignaturas.getFila(i).setNombre(datos[i][1].toString());
                    this.frmimpresion.TablaAsignaturas.getFila(i).setCurso(datos[i][2].toString());
                    this.frmimpresion.TablaAsignaturas.getFila(i).setTipo(datos[i][3].toString());
                    this.frmimpresion.TablaAsignaturas.getFila(i).setGrupo(datos[i][4].toString());
                }
                else
                {
                    this.frmimpresion.TablaAsignaturas.getFila(i).setHabilitar(false);
                    this.frmimpresion.TablaAsignaturas.getFila(i).setNum("");
                    this.frmimpresion.TablaAsignaturas.getFila(i).setSigla("");
                    this.frmimpresion.TablaAsignaturas.getFila(i).setNombre("");
                    this.frmimpresion.TablaAsignaturas.getFila(i).setCurso("");
                    this.frmimpresion.TablaAsignaturas.getFila(i).setTipo("");
                }
            }
         }
        //se colocan las acciones y se pone a escuchar
        this.frmimpresion.cmdProcesar.setText("Vista para Impresión");
        this.frmimpresion.cmdProcesar.setActionCommand("Ver Reporte");
        this.frmimpresion.cmdSalirP.setText("Cerrar Ventana");
        this.frmimpresion.cmdSalirP.setActionCommand("Salir Impresion");
        this.frmimpresion.cmdProcesar.addActionListener(this);
        this.frmimpresion.cmdSalirP.addActionListener(this);
        //centrado de formulario
        frmimpresion.setLocation(centradoXY(frmimpresion));
        frmimpresion.setVisible(true);
     }
     else
        JOptionPane.showMessageDialog(this.view,"La ventana de 'Impresion' ya esta abierta");
    }
//___________________________________________________________________________________ Soy una barra separadora :)

}
