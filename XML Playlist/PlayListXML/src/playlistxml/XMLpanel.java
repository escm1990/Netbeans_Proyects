package playlistxml;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class XMLpanel extends javax.swing.JPanel {
    
    Dimension d = new Dimension(470,500);
    
    //constructor al cual se le pasa la direccion del archivo XML
    public XMLpanel(String pl){    
        int i=0;
        //añadimos un layout
        this.setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));               
        try {
         // Creamos el builder SAX
         SAXBuilder builder = new SAXBuilder();         
         Document doc = builder.build(new FileInputStream(pl));
          // Obtenemos la etiqueta raíz
         Element raiz = doc.getRootElement();                  
         List <Element> hijosRaiz = raiz.getChildren();                
         //recorremos todos los hijos de la raiz
         for(Element hijo: hijosRaiz){ 
             //creamos un nuevo objeto SONG
             this.add(new song());         
             //añadimos propiedades
             ((song)this.getComponent(i)).setTitulo(hijo.getChild("titulo").getValue());
             ((song)this.getComponent(i)).setArtista(hijo.getChild("artista").getValue());
             ((song)this.getComponent(i)).setAlbum(hijo.getChild("album").getValue());
             ((song)this.getComponent(i)).setLocation(hijo.getChild("location").getValue());             
             ((song)this.getComponent(i)).setPreview(hijo.getChild("artLocation").getValue());                                          
             i++;             
         }//fin hijos               
        }catch (JDOMException ex) {
            Logger.getLogger(XMLpanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLpanel.class.getName()).log(Level.SEVERE, null, ex);
        }         
        //asignamos tamaño al panel deacuerdo 
        d = new Dimension(410,(100*(i)));          
        this.setSize(d);        
        this.repaint();      
    }
    
  //sirve para obtener cual es el archivo mo3 seleccionado del playlist  
  public String getSongSelecionado(){
      String File="";
      for(int i=0; i<this.getComponentCount();i++){            
            if(((song)this.getComponent(i)).getSeleccion()){
                File = ((song)this.getComponent(i)).getLoaction();                      
                break;
            }            
        }
    return File;
  }
    
}
