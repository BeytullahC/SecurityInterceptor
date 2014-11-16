/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beto.test.securityinterceptor.model.entity.KAHIN;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 912867
 */
@Entity
@Table(name = "MENU_DEF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuDef.findAll", query = "SELECT m FROM MenuDef m"),
    @NamedQuery(name = "MenuDef.findById", query = "SELECT m FROM MenuDef m WHERE m.id = :id"),
    @NamedQuery(name = "MenuDef.findByMenuCode", query = "SELECT m FROM MenuDef m WHERE m.menuCode = :menuCode"),
    @NamedQuery(name = "MenuDef.findByMenuType", query = "SELECT m FROM MenuDef m WHERE m.menuType = :menuType"),
    @NamedQuery(name = "MenuDef.findByOrderCode", query = "SELECT m FROM MenuDef m WHERE m.orderCode = :orderCode")})
public class MenuDef implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MENU_CODE")
    private String menuCode;
    @Size(max = 15)
    @Column(name = "MENU_TYPE")
    private String menuType;
    @Column(name = "ORDER_CODE")
    private Integer orderCode;

    public MenuDef() {
    }

    public MenuDef(Integer id) {
        this.id = id;
    }

    public MenuDef(Integer id, String menuCode) {
        this.id = id;
        this.menuCode = menuCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public Integer getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Integer orderCode) {
        this.orderCode = orderCode;
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
        if (!(object instanceof MenuDef)) {
            return false;
        }
        MenuDef other = (MenuDef) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.test.mavenproject5.MenuDef[ id=" + id + " ]";
    }
    
}
