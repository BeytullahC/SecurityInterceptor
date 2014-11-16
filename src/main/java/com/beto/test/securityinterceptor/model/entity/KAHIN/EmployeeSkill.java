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
@Table(name = "Employee_Skill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeSkill.findAll", query = "SELECT e FROM EmployeeSkill e"),
    @NamedQuery(name = "EmployeeSkill.findBySkillId", query = "SELECT e FROM EmployeeSkill e WHERE e.skillId = :skillId"),
    @NamedQuery(name = "EmployeeSkill.findByCreatedBy", query = "SELECT e FROM EmployeeSkill e WHERE e.createdBy = :createdBy"),
    @NamedQuery(name = "EmployeeSkill.findByCreatedDate", query = "SELECT e FROM EmployeeSkill e WHERE e.createdDate = :createdDate"),
    @NamedQuery(name = "EmployeeSkill.findByUpdatedBy", query = "SELECT e FROM EmployeeSkill e WHERE e.updatedBy = :updatedBy"),
    @NamedQuery(name = "EmployeeSkill.findByUpdatedDate", query = "SELECT e FROM EmployeeSkill e WHERE e.updatedDate = :updatedDate")})
public class EmployeeSkill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Skill_Id")
    private Integer skillId;
    @Size(max = 10)
    @Column(name = "Created_By")
    private String createdBy;
    @Column(name = "Created_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 10)
    @Column(name = "Updated_By")
    private String updatedBy;
    @Size(max = 10)
    @Column(name = "Updated_Date")
    private String updatedDate;
    @JoinColumn(name = "Skill_MasterId", referencedColumnName = "Skill_Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private SkillMaster skillMasterId;
    @JoinColumn(name = "Employee", referencedColumnName = "Sicil")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;

    public EmployeeSkill() {
    }

    public EmployeeSkill(Integer skillId) {
        this.skillId = skillId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
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

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public SkillMaster getSkillMasterId() {
        return skillMasterId;
    }

    public void setSkillMasterId(SkillMaster skillMasterId) {
        this.skillMasterId = skillMasterId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skillId != null ? skillId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeSkill)) {
            return false;
        }
        EmployeeSkill other = (EmployeeSkill) object;
        if ((this.skillId == null && other.skillId != null) || (this.skillId != null && !this.skillId.equals(other.skillId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.test.mavenproject5.EmployeeSkill[ skillId=" + skillId + " ]";
    }
    
}
