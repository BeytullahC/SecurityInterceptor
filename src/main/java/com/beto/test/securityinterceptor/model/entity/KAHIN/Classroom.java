/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beto.test.securityinterceptor.model.entity.KAHIN;
import java.io.Serializable;
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
@Table(name = "Classroom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classroom.findAll", query = "SELECT c FROM Classroom c"),
    @NamedQuery(name = "Classroom.findByClassId", query = "SELECT c FROM Classroom c WHERE c.classId = :classId"),
    @NamedQuery(name = "Classroom.findByClassroom", query = "SELECT c FROM Classroom c WHERE c.classroom = :classroom"),
    @NamedQuery(name = "Classroom.findByDescription", query = "SELECT c FROM Classroom c WHERE c.description = :description"),
    @NamedQuery(name = "Classroom.findByCapacitiy", query = "SELECT c FROM Classroom c WHERE c.capacitiy = :capacitiy"),
    @NamedQuery(name = "Classroom.findByAuthority", query = "SELECT c FROM Classroom c WHERE c.authority = :authority"),
    @NamedQuery(name = "Classroom.findByProjektor", query = "SELECT c FROM Classroom c WHERE c.projektor = :projektor"),
    @NamedQuery(name = "Classroom.findByInternet", query = "SELECT c FROM Classroom c WHERE c.internet = :internet"),
    @NamedQuery(name = "Classroom.findByWhiteBoard", query = "SELECT c FROM Classroom c WHERE c.whiteBoard = :whiteBoard"),
    @NamedQuery(name = "Classroom.findByPhone", query = "SELECT c FROM Classroom c WHERE c.phone = :phone"),
    @NamedQuery(name = "Classroom.findByCreatedBy", query = "SELECT c FROM Classroom c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "Classroom.findByCreatedDate", query = "SELECT c FROM Classroom c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "Classroom.findByUpdatedBy", query = "SELECT c FROM Classroom c WHERE c.updatedBy = :updatedBy"),
    @NamedQuery(name = "Classroom.findByUpdatedDate", query = "SELECT c FROM Classroom c WHERE c.updatedDate = :updatedDate")})
public class Classroom implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Class_Id")
    private Short classId;
    @Size(max = 50)
    @Column(name = "Classroom")
    private String classroom;
    @Size(max = 150)
    @Column(name = "Description")
    private String description;
    @Column(name = "Capacitiy")
    private Integer capacitiy;
    @Size(max = 150)
    @Column(name = "Authority")
    private String authority;
    @Size(max = 50)
    @Column(name = "Projektor")
    private String projektor;
    @Column(name = "Internet")
    private Boolean internet;
    @Column(name = "WhiteBoard")
    private Boolean whiteBoard;
    @Column(name = "Phone")
    private Boolean phone;
    @Size(max = 50)
    @Column(name = "Created_By")
    private String createdBy;
    @Column(name = "Created_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 50)
    @Column(name = "Updated_By")
    private String updatedBy;
    @Column(name = "Updated_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    public Classroom() {
    }

    public Classroom(Short classId) {
        this.classId = classId;
    }

    public Short getClassId() {
        return classId;
    }

    public void setClassId(Short classId) {
        this.classId = classId;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCapacitiy() {
        return capacitiy;
    }

    public void setCapacitiy(Integer capacitiy) {
        this.capacitiy = capacitiy;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getProjektor() {
        return projektor;
    }

    public void setProjektor(String projektor) {
        this.projektor = projektor;
    }

    public Boolean getInternet() {
        return internet;
    }

    public void setInternet(Boolean internet) {
        this.internet = internet;
    }

    public Boolean getWhiteBoard() {
        return whiteBoard;
    }

    public void setWhiteBoard(Boolean whiteBoard) {
        this.whiteBoard = whiteBoard;
    }

    public Boolean getPhone() {
        return phone;
    }

    public void setPhone(Boolean phone) {
        this.phone = phone;
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

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classId != null ? classId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classroom)) {
            return false;
        }
        Classroom other = (Classroom) object;
        if ((this.classId == null && other.classId != null) || (this.classId != null && !this.classId.equals(other.classId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.test.mavenproject5.Classroom[ classId=" + classId + " ]";
    }
    
}
