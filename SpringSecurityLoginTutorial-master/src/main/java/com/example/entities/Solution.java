package com.example.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.internal.NotNull;

@Entity
public class Solution implements Serializable {
	private static final long serialVersionUID = -2076020035785157855L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sId")
	long sId;
	@Column(name = "empId")
	@NotNull
	long empId;
	@Column(name = "pId")
	@NotNull
	long pId;
	@Column(name = "sDescription")
	@NotNull
	String sDescription;
	@Column(name = "sContent")
	@NotNull
	String sContent;
	@Column(name = "sLink")
	@NotNull
	String sLink;
	@Column(name = "voteCount")
	String vCount;

	public long getsId() {
		return sId;
	}

	public void setsId(long sId) {
		this.sId = sId;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public long getpId() {
		return pId;
	}

	public void setpId(long pId) {
		this.pId = pId;
	}

	public String getsDescription() {
		return sDescription;
	}

	public void setsDescription(String sDescription) {
		this.sDescription = sDescription;
	}

	public String getsContent() {
		return sContent;
	}

	public void setsContent(String sContent) {
		this.sContent = sContent;
	}

	public String getsLink() {
		return sLink;
	}

	public void setsLink(String sLink) {
		this.sLink = sLink;
	}

	public String getvCount() {
		return vCount;
	}

	public void setvCount(String vCount) {
		this.vCount = vCount;
	}

	@Override
	public String toString() {
		return "Solution [sId=" + sId + ", empId=" + empId + ", pId=" + pId + ", sDescription=" + sDescription
				+ ", sContent=" + sContent + ", sLink=" + sLink + ", vCount=" + vCount + "]";
	}

}
