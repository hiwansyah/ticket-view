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
@Table(name = "positions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Positions.findAll", query = "SELECT p FROM Positions p")
    , @NamedQuery(name = "Positions.findByPositionId", query = "SELECT p FROM Positions p WHERE p.positionId = :positionId")
    , @NamedQuery(name = "Positions.findByPositionName", query = "SELECT p FROM Positions p WHERE p.positionName = :positionName")})
public class Positions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "position_id")
    private String positionId;
    @Column(name = "position_name")
    private String positionName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "positionId", fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    public Positions() {
    }

    public Positions(String positionId) {
        this.positionId = positionId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
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
        hash += (positionId != null ? positionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Positions)) {
            return false;
        }
        Positions other = (Positions) object;
        if ((this.positionId == null && other.positionId != null) || (this.positionId != null && !this.positionId.equals(other.positionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iwansyy.ticketview.entities.Positions[ positionId=" + positionId + " ]";
    }
    
}
