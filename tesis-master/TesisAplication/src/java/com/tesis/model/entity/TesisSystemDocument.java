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
@Table(name = "tesis_system_document")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TesisSystemDocument.findAll", query = "SELECT t FROM TesisSystemDocument t"),
    @NamedQuery(name = "TesisSystemDocument.findByCodTesisSystemDocument", query = "SELECT t FROM TesisSystemDocument t WHERE t.codTesisSystemDocument = :codTesisSystemDocument"),
    @NamedQuery(name = "TesisSystemDocument.findByDocumentDescription", query = "SELECT t FROM TesisSystemDocument t WHERE t.documentDescription = :documentDescription"),
    @NamedQuery(name = "TesisSystemDocument.findByDocumentExtension", query = "SELECT t FROM TesisSystemDocument t WHERE t.documentExtension = :documentExtension"),
    @NamedQuery(name = "TesisSystemDocument.findByDocumentUri", query = "SELECT t FROM TesisSystemDocument t WHERE t.documentUri = :documentUri")})
public class TesisSystemDocument implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tesis_system_document")
    private Integer codTesisSystemDocument;
    @Size(max = 255)
    @Column(name = "document_description")
    private String documentDescription;
    @Size(max = 255)
    @Column(name = "document_extension")
    private String documentExtension;
    @Size(max = 255)
    @Column(name = "document_uri")
    private String documentUri;
    @OneToMany(mappedBy = "fkTesisSystemDocument")
    private Collection<TesisMasters> tesisMastersCollection;
    @OneToMany(mappedBy = "fkTesisSystemDocument")
    private Collection<TesisOffer> tesisOfferCollection;
    @OneToMany(mappedBy = "fkTesisSystemDocument")
    private Collection<TesisPlans> tesisPlansCollection;
    @OneToMany(mappedBy = "fkSystemDocument")
    private Collection<TesisCulture> tesisCultureCollection;
    @OneToMany(mappedBy = "fkTesisSystemDocument")
    private Collection<TesisInfrastructure> tesisInfrastructureCollection;

    public TesisSystemDocument() {
    }

    public TesisSystemDocument(Integer codTesisSystemDocument) {
        this.codTesisSystemDocument = codTesisSystemDocument;
    }

    public Integer getCodTesisSystemDocument() {
        return codTesisSystemDocument;
    }

    public void setCodTesisSystemDocument(Integer codTesisSystemDocument) {
        this.codTesisSystemDocument = codTesisSystemDocument;
    }

    public String getDocumentDescription() {
        return documentDescription;
    }

    public void setDocumentDescription(String documentDescription) {
        this.documentDescription = documentDescription;
    }

    public String getDocumentExtension() {
        return documentExtension;
    }

    public void setDocumentExtension(String documentExtension) {
        this.documentExtension = documentExtension;
    }

    public String getDocumentUri() {
        return documentUri;
    }

    public void setDocumentUri(String documentUri) {
        this.documentUri = documentUri;
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
        hash += (codTesisSystemDocument != null ? codTesisSystemDocument.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TesisSystemDocument)) {
            return false;
        }
        TesisSystemDocument other = (TesisSystemDocument) object;
        if ((this.codTesisSystemDocument == null && other.codTesisSystemDocument != null) || (this.codTesisSystemDocument != null && !this.codTesisSystemDocument.equals(other.codTesisSystemDocument))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tesis.model.entity.TesisSystemDocument[ codTesisSystemDocument=" + codTesisSystemDocument + " ]";
    }

}
