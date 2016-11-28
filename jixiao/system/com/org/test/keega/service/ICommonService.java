package com.org.test.keega.service;

import java.util.List;

import com.org.test.keega.model.Common;
import com.org.test.keega.model.Common2DescAndScore;

public interface ICommonService {
	public List<Common> getListCommonBPIByItemId(String template_id);

	public List<Common> getListCommonByItemId(String template_id);

	public List<Common2DescAndScore> getListCommonBPIAndScore(ICommonScoreService commonScoreService, String objectid,
			int planid, String mainbodyid,String template_id);

	public List<Common2DescAndScore> getListCommonAndScore(ICommonScoreService commonScoreService, String objectid,
			int planid,String mainbodyid,String template_id,String newBody);
}
