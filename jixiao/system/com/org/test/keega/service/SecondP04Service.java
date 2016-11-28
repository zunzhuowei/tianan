package com.org.test.keega.service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.test.keega.dao.ISecondP04Dao;
import com.org.test.keega.model.Evaluation;
import com.org.test.keega.model.EvaluationSelfOther;
import com.org.test.keega.model.InitClass;
import com.org.test.keega.model.SecondP04;
import com.org.test.keega.model.SecondP04AndEva;

@Service("secondP04Service")
public class SecondP04Service implements ISecondP04Service {

	@Resource
	private ISecondP04Dao secondP04Dao;

	@Override
	public void add(SecondP04 secondP04) {
		this.secondP04Dao.add(secondP04);
	}

	@Override
	public void delete(String id) {
		this.secondP04Dao.delete(id);
	}

	@Override
	public void update(SecondP04 secondP04) {
		this.secondP04Dao.update(secondP04);
	}

	@Override
	public SecondP04 load(String id) {
		return this.secondP04Dao.load(id);
	}

	@Override
	public List<SecondP04> listAllSecondP04(String planid,String objectid,String template_id) {
		return this.secondP04Dao.listAllSecondP04(planid,objectid,template_id);
	}

	@Override//objectid,mainbodyid,planid
	public List<SecondP04AndEva> listSecondP04AndEva(
			List<SecondP04> sp, IEvalutionService es,String objectid,String mainbodyid,String planid) {
		List<SecondP04AndEva> spaes = new ArrayList<SecondP04AndEva>();
		SecondP04AndEva spae = null;
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2);

		if (sp != null) {
			for (int i = 0; i < sp.size(); i++) {
				spae = new SecondP04AndEva();
				String p0400 = sp.get(i).getP0400() + "";
				if (p0400 != null && !"".equals(p0400.trim())) {
					EvaluationSelfOther seo = new EvaluationSelfOther();
					if (!mainbodyid.equals(objectid)) {//表示评分人进来
						Evaluation ee = es.loadSelfByP0400(p0400,mainbodyid,objectid,planid);
						Evaluation e = es.loadSelfByP0400(p0400,objectid,objectid,planid);
						if (ee != null && e != null) {
							if (ee.getScore() != null && e.getScore() != null) {
								Double d = Double.parseDouble(ee.getScore());
								String s = numberFormat.format(d);
								seo.setOtherScore(s);

								Double d1 = Double.parseDouble(e.getScore());
								String s1 = numberFormat.format(d1);
								seo.setSelfScore(s1);
							} else {
								seo.setOtherScore(null);
								seo.setSelfScore(null);
							}
						}else if (ee != null) {
							if (ee.getScore() != null) {
								Double d = Double.parseDouble(ee.getScore());
								String s = numberFormat.format(d);
								seo.setOtherScore(s);
							} else {
								seo.setOtherScore(null);
							}
						} else if (e != null) {
							if (e.getScore() != null) {
								Double d = Double.parseDouble(e.getScore());
								String s = numberFormat.format(d);
								seo.setSelfScore(s);
							} else {
								seo.setSelfScore(null);
							}
						} else {
							seo.setOtherScore(null);
							seo.setSelfScore(null);
						}
					}else {//表示被考核人进来
						Evaluation e = es.loadOtherByP0400(p0400,mainbodyid,objectid,planid);
						if (e != null) {
							if (e.getScore() != null) {
								Double d = Double.parseDouble(e.getScore());
								String s = numberFormat.format(d);
								seo.setSelfScore(s);
							} else {
								seo.setSelfScore(null);
							}
						} else {
							seo.setSelfScore(null);
						}
					}
					spae.setEvaluationSelfOther(seo);

				} else {
					spae.setEvaluationSelfOther(new EvaluationSelfOther());
				}
				spae.setSecondP04(sp.get(i));
				spaes.add(spae);
			}
		}
		return spaes;
	}

	@Override
	public InitClass getInitClassByA0100(String a0100) {
		return this.secondP04Dao.getInitClassByA0100(a0100);
	}
}
