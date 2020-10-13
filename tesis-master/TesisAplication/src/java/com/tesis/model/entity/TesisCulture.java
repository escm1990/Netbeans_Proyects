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
@Table(name = "tesis_culture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TesisCulture.findAll", query = "SELECT t FROM TesisCulture t"),
    @NamedQuery(name = "TesisCulture.findByCodTesisCulture", query = "SELECT t FROM TesisCulture t WHERE t.codTesisCulture = :codTesisCulture"),
    @NamedQuery(name = "TesisCulture.findByCreatedBy", query = "SELECT t FROM TesisCulture t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "TesisCulture.findByCreatedDate", query = "SELECT t FROM TesisCulture t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "TesisCulture.findByCultureDescription", query = "SELECT t FROM TesisCulture t WHERE t.cultureDescription = :cultureDescription"),
    @NamedQuery(name = "TesisCulture.findByCultureName", query = "SELECT t FROM TesisCulture t WHERE t.cultureName = :cultureName"),
    @NamedQuery(name = "TesisCulture.findByUpdateBy", query = "SELECT t FROM TesisCulture t WHERE t.updateBy = :updateBy"),
    @NamedQuery(name = "TesisCulture.findByUpdateDate", query = "SELECT t FROM TesisCulture t WHERE t.updateDate = :updateDate")})
public class TesisCulture implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tesis_culture")
    private Integer codTesisCulture;
    @Size(max = 255)
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 5000)
    @Column(name = "culture_description")
    private String cultureDescription;
    @Size(max = 500)
    @Column(name = "culture_name")
    private String cultureName;
    @Size(max = 255)
    @Column(name = "update_by")
    private String updateBy;
    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "fk_system_images", referencedColumnName = "cod_tesis_system_images")
    @ManyToOne
    private TesisSystemImage fkSystemImages;
    @JoinColumn(name = "fk_system_document", referencedColumnName = "cod_tesis_system_document")
    @ManyToOne
    private TesisSystemDocument fkSystemDocument;
    @JoinColumn(name = "fk_tesis_campus", referencedColumnName = "cod_tesis_campus")
    @ManyToOne
    private TesisCampus fkTesisCampus;

    public TesisCulture() {
    }

    public TesisCulture(Integer codTesisCulture) {
        this.codTesisCulture = codTesisCulture;
    }

    public Integer getCodTesisCulture() {
        return codTesisCulture;
    }

    public void setCodTesisCulture(Integer codTesisCulture) {
        this.codTesisCulture = codTesisCulture;
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

    public String getCultureDescription() {
        return cultureDescription;
    }

    public void setCultureDescription(String cultureDescription) {
        this.cultureDescription = cultureDescription;
    }

    public String getCultureName() {
        return cultureName;
    }

    public void setCultureName(String cultureName) {
        this.cultureName = cultureName;
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

    public TesisSystemImage getFkSystemImages() {
        return fkSystemImages;
    }

    public void setFkSystemImages(TesisSystemImage fkSystemImages) {
        this.fkSystemImages = fkSystemImages;
    }

    public TesisSystemDocument getFkSystemDocument() {
        return fkSystemDocument;
    }

    public void setFkSystemDocument(TesisSystemDocument fkSystemDocument) {
        this.fkSystemDocument = fkSystemDocument;
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
        hash += (codTesisCulture != null ? codTesisCulture.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TesisCulture)) {
            return false;
        }
        TesisCulture other = (TesisCulture) object;
        if ((this.codTesisCulture == null && other.codTesisCulture != null) || (this.codTesisCulture != null && !this.codTesisCulture.equals(other.codTesisCulture))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tesis.model.entity.TesisCulture[ codTesisCulture=" + codTesisCulture + " ]";
    }

}
