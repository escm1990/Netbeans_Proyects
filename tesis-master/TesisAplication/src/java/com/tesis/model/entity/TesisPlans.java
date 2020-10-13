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
@Table(name = "tesis_plans")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TesisPlans.findAll", query = "SELECT t FROM TesisPlans t"),
    @NamedQuery(name = "TesisPlans.findByCodTesisPlans", query = "SELECT t FROM TesisPlans t WHERE t.codTesisPlans = :codTesisPlans"),
    @NamedQuery(name = "TesisPlans.findByCreatedBy", query = "SELECT t FROM TesisPlans t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "TesisPlans.findByCreatedDate", query = "SELECT t FROM TesisPlans t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "TesisPlans.findByPlanDescription", query = "SELECT t FROM TesisPlans t WHERE t.planDescription = :planDescription"),
    @NamedQuery(name = "TesisPlans.findByPlanName", query = "SELECT t FROM TesisPlans t WHERE t.planName = :planName"),
    @NamedQuery(name = "TesisPlans.findByUpdateBy", query = "SELECT t FROM TesisPlans t WHERE t.updateBy = :updateBy"),
    @NamedQuery(name = "TesisPlans.findByUpdateDate", query = "SELECT t FROM TesisPlans t WHERE t.updateDate = :updateDate")})
public class TesisPlans implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tesis_plans")
    private Integer codTesisPlans;
    @Size(max = 255)
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 2000)
    @Column(name = "plan_description")
    private String planDescription;
    @Size(max = 500)
    @Column(name = "plan_name")
    private String planName;
    @Size(max = 255)
    @Column(name = "update_by")
    private String updateBy;
    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "fk_tesis_system_images", referencedColumnName = "cod_tesis_system_images")
    @ManyToOne
    private TesisSystemImage fkTesisSystemImages;
    @JoinColumn(name = "fk_tesis_system_document", referencedColumnName = "cod_tesis_system_document")
    @ManyToOne
    private TesisSystemDocument fkTesisSystemDocument;
    @JoinColumn(name = "fk_tesis_campus", referencedColumnName = "cod_tesis_campus")
    @ManyToOne
    private TesisCampus fkTesisCampus;

    public TesisPlans() {
    }

    public TesisPlans(Integer codTesisPlans) {
        this.codTesisPlans = codTesisPlans;
    }

    public Integer getCodTesisPlans() {
        return codTesisPlans;
    }

    public void setCodTesisPlans(Integer codTesisPlans) {
        this.codTesisPlans = codTesisPlans;
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

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public TesisSystemImage getFkTesisSystemImages() {
        return fkTesisSystemImages;
    }

    public void setFkTesisSystemImages(TesisSystemImage fkTesisSystemImages) {
        this.fkTesisSystemImages = fkTesisSystemImages;
    }

    public TesisSystemDocument getFkTesisSystemDocument() {
        return fkTesisSystemDocument;
    }

    public void setFkTesisSystemDocument(TesisSystemDocument fkTesisSystemDocument) {
        this.fkTesisSystemDocument = fkTesisSystemDocument;
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
        hash += (codTesisPlans != null ? codTesisPlans.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TesisPlans)) {
            return false;
        }
        TesisPlans other = (TesisPlans) object;
        if ((this.codTesisPlans == null && other.codTesisPlans != null) || (this.codTesisPlans != null && !this.codTesisPlans.equals(other.codTesisPlans))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tesis.model.entity.TesisPlans[ codTesisPlans=" + codTesisPlans + " ]";
    }

}
