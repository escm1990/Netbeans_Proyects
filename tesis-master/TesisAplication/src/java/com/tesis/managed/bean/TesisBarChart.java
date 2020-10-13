/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.managed.bean;

import com.tesis.controllers.TesisAuditJpaController;
import com.tesis.model.chartInformation;
import com.tesis.model.entity.TesisAudit;
import com.tesis.utils.DatetoString;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author luis.chavez
 */
@ManagedBean (name = "barChart")
@SessionScoped
public class TesisBarChart {

    /**
     * Creates a new instance of TesisBarChart
     */
    TesisAuditJpaController auditImp = new TesisAuditJpaController();

    private Date from;
    private Date to;
    private List<chartInformation> list = new ArrayList<chartInformation>();
    
    private BarChartModel barModel;

    public TesisBarChart() {
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
     * @return the barModel
     */
    public BarChartModel getBarModel() {
        return barModel;
    }

    /**
     * @param barModel the barModel to set
     */
    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }
    
    public String calChartBar() {
        try {

            this.list = new ArrayList<chartInformation>();
            List<TesisAudit> listInfra = auditImp.findAllAuditByCriteria(from, to, "Infraestructura","visita");
            chartInformation infra = new chartInformation("Infraestructura", String.valueOf(listInfra.size()));
            this.list.add(infra);
            List<TesisAudit> listOffer = auditImp.findAllAuditByCriteria(from, to, "Oferta","visita");
            chartInformation oferta = new chartInformation("Oferta Académica", String.valueOf(listOffer.size()));
            this.list.add(oferta);
            List<TesisAudit> listCul = auditImp.findAllAuditByCriteria(from, to, "Cultura","visita");
            chartInformation cultura = new chartInformation("Eventos Culturales", String.valueOf(listCul.size()));
            this.list.add(cultura);
            List<TesisAudit> listPlan = auditImp.findAllAuditByCriteria(from, to, "Planes","visita");
            chartInformation plan = new chartInformation("Planes de Estudio", String.valueOf(listPlan.size()));
            this.list.add(plan);
            List<TesisAudit> listMa = auditImp.findAllAuditByCriteria(from, to, "Maestrias","visita");
            chartInformation maestria = new chartInformation("Maestrías", String.valueOf(listMa.size()));
            this.list.add(maestria);
            
            createBarModel(listInfra,listOffer,listCul,listPlan,listMa,from,to);
            this.from = null;
            this.to = null;
             return "bar_chart_detail";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "bar_chart_detail";
        }
    }
        
        
    private BarChartModel initBarModel(List<TesisAudit> listin,List<TesisAudit> listOf,List<TesisAudit> listCu,List<TesisAudit> listPla,List<TesisAudit> listMa) {
        
        int inf;
        int offer;
        int cul;
        int pla;
        int ma;
   
        BarChartModel model = new BarChartModel();

        ChartSeries infra = new ChartSeries();
        if (listin.isEmpty() == false) {
            infra.setLabel("Infraestructura");
            inf = listin.size();
            infra.set("Serie", inf);
            model.addSeries(infra);
        }

        ChartSeries of = new ChartSeries();
        if (listOf.isEmpty() == false) {
            of.setLabel("Oferta Académica");
            offer = listOf.size();
            of.set("Serie", offer);
            model.addSeries(of);
        }
      
        ChartSeries cultu = new ChartSeries();
        if (listCu.isEmpty() == false) {
            cultu.setLabel("Evento Cultural");
            cul = listCu.size();
            cultu.set("Serie", cul);
            model.addSeries(cultu);
        }

        ChartSeries planes = new ChartSeries();
        if (listPla.isEmpty() == false) {
            planes.setLabel("Planes de Estudio");
            pla = listPla.size();
            planes.set("Serie", pla);
            model.addSeries(planes);
        }

        ChartSeries master = new ChartSeries();
        if (listMa.isEmpty() == false) {
            master.setLabel("Maestrías");
            ma = listMa.size();
            master.set("Serie", ma);
            model.addSeries(master);
        }
        return model;
    }

    private void createBarModel(List<TesisAudit> listin,List<TesisAudit> listOf,List<TesisAudit> listCu,List<TesisAudit> listPla,List<TesisAudit> listMa, Date from, Date to) {
        barModel = initBarModel(listin,listOf,listCu,listPla,listMa);

        barModel.setTitle("Visitas realizadas al sistema del: "+ DatetoString.getDateD(from) + " Hasta: " + DatetoString.getDateD(to));
        barModel.setLegendPosition("ne");

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Módulos");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Visitas");
        yAxis.setMin(0);
        yAxis.setMax(getMaxValue(listin, listOf, listCu, listPla, listMa));
    }
    
    
    public int getMaxValue(List<TesisAudit> listin,List<TesisAudit> listOf,List<TesisAudit> listCu,List<TesisAudit> listPla,List<TesisAudit> listMa) {
        int val = 0;
      
        int inf = listin.size();
        int offer = listOf.size();
        int cul = listCu.size();
        int pla = listPla.size();
        int ma = listMa.size();
        
        try {
            int[] arreglo = new int[5]; 
            arreglo[0] = inf;
            arreglo[1] = offer;
            arreglo[2] = cul;
            arreglo[3] = pla;
            arreglo[4] = ma;

            for (int i = 0; i < 5; i++) {
                if (val < arreglo[i]) {
                    val = arreglo[i];
                }
            }
            val = val + 5;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return val;
    }

    /**
     * @return the list
     */
    public List<chartInformation> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<chartInformation> list) {
        this.list = list;
    }
    
    
    
}
