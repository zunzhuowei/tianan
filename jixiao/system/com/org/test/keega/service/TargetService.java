package com.org.test.keega.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.test.keega.dao.ITargetDao;
import com.org.test.keega.model.Target;

@Service("targetService")
public class TargetService implements ITargetService {

	@Resource private ITargetDao targetDao;

	@Override
	public void add(Target target) {
		this.targetDao.add(target);
	}

	@Override
	public void update(Target target) {
		this.targetDao.update(target);
	}

	@Override
	public void delete(int id) {
		this.targetDao.delete(id);
	}

	@Override
	public Target load(String id) {
		return this.targetDao.load(id);
	}

	@Override
	public List<Target> listAllTarget() {
		return this.targetDao.listAllTarget();
	}

	@Override
	public List<Target> findByDesc1(String desc1) {
		return this.targetDao.findByDesc1(desc1);
	}

	@Override
	public List<Target> findAllDesc1AndId() {
		return this.targetDao.findAllDesc1AndId();
	}

	@Override
	public Target selectTarget(String selectId) {
		if ("initValue".equals(selectId)) {
			return new Target();
		}else {
			Target t = this.load(selectId);
			return t;
		}
	}

}
