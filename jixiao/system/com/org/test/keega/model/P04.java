package com.org.test.keega.model;

public class P04 {
	private int p0400; // 不是自增id，
	private String p04BA; // target的id,可以根据这个id查询target
	private String p0407; // 指标
	private String p04BC; // 数据来源
	private String p0415; // 权重
	private String p04Z9; // 完成情况
	private String p04BK;// 目标达成值录入
	
	private String plan_id;
	private String b0110;
	private String e0122;
	private String e01A1;
	private String nbase;
	private String a0100;
	private String a0101;
	private String item_id;
	private String fromflag;
	

	public String getFromflag() {
		return fromflag;
	}

	public void setFromflag(String fromflag) {
		this.fromflag = fromflag;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
	}


	public String getB0110() {
		return b0110;
	}

	public void setB0110(String b0110) {
		this.b0110 = b0110;
	}

	public String getE0122() {
		return e0122;
	}

	public void setE0122(String e0122) {
		this.e0122 = e0122;
	}

	public String getE01A1() {
		return e01A1;
	}

	public void setE01A1(String e01a1) {
		e01A1 = e01a1;
	}



	public String getNbase() {
		return nbase;
	}

	public void setNbase(String nbase) {
		this.nbase = nbase;
	}

	public String getA0100() {
		return a0100;
	}

	public void setA0100(String a0100) {
		this.a0100 = a0100;
	}

	public String getA0101() {
		return a0101;
	}

	public void setA0101(String a0101) {
		this.a0101 = a0101;
	}

	public String getP04BK() {
		return p04BK;
	}

	public void setP04BK(String p04bk) {
		p04BK = p04bk;
	}

	public int getP0400() {
		return p0400;
	}

	public void setP0400(int p0400) {
		this.p0400 = p0400;
	}

	public String getP04BA() {
		return p04BA;
	}

	public void setP04BA(String p04ba) {
		p04BA = p04ba;
	}

	public String getP0415() {
		return p0415;
	}

	public void setP0415(String p0415) {
		this.p0415 = p0415;
	}

	public String getP0407() {
		return p0407;
	}

	public void setP0407(String p0407) {
		this.p0407 = p0407;
	}

	public String getP04BC() {
		return p04BC;
	}

	public void setP04BC(String p04bc) {
		this.p04BC = p04bc;
	}

	public String getP04Z9() {
		return p04Z9;
	}

	public void setP04Z9(String p04z9) {
		this.p04Z9 = p04z9;
	}



	public P04(int p0400, String p04ba, String p0407, String p04bc, String p0415, String p04z9, String p04bk,
			String plan_id, String b0110, String e0122, String e01a1, String nbase, String a0100, String a0101,
			String item_id, String fromflag) {
		super();
		this.p0400 = p0400;
		p04BA = p04ba;
		this.p0407 = p0407;
		p04BC = p04bc;
		this.p0415 = p0415;
		p04Z9 = p04z9;
		p04BK = p04bk;
		this.plan_id = plan_id;
		this.b0110 = b0110;
		this.e0122 = e0122;
		e01A1 = e01a1;
		this.nbase = nbase;
		this.a0100 = a0100;
		this.a0101 = a0101;
		this.item_id = item_id;
		this.fromflag = fromflag;
	}

	@Override
	public String toString() {
		return "P04 [p0400=" + p0400 + ", p04BA=" + p04BA + ", p0407=" + p0407 + ", p04BC=" + p04BC + ", p0415=" + p0415
				+ ", p04Z9=" + p04Z9 + ", p04BK=" + p04BK + ", plan_id=" + plan_id + ", b0110=" + b0110 + ", e0122="
				+ e0122 + ", e01A1=" + e01A1 + ", nbase=" + nbase + ", a0100=" + a0100 + ", a0101=" + a0101
				+ ", item_id=" + item_id + ", fromflag=" + fromflag + "]";
	}

	public P04() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * [{"desc1":"3","desc2":"dd","desc3":"eee","desc4":"eee","desc5":"eee"
	 * ,"desc6":"ee","id":"3","zhibiao":"非量化类指标","_id":1,"_uid":1
	 * ,"_state":"modified","P0407":"zhibiao","P04BC":"shujulaiyuan"
	 * ,"P0415":"quanzhong","P04Z9":"wanchengqingkuang","xxx":"ziping","yyy":
	 * "kaoherenpingfen"}]
	 */

}
