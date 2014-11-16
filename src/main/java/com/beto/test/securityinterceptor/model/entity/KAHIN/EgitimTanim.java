/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beto.test.securityinterceptor.model.entity.KAHIN;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 912867
 */
@Entity
@Table(name = "Egitim_Tanim")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EgitimTanim.findAll", query = "SELECT e FROM EgitimTanim e"),
    @NamedQuery(name = "EgitimTanim.findByEgtId", query = "SELECT e FROM EgitimTanim e WHERE e.egtId = :egtId"),
    @NamedQuery(name = "EgitimTanim.findByEgtKodu", query = "SELECT e FROM EgitimTanim e WHERE e.egtKodu = :egtKodu"),
    @NamedQuery(name = "EgitimTanim.findByEgtAdi", query = "SELECT e FROM EgitimTanim e WHERE e.egtAdi = :egtAdi"),
    @NamedQuery(name = "EgitimTanim.findByACTipID", query = "SELECT e FROM EgitimTanim e WHERE e.aCTipID = :aCTipID"),
    @NamedQuery(name = "EgitimTanim.findByEgtTeorikSure", query = "SELECT e FROM EgitimTanim e WHERE e.egtTeorikSure = :egtTeorikSure"),
    @NamedQuery(name = "EgitimTanim.findByEgtPratikSure", query = "SELECT e FROM EgitimTanim e WHERE e.egtPratikSure = :egtPratikSure"),
    @NamedQuery(name = "EgitimTanim.findByKaliteKodu", query = "SELECT e FROM EgitimTanim e WHERE e.kaliteKodu = :kaliteKodu"),
    @NamedQuery(name = "EgitimTanim.findByEkleyen", query = "SELECT e FROM EgitimTanim e WHERE e.ekleyen = :ekleyen"),
    @NamedQuery(name = "EgitimTanim.findByEklenenTarih", query = "SELECT e FROM EgitimTanim e WHERE e.eklenenTarih = :eklenenTarih"),
    @NamedQuery(name = "EgitimTanim.findByGuncelleyenPer", query = "SELECT e FROM EgitimTanim e WHERE e.guncelleyenPer = :guncelleyenPer"),
    @NamedQuery(name = "EgitimTanim.findByGuncellenenTar", query = "SELECT e FROM EgitimTanim e WHERE e.guncellenenTar = :guncellenenTar"),
    @NamedQuery(name = "EgitimTanim.findByCostIndividual", query = "SELECT e FROM EgitimTanim e WHERE e.costIndividual = :costIndividual"),
    @NamedQuery(name = "EgitimTanim.findByCostClassroom", query = "SELECT e FROM EgitimTanim e WHERE e.costClassroom = :costClassroom"),
    @NamedQuery(name = "EgitimTanim.findByKurumTanim", query = "SELECT e FROM EgitimTanim e WHERE e.kurumTanim = :kurumTanim"),
    @NamedQuery(name = "EgitimTanim.findByDd046", query = "SELECT e FROM EgitimTanim e WHERE e.dd046 = :dd046"),
    @NamedQuery(name = "EgitimTanim.findBySort", query = "SELECT e FROM EgitimTanim e WHERE e.sort = :sort"),
    @NamedQuery(name = "EgitimTanim.findByLevelid", query = "SELECT e FROM EgitimTanim e WHERE e.levelid = :levelid"),
    @NamedQuery(name = "EgitimTanim.findByChapterid", query = "SELECT e FROM EgitimTanim e WHERE e.chapterid = :chapterid"),
    @NamedQuery(name = "EgitimTanim.findBySubjectid", query = "SELECT e FROM EgitimTanim e WHERE e.subjectid = :subjectid"),
    @NamedQuery(name = "EgitimTanim.findByType147", query = "SELECT e FROM EgitimTanim e WHERE e.type147 = :type147")})
