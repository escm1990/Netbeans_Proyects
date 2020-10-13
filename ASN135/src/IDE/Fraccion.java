/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package IDE;

/**
 *
 * @author ESCM
 */
public class Fraccion {
    private long num;
    private long den;

    public Fraccion()
    {
        num=0;
        den=1;
    }

    public Fraccion(long numerador,long denominador){
        this.num=numerador;
        if(denominador==0)
            throw new ArithmeticException("/ denominador = zero");
        this.den=denominador;
    }

    public void setNumerador(long numerador){
        this.num=numerador;
    }

    public long getNumerador(){
        return num;
    }

    public void setDenominador(long denominador){
        if(denominador==0)
            throw new ArithmeticException("/ denominador = zero");
        this.den=denominador;
    }

    public long getDenominador(){
        return den;
    }

    public static Fraccion sumar(Fraccion a,Fraccion b){
        Fraccion respuesta=new Fraccion();
        respuesta.setDenominador(a.getDenominador()*b.getDenominador());
        respuesta.setNumerador(a.getNumerador()*b.getDenominador()+ b.getNumerador()*a.getDenominador());
        respuesta=Fraccion.simplificar(respuesta);
        return respuesta;
    }

    public static Fraccion restar(Fraccion a,Fraccion b){
        Fraccion respuesta=new Fraccion();
        respuesta.setDenominador(a.getDenominador()*b.getDenominador());
        respuesta.setNumerador(a.getNumerador()*b.getDenominador()- b.getNumerador()*a.getDenominador());
        respuesta=Fraccion.simplificar(respuesta);
        return respuesta;
    }

    public static Fraccion multiplicar(Fraccion a,Fraccion b){
        Fraccion r=new Fraccion(a.getNumerador()*b.getNumerador(), a.getDenominador()*b.getDenominador());
        r=Fraccion.simplificar(r);
        return r;
    }

    public static Fraccion dividir(Fraccion a,Fraccion b){
        Fraccion r=new Fraccion(a.getNumerador()*b.getDenominador(), a.getDenominador()*b.getNumerador());
        return Fraccion.simplificar(r);
    }
    public static Fraccion getInversa(Fraccion a){
        return new Fraccion(a.getDenominador(),a.getNumerador());
    }

    public static Fraccion simplificar(Fraccion b){
        int divisor=2;
        Fraccion a=new Fraccion(b.getNumerador(),b.getDenominador());
        while(divisor<=Math.abs(a.getDenominador())&&divisor<=Math.abs(a.getNumerador()))
        {
            while(a.getDenominador()%divisor==0&&a.getNumerador()%divisor==0)
            {
                a.setDenominador(a.getDenominador()/divisor);
                a.setNumerador(a.getNumerador()/divisor);
            }

            if(divisor==2){
                divisor++;
            }
            else {
                divisor=divisor+2;
            }

        }
        if(a.getNumerador()==0)
            a.setDenominador(1);
        if(Long.signum(a.getDenominador())==Long.signum(a.getNumerador())){
            a.setDenominador(Math.abs(a.getDenominador()));
            a.setNumerador(Math.abs(a.getNumerador()));
        }
        if(Long.signum(a.getDenominador())==-1&&Long.signum(a.getNumerador())==1){
            a.setDenominador(a.getDenominador()*-1);
            a.setNumerador(a.getNumerador()*-1);
        }
        return a;
    }

    public static Fraccion parseFraccion(String texto){
        String[] n=texto.split("/");
        return Fraccion.simplificar(new Fraccion(Long.parseLong(n[0]),Long.parseLong(n[1])));
    }

    public static Fraccion parseFraccion(long numero){
        return new Fraccion(numero,1);
    }

    @Override
    public String toString(){
        return ""+num+"/"+den;
    }

    @Override
    public Fraccion clone(){
        return new Fraccion(this.num, this.den);
    }

    public boolean equals(Fraccion f){
        return f.getDenominador()==this.getDenominador()&&this.getNumerador()==f.getNumerador();
    }
}