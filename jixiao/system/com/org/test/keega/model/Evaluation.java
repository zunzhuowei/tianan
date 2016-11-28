package com.org.test.keega.model;

public class Evaluation {
	private int id;
	private int plan_id;
	private String object_id;
	private String mainbody_id;
	private int p0400;
	private String score;
	private String amount;
	private String degree_id;
	private String reasons;
	private String stdScore;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public String getObject_id() {
		return object_id;
	}

	public void setObject_id(String object_id) {
		this.object_id = object_id;
	}

	public String getMainbody_id() {
		return mainbody_id;
	}

	public void setMainbody_id(String mainbody_id) {
		this.mainbody_id = mainbody_id;
	}

	public int getP0400() {
		return p0400;
	}

	public void setP0400(int p0400) {
		this.p0400 = p0400;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDegree_id() {
		return degree_id;
	}

	public void setDegree_id(String degree_id) {
		this.degree_id = degree_id;
	}

	public String getReasons() {
		return reasons;
	}

	public void setReasons(String reasons) {
		this.reasons = reasons;
	}

	public String getStdScore() {
		return stdScore;
	}

	public void setStdScore(String stdScore) {
		this.stdScore = stdScore;
	}

	public Evaluation( int plan_id, String object_id, String mainbody_id, int p0400, String score, String amount,
			String degree_id, String reasons, String stdScore) {
		super();
		this.plan_id = plan_id;
		this.object_id = object_id;
		this.mainbody_id = mainbody_id;
		this.p0400 = p0400;
		this.score = score;
		this.amount = amount;
		this.degree_id = degree_id;
		this.reasons = reasons;
		this.stdScore = stdScore;
	}

	public Evaluation() {
		super();
	}

	@Override
	public String toString() {
		return "Evaluation [id=" + id + ", plan_id=" + plan_id + ", object_id=" + object_id + ", mainbody_id="
				+ mainbody_id + ", p0400=" + p0400 + ", score=" + score + ", amount=" + amount + ", degree_id="
				+ degree_id + ", reasons=" + reasons + ", stdScore=" + stdScore + "]";
	}

}
