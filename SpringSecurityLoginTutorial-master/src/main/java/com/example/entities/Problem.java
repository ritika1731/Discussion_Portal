package com.example.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Problem implements Serializable{
	
	private static final long serialVersionUID = -8311263678494125976L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="p_id")
	private long pId;
	
	@Column(name="emp_id")
	private long empId;
	
	@Column(name="p_description")
	private String pDescription;
	
	@Column(name="p_start_date")
	Date sDate;
	
	@Column(name="p_end_date")
	Date eDate;
	
	@Column(name="p_content")
	private String pContent;

	public long getpId() {
		return pId;
	}

	public void setpId(long pId) {
		this.pId = pId;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}


	@Override
	public String toString() {
		return "Problem [pId=" + pId + ", empId=" + empId + ", pDescription=" + pDescription + ", sDate=" + sDate
				+ ", eDate=" + eDate + ", pContent=" + pContent + "]";
	}
	
}
