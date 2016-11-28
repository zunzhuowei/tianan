package com.org.test.keega.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.test.keega.dao.IEvaluationDao;
import com.org.test.keega.model.Evaluation;

@Service("evalutionService")
public class EvalutionService implements IEvalutionService {
	
	@Resource private IEvaluationDao evalutionDao;
	
	@Override
	public void add(Evaluation evaluation) {
		this.evalutionDao.add(evaluation);
	}

	@Override
	public void update(Evaluation evaluation,String mainbodyid,String objectid,String planid) {
		this.evalutionDao.update(evaluation,mainbodyid,objectid,planid);
	}

	@Override
	public void delete(String id) {
		this.evalutionDao.delete(id);
	}

	@Override
	public Evaluation load(String id) {
		return this.evalutionDao.load(id);
	}

	@Override
	public List<Evaluation> listByObjectId(String object_id) {
		return this.evalutionDao.listByObjectId(object_id);
	}

	@Override
	public List<Evaluation> listByMainBodyId(String mainBodyId) {
		return this.evalutionDao.listByMainBodyId(mainBodyId);
	}

	@Override
	public Evaluation loadByP0400(String p0400) {
		return this.evalutionDao.loadByP0400(p0400);
	}


	@Override
	public void submitEva(String sp_flag, String objectid, String planid) {
		this.evalutionDao.submitEva(sp_flag, objectid, planid);
	}

	@Override
	public Evaluation loadSelfByP0400(String p0400, String mainbodyid, String objectid,String planid) {
		return this.evalutionDao.loadSelfByP0400(p0400, mainbodyid, objectid,planid);
	}

	@Override
	public Evaluation loadOtherByP0400(String p0400, String mainbodyid, String objectid,String planid) {
		return this.evalutionDao.loadOtherByP0400(p0400, mainbodyid, objectid,planid);
	}

}
