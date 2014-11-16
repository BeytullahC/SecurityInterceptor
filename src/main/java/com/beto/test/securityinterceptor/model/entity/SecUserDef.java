/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beto.test.securityinterceptor.model.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Belgelerim
 */
@Entity
@Table(name = "sec_user_def", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"username"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecUserDef.findAll", query = "SELECT s FROM SecUserDef s"),
    @NamedQuery(name = "SecUserDef.findById", query = "SELECT s FROM SecUserDef s WHERE s.id = :id"),
    @NamedQuery(name = "SecUserDef.findByAccountExpired", query = "SELECT s FROM SecUserDef s WHERE s.accountExpired = :accountExpired"),
    @NamedQuery(name = "SecUserDef.findByAccountLocked", query = "SELECT s FROM SecUserDef s WHERE s.accountLocked = :accountLocked"),
    @NamedQuery(name = "SecUserDef.findByAccountValid", query = "SELECT s FROM SecUserDef s WHERE s.accountValid = :accountValid"),
    @NamedQuery(name = "SecUserDef.findByEmail", query = "SELECT s FROM SecUserDef s WHERE s.email = :email"),
    @NamedQuery(name = "SecUserDef.findByFirstName", query = "SELECT s FROM SecUserDef s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "SecUserDef.findByLastLoginDate", query = "SELECT s FROM SecUserDef s WHERE s.lastLoginDate = :lastLoginDate"),
    @NamedQuery(name = "SecUserDef.findByLastName", query = "SELECT s FROM SecUserDef s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "SecUserDef.findByLastPwdDate", query = "SELECT s FROM SecUserDef s WHERE s.lastPwdDate = :lastPwdDate"),
    @NamedQuery(name = "SecUserDef.findByLoginTry", query = "SELECT s FROM SecUserDef s WHERE s.loginTry = :loginTry"),
    @NamedQuery(name = "SecUserDef.findByPassword", query = "SELECT s FROM SecUserDef s WHERE s.password = :password"),
    @NamedQuery(name = "SecUserDef.findByPwdExpired", query = "SELECT s FROM SecUserDef s WHERE s.pwdExpired = :pwdExpired"),
    @NamedQuery(name = "SecUserDef.findByUserType", query = "SELECT s FROM SecUserDef s WHERE s.userType = :userType"),
    @NamedQuery(name = "SecUserDef.findByUsername", query = "SELECT s FROM SecUserDef s WHERE s.username = :username")})
public class SecUserDef implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name = "ACCOUNT_EXPIRED")
    private Character accountExpired;
    @Column(name = "ACCOUNT_LOCKED")
    private Character accountLocked;
    @Column(name = "ACCOUNT_VALID")
    private Character accountValid;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "EMAIL", nullable = false, length = 255)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FIRST_NAME", nullable = false, length = 255)
    private String firstName;
    @Column(name = "LAST_LOGIN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LAST_NAME", nullable = false, length = 255)
    private String lastName;
    @Column(name = "LAST_PWD_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastPwdDate;
    @Column(name = "LOGIN_TRY")
    private BigInteger loginTry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Column(name = "PWD_EXPIRED")
    private Character pwdExpired;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "USER_TYPE", nullable = false, length = 255)
    private String userType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username", nullable = false, length = 255)
    private String username;
    @JoinTable(name = "user_roles", joinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "ID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "role", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<SecRoleDef> secRoleDefList;

    public SecUserDef() {
    }

    public SecUserDef(Long id) {
        this.id = id;
    }

    public SecUserDef(Long id, String email, String firstName, String lastName, String password, String userType, String username) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userType = userType;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(Character accountExpired) {
        this.accountExpired = accountExpired;
    }

    public Character getAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(Character accountLocked) {
        this.accountLocked = accountLocked;
    }

    public Character getAccountValid() {
        return accountValid;
    }

    public void setAccountValid(Character accountValid) {
        this.accountValid = accountValid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLastPwdDate() {
        return lastPwdDate;
    }

    public void setLastPwdDate(Date lastPwdDate) {
        this.lastPwdDate = lastPwdDate;
    }

    public BigInteger getLoginTry() {
        return loginTry;
    }

    public void setLoginTry(BigInteger loginTry) {
        this.loginTry = loginTry;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Character getPwdExpired() {
        return pwdExpired;
    }

    public void setPwdExpired(Character pwdExpired) {
        this.pwdExpired = pwdExpired;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlTransient
    public List<SecRoleDef> getSecRoleDefList() {
        return secRoleDefList;
    }

    public void setSecRoleDefList(List<SecRoleDef> secRoleDefList) {
        this.secRoleDefList = secRoleDefList;
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
        if (!(object instanceof SecUserDef)) {
            return false;
        }
        SecUserDef other = (SecUserDef) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        try {
            return "SecUserDef{" + "id=" + id +
            		               ", accountExpired=" + accountExpired +
            		               ", accountLocked=" + accountLocked +
            		               ", accountValid=" + accountValid +
            		               ", email=" + email +
            		               ", firstName=" + firstName +
            		               ", lastLoginDate=" + lastLoginDate +
            		               ", lastName=" + lastName +
            		               ", lastPwdDate=" + lastPwdDate +
            		               ", loginTry=" + loginTry +
            		               ", password=" + password +
            		               ", pwdExpired=" + pwdExpired +
            		               ", userType=" + userType +
            		               ", username=" + username +
            		               ", secRoleDefList=" + secRoleDefList + '}';
        } catch (Exception e) {

        }
        return "NOT FULLL";
    }

}
