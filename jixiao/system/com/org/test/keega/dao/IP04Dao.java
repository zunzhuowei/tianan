package com.org.test.keega.dao;

import java.util.List;

import com.org.test.keega.model.InitClass;
import com.org.test.keega.model.P04;

public interface IP04Dao {
	public void add(P04 p04);

	public void delete(int id);

	public void update(P04 p04);

	public P04 load(String id);
	
	public List<P04> listAllP04(String planid,String objectId,String template_id);
	
	public InitClass getInitClassByA0100(String a0100);
}
