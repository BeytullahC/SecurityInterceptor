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
@Table(name = "Egitim_Turu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EgitimTuru.findAll", query = "SELECT e FROM EgitimTuru e"),
    @NamedQuery(name = "EgitimTuru.findByEturId", query = "SELECT e FROM EgitimTuru e WHERE e.eturId = :eturId"),
    @NamedQuery(name = "EgitimTuru.findByEgitimTuru", query = "SELECT e FROM EgitimTuru e WHERE e.egitimTuru = :egitimTuru"),
    @NamedQuery(name = "EgitimTuru.findByTekrarYili", query = "SELECT e FROM EgitimTuru e WHERE e.tekrarYili = :tekrarYili"),
    @NamedQuery(name = "EgitimTuru.findByZorunlu", query = "SELECT e FROM EgitimTuru e WHERE e.zorunlu = :zorunlu"),
    @NamedQuery(name = "EgitimTuru.findByEkleyen", query = "SELECT e FROM EgitimTuru e WHERE e.ekleyen = :ekleyen"),
    @NamedQuery(name = "EgitimTuru.findByEklenenTarih", query = "SELECT e FROM EgitimTuru e WHERE e.eklenenTarih = :eklenenTarih"),
    @NamedQuery(name = "EgitimTuru.findByGuncelleyenPer", query = "SELECT e FROM EgitimTuru e WHERE e.guncelleyenPer = :guncelleyenPer"),
    @NamedQuery(name = "EgitimTuru.findByGuncellenenTar", query = "SELECT e FROM EgitimTuru e WHERE e.guncellenenTar = :guncellenenTar"),
    @NamedQuery(name = "EgitimTuru.findByType147", query = "SELECT e FROM EgitimTuru e WHERE e.type147 = :type147")})
public class EgitimTuru implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Etur_Id")
    private Short eturId;
    @Size(max = 500)
    @Column(name = "Egitim_Turu")
    private String egitimTuru;
    @Column(name = "Tekrar_Yili")
    private Integer tekrarYili;
    @Column(name = "Zorunlu")
    private Boolean zorunlu;
    @Size(max = 6)
    @Column(name = "Ekleyen")
    private String ekleyen;
    @Column(name = "Eklenen_Tarih")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eklenenTarih;
    @Size(max = 6)
    @Column(name = "Guncelleyen_Per")
    private String guncelleyenPer;
    @Column(name = "Guncellenen_Tar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date guncellenenTar;
    @Column(name = "Type_147")
    private Boolean type147;
    @OneToMany(mappedBy = "eturId", fetch = FetchType.LAZY)
    private List<EgitimTanim> egitimTanimList;

    public EgitimTuru() {
    }

    public EgitimTuru(Short eturId) {
        this.eturId = eturId;
    }

    public Short getEturId() {
        return eturId;
    }

    public void setEturId(Short eturId) {
        this.eturId = eturId;
    }

    public String getEgitimTuru() {
        return egitimTuru;
    }

    public void setEgitimTuru(String egitimTuru) {
        this.egitimTuru = egitimTuru;
    }

    public Integer getTekrarYili() {
        return tekrarYili;
    }

    public void setTekrarYili(Integer tekrarYili) {
        this.tekrarYili = tekrarYili;
    }

    public Boolean getZorunlu() {
        return zorunlu;
    }

    public void setZorunlu(Boolean zorunlu) {
        this.zorunlu = zorunlu;
    }

    public String getEkleyen() {
        return ekleyen;
    }

    public void setEkleyen(String ekleyen) {
        this.ekleyen = ekleyen;
    }

    public Date getEklenenTarih() {
        return eklenenTarih;
    }

    public void setEklenenTarih(Date eklenenTarih) {
        this.eklenenTarih = eklenenTarih;
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

    public Boolean getType147() {
        return type147;
    }

    public void setType147(Boolean type147) {
        this.type147 = type147;
    }

    @XmlTransient
    public List<EgitimTanim> getEgitimTanimList() {
        return egitimTanimList;
    }

    public void setEgitimTanimList(List<EgitimTanim> egitimTanimList) {
        this.egitimTanimList = egitimTanimList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eturId != null ? eturId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EgitimTuru)) {
            return false;
        }
        EgitimTuru other = (EgitimTuru) object;
        if ((this.eturId == null && other.eturId != null) || (this.eturId != null && !this.eturId.equals(other.eturId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.test.mavenproject5.EgitimTuru[ eturId=" + eturId + " ]";
    }
    
}
