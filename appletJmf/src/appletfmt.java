/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;

/**
 *
 * @author USUARIO
 */

import java.awt.*;
import java.awt.event.*;
import javax.media.*;
import javax.media.control.*;
import java.net.*;
import java.io.*;
import javax.media.rtp.*;
import javax.media.protocol.ContentDescriptor;
import javax.media.format.AudioFormat;
import javax.media.format.VideoFormat;


/**
 * <p>Título: Título: Reproduccion de contenidos multimedia a través de JMF</p>
 * <p>Copyright: Copyright (c) 2003 Universidad de Málaga</p>
 * @author Manuel Vegas Santiago (mvs@ieee.org)
 * @version 0.0 (1-DIC-2003)
 */

public class ProcesamientoJMF implements ControllerListener{


  /////////////////////////////////////////////////////////////////////////////
  //DECLARACION DE PROPIEDADES Y VARIABLES////////////////////////////////////

  //UI será una instancia de una clase que implemente el interfaz IFProcesamientoJMFUI
  //de manera que ProcesamientoJMF pueda acceder a los métodos que especifica la IF
  //private IFProcesamientoJMFUI UI = null;
  /*PRUEBAS*/ private AppletProcesadorUI UI = null;


  //Opciones de procesamiento//

  //FIN Opciones de procesamiento//

  //Objeto instancia del procesador de JMF
  private Processor processor = null;

  //Variables de estado
  //Variables que indican si se ha alcanzado cada uno de los estados del procesador
  private boolean esperandoDescriptorSalida;
  private boolean configurado;
  private boolean realizado;
  //Variables booleanas usadas para sincronización de hilos concurrentes
  private boolean establecidoDescriptorSalida;
  //FIN variables de estado

  //Componentes y controles
  //Control para cada una de las pistas ("tracks") demultiplexadas
  private TrackControl[] controlPista = null;
  //Descriptores de contenido soportados
  private ContentDescriptor[] descriptoresSoportados = null;
  private Control[] controles = null;
  private BitRateControl controlTasaBits = null;
  private FrameRateControl controlTasaCuadros = null;
  private QualityControl controlCalidad = null;
  private KeyFrameControl controlCuadrosClave = null;
  private PacketSizeControl controlTamPaquete = null;

  private Component componenteControl = null;
  private Component componenteVisual = null;
  private Component componenteBarraProgreso = null;
  private RTPControl controlRTP = null;
  private CachingControl controlCache = null;
  //FIN Componentes y controles

  //Incorporamos un temporizador para mostrar información extra en la UI cada
  //cierto intervalo de tiempo, le asociamos una "tareaPeriodica"
  //private Timer temporizador = null;

  //FIN Temporizador
  //FIN DECLARACIÓN DE PROPIEDADES Y VARIABLES/////////////////////////////////


  public ProcesamientoJMF(AppletProcesadorUI UI) {
    this.UI = UI;
    this.esperandoDescriptorSalida = false;
    this.establecidoDescriptorSalida = false;
    this.configurado = false;
    this.realizado = false;
  }


  public boolean abrirContenidoMM(String cadenaContenidoMM) {
    boolean exito = true;
    try {
      //Se crea URL para la cadena
      URL url = null;
      url = new URL(cadenaContenidoMM);
      if (url == null) {
        System.err.println("No se puede construir URL para el archivo");
        UI.setTextoEstado("No se puede construir URL para el archivo", this);
      }
      //Se crea el procesador JMF para la URL
      if (processor != null) {
        processor.stop();
        processor.deallocate();
      }
      processor = Manager.createProcessor(url);
      processor.addControllerListener(this);
      processor.configure();
    }
    //Se tratan las posibles excepciones
    catch (MalformedURLException e) {
      System.err.println("URL no valida");
      UI.setTextoEstado("URL no valida",this);
      exito = false;
    }
    catch (IOException e) {
      System.err.println("Excepcion de Lectura/Escritura");
      UI.setTextoEstado("Excepcion de Lectura/Escritura",this);
      exito = false;
    }
    catch (NoPlayerException e) {
      System.err.println("No existe reproductor");
      UI.setTextoEstado("No existe reproductor",this);
      exito = false;
    }
    return exito;
  }


