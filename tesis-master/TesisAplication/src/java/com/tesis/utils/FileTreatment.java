/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.utils;

import com.tesis.model.entity.TesisSystemDocument;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.Part;

/**
 *
 * @author luis.chavez
 */
public class FileTreatment {
    
    public static TesisSystemDocument fillFile(String path, Part file, String carper) {
        TesisSystemDocument doc = new TesisSystemDocument();
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            if (file.getSize() != 0) {
                String fileName = DocumentUtils.getFileNameFromPart(file);
                String savePath = "resources/document/" + carper + fileName;
                String extension = DocumentUtils.getExtension(savePath);
                doc.setDocumentDescription(fileName);
                doc.setDocumentExtension(extension);
                String path_sistem = savePath.replaceAll("resources/", "").replaceAll(fileName, "");
                doc.setDocumentUri(path_sistem);
                path = path.replace("\\build", "");
                File outputFile = new File(path + File.separator + savePath);
                saveFile(file, outputFile, inputStream, outputStream);
                return doc;
            } else {
                return doc;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return doc;
        }
    }

    public static void saveFile(Part file, File archivo, InputStream input, OutputStream out) {
        try {
            input = file.getInputStream();
            out = new FileOutputStream(archivo);
            byte[] buffer = new byte[Constants.BUFFER_SIZE];
            int bytesRead = 0;
            while ((bytesRead = input.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            input.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
