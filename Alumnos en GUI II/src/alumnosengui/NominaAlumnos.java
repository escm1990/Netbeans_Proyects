package alumnosengui;

public class NominaAlumnos {

//----------------------------
//    VARIABLES DE CONDICION
//----------------------------
    private Alumno alumnos[];
    private int reprobados;
    private int aprobados;
//----------------------------
//    CONSTRUCTOR
//----------------------------
    public NominaAlumnos()
    {
        alumnos=new Alumno[0];
        aprobados=0;
        reprobados=0;
    }
//----------------------------
//    METODOS
//----------------------------
    public void agregar(String car, String nom, String ape,  double par1,
            double par2, double par3, double par4, double par5)
    {
        Alumno temp[]=alumnos.clone();
        alumnos=new Alumno[temp.length+1];
        System.arraycopy(temp, 0, alumnos, 0, temp.length);
        alumnos[alumnos.length-1]=new Alumno(car, nom, ape,par1, par2,  par3,  par4, par5);
        if (alumnos[alumnos.length-1].CalcularPromedio()>=6)
        {
            aprobados++;
        }
        else
        {
            reprobados++;
        }

    }

//------------------------------------------------------------------------------
    public Alumno obtener(int indice)
    {
        return alumnos[indice];
    }
//------------------------------------------------------------------------------
    public void modificar(int indice, String car, String nom,String ape, double par1,
            double par2, double par3, double par4, double par5)
    {
        if (alumnos[indice].CalcularPromedio()>=6)
        {
            aprobados--;
        }
        else
        {
            reprobados--;
        }
        alumnos[indice]=new Alumno(car, nom, ape,par1, par2,  par3,  par4, par5);
        if (alumnos[indice].CalcularPromedio()>=6)
        {
            aprobados++;
        }
        else
        {
            reprobados++;
        }
    }
//------------------------------------------------------------------------------
    public void eliminar(int indice)
    {
        if (alumnos[indice].CalcularPromedio()>=6)
        {
            aprobados--;
        }
        else
        {
            reprobados--;
        }
        Alumno temp[]=alumnos.clone();
        alumnos=new Alumno[temp.length-1];
        for (int i=0;i<alumnos.length;i++)
        {
            if(i<indice)
            {
                alumnos[i]=temp[i];
            }
            else 
            {
                alumnos[i]=temp[i+1];
            }
        }
        

    }
//------------------------------------------------------------------------------
    public int cantidadAlumnos()
    {
        return alumnos.length;
    }
//------------------------------------------------------------------------------
    public int obtenerAprobados()
    {
        return aprobados;
    }
//------------------------------------------------------------------------------
    public int obtenerReprobados()
    {
        return reprobados;
    }
}
