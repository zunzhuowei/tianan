package com.org.test.keega.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.org.test.keega.model.CommonScore;
import com.org.test.keega.utli.AddUtil;
import com.org.test.keega.utli.LoadUtil;
import com.org.test.keega.utli.UpdateUtil;

@Repository("commonScoreDao")
public class CommonScoreDao implements ICommonScoreDao {
	
	@Resource private JdbcTemplate jdbcTemplate;

	@Override
	public void add(CommonScore commonScore,int plan_id) {
		AddUtil.addCommonSorce(commonScore, jdbcTemplate, plan_id);
	}

	@Override
	public void update(CommonScore commonScore,String point_id,String object_id,int plan_id,String mainbodyid) {
		UpdateUtil.updateCommonScore(commonScore, point_id, object_id, plan_id,mainbodyid, jdbcTemplate);
	}
	
	//查询如果是空的，需要往数据库插入对应此条件下的空分数数据进数据库
	@Override
	public CommonScore getCommonScoreByPointId(String point_id,int plan_id,String object_id,String mainbodyid) {
		return (CommonScore) LoadUtil.getCommonScoreByPointId(jdbcTemplate, point_id, plan_id, object_id, mainbodyid, CommonScore.class);
	}

	@Override
	public CommonScore getCommonScoreByPointId1(String point_id,int plan_id,String object_id,String mainbodyid) {
		return (CommonScore) LoadUtil.getCommonScoreByPointId1(jdbcTemplate, point_id, plan_id, object_id, mainbodyid, CommonScore.class);
	}


}
