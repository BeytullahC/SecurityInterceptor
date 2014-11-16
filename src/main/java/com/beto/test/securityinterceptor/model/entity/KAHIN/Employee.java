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
import javax.persistence.CascadeType;
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
@Table(name = "Employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByPkId", query = "SELECT e FROM Employee e WHERE e.pkId = :pkId"),
    @NamedQuery(name = "Employee.findByTCKimlik", query = "SELECT e FROM Employee e WHERE e.tCKimlik = :tCKimlik"),
    @NamedQuery(name = "Employee.findBySicil", query = "SELECT e FROM Employee e WHERE e.sicil = :sicil"),
    @NamedQuery(name = "Employee.findBySoyadi", query = "SELECT e FROM Employee e WHERE e.soyadi = :soyadi"),
    @NamedQuery(name = "Employee.findByAdi", query = "SELECT e FROM Employee e WHERE e.adi = :adi"),
    @NamedQuery(name = "Employee.findByBabaAdi", query = "SELECT e FROM Employee e WHERE e.babaAdi = :babaAdi"),
    @NamedQuery(name = "Employee.findByAnaAdi", query = "SELECT e FROM Employee e WHERE e.anaAdi = :anaAdi"),
    @NamedQuery(name = "Employee.findByDogumTarihi", query = "SELECT e FROM Employee e WHERE e.dogumTarihi = :dogumTarihi"),
    @NamedQuery(name = "Employee.findByDogumYeri", query = "SELECT e FROM Employee e WHERE e.dogumYeri = :dogumYeri"),
    @NamedQuery(name = "Employee.findByMedeniHali", query = "SELECT e FROM Employee e WHERE e.medeniHali = :medeniHali"),
    @NamedQuery(name = "Employee.findByAdres1", query = "SELECT e FROM Employee e WHERE e.adres1 = :adres1"),
    @NamedQuery(name = "Employee.findByAdres2", query = "SELECT e FROM Employee e WHERE e.adres2 = :adres2"),
    @NamedQuery(name = "Employee.findByBitirdigiLise", query = "SELECT e FROM Employee e WHERE e.bitirdigiLise = :bitirdigiLise"),
    @NamedQuery(name = "Employee.findByLiseBolum", query = "SELECT e FROM Employee e WHERE e.liseBolum = :liseBolum"),
    @NamedQuery(name = "Employee.findByBitirdigiUni", query = "SELECT e FROM Employee e WHERE e.bitirdigiUni = :bitirdigiUni"),
    @NamedQuery(name = "Employee.findByUniBolum", query = "SELECT e FROM Employee e WHERE e.uniBolum = :uniBolum"),
    @NamedQuery(name = "Employee.findBySifre", query = "SELECT e FROM Employee e WHERE e.sifre = :sifre"),
    @NamedQuery(name = "Employee.findBySiraNo", query = "SELECT e FROM Employee e WHERE e.siraNo = :siraNo"),
    @NamedQuery(name = "Employee.findByAskerlikDurumu", query = "SELECT e FROM Employee e WHERE e.askerlikDurumu = :askerlikDurumu"),
    @NamedQuery(name = "Employee.findByTerhisTar", query = "SELECT e FROM Employee e WHERE e.terhisTar = :terhisTar"),
    @NamedQuery(name = "Employee.findByCinsiyet", query = "SELECT e FROM Employee e WHERE e.cinsiyet = :cinsiyet"),
    @NamedQuery(name = "Employee.findByKayitYapanPer", query = "SELECT e FROM Employee e WHERE e.kayitYapanPer = :kayitYapanPer"),
    @NamedQuery(name = "Employee.findByKayitTar", query = "SELECT e FROM Employee e WHERE e.kayitTar = :kayitTar"),
    @NamedQuery(name = "Employee.findByGuncelleyenper", query = "SELECT e FROM Employee e WHERE e.guncelleyenper = :guncelleyenper"),
    @NamedQuery(name = "Employee.findByGuncellenenTar", query = "SELECT e FROM Employee e WHERE e.guncellenenTar = :guncellenenTar"),
    @NamedQuery(name = "Employee.findByDurum", query = "SELECT e FROM Employee e WHERE e.durum = :durum"),
    @NamedQuery(name = "Employee.findByASId", query = "SELECT e FROM Employee e WHERE e.aSId = :aSId"),
    @NamedQuery(name = "Employee.findByAyrilmaTar", query = "SELECT e FROM Employee e WHERE e.ayrilmaTar = :ayrilmaTar"),
    @NamedQuery(name = "Employee.findByTedarikci", query = "SELECT e FROM Employee e WHERE e.tedarikci = :tedarikci"),
    @NamedQuery(name = "Employee.findByKbId", query = "SELECT e FROM Employee e WHERE e.kbId = :kbId"),
    @NamedQuery(name = "Employee.findByIstasyonId", query = "SELECT e FROM Employee e WHERE e.istasyonId = :istasyonId"),
    @NamedQuery(name = "Employee.findByPostaId", query = "SELECT e FROM Employee e WHERE e.postaId = :postaId"),
    @NamedQuery(name = "Employee.findBySkillId", query = "SELECT e FROM Employee e WHERE e.skillId = :skillId"),
    @NamedQuery(name = "Employee.findByKadro", query = "SELECT e FROM Employee e WHERE e.kadro = :kadro"),
    @NamedQuery(name = "Employee.findByIseGirisTar", query = "SELECT e FROM Employee e WHERE e.iseGirisTar = :iseGirisTar"),
    @NamedQuery(name = "Employee.findBySonGorevBastar", query = "SELECT e FROM Employee e WHERE e.sonGorevBastar = :sonGorevBastar"),
    @NamedQuery(name = "Employee.findByLisansNo", query = "SELECT e FROM Employee e WHERE e.lisansNo = :lisansNo"),
    @NamedQuery(name = "Employee.findByLisansBastar", query = "SELECT e FROM Employee e WHERE e.lisansBastar = :lisansBastar"),
    @NamedQuery(name = "Employee.findByLisansBittar", query = "SELECT e FROM Employee e WHERE e.lisansBittar = :lisansBittar"),
    @NamedQuery(name = "Employee.findByKangurubuId", query = "SELECT e FROM Employee e WHERE e.kangurubuId = :kangurubuId"),
    @NamedQuery(name = "Employee.findByEhliyet", query = "SELECT e FROM Employee e WHERE e.ehliyet = :ehliyet"),
    @NamedQuery(name = "Employee.findByApronEhliyet", query = "SELECT e FROM Employee e WHERE e.apronEhliyet = :apronEhliyet"),
    @NamedQuery(name = "Employee.findByCepTel", query = "SELECT e FROM Employee e WHERE e.cepTel = :cepTel"),
    @NamedQuery(name = "Employee.findByEvTel", query = "SELECT e FROM Employee e WHERE e.evTel = :evTel"),
    @NamedQuery(name = "Employee.findByDigerTel", query = "SELECT e FROM Employee e WHERE e.digerTel = :digerTel"),
    @NamedQuery(name = "Employee.findByDahiliTel", query = "SELECT e FROM Employee e WHERE e.dahiliTel = :dahiliTel"),
    @NamedQuery(name = "Employee.findByEMail", query = "SELECT e FROM Employee e WHERE e.eMail = :eMail"),
    @NamedQuery(name = "Employee.findByIngsinvaTar", query = "SELECT e FROM Employee e WHERE e.ingsinvaTar = :ingsinvaTar"),
    @NamedQuery(name = "Employee.findByIngPuan", query = "SELECT e FROM Employee e WHERE e.ingPuan = :ingPuan")})
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Pk_Id")
    private int pkId;
    @Column(name = "TCKimlik")
    private Long tCKimlik;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Sicil")
    private String sicil;
    @Size(max = 50)
    @Column(name = "Soyadi")
    private String soyadi;
    @Size(max = 70)
    @Column(name = "Adi")
    private String adi;
    @Size(max = 50)
    @Column(name = "Baba_Adi")
    private String babaAdi;
    @Size(max = 50)
    @Column(name = "Ana_Adi")
    private String anaAdi;
    @Column(name = "Dogum_Tarihi")
    @Temporal(TemporalType.DATE)
    private Date dogumTarihi;
    @Size(max = 50)
    @Column(name = "Dogum_Yeri")
    private String dogumYeri;
    @Size(max = 50)
    @Column(name = "Medeni_Hali")
    private String medeniHali;
    @Size(max = 550)
    @Column(name = "Adres1")
    private String adres1;
    @Size(max = 150)
    @Column(name = "Adres2")
    private String adres2;
    @Size(max = 150)
    @Column(name = "Bitirdigi_Lise")
    private String bitirdigiLise;
    @Size(max = 150)
    @Column(name = "Lise_Bolum")
    private String liseBolum;
    @Size(max = 150)
    @Column(name = "Bitirdigi_Uni")
    private String bitirdigiUni;
    @Size(max = 150)
    @Column(name = "Uni_Bolum")
    private String uniBolum;
    @Size(max = 50)
    @Column(name = "Sifre")
    private String sifre;
    @Column(name = "Sira_No")
    private Integer siraNo;
    @Size(max = 50)
    @Column(name = "Askerlik_Durumu")
    private String askerlikDurumu;
    @Column(name = "Terhis_Tar")
    @Temporal(TemporalType.DATE)
    private Date terhisTar;
    @Size(max = 20)
    @Column(name = "Cinsiyet")
    private String cinsiyet;
    @Size(max = 6)
    @Column(name = "Kayit_Yapan_Per")
    private String kayitYapanPer;
    @Column(name = "Kayit_Tar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date kayitTar;
    @Size(max = 6)
    @Column(name = "Guncelleyen_per")
    private String guncelleyenper;
    @Column(name = "Guncellenen_Tar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date guncellenenTar;
    @Column(name = "Durum")
    private Boolean durum;
    @Column(name = "AS_Id")
    private Integer aSId;
    @Column(name = "Ayrilma_Tar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ayrilmaTar;
    @Column(name = "Tedarikci")
    private Short tedarikci;
    @Column(name = "Kb_Id")
    private Integer kbId;
    @Column(name = "Istasyon_Id")
    private Short istasyonId;
    @Column(name = "Posta_Id")
    private Short postaId;
    @Column(name = "Skill_Id")
    private Short skillId;
    @Size(max = 50)
    @Column(name = "Kadro")
    private String kadro;
    @Column(name = "Ise_Giris_Tar")
    @Temporal(TemporalType.DATE)
    private Date iseGirisTar;
    @Column(name = "Son_Gorev_Bas_tar")
    @Temporal(TemporalType.DATE)
    private Date sonGorevBastar;
    @Size(max = 10)
    @Column(name = "lisans_No")
    private String lisansNo;
    @Column(name = "lisans_Bastar")
    @Temporal(TemporalType.DATE)
    private Date lisansBastar;
    @Column(name = "lisans_Bittar")
    @Temporal(TemporalType.DATE)
    private Date lisansBittar;
    @Column(name = "Kangurubu_Id")
    private Short kangurubuId;
    @Size(max = 6)
    @Column(name = "Ehliyet")
    private String ehliyet;
    @Size(max = 6)
    @Column(name = "Apron_Ehliyet")
    private String apronEhliyet;
    @Size(max = 50)
    @Column(name = "Cep_Tel")
    private String cepTel;
    @Size(max = 50)
    @Column(name = "Ev_Tel")
    private String evTel;
    @Size(max = 50)
    @Column(name = "Diger_Tel")
    private String digerTel;
    @Size(max = 50)
    @Column(name = "Dahili_Tel")
    private String dahiliTel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 150)
    @Column(name = "E_Mail")
    private String eMail;
    @Column(name = "Ing_sinva_Tar")
    @Temporal(TemporalType.DATE)
    private Date ingsinvaTar;
    @Size(max = 3)
    @Column(name = "Ing_Puan")
    private String ingPuan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private List<EmployeeSkill> employeeSkillList;
    @JoinColumn(name = "Seflik_Id", referencedColumnName = "S_Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Seflik seflikId;
    @JoinColumn(name = "Mudurluk_Id", referencedColumnName = "M_Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Mudurluk mudurlukId;
    @JoinColumn(name = "Loc_Id", referencedColumnName = "Loc_Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Location locId;
    @JoinColumn(name = "Ilce_Id", referencedColumnName = "Ilce_Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ilce ilceId;
    @JoinColumn(name = "Il_Id", referencedColumnName = "I_Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Il ilId;
    @JoinColumn(name = "Gorev_Id", referencedColumnName = "G_Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Gorevler gorevId;
    @JoinColumn(name = "Baskanlik_Id", referencedColumnName = "B_Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Baskanlik baskanlikId;

    public Employee() {
    }

    public Employee(String sicil) {
        this.sicil = sicil;
    }

    public Employee(String sicil, int pkId) {
        this.sicil = sicil;
        this.pkId = pkId;
    }

    public int getPkId() {
        return pkId;
    }

    public void setPkId(int pkId) {
        this.pkId = pkId;
    }

    public Long getTCKimlik() {
        return tCKimlik;
    }

    public void setTCKimlik(Long tCKimlik) {
        this.tCKimlik = tCKimlik;
    }

    public String getSicil() {
        return sicil;
    }

    public void setSicil(String sicil) {
        this.sicil = sicil;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getBabaAdi() {
        return babaAdi;
    }

    public void setBabaAdi(String babaAdi) {
        this.babaAdi = babaAdi;
    }

    public String getAnaAdi() {
        return anaAdi;
    }

    public void setAnaAdi(String anaAdi) {
        this.anaAdi = anaAdi;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getDogumYeri() {
        return dogumYeri;
    }

    public void setDogumYeri(String dogumYeri) {
        this.dogumYeri = dogumYeri;
    }

    public String getMedeniHali() {
        return medeniHali;
    }

    public void setMedeniHali(String medeniHali) {
        this.medeniHali = medeniHali;
    }

    public String getAdres1() {
        return adres1;
    }

    public void setAdres1(String adres1) {
        this.adres1 = adres1;
    }

    public String getAdres2() {
        return adres2;
    }

    public void setAdres2(String adres2) {
        this.adres2 = adres2;
    }

    public String getBitirdigiLise() {
        return bitirdigiLise;
    }

    public void setBitirdigiLise(String bitirdigiLise) {
        this.bitirdigiLise = bitirdigiLise;
    }

    public String getLiseBolum() {
        return liseBolum;
    }

    public void setLiseBolum(String liseBolum) {
        this.liseBolum = liseBolum;
    }

    public String getBitirdigiUni() {
        return bitirdigiUni;
    }

    public void setBitirdigiUni(String bitirdigiUni) {
        this.bitirdigiUni = bitirdigiUni;
    }

    public String getUniBolum() {
        return uniBolum;
    }

    public void setUniBolum(String uniBolum) {
        this.uniBolum = uniBolum;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public Integer getSiraNo() {
        return siraNo;
    }

    public void setSiraNo(Integer siraNo) {
        this.siraNo = siraNo;
    }

    public String getAskerlikDurumu() {
        return askerlikDurumu;
    }

    public void setAskerlikDurumu(String askerlikDurumu) {
        this.askerlikDurumu = askerlikDurumu;
    }

    public Date getTerhisTar() {
        return terhisTar;
    }

    public void setTerhisTar(Date terhisTar) {
        this.terhisTar = terhisTar;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getKayitYapanPer() {
        return kayitYapanPer;
    }

    public void setKayitYapanPer(String kayitYapanPer) {
        this.kayitYapanPer = kayitYapanPer;
    }

    public Date getKayitTar() {
        return kayitTar;
    }

    public void setKayitTar(Date kayitTar) {
        this.kayitTar = kayitTar;
    }

    public String getGuncelleyenper() {
        return guncelleyenper;
    }

    public void setGuncelleyenper(String guncelleyenper) {
        this.guncelleyenper = guncelleyenper;
    }

    public Date getGuncellenenTar() {
        return guncellenenTar;
    }

    public void setGuncellenenTar(Date guncellenenTar) {
        this.guncellenenTar = guncellenenTar;
    }

    public Boolean getDurum() {
        return durum;
    }

    public void setDurum(Boolean durum) {
        this.durum = durum;
    }

    public Integer getASId() {
        return aSId;
    }

    public void setASId(Integer aSId) {
        this.aSId = aSId;
    }

    public Date getAyrilmaTar() {
        return ayrilmaTar;
    }

    public void setAyrilmaTar(Date ayrilmaTar) {
        this.ayrilmaTar = ayrilmaTar;
    }

    public Short getTedarikci() {
        return tedarikci;
    }

    public void setTedarikci(Short tedarikci) {
        this.tedarikci = tedarikci;
    }

    public Integer getKbId() {
        return kbId;
    }

    public void setKbId(Integer kbId) {
        this.kbId = kbId;
    }

    public Short getIstasyonId() {
        return istasyonId;
    }

    public void setIstasyonId(Short istasyonId) {
        this.istasyonId = istasyonId;
    }

    public Short getPostaId() {
        return postaId;
    }

    public void setPostaId(Short postaId) {
        this.postaId = postaId;
    }

    public Short getSkillId() {
        return skillId;
    }

    public void setSkillId(Short skillId) {
        this.skillId = skillId;
    }

    public String getKadro() {
        return kadro;
    }

    public void setKadro(String kadro) {
        this.kadro = kadro;
    }

    public Date getIseGirisTar() {
        return iseGirisTar;
    }

    public void setIseGirisTar(Date iseGirisTar) {
        this.iseGirisTar = iseGirisTar;
    }

    public Date getSonGorevBastar() {
        return sonGorevBastar;
    }

    public void setSonGorevBastar(Date sonGorevBastar) {
        this.sonGorevBastar = sonGorevBastar;
    }

    public String getLisansNo() {
        return lisansNo;
    }

    public void setLisansNo(String lisansNo) {
        this.lisansNo = lisansNo;
    }

    public Date getLisansBastar() {
        return lisansBastar;
    }

    public void setLisansBastar(Date lisansBastar) {
        this.lisansBastar = lisansBastar;
    }

    public Date getLisansBittar() {
        return lisansBittar;
    }

    public void setLisansBittar(Date lisansBittar) {
        this.lisansBittar = lisansBittar;
    }

    public Short getKangurubuId() {
        return kangurubuId;
    }

    public void setKangurubuId(Short kangurubuId) {
        this.kangurubuId = kangurubuId;
    }

    public String getEhliyet() {
        return ehliyet;
    }

    public void setEhliyet(String ehliyet) {
        this.ehliyet = ehliyet;
    }

    public String getApronEhliyet() {
        return apronEhliyet;
    }

    public void setApronEhliyet(String apronEhliyet) {
        this.apronEhliyet = apronEhliyet;
    }

    public String getCepTel() {
        return cepTel;
    }

    public void setCepTel(String cepTel) {
        this.cepTel = cepTel;
    }

    public String getEvTel() {
        return evTel;
    }

    public void setEvTel(String evTel) {
        this.evTel = evTel;
    }

    public String getDigerTel() {
        return digerTel;
    }

    public void setDigerTel(String digerTel) {
        this.digerTel = digerTel;
    }

    public String getDahiliTel() {
        return dahiliTel;
    }

    public void setDahiliTel(String dahiliTel) {
        this.dahiliTel = dahiliTel;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public Date getIngsinvaTar() {
        return ingsinvaTar;
    }

    public void setIngsinvaTar(Date ingsinvaTar) {
        this.ingsinvaTar = ingsinvaTar;
    }

    public String getIngPuan() {
        return ingPuan;
    }

    public void setIngPuan(String ingPuan) {
        this.ingPuan = ingPuan;
    }

    @XmlTransient
    public List<EmployeeSkill> getEmployeeSkillList() {
        return employeeSkillList;
    }

    public void setEmployeeSkillList(List<EmployeeSkill> employeeSkillList) {
        this.employeeSkillList = employeeSkillList;
    }

    public Seflik getSeflikId() {
        return seflikId;
    }

    public void setSeflikId(Seflik seflikId) {
        this.seflikId = seflikId;
    }

    public Mudurluk getMudurlukId() {
        return mudurlukId;
    }

    public void setMudurlukId(Mudurluk mudurlukId) {
        this.mudurlukId = mudurlukId;
    }

    public Location getLocId() {
        return locId;
    }

    public void setLocId(Location locId) {
        this.locId = locId;
    }

    public Ilce getIlceId() {
        return ilceId;
    }

    public void setIlceId(Ilce ilceId) {
        this.ilceId = ilceId;
    }

    public Il getIlId() {
        return ilId;
    }

    public void setIlId(Il ilId) {
        this.ilId = ilId;
    }

    public Gorevler getGorevId() {
        return gorevId;
    }

    public void setGorevId(Gorevler gorevId) {
        this.gorevId = gorevId;
    }

    public Baskanlik getBaskanlikId() {
        return baskanlikId;
    }

    public void setBaskanlikId(Baskanlik baskanlikId) {
        this.baskanlikId = baskanlikId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sicil != null ? sicil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.sicil == null && other.sicil != null) || (this.sicil != null && !this.sicil.equals(other.sicil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.test.mavenproject5.Employee[ sicil=" + sicil + " ]";
    }
    
}
