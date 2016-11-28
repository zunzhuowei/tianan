package com.org.test.keega.model;

public class InitClass {
	// select B0110 ,E0122 ,E01A1 ,'Usr' as NBASE,A0100 ,A0101 from UsrA01 where
	// a0100 = '00000177'
	private String B0110;
	private String E0122;
	private String E01A1;
	private String NBASE;
	private String A0100;
	private String A0101;


	public String getB0110() {
		return B0110;
	}

	public void setB0110(String b0110) {
		B0110 = b0110;
	}

	public String getE0122() {
		return E0122;
	}

	public void setE0122(String e0122) {
		E0122 = e0122;
	}

	public String getE01A1() {
		return E01A1;
	}

	public void setE01A1(String e01a1) {
		E01A1 = e01a1;
	}

	public String getNBASE() {
		return NBASE;
	}

	public void setNBASE(String nBASE) {
		NBASE = nBASE;
	}

	public String getA0100() {
		return A0100;
	}

	public void setA0100(String a0100) {
		A0100 = a0100;
	}

	public String getA0101() {
		return A0101;
	}

	public void setA0101(String a0101) {
		A0101 = a0101;
	}

	public InitClass(String b0110, String e0122, String e01a1, String nBASE, String a0100, String a0101) {
		super();
		B0110 = b0110;
		E0122 = e0122;
		E01A1 = e01a1;
		NBASE = nBASE;
		A0100 = a0100;
		A0101 = a0101;
	}

	public InitClass() {
		super();
	}

	@Override
	public String toString() {
		return "InitClass [B0110=" + B0110 + ", E0122=" + E0122 + ", E01A1=" + E01A1 + ", NBASE=" + NBASE + ", A0100="
				+ A0100 + ", A0101=" + A0101 + "]";
	}

}
