package com.org.test.keega.model;

public class Target {
	private int id;
	private String desc1;
	private String desc2;
	private String desc3;
	private String desc4;
	private String desc5;
	private String desc6;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDesc5() {
		return desc5;
	}

	public void setDesc5(String desc5) {
		this.desc5 = desc5;
	}

	public String getDesc6() {
		return desc6;
	}

	public void setDesc6(String desc6) {
		this.desc6 = desc6;
	}

	public Target(String desc1, String desc2, String desc3, String desc4, String desc5, String desc6) {
		super();
		this.desc1 = desc1;
		this.desc2 = desc2;
		this.desc3 = desc3;
		this.desc4 = desc4;
		this.desc5 = desc5;
		this.desc6 = desc6;
	}

	public Target() {
	}

	@Override
	public String toString() {
		return "Target [id=" + id + ", desc1=" + desc1 + ", desc2=" + desc2 + ", desc3=" + desc3 + ", desc4=" + desc4
				+ ", desc5=" + desc5 + ", desc6=" + desc6 + "]";
	}

}
