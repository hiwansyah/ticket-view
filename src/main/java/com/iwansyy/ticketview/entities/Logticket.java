/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iwansyy.ticketview.entities;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iwansy
 */

@Entity
@Table(name = "logticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logticket.findAll", query = "SELECT l FROM Logticket l")
    , @NamedQuery(name = "Logticket.findByLogticketId", query = "SELECT l FROM Logticket l WHERE l.logticketId = :logticketId")
    , @NamedQuery(name = "Logticket.findByAction", query = "SELECT l FROM Logticket l WHERE l.action = :action")
    , @NamedQuery(name = "Logticket.findByDescription", query = "SELECT l FROM Logticket l WHERE l.description = :description")
    , @NamedQuery(name = "Logticket.findByChangeDate", query = "SELECT l FROM Logticket l WHERE l.changeDate = :changeDate")})
public class Logticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "logticket_id")
    private String logticketId;
    @Basic(optional = false)
    @Column(name = "action")
    private String action;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Column(name = "change_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date changeDate;
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ticket ticketId;
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status statusId;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employeeId;

    public Logticket() {
    }

    public Logticket(String logticketId) {
        this.logticketId = logticketId;
    }

    public Logticket(String logticketId, String action, String description) {
        this.logticketId = logticketId;
        this.action = action;
        this.description = description;
    }

    public String getLogticketId() {
        return logticketId;
    }

    public void setLogticketId(String logticketId) {
        this.logticketId = logticketId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public Ticket getTicketId() {
        return ticketId;
    }

    public void setTicketId(Ticket ticketId) {
        this.ticketId = ticketId;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logticketId != null ? logticketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logticket)) {
            return false;
        }
        Logticket other = (Logticket) object;
        if ((this.logticketId == null && other.logticketId != null) || (this.logticketId != null && !this.logticketId.equals(other.logticketId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iwansyy.ticketview.entities.Logticket[ logticketId=" + logticketId + " ]";
    }
    
}
