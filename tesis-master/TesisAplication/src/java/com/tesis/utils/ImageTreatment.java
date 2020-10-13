/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesis.utils;

import com.tesis.model.entity.TesisSystemImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.Part;

/**
 *
 * @author Luis Chávez
 */
public class ImageTreatment {

    public static TesisSystemImage fillImage(String path, Part file, String carper) {
        TesisSystemImage image = new TesisSystemImage();
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            if (file.getSize() != 0) {
                String fileName = ImageUtils.getFileNameFromPart(file);
                String savePath = "resources/avatar/" + carper + fileName;
                String extension = ImageUtils.getExtension(savePath);
                image.setImageDescription(fileName);
                image.setImageExtesion(extension);
                String path_sistem = savePath.replaceAll("resources/", "").replaceAll(fileName, "");
                image.setImageUri(path_sistem);
                path = path.replace("\\build", "");
                File outputFile = new File(path + File.separator + savePath);
                saveImage(file, outputFile, inputStream, outputStream);
                return image;
            } else {
                return image;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return image;
        }
    }

    public static void saveImage(Part file, File archivo, InputStream input, OutputStream out) {
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
