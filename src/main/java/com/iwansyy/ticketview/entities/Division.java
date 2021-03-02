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
@Table(name = "division")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Division.findAll", query = "SELECT d FROM Division d")
    , @NamedQuery(name = "Division.findByDivisionId", query = "SELECT d FROM Division d WHERE d.divisionId = :divisionId")
    , @NamedQuery(name = "Division.findByDivisionName", query = "SELECT d FROM Division d WHERE d.divisionName = :divisionName")})
public class Division implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "division_id")
    private String divisionId;
    @Column(name = "division_name")
    private String divisionName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "divisionId", fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    public Division() {
    }

    public Division(String divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(String divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
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
        hash += (divisionId != null ? divisionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Division)) {
            return false;
        }
        Division other = (Division) object;
        if ((this.divisionId == null && other.divisionId != null) || (this.divisionId != null && !this.divisionId.equals(other.divisionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iwansyy.ticketview.entities.Division[ divisionId=" + divisionId + " ]";
    }
    
}
