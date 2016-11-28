package com.org.test.keega.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.test.keega.dao.ICommonScoreDao;
import com.org.test.keega.model.CommonScore;

@Service("commonScoreService")
public class CommonScoreService implements ICommonScoreService {
	
	@Resource private ICommonScoreDao commonScoreDao;
	
	@Override//这个是bpi考核的
	public CommonScore getCommonScoreByPointId(String point_id, int plan_id, String object_id,String mainbodyid) {
		return this.commonScoreDao.getCommonScoreByPointId(point_id, plan_id, object_id,mainbodyid);
	}

	@Override//这个是通用类考核的
	public CommonScore getCommonScoreByPointId1(String point_id, int plan_id, String object_id, String mainbodyid, String newBody) {
		/*if ("1".equals(newBody.trim())) {
			//查询张碧评的分
			CommonScore commonScore = this.commonScoreDao.getCommonScoreByPointId1(point_id, plan_id, object_id, mainbodyid);//这里的mainbodyid是无用的
			//查询金鉴评的分
			CommonScore commonScore1 = this.commonScoreDao.getCommonScoreByPointId(point_id, plan_id, object_id, mainbodyid);
			if (commonScore != null && commonScore1 == null) {//张碧林打分了之后，分数不为空。金鉴没有初始化分数(当初始化分数之后，他的分数就为张碧林的分数)
				//把张碧林评的分数，默认给金鉴插入相同的分数。
				this.commonScoreDao.add(new CommonScore(object_id, mainbodyid, commonScore.getScore(), "1", point_id, "A"), plan_id);
				return this.commonScoreDao.getCommonScoreByPointId(point_id, plan_id, object_id, mainbodyid);
			} else {
				return this.commonScoreDao.getCommonScoreByPointId(point_id, plan_id, object_id, mainbodyid);
			}
		} else if ("25".equals(newBody.trim())) {//如果是张碧林自己登陆
			return this.commonScoreDao.getCommonScoreByPointId1(point_id, plan_id, object_id, mainbodyid);
		} else {//如果是普通员工，就不用张碧林打分通用类的分数了。
			return this.commonScoreDao.getCommonScoreByPointId(point_id, plan_id, object_id, mainbodyid);
		}*/

		if (!"25".equals(newBody.trim())) {
			//查询张碧评的分
			CommonScore commonScore = this.commonScoreDao.getCommonScoreByPointId1(point_id, plan_id, object_id, mainbodyid);//这里的mainbodyid是无用的
			//查询金鉴评的分
			CommonScore commonScore1 = this.commonScoreDao.getCommonScoreByPointId(point_id, plan_id, object_id, mainbodyid);
			if (commonScore != null && commonScore1 == null) {//张碧林打分了之后，分数不为空。金鉴没有初始化分数(当初始化分数之后，他的分数就为张碧林的分数)
				//把张碧林评的分数，默认给金鉴插入相同的分数。
				this.commonScoreDao.add(new CommonScore(object_id, mainbodyid, commonScore.getScore(), "1", point_id, "A"), plan_id);
				return this.commonScoreDao.getCommonScoreByPointId(point_id, plan_id, object_id, mainbodyid);
			} else {
				return this.commonScoreDao.getCommonScoreByPointId(point_id, plan_id, object_id, mainbodyid);
			}
		} else if ("25".equals(newBody.trim())) {//如果是张碧林自己登陆
			//return this.commonScoreDao.getCommonScoreByPointId1(point_id, plan_id, object_id, mainbodyid);
			return this.commonScoreDao.getCommonScoreByPointId(point_id, plan_id, object_id, mainbodyid);
		} else {//如果是普通员工，就不用张碧林打分通用类的分数了。
			return this.commonScoreDao.getCommonScoreByPointId(point_id, plan_id, object_id, mainbodyid);
		}

	}

	@Override
	public void add(CommonScore commonScore, int plan_id) {
		this.commonScoreDao.add(commonScore, plan_id);
	}

	@Override
	public void update(CommonScore commonScore, String point_id, String object_id, int plan_id,String mainbodyid) {
		this.commonScoreDao.update(commonScore, point_id, object_id, plan_id,mainbodyid);
	}

}
