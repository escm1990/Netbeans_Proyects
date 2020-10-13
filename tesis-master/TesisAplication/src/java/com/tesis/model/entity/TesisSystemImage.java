/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.model.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 
 * @author luis.chavez
 */
@Entity
@Table(name = "tesis_system_image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TesisSystemImage.findAll", query = "SELECT t FROM TesisSystemImage t"),
    @NamedQuery(name = "TesisSystemImage.findByCodTesisSystemImages", query = "SELECT t FROM TesisSystemImage t WHERE t.codTesisSystemImages = :codTesisSystemImages"),
    @NamedQuery(name = "TesisSystemImage.findByImageDescription", query = "SELECT t FROM TesisSystemImage t WHERE t.imageDescription = :imageDescription"),
    @NamedQuery(name = "TesisSystemImage.findByImageExtesion", query = "SELECT t FROM TesisSystemImage t WHERE t.imageExtesion = :imageExtesion"),
    @NamedQuery(name = "TesisSystemImage.findByImageUri", query = "SELECT t FROM TesisSystemImage t WHERE t.imageUri = :imageUri")})
public class TesisSystemImage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tesis_system_images")
    private Integer codTesisSystemImages;
    @Size(max = 255)
    @Column(name = "image_description")
    private String imageDescription;
    @Size(max = 255)
    @Column(name = "image_extesion")
    private String imageExtesion;
    @Size(max = 255)
    @Column(name = "image_uri")
    private String imageUri;
    @OneToMany(mappedBy = "fkTesisSystemImages")
    private Collection<TesisMasters> tesisMastersCollection;
    @OneToMany(mappedBy = "fkTesisSystemImage")
    private Collection<TesisOffer> tesisOfferCollection;
    @OneToMany(mappedBy = "fkTesisSystemImages")
    private Collection<TesisPlans> tesisPlansCollection;
    @OneToMany(mappedBy = "fkSystemImages")
    private Collection<TesisCulture> tesisCultureCollection;
    @OneToMany(mappedBy = "fkTesisSystemImages")
    private Collection<TesisInfrastructure> tesisInfrastructureCollection;

    public TesisSystemImage() {
    }

    public TesisSystemImage(Integer codTesisSystemImages) {
        this.codTesisSystemImages = codTesisSystemImages;
    }

    public Integer getCodTesisSystemImages() {
        return codTesisSystemImages;
    }

    public void setCodTesisSystemImages(Integer codTesisSystemImages) {
        this.codTesisSystemImages = codTesisSystemImages;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public String getImageExtesion() {
        return imageExtesion;
    }

    public void setImageExtesion(String imageExtesion) {
        this.imageExtesion = imageExtesion;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
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
        hash += (codTesisSystemImages != null ? codTesisSystemImages.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TesisSystemImage)) {
            return false;
        }
        TesisSystemImage other = (TesisSystemImage) object;
        if ((this.codTesisSystemImages == null && other.codTesisSystemImages != null) || (this.codTesisSystemImages != null && !this.codTesisSystemImages.equals(other.codTesisSystemImages))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tesis.model.entity.TesisSystemImage[ codTesisSystemImages=" + codTesisSystemImages + " ]";
    }

}
