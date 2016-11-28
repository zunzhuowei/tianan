package com.org.test.keega.model;

/**
 * 未使用---旨在存 通用类指标
 * 
 * @author zhuozun.wei
 * @createDate 2016年8月30日--下午4:35:09
 */
public class Common {
	private String point_id;
	private String pointname;
	private String description;
	private String rank;

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getPoint_id() {
		return point_id;
	}

	public void setPoint_id(String point_id) {
		this.point_id = point_id;
	}

	public String getPointname() {
		return pointname;
	}

	public void setPointname(String pointname) {
		this.pointname = pointname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Common(String point_id, String pointname, String description, String rank) {
		super();
		this.point_id = point_id;
		this.pointname = pointname;
		this.description = description;
		this.rank = rank;
	}

	public Common() {
	}

	@Override
	public String toString() {
		return "Common [point_id=" + point_id + ", pointname=" + pointname + ", description=" + description + ", rank="
				+ rank + "]";
	}

}
