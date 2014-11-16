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
import javax.persistence.ManyToMany;
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
@Table(name = "sec_role_def", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"role"}),
    @UniqueConstraint(columnNames = {"ROLE_ORDER"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecRoleDef.findAll", query = "SELECT s FROM SecRoleDef s"),
    @NamedQuery(name = "SecRoleDef.findByRole", query = "SELECT s FROM SecRoleDef s WHERE s.role = :role"),
    @NamedQuery(name = "SecRoleDef.findByLoginOlur", query = "SELECT s FROM SecRoleDef s WHERE s.loginOlur = :loginOlur"),
    @NamedQuery(name = "SecRoleDef.findByRoleDesc", query = "SELECT s FROM SecRoleDef s WHERE s.roleDesc = :roleDesc"),
    @NamedQuery(name = "SecRoleDef.findByRoleOrder", query = "SELECT s FROM SecRoleDef s WHERE s.roleOrder = :roleOrder"),
    @NamedQuery(name = "SecRoleDef.findByUserType", query = "SELECT s FROM SecRoleDef s WHERE s.userType = :userType")})
public class SecRoleDef implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "role", nullable = false, length = 50)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String role;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOGIN_OLUR", nullable = false)
    private Character loginOlur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ROLE_DESC", nullable = false, length = 255)
    private String roleDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROLE_ORDER", nullable = false)
    private long roleOrder;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "USER_TYPE", nullable = false, length = 255)
    private String userType;
    @ManyToMany(mappedBy = "secRoleDefList", fetch = FetchType.LAZY)
    private List<SecUserDef> secUserDefList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role", fetch = FetchType.LAZY)
    private List<SecPageRoleDef> secPageRoleDefList;

    public SecRoleDef() {
    }

    public SecRoleDef(String role) {
        this.role = role;
    }

    public SecRoleDef(String role, Character loginOlur, String roleDesc, long roleOrder, String userType) {
        this.role = role;
        this.loginOlur = loginOlur;
        this.roleDesc = roleDesc;
        this.roleOrder = roleOrder;
        this.userType = userType;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Character getLoginOlur() {
        return loginOlur;
    }

    public void setLoginOlur(Character loginOlur) {
        this.loginOlur = loginOlur;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public long getRoleOrder() {
        return roleOrder;
    }

    public void setRoleOrder(long roleOrder) {
        this.roleOrder = roleOrder;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @XmlTransient
    public List<SecUserDef> getSecUserDefList() {
        return secUserDefList;
    }

    public void setSecUserDefList(List<SecUserDef> secUserDefList) {
        this.secUserDefList = secUserDefList;
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
        hash += (role != null ? role.hashCode() : 0);
        return hash;
        
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SecRoleDef)) {
            return false;
        }
        SecRoleDef other = (SecRoleDef) object;
        if ((this.role == null && other.role != null) || (this.role != null && !this.role.equals(other.role))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SecRoleDef{" + "role=" + role + '}';
    }

    
    
}
