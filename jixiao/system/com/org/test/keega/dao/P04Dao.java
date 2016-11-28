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
import com.org.test.keega.model.P04;
import com.org.test.keega.utli.AddUtil;
import com.org.test.keega.utli.DeleteUtil;
import com.org.test.keega.utli.ListUtil;
import com.org.test.keega.utli.LoadUtil;
import com.org.test.keega.utli.UpdateUtil;

@Repository("p04Dao")
public class P04Dao implements IP04Dao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private ITargetDao targetDao;

	@Override
	public void add(P04 p04) {
		AddUtil.addP04(p04, jdbcTemplate);
	}

	@Override
	public void delete(int id) {
		DeleteUtil.deleteP0400(P04.class, id, jdbcTemplate);
	}

	@Override
	public void update(P04 p04) {
		UpdateUtil.updateP0400(p04, jdbcTemplate);
	}

	@Override
	public P04 load(String id) {
		return (P04) LoadUtil.loadP0400(jdbcTemplate, id, P04.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<P04> listAllP04(String planid,String objectId,String template_id) {
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2);
		List<P04> list = (List<P04>) ListUtil.listAllP04(P04.class, jdbcTemplate,planid,objectId,template_id);
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i).getP0415();
			Double d = Double.parseDouble(str);
			String str1 = numberFormat.format(d*100);//从数据库取出来的值乘以100倍
			list.get(i).setP0415(str1);
		}
		//return (List<P04>) ListUtil.listAllP04(P04.class, jdbcTemplate,planid,objectId);
		return list ;
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
