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
@ManagedBean (name = "pensum_chart")
@SessionScoped
public class TesisAdministrationPensumChart {

    /**
     * Creates a new instance of TesisAdministrationPensumChart
     */
    public TesisAdministrationPensumChart() {
   
    }
    
     TesisAuditJpaController auditImp = new TesisAuditJpaController();

    private Date from;
    private Date to;
    private List<chartInformation> list = new ArrayList<chartInformation>();
    
    private BarChartModel barModel;
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
            
            List<TesisAudit> listMedicina = auditImp.findAllAuditByCriteria(from, to, "Oferta","Departamento de Medicina");
            chartInformation med = new chartInformation("Departamento de Medicina", String.valueOf(listMedicina.size()));
            this.list.add(med);
         
            List<TesisAudit> listJuri = auditImp.findAllAuditByCriteria(from, to, "Oferta", "Departamento de Ciencias Jurídicas");
            chartInformation jur = new chartInformation("Departamento de Ciencias Jurídicas", String.valueOf(listJuri.size()));
            this.list.add(jur);

            List<TesisAudit> listFilo = auditImp.findAllAuditByCriteria(from, to, "Oferta", "Departamento de Ciencias Sociales, Filosofia y Letras");
            chartInformation filo = new chartInformation("Departamento de Ciencias Sociales, Filosofia y Letras", String.valueOf(listFilo.size()));
            this.list.add(filo);

            List<TesisAudit> listId = auditImp.findAllAuditByCriteria(from, to, "Oferta", "Departamento de Idiomas");
            chartInformation Id = new chartInformation("Departamento de Idiomas", String.valueOf(listId.size()));
            this.list.add(Id);
            
            List<TesisAudit> listIng = auditImp.findAllAuditByCriteria(from, to, "Oferta", "Departamento de Ingeniería");
            chartInformation Ing = new chartInformation("Departamento de Ingeniería", String.valueOf(listIng.size()));
            this.list.add(Ing);
            
            List<TesisAudit> listEco = auditImp.findAllAuditByCriteria(from, to, "Oferta", "Departamento de Ciencias Económicas");
            chartInformation eco = new chartInformation("Departamento de Ciencias Económicas", String.valueOf(listEco.size()));
            this.list.add(eco);
            
            List<TesisAudit> listQui = auditImp.findAllAuditByCriteria(from, to, "Oferta", "Departamento de Química");
            chartInformation qui = new chartInformation("Departamento de Química", String.valueOf(listQui.size()));
            this.list.add(qui);
           
            List<TesisAudit> listBio = auditImp.findAllAuditByCriteria(from, to, "Oferta", "Departamento de Biología");
            chartInformation bio = new chartInformation("Departamento de Biología", String.valueOf(listBio.size()));
            this.list.add(bio);
            
            List<TesisAudit> listFi = auditImp.findAllAuditByCriteria(from, to, "Oferta", "Departamento de Fisica");
            chartInformation fi = new chartInformation("Departamento de Fisica", String.valueOf(listFi.size()));
            this.list.add(fi);
            
            List<TesisAudit> listMat = auditImp.findAllAuditByCriteria(from, to, "Oferta", "Departamento de Matemática");
            chartInformation ma = new chartInformation("Departamento de Matemática", String.valueOf(listMat.size()));
            this.list.add(ma);

