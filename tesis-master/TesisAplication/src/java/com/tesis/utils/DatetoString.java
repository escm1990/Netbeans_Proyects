/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 
 * @author luis.chavez
 */
public abstract class DatetoString {

    public static String getDate(Date fecha) {
        try {
            SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String hoy = Format.format(fecha);
            return hoy;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public static String getDateD(Date fecha) {
        try {  
            SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
            String hoy = Format.format(fecha);
            return hoy;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public static Date getDateZero(String fecha) {
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateInString = fecha + " 00:00:00";
            Date date = sdf.parse(dateInString);
            return date;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return new Date();
        }
        
    }
    
     public static Date getDateFull(String fecha) {
        try {
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateInString = fecha + " 23:59:59";
            Date date = sdf.parse(dateInString);
            return date;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return new Date();
        }
        
    }
}
