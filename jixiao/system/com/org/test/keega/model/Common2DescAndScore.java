package com.org.test.keega.model;

//dto
public class Common2DescAndScore {
	private Common2Desc common2Desc;
	private CommonScore commonScore;

	public Common2Desc getCommon2Desc() {
		return common2Desc;
	}

	public void setCommon2Desc(Common2Desc common2Desc) {
		this.common2Desc = common2Desc;
	}

	public CommonScore getCommonScore() {
		return commonScore;
	}

	public void setCommonScore(CommonScore commonScore) {
		this.commonScore = commonScore;
	}

	@Override
	public String toString() {
		return "Common2DescAndScore [common2Desc=" + common2Desc + ", commonScore=" + commonScore + "]";
	}

	public Common2DescAndScore(Common2Desc common2Desc, CommonScore commonScore) {
		super();
		this.common2Desc = common2Desc;
		this.commonScore = commonScore;
	}

	public Common2DescAndScore() {
		super();
	}



}
