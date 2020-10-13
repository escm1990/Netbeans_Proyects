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
@Table(name = "tesis_offer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TesisOffer.findAll", query = "SELECT t FROM TesisOffer t"),
    @NamedQuery(name = "TesisOffer.findByCodTesisOffer", query = "SELECT t FROM TesisOffer t WHERE t.codTesisOffer = :codTesisOffer"),
    @NamedQuery(name = "TesisOffer.findByCreatedBy", query = "SELECT t FROM TesisOffer t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "TesisOffer.findByCreatedDate", query = "SELECT t FROM TesisOffer t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "TesisOffer.findByOfferArea", query = "SELECT t FROM TesisOffer t WHERE t.offerArea = :offerArea"),
    @NamedQuery(name = "TesisOffer.findByOfferCycles", query = "SELECT t FROM TesisOffer t WHERE t.offerCycles = :offerCycles"),
    @NamedQuery(name = "TesisOffer.findByOfferDescription", query = "SELECT t FROM TesisOffer t WHERE t.offerDescription = :offerDescription"),
    @NamedQuery(name = "TesisOffer.findByOfferMode", query = "SELECT t FROM TesisOffer t WHERE t.offerMode = :offerMode"),
    @NamedQuery(name = "TesisOffer.findByOfferName", query = "SELECT t FROM TesisOffer t WHERE t.offerName = :offerName"),
    @NamedQuery(name = "TesisOffer.findByOfferRequirement", query = "SELECT t FROM TesisOffer t WHERE t.offerRequirement = :offerRequirement"),
    @NamedQuery(name = "TesisOffer.findByOfferStudyPlan", query = "SELECT t FROM TesisOffer t WHERE t.offerStudyPlan = :offerStudyPlan"),
    @NamedQuery(name = "TesisOffer.findByUpdateBy", query = "SELECT t FROM TesisOffer t WHERE t.updateBy = :updateBy"),
    @NamedQuery(name = "TesisOffer.findByUpdateDate", query = "SELECT t FROM TesisOffer t WHERE t.updateDate = :updateDate")})
public class TesisOffer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tesis_offer")
    private Integer codTesisOffer;
    @Size(max = 255)
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 255)
    @Column(name = "offer_area")
    private String offerArea;
    @Size(max = 255)
    @Column(name = "offer_cycles")
    private String offerCycles;
    @Size(max = 255)
    @Column(name = "offer_description")
    private String offerDescription;
    @Size(max = 255)
    @Column(name = "offer_mode")
    private String offerMode;
    @Size(max = 255)
    @Column(name = "offer_name")
    private String offerName;
    @Size(max = 255)
    @Column(name = "offer_requirement")
    private String offerRequirement;
    @Size(max = 255)
    @Column(name = "offer_study_plan")
    private String offerStudyPlan;
    @Size(max = 255)
    @Column(name = "update_by")
    private String updateBy;
    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "fk_tesis_system_image", referencedColumnName = "cod_tesis_system_images")
    @ManyToOne
    private TesisSystemImage fkTesisSystemImage;
    @JoinColumn(name = "fk_tesis_system_document", referencedColumnName = "cod_tesis_system_document")
    @ManyToOne
    private TesisSystemDocument fkTesisSystemDocument;
    @JoinColumn(name = "fk_tesis_campus", referencedColumnName = "cod_tesis_campus")
    @ManyToOne
    private TesisCampus fkTesisCampus;

    public TesisOffer() {
    }

    public TesisOffer(Integer codTesisOffer) {
        this.codTesisOffer = codTesisOffer;
    }

    public Integer getCodTesisOffer() {
        return codTesisOffer;
    }

    public void setCodTesisOffer(Integer codTesisOffer) {
        this.codTesisOffer = codTesisOffer;
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

    public String getOfferArea() {
        return offerArea;
    }

    public void setOfferArea(String offerArea) {
        this.offerArea = offerArea;
    }

    public String getOfferCycles() {
        return offerCycles;
    }

    public void setOfferCycles(String offerCycles) {
        this.offerCycles = offerCycles;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    public String getOfferMode() {
        return offerMode;
    }

    public void setOfferMode(String offerMode) {
        this.offerMode = offerMode;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getOfferRequirement() {
        return offerRequirement;
    }

    public void setOfferRequirement(String offerRequirement) {
        this.offerRequirement = offerRequirement;
    }

    public String getOfferStudyPlan() {
        return offerStudyPlan;
    }

    public void setOfferStudyPlan(String offerStudyPlan) {
        this.offerStudyPlan = offerStudyPlan;
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

    public TesisSystemImage getFkTesisSystemImage() {
        return fkTesisSystemImage;
    }

    public void setFkTesisSystemImage(TesisSystemImage fkTesisSystemImage) {
        this.fkTesisSystemImage = fkTesisSystemImage;
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
        hash += (codTesisOffer != null ? codTesisOffer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TesisOffer)) {
            return false;
        }
        TesisOffer other = (TesisOffer) object;
        if ((this.codTesisOffer == null && other.codTesisOffer != null) || (this.codTesisOffer != null && !this.codTesisOffer.equals(other.codTesisOffer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tesis.model.entity.TesisOffer[ codTesisOffer=" + codTesisOffer + " ]";
    }

}
