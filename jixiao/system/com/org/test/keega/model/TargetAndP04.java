package com.org.test.keega.model;

/**
 * 
 * @author zhuozun.wei
 * @createDate 2016年8月27日--下午12:46:23
 */
public class TargetAndP04 {

	private P04 p04;
	private Target target;
	private EvaluationSelfOther evaluationSelfOther;

	public P04 getP04() {
		return p04;
	}

	public void setP04(P04 p04) {
		this.p04 = p04;
	}

	public Target getTarget() {
		return target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	public TargetAndP04(P04 p04, Target target) {
		super();
		this.p04 = p04;
		this.target = target;
	}
	
	public EvaluationSelfOther getEvaluationSelfOther() {
		return evaluationSelfOther;
	}

	public void setEvaluationSelfOther(EvaluationSelfOther evaluationSelfOther) {
		this.evaluationSelfOther = evaluationSelfOther;
	}
	
	public TargetAndP04(P04 p04, Target target, EvaluationSelfOther evaluationSelfOther) {
		super();
		this.p04 = p04;
		this.target = target;
		this.evaluationSelfOther = evaluationSelfOther;
	}

	public TargetAndP04() {
		super();
	}

}
