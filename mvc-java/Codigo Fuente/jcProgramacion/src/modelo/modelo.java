package modelo;
/**
 * @web http://www.jc-mouse.net/
 * @author Mouse
 */
public class modelo extends database{

    public universitario univ = new universitario();

    public modelo(){}

//___________________________________________________________________________________ Soy una barra separadora :)
/* METODO PARA IDENTIFICARSE EN EL SISTEMA, SI LA IDENTIFICACION TIENE EXITO INSERTA DATOS EN "UNIV"
 * INPUT:
 *      cu = String => Carnet Universitario
 *      ci = String => Carnet de Identidad
 * OUTPUT
 *      boolean
 */
    public boolean ingresar(String cu, String ci)
    {        
        Object[][] res = this.select("universitario", " u_cu , u_ci , u_nombre", " u_cu='"+cu+"' AND u_ci='"+ci+"' ");
        if( res.length > 0)
        {
            univ.setCU( res[0][0].toString() );
            univ.setCI( res[0][1].toString() );
            univ.setNombre( res[0][2].toString() );
            univ.setMatricula( generar_matricula() );//Coloca una matricula al azar
            return true;
        }        
        else
            return false;
    }
//___________________________________________________________________________________ Soy una barra separadora :)
/* METODO PARA OBTENER TODAS LAS ASIGNATURAS
 * OUTPUT:
 *          Matriz[][] con los datos de las asignaturas, si no obtiene datos retorna NULL
 */
    public Object[][] getAsignaturas()
    {
        Object[][] res = this.select("materia", " m_sigla, m_nombre,m_curso, m_tipo", null);
        if( res.length > 0)
            return res;
        else
            return null;
    }
//___________________________________________________________________________________ Soy una barra separadora :)
    /* METODO PARA OBTENER LAS MATERIAS PROGRAMAS
     * INPUT:
     *      cu = String => Carnet Universitario
     * OUTPUT:
     *      Matriz con los datos obtenidos, caso contrario retorna NULL
     */
    public Object[][] getMateriasProgramadas(String cu)
    {
        Object[][] res = this.select(" materia inner join programacion on m_sigla = p_materia ",
                                     " m_sigla, m_nombre, m_curso, m_tipo, p_grupo ",
                                     " p_univ='"+cu+"' ");
        if( res.length > 0)
            return res;
        else
            return null;
    }
//___________________________________________________________________________________ Soy una barra separadora :)
/* METODO PARA PROGRAMAR LAS ASIGNATURAS SELECCIONADAS POR EL ESTUDIANTE
 * INPUT:
 *      Materia: String con las siglas de las materias seleccioandas
 *      Grupos: String con el numero de grupo seleccionado por fila
 * OUTPUT:
 *      BOOLEAN
 */
    public boolean Programar_Asignaturas(String[] Materia , String[] Grupos)
    {
        //Crea nueva Matricula de programacion, GESTION 01/12 = Primer semestre año 2012
        if( this.insert("matricula", " m_id , m_gestion, m_fecha ",
                    " '"+this.univ.getMatricula()+"' , '01/12' , now() ") )
        //Con in ciclo FOR se van insertando las materias seleccionadas a la base de datos
         for( int i=0; i<Materia.length; i++)
         {
            if(Materia[i]!=null)
                this.insert("programacion",
                        " p_matricula, p_univ, p_materia , p_grupo ",
                        " '"+this.univ.getMatricula()+"', '"+this.univ.getCU()+"' , '"+Materia[i]+"', '"+Grupos[i]+"' ");
         }
        return true;
    }
//___________________________________________________________________________________ Soy una barra separadora :)
/* METODO PARA DETERMINA SI UN UNIVERSITARIO YA CUENTA CON PROGRAMACION
 * INPUT:
 *      CU = CARNET UNIVERSITARIO
 * OUTPUT:
 *      boolean
 * Si esta matriculado coloca el numero de matricula en UNIV
 */
    public boolean esta_programado(String cu)
    {
        Object[][] res = this.select("programacion", "p_matricula ", " p_univ='"+cu+"' ");
        if( res.length > 0)
        {
            univ.setMatricula( res[0][0].toString() );
            return true;
        }else return false;
        
    }
//___________________________________________________________________________________ Soy una barra separadora :)
/* METODO PRIVADO PARA GENERAR UN NUMERO DE MATRICUL ALEATORIAMENTE
 * OUTPUT:
 *      String de 9 caracteres
 */
    private String generar_matricula()
    {
        String code="JC-";
        for(int i=1 ; i<=6 ; i++ )
        {
            int num = (int) (Math.random()*9+1);
            code += String.valueOf(num);            
        }
        return code;
    }
//___________________________________________________________________________________ Soy una barra separadora :)
/* METODO QUE MANDA A IMPRIMIR LA PROGRAMACION EN IREPORT
 */
    public void imprimir()
    {        
        new reporte(this.getConnection()).ver_reporte(this.univ.getCU(), this.univ.getCI(), this.univ.getNombre(),this.univ.getMatricula());
    }
//___________________________________________________________________________________ Soy una barra separadora :)

}
