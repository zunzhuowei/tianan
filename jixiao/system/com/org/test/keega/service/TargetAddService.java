package com.org.test.keega.service;

import com.org.test.keega.model.Target;


public class TargetAddService {
	
	Target target;
	
	public TargetAddService(Target target){
		this.target = target;
	}
	
	public String add(){
		//校验数据完整性
		if (this.checkData() == false) {
			return "插入失败，请校验数据的完整性";
		}
		
		//数据的插入
		if (insert()) {
			if (sendMail()) {
				startAutoEmail("2016-01-01");
			}
		}
		
		
		return "";
	}
	
	/**
	 * 验证数据的完整性
	 * @return
	 */
	private boolean checkData(){
		
		return true;
	}
	
	public boolean insert(){
		
		return true;
	}
	
	/**
	 * 发送邮件
	 * @return
	 */
	private boolean sendMail(){
		
		return true;
	}
	
	/**
	 * 自动发送邮件
	 */
	public void startAutoEmail(String startDate){
		
		
	}
}
