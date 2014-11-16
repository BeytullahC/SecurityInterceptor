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
@Table(name = "Skill_Master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SkillMaster.findAll", query = "SELECT s FROM SkillMaster s"),
    @NamedQuery(name = "SkillMaster.findBySkillId", query = "SELECT s FROM SkillMaster s WHERE s.skillId = :skillId"),
    @NamedQuery(name = "SkillMaster.findBySkill", query = "SELECT s FROM SkillMaster s WHERE s.skill = :skill"),
    @NamedQuery(name = "SkillMaster.findByCreatedby", query = "SELECT s FROM SkillMaster s WHERE s.createdby = :createdby"),
    @NamedQuery(name = "SkillMaster.findByCreatedDate", query = "SELECT s FROM SkillMaster s WHERE s.createdDate = :createdDate"),
    @NamedQuery(name = "SkillMaster.findByDesciption", query = "SELECT s FROM SkillMaster s WHERE s.desciption = :desciption")})
public class SkillMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Skill_Id")
    private Short skillId;
    @Size(max = 50)
    @Column(name = "Skill")
    private String skill;
    @Size(max = 50)
    @Column(name = "Created_by")
    private String createdby;
    @Column(name = "Created_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 255)
    @Column(name = "Desciption")
    private String desciption;
    @OneToMany(mappedBy = "skillMasterId", fetch = FetchType.LAZY)
    private List<EmployeeSkill> employeeSkillList;

    public SkillMaster() {
    }

    public SkillMaster(Short skillId) {
        this.skillId = skillId;
    }

    public Short getSkillId() {
        return skillId;
    }

    public void setSkillId(Short skillId) {
        this.skillId = skillId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    @XmlTransient
    public List<EmployeeSkill> getEmployeeSkillList() {
        return employeeSkillList;
    }

    public void setEmployeeSkillList(List<EmployeeSkill> employeeSkillList) {
        this.employeeSkillList = employeeSkillList;
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
        if (!(object instanceof SkillMaster)) {
            return false;
        }
        SkillMaster other = (SkillMaster) object;
        if ((this.skillId == null && other.skillId != null) || (this.skillId != null && !this.skillId.equals(other.skillId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.test.mavenproject5.SkillMaster[ skillId=" + skillId + " ]";
    }
    
}
