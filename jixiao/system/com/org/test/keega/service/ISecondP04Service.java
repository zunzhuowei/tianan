package com.org.test.keega.service;

import java.util.List;

import com.org.test.keega.model.InitClass;
import com.org.test.keega.model.SecondP04;
import com.org.test.keega.model.SecondP04AndEva;

public interface ISecondP04Service {

	public void add(SecondP04 secondP04);

	public void delete(String id);

	public void update(SecondP04 secondP04);

	public SecondP04 load(String id);

	public List<SecondP04> listAllSecondP04(String planid,String objectid,String template_id);
//objectid,mainbodyid,planid
	public List<SecondP04AndEva> listSecondP04AndEva(
			List<SecondP04> sp, IEvalutionService es,String objectid,String mainbodyid,String planid);
	
	public InitClass getInitClassByA0100(String a0100);
}
