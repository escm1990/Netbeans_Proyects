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
@Table(name = "tesis_infrastructure")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TesisInfrastructure.findAll", query = "SELECT t FROM TesisInfrastructure t"),
    @NamedQuery(name = "TesisInfrastructure.findByCodTesisInfrastructure", query = "SELECT t FROM TesisInfrastructure t WHERE t.codTesisInfrastructure = :codTesisInfrastructure"),
    @NamedQuery(name = "TesisInfrastructure.findByCreatedBy", query = "SELECT t FROM TesisInfrastructure t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "TesisInfrastructure.findByCreatedDate", query = "SELECT t FROM TesisInfrastructure t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "TesisInfrastructure.findByHeightLength", query = "SELECT t FROM TesisInfrastructure t WHERE t.heightLength = :heightLength"),
    @NamedQuery(name = "TesisInfrastructure.findByInfraestructuraName", query = "SELECT t FROM TesisInfrastructure t WHERE t.infraestructuraName = :infraestructuraName"),
    @NamedQuery(name = "TesisInfrastructure.findByInfraestucturaDescription", query = "SELECT t FROM TesisInfrastructure t WHERE t.infraestucturaDescription = :infraestucturaDescription"),
    @NamedQuery(name = "TesisInfrastructure.findByInfraestucturaLocation", query = "SELECT t FROM TesisInfrastructure t WHERE t.infraestucturaLocation = :infraestucturaLocation"),
    @NamedQuery(name = "TesisInfrastructure.findByLength", query = "SELECT t FROM TesisInfrastructure t WHERE t.length = :length"),
    @NamedQuery(name = "TesisInfrastructure.findByUpdateBy", query = "SELECT t FROM TesisInfrastructure t WHERE t.updateBy = :updateBy"),
    @NamedQuery(name = "TesisInfrastructure.findByUpdateDate", query = "SELECT t FROM TesisInfrastructure t WHERE t.updateDate = :updateDate"),
    @NamedQuery(name = "TesisInfrastructure.findByWeigthLength", query = "SELECT t FROM TesisInfrastructure t WHERE t.weigthLength = :weigthLength"),
    @NamedQuery(name = "TesisInfrastructure.findByInfraestructuraType", query = "SELECT t FROM TesisInfrastructure t WHERE t.infraestructuraType = :infraestructuraType")})
public class TesisInfrastructure implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tesis_infrastructure")
    private Integer codTesisInfrastructure;
    @Size(max = 255)
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 255)
    @Column(name = "height_length")
    private String heightLength;
    @Size(max = 500)
    @Column(name = "infraestructura_name")
    private String infraestructuraName;
    @Size(max = 2000)
    @Column(name = "infraestuctura_description")
    private String infraestucturaDescription;
    @Size(max = 500)
    @Column(name = "infraestuctura_location")
    private String infraestucturaLocation;
    @Size(max = 255)
    @Column(name = "length")
    private String length;
    @Size(max = 255)
    @Column(name = "update_by")
    private String updateBy;
    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Size(max = 255)
    @Column(name = "weigth_length")
    private String weigthLength;
    @Size(max = 500)
    @Column(name = "infraestructura_type")
    private String infraestructuraType;
    @JoinColumn(name = "fk_tesis_system_images", referencedColumnName = "cod_tesis_system_images")
    @ManyToOne
    private TesisSystemImage fkTesisSystemImages;
    @JoinColumn(name = "fk_tesis_system_document", referencedColumnName = "cod_tesis_system_document")
    @ManyToOne
    private TesisSystemDocument fkTesisSystemDocument;
    @JoinColumn(name = "fk_tesis_campus", referencedColumnName = "cod_tesis_campus")
    @ManyToOne
    private TesisCampus fkTesisCampus;

    public TesisInfrastructure() {
    }

    public TesisInfrastructure(Integer codTesisInfrastructure) {
        this.codTesisInfrastructure = codTesisInfrastructure;
    }

    public Integer getCodTesisInfrastructure() {
        return codTesisInfrastructure;
    }

    public void setCodTesisInfrastructure(Integer codTesisInfrastructure) {
        this.codTesisInfrastructure = codTesisInfrastructure;
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

    public String getHeightLength() {
        return heightLength;
    }

    public void setHeightLength(String heightLength) {
        this.heightLength = heightLength;
    }

    public String getInfraestructuraName() {
        return infraestructuraName;
    }

    public void setInfraestructuraName(String infraestructuraName) {
        this.infraestructuraName = infraestructuraName;
    }

    public String getInfraestucturaDescription() {
        return infraestucturaDescription;
    }

    public void setInfraestucturaDescription(String infraestucturaDescription) {
        this.infraestucturaDescription = infraestucturaDescription;
    }

    public String getInfraestucturaLocation() {
        return infraestucturaLocation;
    }

    public void setInfraestucturaLocation(String infraestucturaLocation) {
        this.infraestucturaLocation = infraestucturaLocation;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
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

    public String getWeigthLength() {
        return weigthLength;
    }

    public void setWeigthLength(String weigthLength) {
        this.weigthLength = weigthLength;
    }

    public String getInfraestructuraType() {
        return infraestructuraType;
    }

    public void setInfraestructuraType(String infraestructuraType) {
        this.infraestructuraType = infraestructuraType;
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
        hash += (codTesisInfrastructure != null ? codTesisInfrastructure.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TesisInfrastructure)) {
            return false;
        }
        TesisInfrastructure other = (TesisInfrastructure) object;
        if ((this.codTesisInfrastructure == null && other.codTesisInfrastructure != null) || (this.codTesisInfrastructure != null && !this.codTesisInfrastructure.equals(other.codTesisInfrastructure))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tesis.model.entity.TesisInfrastructure[ codTesisInfrastructure=" + codTesisInfrastructure + " ]";
    }

}
