/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesis.utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;
/**
 *
 * @author luis.chavez
 */
@FacesValidator("FileUploadValidator")
public class FileUploadValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        Part part = (Part) o;

        if (part != null) {
            String fileName = ImageUtils.getFileNameFromPart(part);
            if (fileName.length() == 0) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: Archivo es inválido !!", null);
                throw new ValidatorException(message);
            } else if (fileName.length() > 100) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: Archivo es demasiado grande !!", null);
                throw new ValidatorException(message);
            }

            if (!"image/png".equals(part.getContentType()) && !"image/jpeg".equals(part.getContentType()) && !"image/gif".equals(part.getContentType()) && !"image/x-ms-bmp".equals(part.getContentType())) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: archivo es inválido !!", null);
                throw new ValidatorException(message);
            }

            if (part.getSize() > 1024000) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: Imagen es demasiado grande, tamaño máximo para imagen es 1 mb !!", null);
                throw new ValidatorException(message);
            }
        }


     
    }

}
