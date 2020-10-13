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
@Table(name = "tesis_masters")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TesisMasters.findAll", query = "SELECT t FROM TesisMasters t"),
    @NamedQuery(name = "TesisMasters.findByCodTesisMasters", query = "SELECT t FROM TesisMasters t WHERE t.codTesisMasters = :codTesisMasters"),
    @NamedQuery(name = "TesisMasters.findByApproved", query = "SELECT t FROM TesisMasters t WHERE t.approved = :approved"),
    @NamedQuery(name = "TesisMasters.findByCreatedBy", query = "SELECT t FROM TesisMasters t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "TesisMasters.findByCreatedDate", query = "SELECT t FROM TesisMasters t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "TesisMasters.findByMaestriaDescripcion", query = "SELECT t FROM TesisMasters t WHERE t.maestriaDescripcion = :maestriaDescripcion"),
    @NamedQuery(name = "TesisMasters.findByMaestriaName", query = "SELECT t FROM TesisMasters t WHERE t.maestriaName = :maestriaName"),
    @NamedQuery(name = "TesisMasters.findByStudyPlan", query = "SELECT t FROM TesisMasters t WHERE t.studyPlan = :studyPlan"),
    @NamedQuery(name = "TesisMasters.findByUpdateBy", query = "SELECT t FROM TesisMasters t WHERE t.updateBy = :updateBy"),
    @NamedQuery(name = "TesisMasters.findByUpdateDate", query = "SELECT t FROM TesisMasters t WHERE t.updateDate = :updateDate")})
public class TesisMasters implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tesis_masters")
    private Integer codTesisMasters;
    @Size(max = 500)
    @Column(name = "approved")
    private String approved;
    @Size(max = 255)
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 2000)
    @Column(name = "maestria_descripcion")
    private String maestriaDescripcion;
    @Size(max = 500)
    @Column(name = "maestria_name")
    private String maestriaName;
    @Size(max = 500)
    @Column(name = "study_plan")
    private String studyPlan;
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

    public TesisMasters() {
    }

    public TesisMasters(Integer codTesisMasters) {
        this.codTesisMasters = codTesisMasters;
    }

    public Integer getCodTesisMasters() {
        return codTesisMasters;
    }

    public void setCodTesisMasters(Integer codTesisMasters) {
        this.codTesisMasters = codTesisMasters;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
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

    public String getMaestriaDescripcion() {
        return maestriaDescripcion;
    }

    public void setMaestriaDescripcion(String maestriaDescripcion) {
        this.maestriaDescripcion = maestriaDescripcion;
    }

    public String getMaestriaName() {
        return maestriaName;
    }

    public void setMaestriaName(String maestriaName) {
        this.maestriaName = maestriaName;
    }

    public String getStudyPlan() {
        return studyPlan;
    }

    public void setStudyPlan(String studyPlan) {
        this.studyPlan = studyPlan;
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
        hash += (codTesisMasters != null ? codTesisMasters.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TesisMasters)) {
            return false;
        }
        TesisMasters other = (TesisMasters) object;
        if ((this.codTesisMasters == null && other.codTesisMasters != null) || (this.codTesisMasters != null && !this.codTesisMasters.equals(other.codTesisMasters))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tesis.model.entity.TesisMasters[ codTesisMasters=" + codTesisMasters + " ]";
    }

}
