/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iwansyy.ticketview.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author iwansy
 */

@Entity
@Table(name = "ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")
    , @NamedQuery(name = "Ticket.findByTicketId", query = "SELECT t FROM Ticket t WHERE t.ticketId = :ticketId")
    , @NamedQuery(name = "Ticket.findBySubject", query = "SELECT t FROM Ticket t WHERE t.subject = :subject")
    , @NamedQuery(name = "Ticket.findByDescriptions", query = "SELECT t FROM Ticket t WHERE t.descriptions = :descriptions")
    , @NamedQuery(name = "Ticket.findByRequestName", query = "SELECT t FROM Ticket t WHERE t.requestName = :requestName")
    , @NamedQuery(name = "Ticket.findByEmailRequest", query = "SELECT t FROM Ticket t WHERE t.emailRequest = :emailRequest")
    , @NamedQuery(name = "Ticket.findByRegisDate", query = "SELECT t FROM Ticket t WHERE t.regisDate = :regisDate")
    , @NamedQuery(name = "Ticket.findByAssignTo", query = "SELECT t FROM Ticket t WHERE t.assignTo = :assignTo")
    , @NamedQuery(name = "Ticket.findByDueDate", query = "SELECT t FROM Ticket t WHERE t.dueDate = :dueDate")
    , @NamedQuery(name = "Ticket.findByNoteAdd", query = "SELECT t FROM Ticket t WHERE t.noteAdd = :noteAdd")
    , @NamedQuery(name = "Ticket.findByResponseTime", query = "SELECT t FROM Ticket t WHERE t.responseTime = :responseTime")
    , @NamedQuery(name = "Ticket.findByResolutionTime", query = "SELECT t FROM Ticket t WHERE t.resolutionTime = :resolutionTime")
    , @NamedQuery(name = "Ticket.findByResolveTime", query = "SELECT t FROM Ticket t WHERE t.resolveTime = :resolveTime")
    , @NamedQuery(name = "Ticket.findByChangeDate", query = "SELECT t FROM Ticket t WHERE t.changeDate = :changeDate")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ticket_id")
    private String ticketId;
    @Basic(optional = false)
    @Column(name = "subject")
    private String subject;
    @Basic(optional = false)
    @Column(name = "descriptions")
    private String descriptions;
    @Basic(optional = false)
    @Column(name = "request_name")
    private String requestName;
    @Basic(optional = false)
    @Column(name = "email_request")
    private String emailRequest;
    @Column(name = "regis_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regisDate;
    @Basic(optional = false)
    @Column(name = "assign_to")
    private String assignTo;
    @Column(name = "due_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Basic(optional = false)
    @Column(name = "note_add")
    private String noteAdd;
    @Column(name = "response_time")
    private Integer responseTime;
    @Column(name = "resolution_time")
    private Integer resolutionTime;
    @Column(name = "resolve_time")
    private Integer resolveTime;
    @Column(name = "change_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date changeDate;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employeeId;
    @JoinColumn(name = "services_id", referencedColumnName = "services_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Services servicesId;
    @JoinColumn(name = "issue_id", referencedColumnName = "issue_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Issue issueId;
    @JoinColumn(name = "priority_id", referencedColumnName = "priority_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Priority priorityId;
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status statusId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketId", fetch = FetchType.LAZY)
    private List<Logticket> logticketList;

    public Ticket() {
    }

    public Ticket(String ticketId) {
        this.ticketId = ticketId;
    }

    public Ticket(String ticketId, String subject, String descriptions, String requestName, String emailRequest, String assignTo, String noteAdd) {
        this.ticketId = ticketId;
        this.subject = subject;
        this.descriptions = descriptions;
        this.requestName = requestName;
        this.emailRequest = emailRequest;
        this.assignTo = assignTo;
        this.noteAdd = noteAdd;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getEmailRequest() {
        return emailRequest;
    }

    public void setEmailRequest(String emailRequest) {
        this.emailRequest = emailRequest;
    }

    public Date getRegisDate() {
        return regisDate;
    }

    public void setRegisDate(Date regisDate) {
        this.regisDate = regisDate;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getNoteAdd() {
        return noteAdd;
    }

    public void setNoteAdd(String noteAdd) {
        this.noteAdd = noteAdd;
    }

    public Integer getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Integer responseTime) {
        this.responseTime = responseTime;
    }

    public Integer getResolutionTime() {
        return resolutionTime;
    }

    public void setResolutionTime(Integer resolutionTime) {
        this.resolutionTime = resolutionTime;
    }

    public Integer getResolveTime() {
        return resolveTime;
    }

    public void setResolveTime(Integer resolveTime) {
        this.resolveTime = resolveTime;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Services getServicesId() {
        return servicesId;
    }

    public void setServicesId(Services servicesId) {
        this.servicesId = servicesId;
    }

    public Issue getIssueId() {
        return issueId;
    }

    public void setIssueId(Issue issueId) {
        this.issueId = issueId;
    }

    public Priority getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Priority priorityId) {
        this.priorityId = priorityId;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
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
        hash += (ticketId != null ? ticketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.ticketId == null && other.ticketId != null) || (this.ticketId != null && !this.ticketId.equals(other.ticketId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iwansyy.ticketview.entities.Ticket[ ticketId=" + ticketId + " ]";
    }
    
}