            createBarModel(listMedicina,listJuri,listFilo,listId,listIng,listEco,listQui,listBio,listFi,listMat,from,to);
            this.from = null;
            this.to = null;
             return "pensum_chart_detail";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "pensum_chart_detail";
        }
    }
        
        
    private BarChartModel initBarModel(List<TesisAudit> med,List<TesisAudit> jur,List<TesisAudit> filo,List<TesisAudit> idio,List<TesisAudit> ing,List<TesisAudit> eco,List<TesisAudit> qui,List<TesisAudit> bio,List<TesisAudit> fis,List<TesisAudit> mat) {
        
        int me;
        int ju;
        int fi;
        int id;
        int ig;
        int ec;
        int qu;
        int bi;
        int fisi;
        int ma;
   
        BarChartModel model = new BarChartModel();

        ChartSeries medicina = new ChartSeries();
        if (med.isEmpty() == false) {
            medicina.setLabel("Medicina");
            me = med.size();
            medicina.set("Serie", me);
            model.addSeries(medicina);
        }

        ChartSeries juridica = new ChartSeries();
        if (jur.isEmpty() == false) {
            juridica.setLabel("Ciencias Jurídicas");
            ju = jur.size();
            juridica.set("Serie", ju);
            model.addSeries(juridica);
        }
      
        ChartSeries filos = new ChartSeries();
        if (filo.isEmpty() == false) {
            filos.setLabel("Filosofía, Letras");
            fi = filo.size();
            filos.set("Serie", fi);
            model.addSeries(filos);
        }

        ChartSeries idiom = new ChartSeries();
        if (idio.isEmpty() == false) {
            idiom.setLabel("Idiomas");
            id = idio.size();
            idiom.set("Serie", id);
            model.addSeries(idiom);
        }

        ChartSeries inge = new ChartSeries();
        if (ing.isEmpty() == false) {
            inge.setLabel("Ingeniería");
            ig = ing.size();
            inge.set("Serie", ig);
            model.addSeries(inge);
        }
   
        ChartSeries economia = new ChartSeries();
        if (eco.isEmpty() == false) {
            economia.setLabel("Economía");
            ec = eco.size();
            economia.set("Serie", ec);
            model.addSeries(economia);
        }

        ChartSeries quimica = new ChartSeries();
        if (qui.isEmpty() == false) {
            quimica.setLabel("Química");
            qu = qui.size();
            quimica.set("Serie", qu);
            model.addSeries(quimica);
        }
      
        ChartSeries biologia = new ChartSeries();
        if (bio.isEmpty() == false) {
            biologia.setLabel("Biología");
            bi = bio.size();
            biologia.set("Serie", bi);
            model.addSeries(biologia);
        }

        ChartSeries fisica = new ChartSeries();
        if (fis.isEmpty() == false) {
            fisica.setLabel("Fisica");
            fisi = fis.size();
            fisica.set("Serie", fisi);
            model.addSeries(fisica);
        }

        ChartSeries matema = new ChartSeries();
        if (mat.isEmpty() == false) {
            matema.setLabel("Ingeniería");
            ma = mat.size();
            matema.set("Serie", ma);
            model.addSeries(matema);
        }
        
        return model;
    }

    private void createBarModel(List<TesisAudit> med,List<TesisAudit> jur,List<TesisAudit> filo,List<TesisAudit> idio,List<TesisAudit> ing,List<TesisAudit> eco,List<TesisAudit> qui,List<TesisAudit> bio,List<TesisAudit> fis,List<TesisAudit> mat, Date from, Date to) {
        barModel = initBarModel(med,jur,filo,idio,ing,eco,qui,bio,fis,mat);

        barModel.setTitle("Pensum descargados por departamento del: "+ DatetoString.getDateD(from) + " Hasta: " + DatetoString.getDateD(to));
        barModel.setLegendPosition("ne");

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Departamentos");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Descargas");
        yAxis.setMin(0);
        yAxis.setMax(getMaxValue(med,jur,filo,idio,ing,eco,qui,bio,fis,mat));
    }
    
    
    public int getMaxValue(List<TesisAudit> med,List<TesisAudit> jur,List<TesisAudit> filo,List<TesisAudit> idio,List<TesisAudit> ing,List<TesisAudit> eco,List<TesisAudit> qui,List<TesisAudit> bio,List<TesisAudit> fis,List<TesisAudit> mat) {
        int val = 0;
      
        int me = med.size();
        int ju = jur.size();
        int fi = filo.size();
        int id = idio.size();
        int ig = ing.size();
        int ec = eco.size();
        int qu = qui.size();
        int bi = bio.size();
        int fisi = fis.size();
        int ma = mat.size();
        
        try {
            int[] arreglo = new int[10]; 
            arreglo[0] = me;
            arreglo[1] = ju;
            arreglo[2] = fi;
            arreglo[3] = id;
            arreglo[4] = ig;
            arreglo[5] = ec;
            arreglo[6] = qu;
            arreglo[7] = bi;
            arreglo[8] = fisi;
            arreglo[9] = ma;

            for (int i = 0; i < 10; i++) {
                if (val < arreglo[i]) {
                    val = arreglo[i];
                }
            }
            val = val + 10;
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
