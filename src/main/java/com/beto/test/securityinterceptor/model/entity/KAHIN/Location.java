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
@Table(name = "Location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findByLocId", query = "SELECT l FROM Location l WHERE l.locId = :locId"),
    @NamedQuery(name = "Location.findByLocation", query = "SELECT l FROM Location l WHERE l.location = :location"),
    @NamedQuery(name = "Location.findByDescription", query = "SELECT l FROM Location l WHERE l.description = :description"),
    @NamedQuery(name = "Location.findByInventory", query = "SELECT l FROM Location l WHERE l.inventory = :inventory"),
    @NamedQuery(name = "Location.findByFacility", query = "SELECT l FROM Location l WHERE l.facility = :facility"),
    @NamedQuery(name = "Location.findByStation", query = "SELECT l FROM Location l WHERE l.station = :station"),
    @NamedQuery(name = "Location.findByQuarantina", query = "SELECT l FROM Location l WHERE l.quarantina = :quarantina"),
    @NamedQuery(name = "Location.findByLibrary", query = "SELECT l FROM Location l WHERE l.library = :library"),
    @NamedQuery(name = "Location.findByCreatedBy", query = "SELECT l FROM Location l WHERE l.createdBy = :createdBy"),
    @NamedQuery(name = "Location.findByCreatedDate", query = "SELECT l FROM Location l WHERE l.createdDate = :createdDate")})
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Loc_Id")
    private Short locId;
    @Size(max = 50)
    @Column(name = "Location")
    private String location;
    @Size(max = 150)
    @Column(name = "Description")
    private String description;
    @Column(name = "Inventory")
    private Boolean inventory;
    @Column(name = "Facility")
    private Boolean facility;
    @Column(name = "Station")
    private Boolean station;
    @Column(name = "Quarantina")
    private Boolean quarantina;
    @Column(name = "Library")
    private Boolean library;
    @Size(max = 50)
    @Column(name = "Created_By")
    private String createdBy;
    @Column(name = "Created_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @OneToMany(mappedBy = "locId", fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    public Location() {
    }

    public Location(Short locId) {
        this.locId = locId;
    }

    public Short getLocId() {
        return locId;
    }

    public void setLocId(Short locId) {
        this.locId = locId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getInventory() {
        return inventory;
    }

    public void setInventory(Boolean inventory) {
        this.inventory = inventory;
    }

    public Boolean getFacility() {
        return facility;
    }

    public void setFacility(Boolean facility) {
        this.facility = facility;
    }

    public Boolean getStation() {
        return station;
    }

    public void setStation(Boolean station) {
        this.station = station;
    }

    public Boolean getQuarantina() {
        return quarantina;
    }

    public void setQuarantina(Boolean quarantina) {
        this.quarantina = quarantina;
    }

    public Boolean getLibrary() {
        return library;
    }

    public void setLibrary(Boolean library) {
        this.library = library;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
        hash += (locId != null ? locId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.locId == null && other.locId != null) || (this.locId != null && !this.locId.equals(other.locId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.test.mavenproject5.Location[ locId=" + locId + " ]";
    }
    
}
