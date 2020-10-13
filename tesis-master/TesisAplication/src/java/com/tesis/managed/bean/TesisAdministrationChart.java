/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.managed.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author luis.chavez
 */
@ManagedBean (name = "charts")
@RequestScoped
public class TesisAdministrationChart {

    /**

     */
    public TesisAdministrationChart() {
    }
    
    public String getchartViewAdministration() {
        return "chart_administration";
    }
    
    public String getchartViewPie() {
        return "pie_chart";
    }

    public String getchartViewBar() {
        return "bar_chart";
    }
  
    public String getchartViewDownloads() {
        return "download_chart";
    }

    public String getchartViewPensum() {
        return "pensum_chart";
    }

    public String getchartViewLine() {
        return "line_chart";
    }

  
    
    
}
