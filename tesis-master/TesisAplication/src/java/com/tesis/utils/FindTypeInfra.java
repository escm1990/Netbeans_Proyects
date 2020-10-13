/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesis.utils;

/**
 *
 * @author luis.chavez
 */
public abstract class FindTypeInfra {

    public static String getType(String select) {
        if (select.equals("1") == true) {
            return "Edificio";
        } else if (select.equals("2") == true) {
            return "Aula";
        } else if (select.equals("3") == true) {
            return "Otro";
        } else {
            return "";
        }

    }

}
