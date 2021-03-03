/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iwansyy.ticketview.entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author iwansy
 */

@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByEmployeeId", query = "SELECT e FROM Employee e WHERE e.employeeId = :employeeId")
    , @NamedQuery(name = "Employee.findByEmployeeName", query = "SELECT e FROM Employee e WHERE e.employeeName = :employeeName")
    , @NamedQuery(name = "Employee.findByPassword", query = "SELECT e FROM Employee e WHERE e.password = :password")
    , @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "employee_id")
    private String employeeId;
    @Column(name = "employee_name")
    private String employeeName;
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId", fetch = FetchType.LAZY)
    private List<Ticket> ticketList;
    @OneToMany(mappedBy = "employeeId", fetch = FetchType.LAZY)
    private List<Logticket> logticketList;
    @JoinColumn(name = "position_id", referencedColumnName = "position_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Positions positionId;
    @JoinColumn(name = "division_id", referencedColumnName = "division_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Division divisionId;

    public Employee() {
    }
//
//    public Employee(String employeeId, String employeeName, String password) {
//        this.employeeId = employeeId;
//        this.employeeName = employeeName;
//        this.password = password;
//    }
    

    public Employee(String employeeId) {
        this.employeeId = employeeId;
    }

    public Employee(String employeeId, String email) {
        this.employeeId = employeeId;
        this.email = email;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @XmlTransient
    public List<Logticket> getLogticketList() {
        return logticketList;
    }

    public void setLogticketList(List<Logticket> logticketList) {
        this.logticketList = logticketList;
    }

    public Positions getPositionId() {
        return positionId;
    }

    public void setPositionId(Positions positionId) {
        this.positionId = positionId;
    }

    public Division getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Division divisionId) {
        this.divisionId = divisionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iwansyy.ticketview.entities.Employee[ employeeId=" + employeeId + " ]";
    }
    
}
