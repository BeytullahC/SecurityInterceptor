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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Ilce")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ilce.findAll", query = "SELECT i FROM Ilce i"),
    @NamedQuery(name = "Ilce.findByIlceId", query = "SELECT i FROM Ilce i WHERE i.ilceId = :ilceId"),
    @NamedQuery(name = "Ilce.findByIlce", query = "SELECT i FROM Ilce i WHERE i.ilce = :ilce")})
public class Ilce implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ilce_Id")
    private Integer ilceId;
    @Size(max = 50)
    @Column(name = "Ilce")
    private String ilce;
    @JoinColumn(name = "Il_Id", referencedColumnName = "I_Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Il ilId;
    @OneToMany(mappedBy = "ilceId", fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    public Ilce() {
    }

    public Ilce(Integer ilceId) {
        this.ilceId = ilceId;
    }

    public Integer getIlceId() {
        return ilceId;
    }

    public void setIlceId(Integer ilceId) {
        this.ilceId = ilceId;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public Il getIlId() {
        return ilId;
    }

    public void setIlId(Il ilId) {
        this.ilId = ilId;
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
        hash += (ilceId != null ? ilceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ilce)) {
            return false;
        }
        Ilce other = (Ilce) object;
        if ((this.ilceId == null && other.ilceId != null) || (this.ilceId != null && !this.ilceId.equals(other.ilceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.test.mavenproject5.Ilce[ ilceId=" + ilceId + " ]";
    }
    
}
