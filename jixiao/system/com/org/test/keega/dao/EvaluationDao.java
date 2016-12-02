package com.org.test.keega.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.org.test.keega.model.Evaluation;
import com.org.test.keega.utli.AddUtil;
import com.org.test.keega.utli.DeleteUtil;
import com.org.test.keega.utli.ListUtil;
import com.org.test.keega.utli.LoadUtil;
import com.org.test.keega.utli.UpdateUtil;

@SuppressWarnings("unchecked")
@Repository("evaluationDao")
public class EvaluationDao implements IEvaluationDao {
	
	@Resource private JdbcTemplate jdbcTemplate;
	
	@Override
	public void add(Evaluation evaluation) {
		AddUtil.addEvalution(evaluation, jdbcTemplate);
	}

	@Override
	public Evaluation load(String id) {
		return (Evaluation) LoadUtil.loadById(jdbcTemplate, id, Evaluation.class);
	}

	@Override
	public List<Evaluation> listByObjectId(String object_id) {
		return (List<Evaluation>) ListUtil.listByObjectId(Evaluation.class, jdbcTemplate, object_id);
	}

	@Override
	public List<Evaluation> listByMainBodyId(String mainBodyId) {
		return (List<Evaluation>) ListUtil.listByMainBodyId(Evaluation.class, jdbcTemplate, mainBodyId);
	}

	@Override
	public Evaluation loadByP0400(String p0400) {
		return (Evaluation) LoadUtil.loadByP0400(jdbcTemplate, p0400, Evaluation.class);
	}

	@Override
	public void delete(String id) {//不提供删除
		DeleteUtil.deleteEvalution(Evaluation.class, id, jdbcTemplate);
	}
	
	@Override
	public void update(Evaluation evaluation,String mainbodyid,String objectid,String planid) {
		this.jdbcTemplate.update("update per_target_evaluation set mainbody_id = '"+evaluation.getMainbody_id()+"' "
				+ ",plan_id = '"+evaluation.getPlan_id()+"', object_id = '"+evaluation.getObject_id()+"' "
						+ ",degree_id = '"+evaluation.getDegree_id()+"' ,amount = '"+evaluation.getAmount()+"' "
								+ ",reasons = '"+evaluation.getReasons()+"' "+ ",stdScore = '"+evaluation.getStdScore()+"' "
										+ ",p0400 = '"+evaluation.getP0400()+"' ,score = '"+evaluation.getScore()+"' "
												+ "where object_id = '"+objectid+"'"
				+ " and mainbody_id = '"+mainbodyid+"' and plan_id = '"+planid+"' and p0400 = '"+evaluation.getP0400()+"'");
		//UpdateUtil.updateEvaluation(evaluation, jdbcTemplate,mainbodyid,objectid,planid);
	}
	
	@Override
	public Evaluation loadSelfByP0400(String p0400,String mainbodyid,String objectid,String planid) {
		return (Evaluation) LoadUtil.loadSelfByP0400(jdbcTemplate,mainbodyid,objectid,planid, p0400, Evaluation.class);
	}

	@Override
	public Evaluation loadOtherByP0400(String p0400,String mainbodyid,String objectid,String planid) {
		return (Evaluation) LoadUtil.loadOtherByP0400(jdbcTemplate,mainbodyid,objectid, p0400,planid, Evaluation.class);
	}

	@Override
	public void submitEva(String sp_flag, String objectid, String planid) {
		this.jdbcTemplate.update(
				"update per_object set sp_flag = ? where object_id = ? and plan_id = ?",
				sp_flag,objectid,planid);
		/*this.jdbcTemplate.update(
				"update t_actor set last_name = ? where id = ?",
				"Banjo", 5276L);*/
	}

	@Override
	public void targetRecall(String objectId, String planId) {
		jdbcTemplate.execute("update per_object set sp_flag='01' " +
				"where object_id='"+objectId+"' and plan_id='"+planId+"' ");
	}

}
