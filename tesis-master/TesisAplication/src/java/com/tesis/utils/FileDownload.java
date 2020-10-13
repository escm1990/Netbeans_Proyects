/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesis.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luis.chavez
 */
public abstract class FileDownload {

    public static void write(HttpServletResponse response, String mime, File file, FacesContext fc) {
        try {
            response.setContentType(mime);
            response.setContentLength((int) file.length());
            String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
            response.setHeader("Content-Disposition", headerValue);
            OutputStream outStream = response.getOutputStream();
            fc.responseComplete();
            byte[] buffer = new byte[(int) file.length()];
            int bytesRead = -1;
            FileInputStream fos = new FileInputStream(file);
            while ((bytesRead = fos.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
            fos.close();
            outStream.flush();
            outStream.close();
            response.flushBuffer();

        } catch (Exception ed) {
            System.out.println(ed.getMessage());
        }
    }
}
