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
@Table(name = "Gorevler")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gorevler.findAll", query = "SELECT g FROM Gorevler g"),
    @NamedQuery(name = "Gorevler.findByGId", query = "SELECT g FROM Gorevler g WHERE g.gId = :gId"),
    @NamedQuery(name = "Gorevler.findByGorev", query = "SELECT g FROM Gorevler g WHERE g.gorev = :gorev"),
    @NamedQuery(name = "Gorevler.findByEkleyen", query = "SELECT g FROM Gorevler g WHERE g.ekleyen = :ekleyen"),
    @NamedQuery(name = "Gorevler.findByEklenenTar", query = "SELECT g FROM Gorevler g WHERE g.eklenenTar = :eklenenTar"),
    @NamedQuery(name = "Gorevler.findByGuncelleyenPer", query = "SELECT g FROM Gorevler g WHERE g.guncelleyenPer = :guncelleyenPer"),
    @NamedQuery(name = "Gorevler.findByGuncellenenTat", query = "SELECT g FROM Gorevler g WHERE g.guncellenenTat = :guncellenenTat")})
public class Gorevler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "G_Id")
    private Short gId;
    @Size(max = 100)
    @Column(name = "Gorev")
    private String gorev;
    @Size(max = 6)
    @Column(name = "Ekleyen")
    private String ekleyen;
    @Column(name = "Eklenen_Tar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eklenenTar;
    @Size(max = 6)
    @Column(name = "Guncelleyen_Per")
    private String guncelleyenPer;
    @Column(name = "Guncellenen_Tat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date guncellenenTat;
    @OneToMany(mappedBy = "gorevId", fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    public Gorevler() {
    }

    public Gorevler(Short gId) {
        this.gId = gId;
    }

    public Short getGId() {
        return gId;
    }

    public void setGId(Short gId) {
        this.gId = gId;
    }

    public String getGorev() {
        return gorev;
    }

    public void setGorev(String gorev) {
        this.gorev = gorev;
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

    public Date getGuncellenenTat() {
        return guncellenenTat;
    }

    public void setGuncellenenTat(Date guncellenenTat) {
        this.guncellenenTat = guncellenenTat;
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
        hash += (gId != null ? gId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gorevler)) {
            return false;
        }
        Gorevler other = (Gorevler) object;
        if ((this.gId == null && other.gId != null) || (this.gId != null && !this.gId.equals(other.gId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.test.mavenproject5.Gorevler[ gId=" + gId + " ]";
    }
    
}
