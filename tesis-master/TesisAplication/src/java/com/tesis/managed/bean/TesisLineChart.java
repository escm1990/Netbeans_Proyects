/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.managed.bean;

import com.tesis.controllers.TesisAuditJpaController;
import com.tesis.model.entity.TesisAudit;
import com.tesis.utils.DatetoString;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author luis.chavez
 */
@ManagedBean (name = "lineChart")
@RequestScoped
public class TesisLineChart {

    /**
     * Creates a new instance of TesisLineChart
     */
    TesisAuditJpaController auditImp = new TesisAuditJpaController();

    private Date from;
    private Date to;
    
    private LineChartModel dateModel;
    

    public TesisLineChart() {
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

    public String calChartLine() {
        try {
            List<TesisAudit> listInfra = auditImp.findAllAuditByCriteria(from, to, "Infraestructura","visita");
            List<TesisAudit> listOffer = auditImp.findAllAuditByCriteria(from, to, "Oferta","visita");
            List<TesisAudit> listCul = auditImp.findAllAuditByCriteria(from, to, "Cultura","visita");
            List<TesisAudit> listPlan = auditImp.findAllAuditByCriteria(from, to, "Planes","visita");
            List<TesisAudit> listMa = auditImp.findAllAuditByCriteria(from, to, "Maestrias","visita");
           createDateModel(listInfra,listOffer,listCul,listPlan,listMa);
            return "line_chart_detail";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "line_chart_detail";
        }
    }

    /**
     * @return the dateModel
     */
    public LineChartModel getDateModel() {
        return dateModel;
    }

    /**
     * @param dateModel the dateModel to set
     */
    public void setDateModel(LineChartModel dateModel) {
        this.dateModel = dateModel;
    }

    private void createDateModel(List<TesisAudit> listin,List<TesisAudit> listOf,List<TesisAudit> listCu,List<TesisAudit> listPla,List<TesisAudit> listMa) {
        dateModel = new LineChartModel();
        
        if (!listin.isEmpty()) {
            LineChartSeries series1 = new LineChartSeries();
            series1.setLabel("Infraestructura");
            
            String temp = "";
            int c = 0;
            for (TesisAudit item : listin) {
                String fecha = DatetoString.getDateD(item.getVisitDate());
                if (fecha.equals(temp)) {
                    c = c + 1;
                } else {
                    if (c == 0) {
                        c = c +1;
                    } else {
                       series1.set(temp, c);
                       c = 1;
                    }
                }             
                temp = fecha;               
            }
            
            if (c != 0) {
                 series1.set(temp, c); 
            } 

            dateModel.addSeries(series1);
        }
        
         if (!listOf.isEmpty()) {
            LineChartSeries series1 = new LineChartSeries();
            series1.setLabel("Oferta Académica");
            
            String temp = "";
            int c = 0;
            for (TesisAudit item : listOf) {
                String fecha = DatetoString.getDateD(item.getVisitDate());
                if (fecha.equals(temp)) {
                    c = c + 1;
                } else {
                    if (c == 0) {
                        c = c +1;
                    } else {
                       series1.set(temp, c);
                       c = 1;
                    }
                }             
                temp = fecha;               
            }
            
            if (c != 0) {
                 series1.set(temp, c); 
            } 

            dateModel.addSeries(series1);
        }

        if (!listCu.isEmpty()) {
            LineChartSeries series1 = new LineChartSeries();
            series1.setLabel("Eventos Culturales");

            String temp = "";
            int c = 0;
            for (TesisAudit item : listCu) {
                String fecha = DatetoString.getDateD(item.getVisitDate());
                if (fecha.equals(temp)) {
                    c = c + 1;
                } else {
                    if (c == 0) {
                        c = c + 1;
                    } else {
                        series1.set(temp, c);
                        c = 1;
                    }
                }
                temp = fecha;
            }

            if (c != 0) {
                series1.set(temp, c);
            }

            dateModel.addSeries(series1);
        }
        
        if (!listPla.isEmpty()) {
            LineChartSeries series1 = new LineChartSeries();
            series1.setLabel("Planes de Estudio");

            String temp = "";
            int c = 0;
            for (TesisAudit item : listPla) {
                String fecha = DatetoString.getDateD(item.getVisitDate());
                if (fecha.equals(temp)) {
                    c = c + 1;
                } else {
                    if (c == 0) {
                        c = c + 1;
                    } else {
                        series1.set(temp, c);
                        c = 1;
                    }
                }
                temp = fecha;
            }

            if (c != 0) {
                series1.set(temp, c);
            }

            dateModel.addSeries(series1);
        }
        
        if (!listMa.isEmpty()) {
            LineChartSeries series1 = new LineChartSeries();
            series1.setLabel("Maestrías");

            String temp = "";
            int c = 0;
            for (TesisAudit item : listMa) {
                String fecha = DatetoString.getDateD(item.getVisitDate());
                if (fecha.equals(temp)) {
                    c = c + 1;
                } else {
                    if (c == 0) {
                        c = c + 1;
                    } else {
                        series1.set(temp, c);
                        c = 1;
                    }
                }
                temp = fecha;
            }

            if (c != 0) {
                series1.set(temp, c);
            }

            dateModel.addSeries(series1);
        }

        dateModel.setTitle("Consulta de visitas realizadas al sistema del: " +DatetoString.getDate(from) + " al: " + DatetoString.getDate(to));
        dateModel.setLegendPosition("e");
        dateModel.setShowPointLabels(true);
        dateModel.getAxis(AxisType.Y).setLabel("Valor");
        DateAxis axis = new DateAxis("Fecha");
        axis.setTickAngle(-50);
        axis.setTickFormat("%b %#d, %y");
        dateModel.getAxes().put(AxisType.X, axis);
    }

}
