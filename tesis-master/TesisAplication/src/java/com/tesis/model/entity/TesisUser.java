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
@Table(name = "tesis_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TesisUser.findAll", query = "SELECT t FROM TesisUser t"),
    @NamedQuery(name = "TesisUser.findByCodTesisUser", query = "SELECT t FROM TesisUser t WHERE t.codTesisUser = :codTesisUser"),
    @NamedQuery(name = "TesisUser.findByCreatedBy", query = "SELECT t FROM TesisUser t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "TesisUser.findByCreatedDate", query = "SELECT t FROM TesisUser t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "TesisUser.findByUpdateBy", query = "SELECT t FROM TesisUser t WHERE t.updateBy = :updateBy"),
    @NamedQuery(name = "TesisUser.findByUpdateDate", query = "SELECT t FROM TesisUser t WHERE t.updateDate = :updateDate"),
    @NamedQuery(name = "TesisUser.findByUserDescription", query = "SELECT t FROM TesisUser t WHERE t.userDescription = :userDescription"),
    @NamedQuery(name = "TesisUser.findByUserName", query = "SELECT t FROM TesisUser t WHERE t.userName = :userName"),
    @NamedQuery(name = "TesisUser.findByUserPass", query = "SELECT t FROM TesisUser t WHERE t.userPass = :userPass")})
public class TesisUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tesis_user")
    private Integer codTesisUser;
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
    @Size(max = 255)
    @Column(name = "user_description")
    private String userDescription;
    @Size(max = 500)
    @Column(name = "user_name")
    private String userName;
    @Size(max = 500)
    @Column(name = "user_pass")
    private String userPass;
    @OneToMany(mappedBy = "fkTesisUser")
    private Collection<TesisUserCampus> tesisUserCampusCollection;

    public TesisUser() {
    }

    public TesisUser(Integer codTesisUser) {
        this.codTesisUser = codTesisUser;
    }

    public Integer getCodTesisUser() {
        return codTesisUser;
    }

    public void setCodTesisUser(Integer codTesisUser) {
        this.codTesisUser = codTesisUser;
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

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<TesisUserCampus> getTesisUserCampusCollection() {
        return tesisUserCampusCollection;
    }

    public void setTesisUserCampusCollection(Collection<TesisUserCampus> tesisUserCampusCollection) {
        this.tesisUserCampusCollection = tesisUserCampusCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTesisUser != null ? codTesisUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TesisUser)) {
            return false;
        }
        TesisUser other = (TesisUser) object;
        if ((this.codTesisUser == null && other.codTesisUser != null) || (this.codTesisUser != null && !this.codTesisUser.equals(other.codTesisUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tesis.model.entity.TesisUser[ codTesisUser=" + codTesisUser + " ]";
    }

}
