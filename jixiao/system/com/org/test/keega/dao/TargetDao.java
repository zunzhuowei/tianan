package com.org.test.keega.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.org.test.keega.model.Target;
import com.org.test.keega.utli.AddUtil;
import com.org.test.keega.utli.DeleteUtil;
import com.org.test.keega.utli.ListUtil;
import com.org.test.keega.utli.LoadUtil;
import com.org.test.keega.utli.UpdateUtil;

@Repository("targetDao")
public class TargetDao implements ITargetDao {

	@Resource
	JdbcTemplate jdbc;
	
	@Override
	public void add(Target target) {
		AddUtil.add(target, jdbc);

	}

	@Override
	public void update(Target target) {
		UpdateUtil.update(target, jdbc);

	}

	@Override
	public void delete(int id) {
		DeleteUtil.delete(Target.class, id, jdbc);

	}

	@Override
	public Target load(String id) {
		return (Target) LoadUtil.load(jdbc, id, Target.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Target> listAllTarget() {
		return (List<Target>) ListUtil.listAllTarget(Target.class, jdbc);
	}

	@Override
	public List<Target> findByDesc1(String desc1) {
		return  LoadUtil.loadByDesc1(jdbc, Target.class, desc1);// 这里返回全部字段了，包括desc1，但是可以不使用
	}

	@Override
	public List<Target> findAllDesc1AndId() {
		/*List<Target> listTarget = this.listAllTarget();
		for (Target target : listTarget) {
			P04 p = new P04();
			p.setP04BA(target.getDesc1());
			new P04Dao().add(p);
		}*/
		return LoadUtil.findAllDesc1AndId(jdbc, Target.class);
	}

}
