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
@Table(name = "Mudurluk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mudurluk.findAll", query = "SELECT m FROM Mudurluk m"),
    @NamedQuery(name = "Mudurluk.findByMId", query = "SELECT m FROM Mudurluk m WHERE m.mId = :mId"),
    @NamedQuery(name = "Mudurluk.findByMadi", query = "SELECT m FROM Mudurluk m WHERE m.madi = :madi"),
    @NamedQuery(name = "Mudurluk.findByEkleyen", query = "SELECT m FROM Mudurluk m WHERE m.ekleyen = :ekleyen"),
    @NamedQuery(name = "Mudurluk.findByEklenenTar", query = "SELECT m FROM Mudurluk m WHERE m.eklenenTar = :eklenenTar"),
    @NamedQuery(name = "Mudurluk.findByGuncelleyenPer", query = "SELECT m FROM Mudurluk m WHERE m.guncelleyenPer = :guncelleyenPer"),
    @NamedQuery(name = "Mudurluk.findByGuncellenenTar", query = "SELECT m FROM Mudurluk m WHERE m.guncellenenTar = :guncellenenTar"),
    @NamedQuery(name = "Mudurluk.findByMMail", query = "SELECT m FROM Mudurluk m WHERE m.mMail = :mMail"),
    @NamedQuery(name = "Mudurluk.findByMudurlukDurum", query = "SELECT m FROM Mudurluk m WHERE m.mudurlukDurum = :mudurlukDurum"),
    @NamedQuery(name = "Mudurluk.findBySirketid", query = "SELECT m FROM Mudurluk m WHERE m.sirketid = :sirketid")})
public class Mudurluk implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "M_Id")
    private Short mId;
    @Size(max = 300)
    @Column(name = "Madi")
    private String madi;
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
    @Size(max = 1000)
    @Column(name = "M_Mail")
    private String mMail;
    @Column(name = "Mudurluk_Durum")
    private Boolean mudurlukDurum;
    @Column(name = "Sirket_id")
    private Integer sirketid;
    @OneToMany(mappedBy = "mId", fetch = FetchType.LAZY)
    private List<Seflik> seflikList;
    @OneToMany(mappedBy = "mudurlukId", fetch = FetchType.LAZY)
    private List<Employee> employeeList;
    @JoinColumn(name = "B_Id", referencedColumnName = "B_Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Baskanlik bId;

    public Mudurluk() {
    }

    public Mudurluk(Short mId) {
        this.mId = mId;
    }

    public Short getMId() {
        return mId;
    }

    public void setMId(Short mId) {
        this.mId = mId;
    }

    public String getMadi() {
        return madi;
    }

    public void setMadi(String madi) {
        this.madi = madi;
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

    public String getMMail() {
        return mMail;
    }

    public void setMMail(String mMail) {
        this.mMail = mMail;
    }

    public Boolean getMudurlukDurum() {
        return mudurlukDurum;
    }

    public void setMudurlukDurum(Boolean mudurlukDurum) {
        this.mudurlukDurum = mudurlukDurum;
    }

    public Integer getSirketid() {
        return sirketid;
    }

    public void setSirketid(Integer sirketid) {
        this.sirketid = sirketid;
    }

    @XmlTransient
    public List<Seflik> getSeflikList() {
        return seflikList;
    }

    public void setSeflikList(List<Seflik> seflikList) {
        this.seflikList = seflikList;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Baskanlik getBId() {
        return bId;
    }

    public void setBId(Baskanlik bId) {
        this.bId = bId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mId != null ? mId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mudurluk)) {
            return false;
        }
        Mudurluk other = (Mudurluk) object;
        if ((this.mId == null && other.mId != null) || (this.mId != null && !this.mId.equals(other.mId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.test.mavenproject5.Mudurluk[ mId=" + mId + " ]";
    }
    
}
