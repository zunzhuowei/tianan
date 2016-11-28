package com.org.test.keega.model;

public class Common2Desc {
	private String point_id;
	private String pointname;
	private String rank;
	private String desc1;
	private String desc2;
	private String desc3;
	private String desc4;

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

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getDesc1() {
		return desc1;
	}

	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}

	public String getDesc2() {
		return desc2;
	}

	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}

	public String getDesc3() {
		return desc3;
	}

	public void setDesc3(String desc3) {
		this.desc3 = desc3;
	}

	public String getDesc4() {
		return desc4;
	}

	public void setDesc4(String desc4) {
		this.desc4 = desc4;
	}


	public Common2Desc() {
		super();
	}

	public Common2Desc(String point_id, String pointname, String rank, String desc1, String desc2, String desc3,
			String desc4) {
		super();
		this.point_id = point_id;
		this.pointname = pointname;
		this.rank = rank;
		this.desc1 = desc1;
		this.desc2 = desc2;
		this.desc3 = desc3;
		this.desc4 = desc4;
	}

	@Override
	public String toString() {
		return "Common2Desc [point_id=" + point_id + ", pointname=" + pointname + ", rank=" + rank + ", desc1=" + desc1
				+ ", desc2=" + desc2 + ", desc3=" + desc3 + ", desc4=" + desc4 + "]";
	}

}
