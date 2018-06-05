package com.example.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Idea {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_id")
	long iId;
	
	@Column(name="emp_id")
	long empId;
	
	@Column(name="i_description")
	String iDescription;
	
	@Column(name="i_start_date")
	Date iStartDate;
	
	@Column(name="i_end_date")
	Date iEndDate;
	
	@Column(name="i_content")
	String iContent;

	public long getiId() {
		return iId;
	}

	public void setiId(long iId) {
		this.iId = iId;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getiDescription() {
		return iDescription;
	}

	public void setiDescription(String iDescription) {
		this.iDescription = iDescription;
	}

	public Date getiStartDate() {
		return iStartDate;
	}

	public void setiStartDate(Date iStartDate) {
		this.iStartDate = iStartDate;
	}

	public Date getiEndDate() {
		return iEndDate;
	}

	public void setiEndDate(Date iEndDate) {
		this.iEndDate = iEndDate;
	}

	public String getiContent() {
		return iContent;
	}

	public void setiContent(String iContent) {
		this.iContent = iContent;
	}

	@Override
	public String toString() {
		return "Idea [iId=" + iId + ", empId=" + empId + ", iDescription=" + iDescription + ", iStartDate=" + iStartDate
				+ ", iEndDate=" + iEndDate + ", iContent=" + iContent + "]";
	}
	
	
	
}
