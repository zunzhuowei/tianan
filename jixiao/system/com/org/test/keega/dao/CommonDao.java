package com.org.test.keega.dao;

import java.text.NumberFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.org.test.keega.model.Common;
import com.org.test.keega.utli.ListUtil;

@SuppressWarnings("unchecked")
@Repository("commonDao")
public class CommonDao implements ICommonDao {

	@Resource private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Common> getListCommonBPIByItemId(String template_id) {
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2);
		List<Common> list = (List<Common>) ListUtil.getListCommonBPIByItemId(Common.class, jdbcTemplate,template_id);
		/*for (int i = 0; i < list.size(); i++) {
			String rank = list.get(i).getRank();
			double d = Double.parseDouble(rank)*100;//放大一百倍
			list.get(i).setRank(numberFormat.format(d));
		}*/
		return list;
	}

	
	@Override
	public List<Common> getListCommonByItemId(String template_id) {
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2);
		List<Common> list = (List<Common>) ListUtil.getListCommonByItemId(Common.class, jdbcTemplate,template_id);
		for (int i = 0; i < list.size(); i++) {
			String rank = list.get(i).getRank();
			double d = Double.parseDouble(rank)*100;//放大一百倍
			list.get(i).setRank(numberFormat.format(d));
		}
		return list;
	}
	
	
	
}
