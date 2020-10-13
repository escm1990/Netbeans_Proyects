/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 
 * @author luis.chavez
 */
@Entity
@Table(name = "tesis_campus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TesisCampus.findAll", query = "SELECT t FROM TesisCampus t"),
    @NamedQuery(name = "TesisCampus.findByCodTesisCampus", query = "SELECT t FROM TesisCampus t WHERE t.codTesisCampus = :codTesisCampus"),
    @NamedQuery(name = "TesisCampus.findByCampusDescription", query = "SELECT t FROM TesisCampus t WHERE t.campusDescription = :campusDescription"),
    @NamedQuery(name = "TesisCampus.findByCampusName", query = "SELECT t FROM TesisCampus t WHERE t.campusName = :campusName"),
    @NamedQuery(name = "TesisCampus.findByCampusTel", query = "SELECT t FROM TesisCampus t WHERE t.campusTel = :campusTel"),
    @NamedQuery(name = "TesisCampus.findByCreatedBy", query = "SELECT t FROM TesisCampus t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "TesisCampus.findByCreatedDate", query = "SELECT t FROM TesisCampus t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "TesisCampus.findByUpdateBy", query = "SELECT t FROM TesisCampus t WHERE t.updateBy = :updateBy"),
    @NamedQuery(name = "TesisCampus.findByUpdateDate", query = "SELECT t FROM TesisCampus t WHERE t.updateDate = :updateDate")})
public class TesisCampus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tesis_campus")
    private Integer codTesisCampus;
    @Size(max = 1000)
    @Column(name = "campus_description")
    private String campusDescription;
    @Size(max = 1000)
    @Column(name = "campus_name")
    private String campusName;
    @Size(max = 255)
    @Column(name = "campus_tel")
    private String campusTel;
    @Size(max = 255)
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 255)
    @Column(name = "update_by")
    private String updateBy;
    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @OneToMany(mappedBy = "fkTesisCampus")
    private Collection<TesisMasters> tesisMastersCollection;
    @OneToMany(mappedBy = "fkTesisCampus")
    private Collection<TesisOffer> tesisOfferCollection;
    @OneToMany(mappedBy = "fkTesisCampus")
    private Collection<TesisPlans> tesisPlansCollection;
    @OneToMany(mappedBy = "fkTesisCampus")
    private Collection<TesisUserCampus> tesisUserCampusCollection;
    @OneToMany(mappedBy = "fkTesisCampus")
    private Collection<TesisCulture> tesisCultureCollection;
    @OneToMany(mappedBy = "fkTesisCampus")
    private Collection<TesisInfrastructure> tesisInfrastructureCollection;

    public TesisCampus() {
    }

    public TesisCampus(Integer codTesisCampus) {
        this.codTesisCampus = codTesisCampus;
    }

    public Integer getCodTesisCampus() {
        return codTesisCampus;
    }

    public void setCodTesisCampus(Integer codTesisCampus) {
        this.codTesisCampus = codTesisCampus;
    }

    public String getCampusDescription() {
        return campusDescription;
    }

    public void setCampusDescription(String campusDescription) {
        this.campusDescription = campusDescription;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public String getCampusTel() {
        return campusTel;
    }

    public void setCampusTel(String campusTel) {
        this.campusTel = campusTel;
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

    @XmlTransient
    @JsonIgnore
    public Collection<TesisMasters> getTesisMastersCollection() {
        return tesisMastersCollection;
    }

    public void setTesisMastersCollection(Collection<TesisMasters> tesisMastersCollection) {
        this.tesisMastersCollection = tesisMastersCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<TesisOffer> getTesisOfferCollection() {
        return tesisOfferCollection;
    }

    public void setTesisOfferCollection(Collection<TesisOffer> tesisOfferCollection) {
        this.tesisOfferCollection = tesisOfferCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<TesisPlans> getTesisPlansCollection() {
        return tesisPlansCollection;
    }

    public void setTesisPlansCollection(Collection<TesisPlans> tesisPlansCollection) {
        this.tesisPlansCollection = tesisPlansCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<TesisUserCampus> getTesisUserCampusCollection() {
        return tesisUserCampusCollection;
    }

    public void setTesisUserCampusCollection(Collection<TesisUserCampus> tesisUserCampusCollection) {
        this.tesisUserCampusCollection = tesisUserCampusCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<TesisCulture> getTesisCultureCollection() {
        return tesisCultureCollection;
    }

    public void setTesisCultureCollection(Collection<TesisCulture> tesisCultureCollection) {
        this.tesisCultureCollection = tesisCultureCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<TesisInfrastructure> getTesisInfrastructureCollection() {
        return tesisInfrastructureCollection;
    }

    public void setTesisInfrastructureCollection(Collection<TesisInfrastructure> tesisInfrastructureCollection) {
        this.tesisInfrastructureCollection = tesisInfrastructureCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTesisCampus != null ? codTesisCampus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TesisCampus)) {
            return false;
        }
        TesisCampus other = (TesisCampus) object;
        if ((this.codTesisCampus == null && other.codTesisCampus != null) || (this.codTesisCampus != null && !this.codTesisCampus.equals(other.codTesisCampus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tesis.model.entity.TesisCampus[ codTesisCampus=" + codTesisCampus + " ]";
    }

}
