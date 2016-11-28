package com.org.test.keega.service;

import com.org.test.keega.model.CommonScore;

public interface ICommonScoreService {
	//point_id用于查询某条指标记录
		//planid用于构造查询某条指标的表名
		//有了object_id才知道这个评分是谁的
		public CommonScore getCommonScoreByPointId(String point_id,int plan_id,String object_id,String mainbodyid);

		public CommonScore getCommonScoreByPointId1(String point_id,int plan_id,String object_id,String mainbodyid,String newBody);

		public void add(CommonScore commonScore,int plan_id);
		
		public void update(CommonScore commonScore,String point_id,String object_id,int plan_id,String mainbodyid);
}
