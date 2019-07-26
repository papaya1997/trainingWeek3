package com.visa.prj.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ticketId")
	private int ticketId;
	
	@Column(name="raiseDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date raiseDate = new Date();
	
	@Column(name="resolvedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date resolvedDate = null;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	@JoinColumn(name="emailEmployee") // FK
  	private Employee employee;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	@JoinColumn(name="emailResolvedBy") //FK
	private Employee resolvedBy;
	
	@Column(name="description", nullable = false, length=100)
	private String description;
	
	@Column(name="resolvedInfo", length=100)
	private String resolvedInfo;
	
	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public Date getRaiseDate() {
		return raiseDate;
	}

	public void setRaiseDate(Date raiseDate) {
		this.raiseDate = raiseDate;
	}


	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee=employee;
	}
	
	public String getResolvedInfo() {
		return resolvedInfo;
	}
	
	public void setResolvedInfo(String resolvedInfo) {
		this.resolvedInfo=resolvedInfo;
	}
	public Date getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(Date resolvedDate) {
		this.resolvedDate = resolvedDate;
	}


	public Employee getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(Employee resolvedBy) {
		this.resolvedBy=resolvedBy;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description=description;
	}
	
	

	
	
}