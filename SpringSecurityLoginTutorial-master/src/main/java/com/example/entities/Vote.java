package com.example.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vote implements Serializable {

	private static final long serialVersionUID = 7502750480982621809L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vote_id")
	private long voteId;

	@Column(name = "p_id")
	private long pId;

	@Column(name = "s_id")
	private long sId;

	@Column(name = "user_id")
	private long userId;

	public long getVoteId() {
		return voteId;
	}

	public void setVoteId(long voteId) {
		this.voteId = voteId;
	}

	public long getpId() {
		return pId;
	}

	public void setpId(long pId) {
		this.pId = pId;
	}

	public long getsId() {
		return sId;
	}

	public void setsId(long sId) {
		this.sId = sId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Vote() {
		super();
	}

	/*public Vote(long pId, long sId, long userId) {
		this.pId = pId;
		this.sId = sId;
		this.userId = userId;
	}*/

	public Vote(long voteId, long pId, long sId, long userId) {
		super();
		this.voteId = voteId;
		this.pId = pId;
		this.sId = sId;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Vote [voteId=" + voteId + ", pId=" + pId + ", sId=" + sId + ", userId=" + userId + "]";
	}

}
