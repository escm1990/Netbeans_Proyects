/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesis.managed.bean;

import com.tesis.utils.FileDownload;
import java.io.File;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luis.chavez
 */
@ManagedBean(name = "client_controller")
@RequestScoped
public class TesisClientController {

    private String asunto = "";
    private String msj = "";
    private String support = "";

    public String getDashBoard() {
        return "index.xhtml";
    }

    public void resetValues() {
        this.asunto = "";
        this.msj = "";
        this.support = "";
    }

    public String getPath() {
        FacesContext context = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        String path = servletContext.getRealPath("");
        return path;
    }

    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * @return the msj
     */
    public String getMsj() {
        return msj;
    }

    /**
     * @param msj the msj to set
     */
    public void setMsj(String msj) {
        this.msj = msj;
    }

    public void enviar_msj() {
        try {
            final String username = "central.contacto.uesfmocc@gmail.com";
            final String password = "72C08446E5";
            String to = "central.contacto.email.ues@gmail.com";
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                message.setSubject(asunto);
                message.setText(msj + " correo de contacto: " + support);

                Transport.send(message);
                resetValues();
                addMessage("Mensaje enviado con éxito!!!");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return the support
     */
    public String getSupport() {
        return support;
    }

    /**
     * @param support the support to set
     */
    public void setSupport(String support) {
        this.support = support;
    }

    public void downloadArchivo() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("/");

            String savePath = "resources/files/ManualUsuario.pdf";
            path = path.replace("\\build", "");
            File file = new File(path + File.separator + savePath);

            String mimeType = servletContext.getMimeType(file.getAbsolutePath());
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }
            FileDownload.write(response, mimeType, file, facesContext);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
