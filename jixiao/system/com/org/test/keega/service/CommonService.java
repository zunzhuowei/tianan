package com.org.test.keega.service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.test.keega.dao.ICommonDao;
import com.org.test.keega.model.Common;
import com.org.test.keega.model.Common2Desc;
import com.org.test.keega.model.Common2DescAndScore;
import com.org.test.keega.model.CommonScore;

@Service("commonService")
public class CommonService implements ICommonService {

	@Resource
	private ICommonDao commonDao;

	@Override
	public List<Common> getListCommonBPIByItemId(String template_id) {
		return this.commonDao.getListCommonBPIByItemId(template_id);
	}

	@Override
	public List<Common> getListCommonByItemId(String template_id) {
		return this.commonDao.getListCommonByItemId(template_id);
	}

	@Override
	public List<Common2DescAndScore> getListCommonBPIAndScore(ICommonScoreService commonScoreService, String objectid,
			int planid, String mainbodyid,String template_id) {
		List<Common2DescAndScore> cas = new ArrayList<Common2DescAndScore>();
		List<Common> commons = this.getListCommonBPIByItemId(template_id);//TODO 需要传---
		for (Common common : commons) {
			String point_id = common.getPoint_id();
			CommonScore commonScore = commonScoreService.getCommonScoreByPointId(point_id, planid, objectid,mainbodyid);
			if (commonScore != null) {
				if (commonScore.getScore() != null) {
					NumberFormat numberFormat = NumberFormat.getInstance();
					numberFormat.setMaximumFractionDigits(2);
					String score = commonScore.getScore();
					double d = Double.parseDouble(score);
					commonScore.setScore(numberFormat.format(d));
				} else {
					commonScore.setScore(null);
				}
			}
			//}
			String[] descs = common.getDescription().split("@@");
			Map<String,String> descMap = new HashMap<String, String>();
			for (int i = 0; i < descs.length; i++) {
				int j = i +1;
				String desc = "desc"+j;
				descMap.put(desc, descs[i]);
			}
			cas.add(new Common2DescAndScore(new Common2Desc(point_id, common.getPointname(), common.getRank(),
					descMap.get("desc1"), descMap.get("desc2"), descMap.get("desc3"), 
					descMap.get("desc4")), commonScore));
		}
		return cas;
	}

	@Override
	public List<Common2DescAndScore> getListCommonAndScore(ICommonScoreService commonScoreService, String objectid,
			int planid, String mainbodyid,String template_id, String newBody) {
		List<Common2DescAndScore> cas = new ArrayList<Common2DescAndScore>();
		List<Common> commons = this.getListCommonByItemId(template_id);
		for (Common common : commons) {
			String point_id = common.getPoint_id();
			CommonScore commonScore = commonScoreService.getCommonScoreByPointId1(point_id, planid, objectid,mainbodyid,newBody);
			if (commonScore != null) {
				if (commonScore.getScore() != null) {
					NumberFormat numberFormat = NumberFormat.getInstance();
					numberFormat.setMaximumFractionDigits(2);
					String score = commonScore.getScore();
					double d = Double.parseDouble(score);
					commonScore.setScore(numberFormat.format(d));
				} else {
					commonScore.setScore(null);
				}
			}
			//}
			String[] descs = common.getDescription().split("@@");
			Map<String,String> descMap = new HashMap<String, String>();
			for (int i = 0; i < descs.length; i++) {
				int j = i +1;
				String desc = "desc"+j;
				descMap.put(desc, descs[i]);
			}
			cas.add(new Common2DescAndScore(new Common2Desc(
					point_id, common.getPointname(), common.getRank(),
					descMap.get("desc1"), descMap.get("desc2"), descMap.get("desc3"), 
					descMap.get("desc4")), commonScore));
		}
		return cas;
	}

}