  public boolean setDescriptorSalida(ContentDescriptor descriptorFormato) {
    boolean exito;
    if (esperandoDescriptorSalida) {
      exito = true;
      controlPista = processor.getTrackControls();
      for (int i = 0; i < controlPista.length; i++) {
        Format[] formatosPista = controlPista[i].getSupportedFormats();
        for (int j = 0; j < formatosPista.length; j++) {
          addFormato(formatosPista[j]);
        }
        UI.addFormatosAudioSoportados(formatosAudio);
        UI.addFormatosVideoSoportados(formatosVideo);
      }
      configurado = true;
      /*PRUEBA*/pantalla("Configurado");
    }
    else {
      exito = false;
      UI.setTextoEstado(
          "Error: El procesador no había alcanzado el estado esperando", this);
    }
    return exito;
  }


  private void addFormato(Format formato){
    if (formato instanceof AudioFormat) {
      //Comunicar formatos a UI. Ej:addFormatoSoportadoAudio
      /*PRUEBA*/pantalla("Audio" + formatosPista[j].toString());
    }
    else if (formato instanceof VideoFormat) {
      //Comunicar formatos a UI.
      /*PRUEBA*/pantalla("Video" + formatosPista[j].toString());
    }
  }


  public boolean setFormatoAudio(AudioFormat formato){
    boolean exito = false;
    if (configurado) {
      //Recorremos el array que controla las pistas y tratamos de establecer
      //en la adecuada el formato de audio deseado
      for (int i = 0; i < controlPista.length; i++) {
        try {
          controlPista[i].setFormat(formato);
          exito = true;
          controlPista[i].setEnabled(true);
        } catch(Exception e) {
        }
      }
    }
    return exito;
  }


  public boolean setFormatoVideo(VideoFormat formato) {
    boolean exito = false;
    if (configurado) {
      //Recorremos el array que controla las pistas y tratamos de establecer
      //en la adecuada el formato de video deseado
      for (int i = 0; i < controlPista.length; i++) {
        try {
          controlPista[i].setFormat(formato);
          exito = true;
          controlPista[i].setEnabled(true);
        } catch(Exception e) {
        }
      }
    }
    return exito;
  }


  public boolean realizar() {
    boolean exito = false;
    if (configurado) {
      processor.realize();
      exito = true;
    }
    return exito;
  }


  public boolean procesar() {
    boolean exito = false;
    if (processor != null && realizado){
      processor.start();
      exito = true;
    } else {
      UI.setTextoEstado("Error: El procesador no había alcanzado el estado realizado",this);
    }
    return exito;
  }


  public boolean detener() {
    boolean exito = false;
    if (processor != null) {
      processor.stop();
      exito = true;
    }
    return exito;
  }


  /**
       * @todo Eliminar todos los componentes visuales que se hayan añadido a la UI!
   */
  public boolean destruir() {
    boolean exito = false;
    if (processor != null) {
      processor.deallocate();
      exito = true;
    }
    return exito;
  }


  public synchronized void controllerUpdate(ControllerEvent event) {
    //Comprobamos que el reproductor está "vivo"
    if (processor == null) {
      return;
    }
    //Qué evento se ha producido?
    //Si se alcanza el estado configurado
    if (event instanceof ConfigureCompleteEvent) {
      //Obtenemos los descriptores de salida soportados por el procesador
      descriptoresSoportados = processor.getSupportedContentDescriptors();
      //Los añadimos a la interfaz gráfica
      UI.addDescriptoresSalidaSoportados(descriptoresSoportados);
      esperandoDescriptorSalida = true;
    }
    //Si se alcanza el estado realizado
    else if (event instanceof RealizeCompleteEvent) {
      //Obtenemos los controles disponibles para el procesador
      controles = processor.getControls();
      //Extraemos los controles que permitan especificar la calidad de la
      //salida del procesador
      for (int i = 0; i < controles.length; i++) {
        if (controles[i] instanceof BitRateControl) {
          controlTasaBits = (BitRateControl) controles[i];
          /*PRUEBA*/pantalla("BitRateControl" + controlTasaBits.toString());
        }
        else if (controles[i] instanceof QualityControl) {
          controlCalidad = (QualityControl) controles[i];
          /*PRUEBA*/pantalla("QualityControl" + controlCalidad.toString());
        }
        else if (controles[i] instanceof KeyFrameControl) {
          controlCuadrosClave = (KeyFrameControl) controles[i];
          /*PRUEBA*/pantalla("KeyFrameControl" + controlCuadrosClave.toString());
        }
        else if (controles[i] instanceof PacketSizeControl) {
          controlTamPaquete = (PacketSizeControl) controles[i];
          /*PRUEBA*/pantalla("PacketSizeControl" + controlTamPaquete.toString());
        }
      }
    realizado = true;
    /*PRUEBA*/pantalla("Realizado");
    }
  }
  private void pantalla(String cadena){
    System.out.println(cadena);
  }
}
    // TODO overwrite start(), stop() and destroy() methods

