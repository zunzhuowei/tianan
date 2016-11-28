package com.org.test.keega.service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.test.keega.dao.IP04Dao;
import com.org.test.keega.model.Evaluation;
import com.org.test.keega.model.EvaluationSelfOther;
import com.org.test.keega.model.InitClass;
import com.org.test.keega.model.P04;
import com.org.test.keega.model.Target;
import com.org.test.keega.model.TargetAndP04;

@Service("p04Service")
public class P04Service implements IP04Service {

	@Resource private IP04Dao p04Dao;
	
	@Override
	public void add(P04 p04) {
		this.p04Dao.add(p04);
	}

	@Override
	public void delete(int id) {
		this.p04Dao.delete(id);
	}

	@Override
	public void update(P04 p04) {
		this.p04Dao.update(p04);
	}
	
	/**
	 * 这个id是值p0400，不是自增的
	 */
	@Override
	public P04 load(String id) {
		return this.p04Dao.load(id);
	}

	@Override
	public List<P04> listAllP04(String planid,String objectid,String template_id) {
		return this.p04Dao.listAllP04(planid,objectid,template_id);
	}

	@Override//objectid,mainbodyid,planid
	public List<TargetAndP04> listTargetAndP04(
			List<P04> t,IEvalutionService es,ITargetService targetService
			,String objectid,String mainbodyid,String planid) {
		List<TargetAndP04> targetAndP04 = new ArrayList<TargetAndP04>();
		TargetAndP04 tap = null;//new TargetAndP04();
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2);
		if (t != null) {
			
			for (int i = 0; i < t.size(); i++ ) {
				tap = new TargetAndP04();
				
				String target = t.get(i).getP04BA();//TODO
				if (target != null && !"".equals(target.trim())) {
					Target tt = targetService.load(target);//TODO
					if (tt != null) {
						tap.setTarget(tt);
					}else {
						tap.setTarget(new Target());
					}
				}else {
					tap.setTarget(new Target());
				}
				
				String p0400 = t.get(i).getP0400()+"";
				if (p0400 != null && !"".equals(p0400.trim())) {
					EvaluationSelfOther seo = new EvaluationSelfOther();
					if (!mainbodyid.equals(objectid)) {//不是被考核人进来，评分人进来
						Evaluation ee = es.loadSelfByP0400(p0400,mainbodyid,objectid,planid);
						Evaluation e = es.loadSelfByP0400(p0400,objectid,objectid,planid);
						if (ee != null && e != null) {
							seo.setOtherScore(numberFormat.format(Double.parseDouble(ee.getScore())));
							seo.setSelfScore(numberFormat.format(Double.parseDouble(e.getScore())));
						}else if (ee != null) {
							seo.setOtherScore(numberFormat.format(Double.parseDouble(ee.getScore())));
							//seo.setSelfScore(numberFormat.format(Double.parseDouble(e.getScore())));
						} else if (e != null) {
							seo.setSelfScore(numberFormat.format(Double.parseDouble(e.getScore())));
						} else {
							seo.setSelfScore(null);
							seo.setOtherScore(null);
						}
					} else {//被考核人自己进来
						Evaluation e = es.loadOtherByP0400(p0400,mainbodyid,objectid,planid);
						if (e != null) {
							seo.setSelfScore(numberFormat.format(Double.parseDouble(e.getScore())));
							//seo.setSelfScore(e.getScore());
						} else {
							seo.setSelfScore(null);
						}
					}
					tap.setEvaluationSelfOther(seo);
				}else {
					tap.setEvaluationSelfOther(new EvaluationSelfOther());
				}
				
				P04 p = t.get(i);
				tap.setP04(p);
				targetAndP04.add(tap);
			}
			
		}
		return targetAndP04;
	}

	@Override
	public InitClass getInitClassByA0100(String a0100) {
		return this.p04Dao.getInitClassByA0100(a0100);
	}

}
