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
@Table(name = "services")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Services.findAll", query = "SELECT s FROM Services s")
    , @NamedQuery(name = "Services.findByServicesId", query = "SELECT s FROM Services s WHERE s.servicesId = :servicesId")
    , @NamedQuery(name = "Services.findByServicesName", query = "SELECT s FROM Services s WHERE s.servicesName = :servicesName")})
public class Services implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "services_id")
    private String servicesId;
    @Basic(optional = false)
    @Column(name = "services_name")
    private String servicesName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicesId", fetch = FetchType.LAZY)
    private List<Issue> issueList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicesId", fetch = FetchType.LAZY)
    private List<Ticket> ticketList;

    public Services() {
    }

    public Services(String servicesId) {
        this.servicesId = servicesId;
    }

    public Services(String servicesId, String servicesName) {
        this.servicesId = servicesId;
        this.servicesName = servicesName;
    }

    public String getServicesId() {
        return servicesId;
    }

    public void setServicesId(String servicesId) {
        this.servicesId = servicesId;
    }

    public String getServicesName() {
        return servicesName;
    }

    public void setServicesName(String servicesName) {
        this.servicesName = servicesName;
    }

    @XmlTransient
    public List<Issue> getIssueList() {
        return issueList;
    }

    public void setIssueList(List<Issue> issueList) {
        this.issueList = issueList;
    }

    @XmlTransient
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicesId != null ? servicesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Services)) {
            return false;
        }
        Services other = (Services) object;
        if ((this.servicesId == null && other.servicesId != null) || (this.servicesId != null && !this.servicesId.equals(other.servicesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iwansyy.ticketview.entities.Services[ servicesId=" + servicesId + " ]";
    }
    
}
