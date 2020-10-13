package beans.baking;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class VacanteForm {
    
    //inyeccion de dependencia
    @Inject
    private Candidato candidato;
    
    public void setCandidato(Candidato candidato){
        this.candidato = candidato;
    }
    
    //redireccionamiento a otra pagina
    public String redirigirNavegacion(){
    String pagina =  "";
        if (this.candidato.getNombre().equals("Juan")) {
            pagina = "exito";
        } else{
            pagina = "fallo";
        }
    return pagina;
    }
}
