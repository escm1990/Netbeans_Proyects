/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.managed.bean;

import com.tesis.controllers.TesisAuditJpaController;
import com.tesis.model.entity.TesisAudit;
import com.tesis.utils.DatetoString;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.PieChartModel;



/**
 *
 * @author luis.chavez
 */
@ManagedBean (name = "pieChart")
@RequestScoped
public class TesisPieChart implements Serializable{

    /**
     * Creates a new instance of TesisPieChart
     */
    TesisAuditJpaController auditImp = new TesisAuditJpaController();
    
    private Date from;
    private Date to;
    
     private PieChartModel pieModel;

    public TesisPieChart() {
    }

    public String calChartPie() {
        try {
            int inf = 0;
            int offer = 0;
            int cul = 0;
            int pla = 0;
            int ma = 0;
            
            List<TesisAudit> listInfra = auditImp.findAllAuditByCriteria(from, to, "Infraestructura","visita");
            if(listInfra.isEmpty() == false) {
               inf = listInfra.size();
            }
            
            List<TesisAudit> listOffer = auditImp.findAllAuditByCriteria(from, to, "Oferta","visita");
            if(listOffer.isEmpty() == false) {
               offer = listOffer.size();
            }
            
            List<TesisAudit> listCul = auditImp.findAllAuditByCriteria(from, to, "Cultura","visita");
            if(listCul.isEmpty() == false) {
               cul = listCul.size();
            }
            
            List<TesisAudit> listPlan = auditImp.findAllAuditByCriteria(from, to, "Planes","visita");
            if (listPlan.isEmpty() == false) {
                pla = listPlan.size();
            }
            
              
            List<TesisAudit> listMa = auditImp.findAllAuditByCriteria(from, to, "Maestrias","visita");
            if (listMa.isEmpty() == false) {
                ma = listMa.size();
            }
            
             createPieModel(inf,offer,cul,pla,ma,from,to);
             return "pie_chart_detail";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "pie_chart_detail";
        }
    }

    /**
     * @return the from
     */
    public Date getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(Date from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public Date getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(Date to) {
        this.to = to;
    }

    /**
     * @return the pieModel
     */
    public PieChartModel getPieModel() {
        return pieModel;
    }

    /**
     * @param pieModel the pieModel to set
     */
    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    private void createPieModel(int infra, int offer, int cul, int plan, int mas, Date from, Date to) {
        pieModel = new PieChartModel();
         
        pieModel.set("Infraestructura", infra);
        pieModel.set("Oferta Académica", offer);
        pieModel.set("Eventos Culturales", cul);
        pieModel.set("Planes de Estudio", plan);
        pieModel.set("Maestrías", mas);
         
        pieModel.setTitle("Consulta de visitas realizadas al sistema del: " + DatetoString.getDate(from) + " hasta: "+DatetoString.getDate(to));
        pieModel.setLegendPosition("w");
        pieModel.setShowDataLabels(true);
    }
     
   

}
