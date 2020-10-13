/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial_numero;

/**
 *
 * @author escm1990
 */
public class Tarea {

    private int valor;
    private int factorial;

    public Tarea() {
        valor = 0;
        factorial = 1;
    }

    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * @return the factorial
     */
    public int getFactorial() {
        return factorial;
    }

    /**
     * @param factorial the factorial to set
     */
    public void setFactorial(int factorial) {
        this.factorial = factorial;
    }
    public void chepito(){
        for(int i=1;i<=valor;i++){
            setFactorial(getFactorial()*i);
    }
    System.out.println(getFactorial());
    }

}
