/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beto.test.securityinterceptor.model.entity.KAHIN;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 912867
 */
@Entity
@Table(name = "Il")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Il.findAll", query = "SELECT i FROM Il i"),
    @NamedQuery(name = "Il.findByIId", query = "SELECT i FROM Il i WHERE i.iId = :iId"),
    @NamedQuery(name = "Il.findByIl", query = "SELECT i FROM Il i WHERE i.il = :il")})
public class Il implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_Id")
    private Integer iId;
    @Size(max = 50)
    @Column(name = "Il")
    private String il;
    @OneToMany(mappedBy = "ilId", fetch = FetchType.LAZY)
    private List<Ilce> ilceList;
    @OneToMany(mappedBy = "ilId", fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    public Il() {
    }

    public Il(Integer iId) {
        this.iId = iId;
    }

    public Integer getIId() {
        return iId;
    }

    public void setIId(Integer iId) {
        this.iId = iId;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    @XmlTransient
    public List<Ilce> getIlceList() {
        return ilceList;
    }

    public void setIlceList(List<Ilce> ilceList) {
        this.ilceList = ilceList;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iId != null ? iId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Il)) {
            return false;
        }
        Il other = (Il) object;
        if ((this.iId == null && other.iId != null) || (this.iId != null && !this.iId.equals(other.iId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.test.mavenproject5.Il[ iId=" + iId + " ]";
    }
    
}
