/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beto.test.securityinterceptor.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Belgelerim
 */
@Entity
@Table(name = "sec_page_def", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"VIEW_ID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecPageDef.findAll", query = "SELECT s FROM SecPageDef s"),
    @NamedQuery(name = "SecPageDef.findById", query = "SELECT s FROM SecPageDef s WHERE s.id = :id"),
    @NamedQuery(name = "SecPageDef.findByName", query = "SELECT s FROM SecPageDef s WHERE s.name = :name"),
    @NamedQuery(name = "SecPageDef.findByType", query = "SELECT s FROM SecPageDef s WHERE s.type = :type"),
    @NamedQuery(name = "SecPageDef.findByViewId", query = "SELECT s FROM SecPageDef s WHERE s.viewId = :viewId")})
public class SecPageDef implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TYPE", nullable = false, length = 255)
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "VIEW_ID", nullable = false, length = 250)
    private String viewId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viewId", fetch = FetchType.EAGER)
    private List<SecPageRoleDef> secPageRoleDefList;

    public SecPageDef() {
    }

    public SecPageDef(Long id) {
        this.id = id;
    }

    public SecPageDef(Long id, String name, String type, String viewId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.viewId = viewId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getViewId() {
        return viewId;
    }

    public void setViewId(String viewId) {
        this.viewId = viewId;
    }

    @XmlTransient
    public List<SecPageRoleDef> getSecPageRoleDefList() {
        return secPageRoleDefList;
    }

    public void setSecPageRoleDefList(List<SecPageRoleDef> secPageRoleDefList) {
        this.secPageRoleDefList = secPageRoleDefList;
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
        if (!(object instanceof SecPageDef)) {
            return false;
        }
        SecPageDef other = (SecPageDef) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "SecPageDef{" + "id=" + id +'}';
    }

   
}
