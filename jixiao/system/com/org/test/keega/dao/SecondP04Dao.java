package com.org.test.keega.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.org.test.keega.model.InitClass;
import com.org.test.keega.model.SecondP04;
import com.org.test.keega.utli.AddUtil;
import com.org.test.keega.utli.DeleteUtil;
import com.org.test.keega.utli.ListUtil;
import com.org.test.keega.utli.LoadUtil;
import com.org.test.keega.utli.UpdateUtil;
import com.sun.org.apache.xml.internal.security.Init;

@Repository("secondP04Dao")
public class SecondP04Dao implements ISecondP04Dao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(SecondP04 secondP04) {
		AddUtil.addSecondP04(secondP04, jdbcTemplate);
	}

	@Override
	public void delete(String id) {
		DeleteUtil.deleteP0400s(SecondP04.class, id, jdbcTemplate);
	}

	@Override
	public void update(SecondP04 secondP04) {
		UpdateUtil.updateSecondP0400(secondP04, jdbcTemplate);
	}

	@Override
	public SecondP04 load(String id) {
		return (SecondP04) LoadUtil.loadSecondP04(jdbcTemplate, id, SecondP04.class, "p04");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecondP04> listAllSecondP04(String planid,String objectid,String template_id) {
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2);
		List<SecondP04> list = (List<SecondP04>) ListUtil.listAllSecondP04(SecondP04.class, jdbcTemplate, "p04", planid, objectid,template_id);
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i).getP0415();
			Double d = Double.parseDouble(str);
			String str1 = numberFormat.format(d*100);//将数据库取出来的值乘以100倍
			list.get(i).setP0415(str1);
		}
		return list;
		//return (List<SecondP04>) ListUtil.listAllSecondP04(SecondP04.class, jdbcTemplate, "p04",planid,objectid);
	}

	@Override
	public InitClass getInitClassByA0100(String a0100) {
		InitClass actor = this.jdbcTemplate.queryForObject(
				"select B0110 ,E0122 ,E01A1,'Usr' as NBASE,A0100 ,A0101 from UsrA01 where a0100 = '" + a0100 + "'",
				new RowMapper<InitClass>() {
					public InitClass mapRow(ResultSet rs, int rowNum) throws SQLException {
						InitClass a = new InitClass();
						a.setA0100(rs.getString("a0100"));
						a.setA0101(rs.getString("a0101"));
						a.setB0110(rs.getString("b0110"));
						a.setE0122(rs.getString("e0122"));
						a.setE01A1(rs.getString("e01a1"));
						a.setNBASE(rs.getString("nbase"));
						return a;
					}
				});
		return actor;
	}

}
