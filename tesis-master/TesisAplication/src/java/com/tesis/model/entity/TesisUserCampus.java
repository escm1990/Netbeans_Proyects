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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tesis_user_campus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TesisUserCampus.findAll", query = "SELECT t FROM TesisUserCampus t"),
    @NamedQuery(name = "TesisUserCampus.findByCodTesisUserCampus", query = "SELECT t FROM TesisUserCampus t WHERE t.codTesisUserCampus = :codTesisUserCampus"),
    @NamedQuery(name = "TesisUserCampus.findByCreatedBy", query = "SELECT t FROM TesisUserCampus t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "TesisUserCampus.findByCreatedDate", query = "SELECT t FROM TesisUserCampus t WHERE t.createdDate = :createdDate")})
public class TesisUserCampus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tesis_user_campus")
    private Integer codTesisUserCampus;
    @Size(max = 255)
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "fk_tesis_user", referencedColumnName = "cod_tesis_user")
    @ManyToOne
    private TesisUser fkTesisUser;
    @JoinColumn(name = "fk_tesis_campus", referencedColumnName = "cod_tesis_campus")
    @ManyToOne
    private TesisCampus fkTesisCampus;

    public TesisUserCampus() {
    }

    public TesisUserCampus(Integer codTesisUserCampus) {
        this.codTesisUserCampus = codTesisUserCampus;
    }

    public Integer getCodTesisUserCampus() {
        return codTesisUserCampus;
    }

    public void setCodTesisUserCampus(Integer codTesisUserCampus) {
        this.codTesisUserCampus = codTesisUserCampus;
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

    public TesisUser getFkTesisUser() {
        return fkTesisUser;
    }

    public void setFkTesisUser(TesisUser fkTesisUser) {
        this.fkTesisUser = fkTesisUser;
    }

    public TesisCampus getFkTesisCampus() {
        return fkTesisCampus;
    }

    public void setFkTesisCampus(TesisCampus fkTesisCampus) {
        this.fkTesisCampus = fkTesisCampus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTesisUserCampus != null ? codTesisUserCampus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TesisUserCampus)) {
            return false;
        }
        TesisUserCampus other = (TesisUserCampus) object;
        if ((this.codTesisUserCampus == null && other.codTesisUserCampus != null) || (this.codTesisUserCampus != null && !this.codTesisUserCampus.equals(other.codTesisUserCampus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tesis.model.entity.TesisUserCampus[ codTesisUserCampus=" + codTesisUserCampus + " ]";
    }

}