public class EgitimTanim implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Egt_Id")
    private int egtId;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Egt_Kodu")
    private String egtKodu;
    @Size(max = 550)
    @Column(name = "Egt_Adi")
    private String egtAdi;
    @Column(name = "AC_Tip_ID")
    private Integer aCTipID;
    @Size(max = 4)
    @Column(name = "Egt_Teorik_Sure")
    private String egtTeorikSure;
    @Size(max = 4)
    @Column(name = "Egt_Pratik_Sure")
    private String egtPratikSure;
    @Size(max = 50)
    @Column(name = "Kalite_Kodu")
    private String kaliteKodu;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Cost_Individual")
    private BigDecimal costIndividual;
    @Column(name = "Cost_Classroom")
    private BigDecimal costClassroom;
    @Column(name = "Kurum_Tanim")
    private Integer kurumTanim;
    @Size(max = 5)
    @Column(name = "dd046")
    private String dd046;
    @Size(max = 10)
    @Column(name = "Sort")
    private String sort;
    @Column(name = "Level_id")
    private Integer levelid;
    @Column(name = "Chapter_id")
    private Integer chapterid;
    @Column(name = "Subject_id")
    private Integer subjectid;
    @Column(name = "Type_147")
    private Boolean type147;
    @JoinColumn(name = "Etur_Id", referencedColumnName = "Etur_Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private EgitimTuru eturId;

    public EgitimTanim() {
    }

    public EgitimTanim(String egtKodu) {
        this.egtKodu = egtKodu;
    }

    public EgitimTanim(String egtKodu, int egtId) {
        this.egtKodu = egtKodu;
        this.egtId = egtId;
    }

    public int getEgtId() {
        return egtId;
    }

    public void setEgtId(int egtId) {
        this.egtId = egtId;
    }

    public String getEgtKodu() {
        return egtKodu;
    }

    public void setEgtKodu(String egtKodu) {
        this.egtKodu = egtKodu;
    }

    public String getEgtAdi() {
        return egtAdi;
    }

    public void setEgtAdi(String egtAdi) {
        this.egtAdi = egtAdi;
    }

    public Integer getACTipID() {
        return aCTipID;
    }

    public void setACTipID(Integer aCTipID) {
        this.aCTipID = aCTipID;
    }

    public String getEgtTeorikSure() {
        return egtTeorikSure;
    }

    public void setEgtTeorikSure(String egtTeorikSure) {
        this.egtTeorikSure = egtTeorikSure;
    }

    public String getEgtPratikSure() {
        return egtPratikSure;
    }

    public void setEgtPratikSure(String egtPratikSure) {
        this.egtPratikSure = egtPratikSure;
    }

    public String getKaliteKodu() {
        return kaliteKodu;
    }

    public void setKaliteKodu(String kaliteKodu) {
        this.kaliteKodu = kaliteKodu;
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

    public BigDecimal getCostIndividual() {
        return costIndividual;
    }

    public void setCostIndividual(BigDecimal costIndividual) {
        this.costIndividual = costIndividual;
    }

    public BigDecimal getCostClassroom() {
        return costClassroom;
    }

    public void setCostClassroom(BigDecimal costClassroom) {
        this.costClassroom = costClassroom;
    }

    public Integer getKurumTanim() {
        return kurumTanim;
    }

    public void setKurumTanim(Integer kurumTanim) {
        this.kurumTanim = kurumTanim;
    }

    public String getDd046() {
        return dd046;
    }

    public void setDd046(String dd046) {
        this.dd046 = dd046;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getLevelid() {
        return levelid;
    }

    public void setLevelid(Integer levelid) {
        this.levelid = levelid;
    }

    public Integer getChapterid() {
        return chapterid;
    }

    public void setChapterid(Integer chapterid) {
        this.chapterid = chapterid;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public Boolean getType147() {
        return type147;
    }

    public void setType147(Boolean type147) {
        this.type147 = type147;
    }

    public EgitimTuru getEturId() {
        return eturId;
    }

    public void setEturId(EgitimTuru eturId) {
        this.eturId = eturId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (egtKodu != null ? egtKodu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EgitimTanim)) {
            return false;
        }
        EgitimTanim other = (EgitimTanim) object;
        if ((this.egtKodu == null && other.egtKodu != null) || (this.egtKodu != null && !this.egtKodu.equals(other.egtKodu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.test.mavenproject5.EgitimTanim[ egtKodu=" + egtKodu + " ]";
    }
    
}
