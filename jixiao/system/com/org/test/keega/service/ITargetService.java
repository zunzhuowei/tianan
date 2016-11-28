package com.org.test.keega.service;

import java.util.List;

import com.org.test.keega.model.Target;

public interface ITargetService {
	public void add(Target target);

	public void update(Target target);

	public void delete(int id);

	/**
	 * 根据id获取某个target全部字段
	 * 
	 * @param id
	 * @return
	 */
	//public Target load(int id);
	public Target load(String id);

	/**
	 * 获取全部Target
	 * 
	 * @return
	 */
	public List<Target> listAllTarget();

	// public List<Target> listByDesc1(String desc1);
	/**
	 * 根据desc1查找某个target的其他字段
	 * 
	 * @param desc1
	 * @return
	 */
	public List<Target> findByDesc1(String desc1);
	
	/**
	 * 获取所有desc1字段用于，做下拉列表；然后再根据显示的desc1的id作为查询条件查找剩下的字段。
	 * @param desc1
	 * @return
	 */
	public List<Target> findAllDesc1AndId();
	/**
	 * 设置下拉列表
	 * @param selectId
	 * @return
	 */
	public Target selectTarget(String selectId);

}
