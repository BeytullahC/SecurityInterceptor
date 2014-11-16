/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beto.test.securityinterceptor.model.entity.KAHIN;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 912867
 */
@Entity
@Table(name = "Seflik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seflik.findAll", query = "SELECT s FROM Seflik s"),
    @NamedQuery(name = "Seflik.findBySId", query = "SELECT s FROM Seflik s WHERE s.sId = :sId"),
    @NamedQuery(name = "Seflik.findBySeflik", query = "SELECT s FROM Seflik s WHERE s.seflik = :seflik"),
    @NamedQuery(name = "Seflik.findByEkleyen", query = "SELECT s FROM Seflik s WHERE s.ekleyen = :ekleyen"),
    @NamedQuery(name = "Seflik.findByEklenenTar", query = "SELECT s FROM Seflik s WHERE s.eklenenTar = :eklenenTar"),
    @NamedQuery(name = "Seflik.findByGuncelleyenPer", query = "SELECT s FROM Seflik s WHERE s.guncelleyenPer = :guncelleyenPer"),
    @NamedQuery(name = "Seflik.findByGuncellenenTar", query = "SELECT s FROM Seflik s WHERE s.guncellenenTar = :guncellenenTar")})
public class Seflik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "S_Id")
    private Short sId;
    @Size(max = 50)
    @Column(name = "Seflik")
    private String seflik;
    @Size(max = 6)
    @Column(name = "Ekleyen")
    private String ekleyen;
    @Column(name = "Eklenen_Tar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eklenenTar;
    @Size(max = 6)
    @Column(name = "Guncelleyen_Per")
    private String guncelleyenPer;
    @Column(name = "Guncellenen_Tar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date guncellenenTar;
    @JoinColumn(name = "M_Id", referencedColumnName = "M_Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Mudurluk mId;
    @OneToMany(mappedBy = "seflikId", fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    public Seflik() {
    }

    public Seflik(Short sId) {
        this.sId = sId;
    }

    public Short getSId() {
        return sId;
    }

    public void setSId(Short sId) {
        this.sId = sId;
    }

    public String getSeflik() {
        return seflik;
    }

    public void setSeflik(String seflik) {
        this.seflik = seflik;
    }

    public String getEkleyen() {
        return ekleyen;
    }

    public void setEkleyen(String ekleyen) {
        this.ekleyen = ekleyen;
    }

    public Date getEklenenTar() {
        return eklenenTar;
    }

    public void setEklenenTar(Date eklenenTar) {
        this.eklenenTar = eklenenTar;
    }

    public String getGuncelleyenPer() {
        return guncelleyenPer;
    }

    public void setGuncelleyenPer(String guncelleyenPer) {
        this.guncelleyenPer = guncelleyenPer;
    }

    public Date getGuncellenenTar() {
        return guncellenenTar;
    }

    public void setGuncellenenTar(Date guncellenenTar) {
        this.guncellenenTar = guncellenenTar;
    }

    public Mudurluk getMId() {
        return mId;
    }

    public void setMId(Mudurluk mId) {
        this.mId = mId;
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
        hash += (sId != null ? sId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seflik)) {
            return false;
        }
        Seflik other = (Seflik) object;
        if ((this.sId == null && other.sId != null) || (this.sId != null && !this.sId.equals(other.sId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.test.mavenproject5.Seflik[ sId=" + sId + " ]";
    }
    
}
