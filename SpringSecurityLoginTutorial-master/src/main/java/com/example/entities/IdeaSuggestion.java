package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IdeaSuggestion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="siId")
	long siId;
	
	@Column(name="empId")
	long empId;
	
	@Column(name="iId")
	long iId;
	
	@Column(name="siDescription")
	String siDescription;
	
	@Column(name="siContent")
	String siContent;
	
	@Column(name="voteCount")
	String vCount;

	public long getSiId() {
		return siId;
	}

	public void setSiId(long siId) {
		this.siId = siId;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public long getiId() {
		return iId;
	}

	public void setiId(long iId) {
		this.iId = iId;
	}

	public String getSiDescription() {
		return siDescription;
	}

	public void setSiDescription(String siDescription) {
		this.siDescription = siDescription;
	}

	public String getSiContent() {
		return siContent;
	}

	public void setSiContent(String siContent) {
		this.siContent = siContent;
	}

	public String getvCount() {
		return vCount;
	}

	public void setvCount(String vCount) {
		this.vCount = vCount;
	}

	@Override
	public String toString() {
		return "IdeaSuggestion [siId=" + siId + ", empId=" + empId + ", iId=" + iId + ", siDescription=" + siDescription
				+ ", siContent=" + siContent + ", vCount=" + vCount + "]";
	}
	
	
}
