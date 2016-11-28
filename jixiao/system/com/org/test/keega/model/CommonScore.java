package com.org.test.keega.model;

public class CommonScore {
	private int id;
	private String object_id;
	private String mainbody_id;
	private String score;
	private String amount;
	private String point_id;
	private String degree_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPoint_id() {
		return point_id;
	}

	public void setPoint_id(String point_id) {
		this.point_id = point_id;
	}

	public String getDegree_id() {
		return degree_id;
	}

	public void setDegree_id(String degree_id) {
		this.degree_id = degree_id;
	}

	public CommonScore(String object_id, String mainbody_id, String score, String amount, String point_id,String degree_id) {
		super();
		this.object_id = object_id;
		this.mainbody_id = mainbody_id;
		this.score = score;
		this.amount = amount;
		this.point_id = point_id;
		this.degree_id = degree_id;
	}

	public CommonScore() {
		super();
	}

	@Override
	public String toString() {
		return "CommonScore [id=" + id + ", object_id=" + object_id + ", mainbody_id=" + mainbody_id + ", score="
				+ score + ", amount=" + amount + ", point_id=" + point_id + ", degree_id=" + degree_id + "]";
	}

}
