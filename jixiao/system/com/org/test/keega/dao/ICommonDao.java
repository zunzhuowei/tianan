package com.org.test.keega.dao;

import java.util.List;

import com.org.test.keega.model.Common;

public interface ICommonDao {
	public List<Common> getListCommonBPIByItemId(String template_id);

	public List<Common> getListCommonByItemId(String template_id);
	

}
