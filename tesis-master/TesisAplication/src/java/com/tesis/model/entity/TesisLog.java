/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author luis.chavez
 */
@Entity
@Table(name = "tesis_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TesisLog.findAll", query = "SELECT t FROM TesisLog t"),
    @NamedQuery(name = "TesisLog.findByCodTesisLog", query = "SELECT t FROM TesisLog t WHERE t.codTesisLog = :codTesisLog"),
    @NamedQuery(name = "TesisLog.findByCreatedBy", query = "SELECT t FROM TesisLog t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "TesisLog.findByCreatedDate", query = "SELECT t FROM TesisLog t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "TesisLog.findByIdLog", query = "SELECT t FROM TesisLog t WHERE t.idLog = :idLog"),
    @NamedQuery(name = "TesisLog.findByLogDescription", query = "SELECT t FROM TesisLog t WHERE t.logDescription = :logDescription")})
public class TesisLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tesis_log")
    private Integer codTesisLog;
    @Size(max = 255)
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 255)
    @Column(name = "id_log")
    private String idLog;
    @Size(max = 255)
    @Column(name = "log_description")
    private String logDescription;

    public TesisLog() {
    }

    public TesisLog(Integer codTesisLog) {
        this.codTesisLog = codTesisLog;
    }

    public Integer getCodTesisLog() {
        return codTesisLog;
    }

    public void setCodTesisLog(Integer codTesisLog) {
        this.codTesisLog = codTesisLog;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getIdLog() {
        return idLog;
    }

    public void setIdLog(String idLog) {
        this.idLog = idLog;
    }

    public String getLogDescription() {
        return logDescription;
    }

    public void setLogDescription(String logDescription) {
        this.logDescription = logDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTesisLog != null ? codTesisLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TesisLog)) {
            return false;
        }
        TesisLog other = (TesisLog) object;
        if ((this.codTesisLog == null && other.codTesisLog != null) || (this.codTesisLog != null && !this.codTesisLog.equals(other.codTesisLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tesis.model.entity.TesisLog[ codTesisLog=" + codTesisLog + " ]";
    }

}
