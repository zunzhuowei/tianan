package com.org.test.keega.dao;

import java.util.List;

import com.org.test.keega.model.InitClass;
import com.org.test.keega.model.SecondP04;

public interface ISecondP04Dao {
	
	public void add(SecondP04 secondP04);

	public void delete(String id);

	public void update(SecondP04 secondP04);

	public SecondP04 load(String id);
	
	public List<SecondP04> listAllSecondP04(String planid,String objectid,String template_id);
	
	public InitClass getInitClassByA0100(String a0100);
}
