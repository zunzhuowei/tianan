package com.org.test.keega.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.dexcoder.commons.utils.JsonUtil;
import flexjson.JSON;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.org.test.keega.model.Evaluation;
import com.org.test.keega.utli.AddUtil;
import com.org.test.keega.utli.DeleteUtil;
import com.org.test.keega.utli.ListUtil;
import com.org.test.keega.utli.LoadUtil;

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

	@Override//confirm默认是0，表示结果没有确认，当确认之后，更新为1.字段confirm类型是int类型。
	public void resultConfirm(String objectId, String planId) {
		//System.out.println(objectId + "----" + planId);
		jdbcTemplate.execute("update per_object set confirm = '1' " +
				"where object_id='"+objectId+"' and plan_id='"+planId+"' ");
	}

	@Override
	public String showConfirmResult(String key, String searchType) {
		String sql = null;
		if ("00".equals(searchType)) {//查询未确认的。
			sql = "select * from (select object_id as id,plan_id as planId," +
					" (select B0110 from UsrA01 where A0100 = object_id) orgid," +
					" (select a0101 from UsrA01 where A0100 = object_id) as name," +
					" (select codeitemdesc from organization where codeitemid = ((select B0110 from UsrA01 where A0100 = object_id))) as company," +
					" (select codeitemdesc from organization where codeitemid = ((select E0122 from UsrA01 where A0100 = object_id))) as department," +
					" (select codeitemdesc from organization where codeitemid = ((select E01A1 from UsrA01 where A0100 = object_id))) as station " +
					" from per_object where confirm='0'" +
					" ) a where (a.name like '%"+key+"%'" +
					" or a.company like '%"+key+"%' " +
					" or a.department like '%"+key+"%' " +
					" or a.station like '%"+key+"%') and a.orgid like '%'";//orgId
		} else if ("01".equals(searchType)) {//查询已经确认的。
			sql = "select * from (select object_id as id,plan_id as planId," +
					" (select B0110 from UsrA01 where A0100 = object_id) orgid," +
					" (select a0101 from UsrA01 where A0100 = object_id) as name," +
					" (select codeitemdesc from organization where codeitemid = ((select B0110 from UsrA01 where A0100 = object_id))) as company," +
					" (select codeitemdesc from organization where codeitemid = ((select E0122 from UsrA01 where A0100 = object_id))) as department," +
					" (select codeitemdesc from organization where codeitemid = ((select E01A1 from UsrA01 where A0100 = object_id))) as station " +
					" from per_object where confirm='1'" +
					" ) a where (a.name like '%"+key+"%'" +
					" or a.company like '%"+key+"%' " +
					" or a.department like '%"+key+"%' " +
					" or a.station like '%"+key+"%') and a.orgid like '%'";//orgId
		} else if ("02".equals(searchType)) {//查询所有人
			sql = "select * from (select object_id as id,plan_id as planId," +
					" (select B0110 from UsrA01 where A0100 = object_id) orgid," +
					" (select a0101 from UsrA01 where A0100 = object_id) as name," +
					" (select codeitemdesc from organization where codeitemid = ((select B0110 from UsrA01 where A0100 = object_id))) as company," +
					" (select codeitemdesc from organization where codeitemid = ((select E0122 from UsrA01 where A0100 = object_id))) as department," +
					" (select codeitemdesc from organization where codeitemid = ((select E01A1 from UsrA01 where A0100 = object_id))) as station " +
					" from per_object " +
					" ) a where (a.name like '%"+key+"%'" +
					" or a.company like '%"+key+"%' " +
					" or a.department like '%"+key+"%' " +
					" or a.station like '%"+key+"%') and a.orgid like '%'";//orgId
		} else {//其他查询所有人
			sql = "select * from (select object_id as id,plan_id as planId," +
					" (select B0110 from UsrA01 where A0100 = object_id) orgid," +
					" (select a0101 from UsrA01 where A0100 = object_id) as name," +
					" (select codeitemdesc from organization where codeitemid = ((select B0110 from UsrA01 where A0100 = object_id))) as company," +
					" (select codeitemdesc from organization where codeitemid = ((select E0122 from UsrA01 where A0100 = object_id))) as department," +
					" (select codeitemdesc from organization where codeitemid = ((select E01A1 from UsrA01 where A0100 = object_id))) as station " +
					" from per_object " +
					" ) a where (a.name like '%"+key+"%'" +
					" or a.company like '%"+key+"%' " +
					" or a.department like '%"+key+"%' " +
					" or a.station like '%"+key+"%') and a.orgid like '%'";//orgId
		}
		List<Map<String,Object>> mapList = jdbcTemplate.queryForList(sql);
		return JsonUtil.list2json(mapList);
	}

}
