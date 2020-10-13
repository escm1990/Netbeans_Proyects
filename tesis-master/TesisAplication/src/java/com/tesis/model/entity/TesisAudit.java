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
@Table(name = "tesis_audit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TesisAudit.findAll", query = "SELECT t FROM TesisAudit t"),
    @NamedQuery(name = "TesisAudit.findByCodTesisAudit", query = "SELECT t FROM TesisAudit t WHERE t.codTesisAudit = :codTesisAudit"),
    @NamedQuery(name = "TesisAudit.findByDescription", query = "SELECT t FROM TesisAudit t WHERE t.description = :description"),
    @NamedQuery(name = "TesisAudit.findByModule", query = "SELECT t FROM TesisAudit t WHERE t.module = :module"),
    @NamedQuery(name = "TesisAudit.findByVisitDate", query = "SELECT t FROM TesisAudit t WHERE t.visitDate = :visitDate")})
public class TesisAudit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tesis_audit")
    private Integer codTesisAudit;
    @Size(max = 1000)
    @Column(name = "description")
    private String description;
    @Size(max = 1000)
    @Column(name = "module")
    private String module;
    @Column(name = "visit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date visitDate;

    public TesisAudit() {
    }

    public TesisAudit(Integer codTesisAudit) {
        this.codTesisAudit = codTesisAudit;
    }

    public Integer getCodTesisAudit() {
        return codTesisAudit;
    }

    public void setCodTesisAudit(Integer codTesisAudit) {
        this.codTesisAudit = codTesisAudit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTesisAudit != null ? codTesisAudit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TesisAudit)) {
            return false;
        }
        TesisAudit other = (TesisAudit) object;
        if ((this.codTesisAudit == null && other.codTesisAudit != null) || (this.codTesisAudit != null && !this.codTesisAudit.equals(other.codTesisAudit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tesis.model.entity.TesisAudit[ codTesisAudit=" + codTesisAudit + " ]";
    }

}
