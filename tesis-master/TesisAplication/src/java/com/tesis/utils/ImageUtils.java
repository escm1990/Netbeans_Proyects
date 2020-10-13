/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.utils;

import javax.servlet.http.Part;

/**
 *
 * @author Luis Chávez
 */
public class ImageUtils {
    
    public static String getFileNameFromPart(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                String fileName = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
                String name = PasswordGenerator.getPassword(20);
                String ext = getExtension(fileName);
                name = name + "." + ext;
                return name;
            }
        }
        return null;
    }
    
    public static String getExtension(String filename) {
        int index = filename.lastIndexOf('.');
        if (index == -1) {
            return "";
        } else {
            return filename.substring(index + 1);
        }
    }
}
