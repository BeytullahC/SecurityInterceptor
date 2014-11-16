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
@Table(name = "Baskanlik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Baskanlik.findAll", query = "SELECT b FROM Baskanlik b"),
    @NamedQuery(name = "Baskanlik.findByBId", query = "SELECT b FROM Baskanlik b WHERE b.bId = :bId"),
    @NamedQuery(name = "Baskanlik.findByBadi", query = "SELECT b FROM Baskanlik b WHERE b.badi = :badi"),
    @NamedQuery(name = "Baskanlik.findByGmyd", query = "SELECT b FROM Baskanlik b WHERE b.gmyd = :gmyd"),
    @NamedQuery(name = "Baskanlik.findByBMail", query = "SELECT b FROM Baskanlik b WHERE b.bMail = :bMail")})
public class Baskanlik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "B_Id")
    private Short bId;
    @Size(max = 40)
    @Column(name = "Badi")
    private String badi;
    @Column(name = "Gmyd")
    private Short gmyd;
    @Size(max = 750)
    @Column(name = "B_Mail")
    private String bMail;
    @OneToMany(mappedBy = "baskanlikId", fetch = FetchType.LAZY)
    private List<Employee> employeeList;
    @OneToMany(mappedBy = "bId", fetch = FetchType.LAZY)
    private List<Mudurluk> mudurlukList;

    public Baskanlik() {
    }

    public Baskanlik(Short bId) {
        this.bId = bId;
    }

    public Short getBId() {
        return bId;
    }

    public void setBId(Short bId) {
        this.bId = bId;
    }

    public String getBadi() {
        return badi;
    }

    public void setBadi(String badi) {
        this.badi = badi;
    }

    public Short getGmyd() {
        return gmyd;
    }

    public void setGmyd(Short gmyd) {
        this.gmyd = gmyd;
    }

    public String getBMail() {
        return bMail;
    }

    public void setBMail(String bMail) {
        this.bMail = bMail;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @XmlTransient
    public List<Mudurluk> getMudurlukList() {
        return mudurlukList;
    }

    public void setMudurlukList(List<Mudurluk> mudurlukList) {
        this.mudurlukList = mudurlukList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bId != null ? bId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Baskanlik)) {
            return false;
        }
        Baskanlik other = (Baskanlik) object;
        if ((this.bId == null && other.bId != null) || (this.bId != null && !this.bId.equals(other.bId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.test.mavenproject5.Baskanlik[ bId=" + bId + " ]";
    }
    
}
