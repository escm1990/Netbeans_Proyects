/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package buscardispositivos;

import javax.media.*;
import javax.media.cdm.CaptureDeviceManager;

/**
 *
 * @author USUARIO
 */
public class Buscar_Dispositivos {

    public Buscar_Dispositivos(){}

    public void Escaner(){
        //se recorre la cantidad de Dispositivos que encuentra disponibles
        for(int i=0; i<CaptureDeviceManager.getDeviceList().size();i++){
            //se muestra uno por uno en pantalla
           System.out.println( ( (CaptureDeviceInfo) CaptureDeviceManager.getDeviceList().get(i) ).getName() );
        }
    }
}
