/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.managed.bean;

import com.tesis.controllers.TesisLogJpaController;
import com.tesis.model.entity.TesisLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author luis.chavez
 */
@ManagedBean (name = "audit_administration")
@ViewScoped
public class TesisAdministrationAudit {

    /**
     * Creates a new instance of TesisAdministrationAudit
     */
     private List<TesisLog> logs = new ArrayList<>();
    TesisLogJpaController logImpl = new TesisLogJpaController();
    private Date from;
    private Date to;
    private String user = "";

    public TesisAdministrationAudit() {
    }
    
    public void resetValues() {
        this.user = "";
        this.from = null;
        this.to = null;
    }
  
    @PostConstruct
    public void init() {
        this.setLogs(logImpl.findAllLog());
    }

    /**
     * @return the logs
     */
    public List<TesisLog> getLogs() {
        return logs;
    }

    /**
     * @param logs the logs to set
     */
    public void setLogs(List<TesisLog> logs) {
        this.logs = logs;
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

    public void busqueda() {
        try {
            if (!this.user.isEmpty()) {
                List<TesisLog> listLog = logImpl.findAllLogByCriteriaUser(from, to, user);
                this.logs = listLog;
            } else {
                List<TesisLog> listLog = logImpl.findAllLogByCriteria(from, to);
                this.logs = listLog;
            }
            
            resetValues();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
    
    
     public void verAll() {
        try {
            this.logs = logImpl.findAllLog();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        resetValues();
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }
    
    

}
