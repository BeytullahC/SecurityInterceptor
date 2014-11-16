/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beto.test.securityinterceptor.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**	
 *
 * @author Belgelerim
 */
@Entity
@Table(name = "sec_page_role_def")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecPageRoleDef.findAll", query = "SELECT s FROM SecPageRoleDef s"),
    @NamedQuery(name = "SecPageRoleDef.findById", query = "SELECT s FROM SecPageRoleDef s WHERE s.id = :id")})
    
public class SecPageRoleDef implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "VIEW_ID", referencedColumnName = "VIEW_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SecPageDef viewId;
    @JoinColumn(name = "ROLE", referencedColumnName = "role", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SecRoleDef role;

    public SecPageRoleDef() {
    }

    public SecPageRoleDef(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SecPageDef getViewId() {
        return viewId;
    }

    public void setViewId(SecPageDef viewId) {
        this.viewId = viewId;
    }

    public SecRoleDef getRole() {
        return role;
    }

    public void setRole(SecRoleDef role) {
        this.role = role;
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
        if (!(object instanceof SecPageRoleDef)) {
            return false;
        }
        SecPageRoleDef other = (SecPageRoleDef) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SecPageRoleDef{" + "id=" + id + ", viewId=" + viewId + ", role=" + role + '}';
    }
    
}
