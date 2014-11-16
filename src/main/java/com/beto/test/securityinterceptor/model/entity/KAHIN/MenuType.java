/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beto.test.securityinterceptor.model.entity.KAHIN;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 912867
 */
@Entity
@Table(name = "MENU_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuType.findAll", query = "SELECT m FROM MenuType m"),
    @NamedQuery(name = "MenuType.findById", query = "SELECT m FROM MenuType m WHERE m.id = :id"),
    @NamedQuery(name = "MenuType.findByName", query = "SELECT m FROM MenuType m WHERE m.name = :name")})
public class MenuType implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "CREATED_TIME")
    private byte[] createdTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NAME")
    private String name;

    public MenuType() {
    }

    public MenuType(BigDecimal id) {
        this.id = id;
    }

    public MenuType(BigDecimal id, byte[] createdTime, String name) {
        this.id = id;
        this.createdTime = createdTime;
        this.name = name;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public byte[] getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(byte[] createdTime) {
        this.createdTime = createdTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuType)) {
            return false;
        }
        MenuType other = (MenuType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.test.mavenproject5.MenuType[ id=" + id + " ]";
    }
    
}
