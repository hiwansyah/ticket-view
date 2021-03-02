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
@Table(name = "status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s")
    , @NamedQuery(name = "Status.findByStatusId", query = "SELECT s FROM Status s WHERE s.statusId = :statusId")
    , @NamedQuery(name = "Status.findByStatusName", query = "SELECT s FROM Status s WHERE s.statusName = :statusName")})
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "status_id")
    private String statusId;
    @Column(name = "status_name")
    private String statusName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusId", fetch = FetchType.LAZY)
    private List<Ticket> ticketList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusId", fetch = FetchType.LAZY)
    private List<Logticket> logticketList;

    public Status() {
    }

    public Status(String statusId) {
        this.statusId = statusId;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusId != null ? statusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.statusId == null && other.statusId != null) || (this.statusId != null && !this.statusId.equals(other.statusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iwansyy.ticketview.entities.Status[ statusId=" + statusId + " ]";
    }
    
}
