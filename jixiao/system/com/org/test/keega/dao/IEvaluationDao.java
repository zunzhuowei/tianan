package com.org.test.keega.dao;

import java.util.List;

import com.org.test.keega.model.Evaluation;

public interface IEvaluationDao {
	public void add(Evaluation evaluation);

	public void update(Evaluation evaluation,String mainbodyid,String objectid,String planid);

	public void delete(String id);

	/**
	 * 根据Id查找一个评分
	 * 
	 * @param id
	 * @return
	 */
	public Evaluation load(String id);

	/**
	 * 根据被打分人查找评分
	 * 
	 * @param object_id
	 * @return
	 */
	public List<Evaluation> listByObjectId(String object_id);

	/**
	 * 根据打分人查找评分
	 * 
	 * @param mainBodyId
	 * @return
	 */
	public List<Evaluation> listByMainBodyId(String mainBodyId);

	/**
	 * 根据考核id查找评分
	 * 
	 * @param p0400
	 * @return
	 */
	public Evaluation loadByP0400(String p0400);

	/**
	 * 自评分数
	 * 
	 * @param p0400
	 * @return
	 */
	public Evaluation loadSelfByP0400(String p0400,String mainbodyid,String objectid,String planid);

	/**
	 * 他评分数
	 * 
	 * @param p0400
	 * @return
	 */
	public Evaluation loadOtherByP0400(String p0400,String mainbodyid,String objectid,String planid);
	
	public void submitEva(String sp_flag,String objectid,String planid);

	/**
	 * 交办之后，未审核的时候可以撤回。
	 * @param objectId 填目标卡的id
	 * @param planId 计划id
	 */
	public void targetRecall(String objectId, String planId);

	/**
	 * 评分结束之后，员工确认考核结果
	 * @param objectId 填目标卡的id
	 * @param planId 计划id
	 */
    public void resultConfirm(String objectId, String planId);

	/**
	 *显示员工考核确认信息
	 * @return json
	 * @param key
	 */
    public String showConfirmResult(String key,String searchType);
}
