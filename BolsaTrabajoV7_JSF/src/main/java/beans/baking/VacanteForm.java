package beans.baking;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
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
    
    private boolean comentarioEnviado;
    
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
    
    //validaciones con cambios
    public void codigoPostalListener(ValueChangeEvent  valueChangeEvent){
        FacesContext facesContext =  FacesContext.getCurrentInstance();
        UIViewRoot uIViewRoot = facesContext.getViewRoot(); //acceder a los elementos de la vista JSF
        String nuevoCodigoPostal = (String) valueChangeEvent.getNewValue();
        if(nuevoCodigoPostal.equals("03810")){
            
            //trabajando con un selectItem
            UIInput coloniaIdSelect = (UIInput) uIViewRoot.findComponent("vacanteForm:coloniaId");
            int coloniaId = 1;
            coloniaIdSelect.setValue(coloniaId);
            coloniaIdSelect.setSubmittedValue(coloniaId);
            
            //recuperando un componente de la vista por ID
            UIInput ciudadInputText = (UIInput) uIViewRoot.findComponent("vacanteForm:ciudad");
            //haciendo cambio en un componente desde Java a la Vista
            String nuevaCiudad = "Ciudad de Mexico";
            ciudadInputText.setValue(nuevaCiudad);
            ciudadInputText.setSubmittedValue(nuevaCiudad);
            
            facesContext.renderResponse(); //enviando la respuesta a la vista
        }
    }
    
    public boolean isComentarioEnviado() {
        return comentarioEnviado;
    }

    public void setComentarioEnviado(boolean comentarioEnviado) {
        this.comentarioEnviado = comentarioEnviado;
    }
    
    public void ocultarComentario(ActionEvent actionEvent){
        this.comentarioEnviado = !this.comentarioEnviado;
    }
}
