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
@Table(name = "priority")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Priority.findAll", query = "SELECT p FROM Priority p")
    , @NamedQuery(name = "Priority.findByPriorityId", query = "SELECT p FROM Priority p WHERE p.priorityId = :priorityId")
    , @NamedQuery(name = "Priority.findByPriorityName", query = "SELECT p FROM Priority p WHERE p.priorityName = :priorityName")
    , @NamedQuery(name = "Priority.findByResponseTime", query = "SELECT p FROM Priority p WHERE p.responseTime = :responseTime")
    , @NamedQuery(name = "Priority.findByResolveTime", query = "SELECT p FROM Priority p WHERE p.resolveTime = :resolveTime")})
public class Priority implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "priority_id")
    private String priorityId;
    @Column(name = "priority_name")
    private String priorityName;
    @Column(name = "response_time")
    private Integer responseTime;
    @Column(name = "resolve_time")
    private Integer resolveTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "priorityId", fetch = FetchType.LAZY)
    private List<Issue> issueList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "priorityId", fetch = FetchType.LAZY)
    private List<Ticket> ticketList;

    public Priority(String priorityName, Integer responseTime, Integer resolveTime) {
        this.priorityName = priorityName;
        this.responseTime = responseTime;
        this.resolveTime = resolveTime;
    }

    
    
    public Priority() {
    }

    public Priority(String priorityId) {
        this.priorityId = priorityId;
    }

    public String getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(String priorityId) {
        this.priorityId = priorityId;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    public Integer getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Integer responseTime) {
        this.responseTime = responseTime;
    }

    public Integer getResolveTime() {
        return resolveTime;
    }

    public void setResolveTime(Integer resolveTime) {
        this.resolveTime = resolveTime;
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
        hash += (priorityId != null ? priorityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Priority)) {
            return false;
        }
        Priority other = (Priority) object;
        if ((this.priorityId == null && other.priorityId != null) || (this.priorityId != null && !this.priorityId.equals(other.priorityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iwansyy.ticketview.entities.Priority[ priorityId=" + priorityId + " ]";
    }
    
}
