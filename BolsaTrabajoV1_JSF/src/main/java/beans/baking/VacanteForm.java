package beans.baking;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
public class VacanteForm {
    
    //inyeccion de dependencia
    @Inject
    private Candidato candidato;

    Logger log = LogManager.getRootLogger();
    
    public VacanteForm() {
        log.info("Creando objeto VacanteForm");
    }
    
    public void setCandidato(Candidato candidato){
        this.candidato = candidato;
    }
    
    //redireccionamiento a otra pagina
    public String redirigirNavegacion(){
    String pagina =  "";
        if (this.candidato.getNombre().equals("Juan")) {
            if(this.candidato.getApellido().equals("Perez")){
                String msg = "Gracias, pero Juan Perez ya trabaja con nosotros";
                //AGREGAR UN MENSAJE EN JSF
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String componentID = null;//este es un mensaje global, no hace referencia a un componente global
                facesContext.addMessage(componentID, facesMessage);
                pagina="index";
            }
            pagina = "exito";
        } else{
            pagina = "fallo";
        }
    return pagina;
    }
}
