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
@Table(name = "issue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Issue.findAll", query = "SELECT i FROM Issue i")
    , @NamedQuery(name = "Issue.findByIssueId", query = "SELECT i FROM Issue i WHERE i.issueId = :issueId")
    , @NamedQuery(name = "Issue.findByIssue", query = "SELECT i FROM Issue i WHERE i.issue = :issue")})
public class Issue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "issue_id")
    private String issueId;
    @Basic(optional = false)
    @Column(name = "issue")
    private String issue;
    @JoinColumn(name = "services_id", referencedColumnName = "services_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Services servicesId;
    @JoinColumn(name = "priority_id", referencedColumnName = "priority_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Priority priorityId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "issueId", fetch = FetchType.LAZY)
    private List<Ticket> ticketList;

    public Issue() {
    }

    public Issue(String issueId, String issue, Services servicesId) {
        this.issueId = issueId;
        this.issue = issue;
        this.servicesId = servicesId;
    }

    public Issue(String issueId) {
        this.issueId = issueId;
    }

    public Issue(String issueId, String issue) {
        this.issueId = issueId;
        this.issue = issue;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public Services getServicesId() {
        return servicesId;
    }

    public void setServicesId(Services servicesId) {
        this.servicesId = servicesId;
    }

    public Priority getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Priority priorityId) {
        this.priorityId = priorityId;
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
        hash += (issueId != null ? issueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Issue)) {
            return false;
        }
        Issue other = (Issue) object;
        if ((this.issueId == null && other.issueId != null) || (this.issueId != null && !this.issueId.equals(other.issueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iwansyy.ticketview.entities.Issue[ issueId=" + issueId + " ]";
    }
    
}
