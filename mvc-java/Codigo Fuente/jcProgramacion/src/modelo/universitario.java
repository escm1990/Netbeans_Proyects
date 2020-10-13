package modelo;
/**
 * @web http://www.jc-mouse.net/
 * @author Mouse
 */
public class universitario {

    private String CU;
    private String CI;
    private String nombre;
    private String matricula;

    public universitario(){}

    public void setMatricula(String m)
    {
        this.matricula=m;
    }
    public String getMatricula()
    {
        return this.matricula;
    }

    public void setCU(String cu)
    {
        this.CU=cu;
    }
    public String getCU()
    {
        return this.CU;
    }

    public void setCI(String ci)
    {
        this.CI=ci;
    }
    public String getCI()
    {
        return this.CI;
    }

    public void setNombre(String n)
    {
        this.nombre=n;
    }
    public String getNombre()
    {
        return this.nombre;
    }
}
