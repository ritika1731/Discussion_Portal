package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PVote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "id_type")
	private String idType;

	@Column(name = "user_id")
	private long userId;

	@Column(name = "is_vote")
	private boolean isVote;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public boolean isVote() {
		return isVote;
	}

	public void setVote(boolean isVote) {
		this.isVote = isVote;
	}

	public PVote() {
		super();
	}

	public PVote(long id, String idType, long userId, boolean isVote) {
		super();
		this.id = id;
		this.idType = idType;
		this.userId = userId;
		this.isVote = isVote;
	}

	@Override
	public String toString() {
		return "Vote [id=" + id + ", idType=" + idType + ", userId=" + userId + ", isVote=" + isVote + "]";
	}

}
