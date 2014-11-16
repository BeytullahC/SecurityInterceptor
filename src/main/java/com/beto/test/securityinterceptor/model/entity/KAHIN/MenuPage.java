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
import javax.persistence.Id;
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
@Table(name = "MENU_PAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuPage.findAll", query = "SELECT m FROM MenuPage m"),
    @NamedQuery(name = "MenuPage.findById", query = "SELECT m FROM MenuPage m WHERE m.id = :id"),
    @NamedQuery(name = "MenuPage.findByCreDate", query = "SELECT m FROM MenuPage m WHERE m.creDate = :creDate"),
    @NamedQuery(name = "MenuPage.findByCreUser", query = "SELECT m FROM MenuPage m WHERE m.creUser = :creUser"),
    @NamedQuery(name = "MenuPage.findByPageActivate", query = "SELECT m FROM MenuPage m WHERE m.pageActivate = :pageActivate"),
    @NamedQuery(name = "MenuPage.findByPageExplanation", query = "SELECT m FROM MenuPage m WHERE m.pageExplanation = :pageExplanation"),
    @NamedQuery(name = "MenuPage.findByPageOrderBy", query = "SELECT m FROM MenuPage m WHERE m.pageOrderBy = :pageOrderBy"),
    @NamedQuery(name = "MenuPage.findByPageSource", query = "SELECT m FROM MenuPage m WHERE m.pageSource = :pageSource"),
    @NamedQuery(name = "MenuPage.findByUpdDate", query = "SELECT m FROM MenuPage m WHERE m.updDate = :updDate"),
    @NamedQuery(name = "MenuPage.findByUpdUser", query = "SELECT m FROM MenuPage m WHERE m.updUser = :updUser"),
    @NamedQuery(name = "MenuPage.findByUpperMenu", query = "SELECT m FROM MenuPage m WHERE m.upperMenu = :upperMenu")})
public class MenuPage implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CRE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "CRE_USER")
    private String creUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAGE_ACTIVATE")
    private short pageActivate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PAGE_EXPLANATION")
    private String pageExplanation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAGE_ORDER_BY")
    private short pageOrderBy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PAGE_SOURCE")
    private String pageSource;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UPD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "UPD_USER")
    private String updUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "UPPER_MENU")
    private String upperMenu;

    public MenuPage() {
    }

    public MenuPage(BigDecimal id) {
        this.id = id;
    }

    public MenuPage(BigDecimal id, Date creDate, String creUser, short pageActivate, String pageExplanation, short pageOrderBy, String pageSource, Date updDate, String updUser, String upperMenu) {
        this.id = id;
        this.creDate = creDate;
        this.creUser = creUser;
        this.pageActivate = pageActivate;
        this.pageExplanation = pageExplanation;
        this.pageOrderBy = pageOrderBy;
        this.pageSource = pageSource;
        this.updDate = updDate;
        this.updUser = updUser;
        this.upperMenu = upperMenu;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getCreDate() {
        return creDate;
    }

    public void setCreDate(Date creDate) {
        this.creDate = creDate;
    }

    public String getCreUser() {
        return creUser;
    }

    public void setCreUser(String creUser) {
        this.creUser = creUser;
    }

    public short getPageActivate() {
        return pageActivate;
    }

    public void setPageActivate(short pageActivate) {
        this.pageActivate = pageActivate;
    }

    public String getPageExplanation() {
        return pageExplanation;
    }

    public void setPageExplanation(String pageExplanation) {
        this.pageExplanation = pageExplanation;
    }

    public short getPageOrderBy() {
        return pageOrderBy;
    }

    public void setPageOrderBy(short pageOrderBy) {
        this.pageOrderBy = pageOrderBy;
    }

    public String getPageSource() {
        return pageSource;
    }

    public void setPageSource(String pageSource) {
        this.pageSource = pageSource;
    }

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }

    public String getUpdUser() {
        return updUser;
    }

    public void setUpdUser(String updUser) {
        this.updUser = updUser;
    }

    public String getUpperMenu() {
        return upperMenu;
    }

    public void setUpperMenu(String upperMenu) {
        this.upperMenu = upperMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuPage)) {
            return false;
        }
        MenuPage other = (MenuPage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.test.mavenproject5.MenuPage[ id=" + id + " ]";
    }
    
}
