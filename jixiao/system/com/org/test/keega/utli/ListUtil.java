package com.org.test.keega.utli;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ListUtil {
	
	/**
	 * 特别注意：这里的clz的对应的类的名字对应表的名字，比喻一样。
	 * @param clz 要输出列表的类的class
	 * @param jdbc Spring JdbcTemplate
	 * @return
	 */
	public static List<?> listAll(Class<?> clz,JdbcTemplate jdbc){
		Field[] fs = clz.getDeclaredFields();
		String s = "";
		for (int i = 0; i < fs.length; i++) {
			s += fs[i].getName()+",";
		}
		s = s.substring(0, s.length()-1);
		String sql = "select "+s+" from "+clz.getSimpleName()+" where p04BB is null";
		List<Object> list = jdbc.query(sql,new ClzMapper(clz));
		return list;
	}
	//TODO  285
	public static List<?> listAllP04(Class<?> clz,JdbcTemplate jdbc,String planid,String objectid,String template_id){
		Field[] fs = clz.getDeclaredFields();
		String s = "";
		for (int i = 0; i < fs.length; i++) {
			s += fs[i].getName()+",";
		}
		s = s.substring(0, s.length()-1);
		String sql = "";
		if ("Z01Q".equals(template_id.trim())) {//管理员
			sql = "select "+s+" from "+clz.getSimpleName()+" where item_id = 279 and plan_id='"+planid+"' and a0100 = "+"'"+objectid+"'";
		} else {//普通员工
			sql = "select "+s+" from "+clz.getSimpleName()+" where item_id = 285 and plan_id='"+planid+"' and a0100 = "+"'"+objectid+"'";
		}
		List<Object> list = jdbc.query(sql,new ClzMapper(clz));
		return list;
	}
	
	public static List<?> listAllTarget(Class<?> clz,JdbcTemplate jdbc){
		Field[] fs = clz.getDeclaredFields();
		String s = "";
		for (int i = 0; i < fs.length; i++) {
			s += fs[i].getName()+",";
		}
		s = s.substring(0, s.length()-1);
		String sql = "select "+s+" from "+clz.getSimpleName()+"";
		List<Object> list = jdbc.query(sql,new ClzMapper(clz));
		return list;
	}
	//TODO 286
	public static List<?> listAllSecondP04(Class<?> clz,JdbcTemplate jdbc,String tableName,String planid,String objectid,String template_id){
		Field[] fs = clz.getDeclaredFields();
		String s = "";
		for (int i = 0; i < fs.length; i++) {
			s += fs[i].getName()+",";
		}
		s = s.substring(0, s.length()-1);
		String sql = "";
		if ("Z01Q".equals(template_id.trim())) {//管理员
			sql = "select "+s+" from "+tableName+" where item_id = 280 and plan_id='"+planid+"' and a0100 = "+"'"+objectid+"'";
		} else {//普通员工
			sql = "select "+s+" from "+tableName+" where item_id = 286 and plan_id='"+planid+"' and a0100 = "+"'"+objectid+"'";
		}
		List<Object> list = jdbc.query(sql,new ClzMapper(clz));
		return list;
	}
	
	public static List<?> listByObjectId(Class<?> clz,JdbcTemplate jdbc,String object_id ){
		Field[] fs = clz.getDeclaredFields();//per_target_evaluation
		String s = "";
		for (int i = 0; i < fs.length; i++) {
			s += fs[i].getName()+",";
		}
		s = s.substring(0, s.length()-1);
		String sql = "select "+s+" from "+"per_target_evaluation"+" where object_id = '"+object_id+"'";
		List<Object> list = jdbc.query(sql,new ClzMapper(clz));
		return list;
	}
	
	public static List<?> listByMainBodyId(Class<?> clz,JdbcTemplate jdbc,String mainBodyId ){
		Field[] fs = clz.getDeclaredFields();//per_target_evaluation
		String s = "";
		for (int i = 0; i < fs.length; i++) {
			s += fs[i].getName()+",";
		}
		s = s.substring(0, s.length()-1);
		String sql = "select "+s+" from "+"per_target_evaluation"+" where mainbody_id = '"+mainBodyId+"'";
		List<Object> list = jdbc.query(sql,new ClzMapper(clz));
		return list;
	}
	
	public static List<?> listByP0400(Class<?> clz,JdbcTemplate jdbc,String p0400 ){
		Field[] fs = clz.getDeclaredFields();//per_target_evaluation
		String s = "";
		for (int i = 0; i < fs.length; i++) {
			s += fs[i].getName()+",";
		}
		s = s.substring(0, s.length()-1);
		String sql = "select "+s+" from "+"per_target_evaluation"+" where p0400 = '"+p0400+"'";
		List<Object> list = jdbc.query(sql,new ClzMapper(clz));
		return list;
	}
	
	//----BPI考核 TODO  template_id='Z01R' and item_id='288')";,String template_id
	public static List<?> getListCommonBPIByItemId(Class<?> clz,JdbcTemplate jdbc,String template_id){
		String sql = "";
		if ("Z01Q".equals(template_id.trim())) {//管理员
			sql = "select a.point_id,b.pointname,b.description "
					+ "from per_template_point a,per_point b "
					+ "where a.point_id=b.point_id and item_id "
					+ "in(select item_id from per_template_item "
					+ "where template_id='Z01Q' and item_id='278')";
		} else {//普通员工
			sql = "select a.point_id,b.pointname,b.description "
					+ "from per_template_point a,per_point b "
					+ "where a.point_id=b.point_id and item_id "
					+ "in(select item_id from per_template_item "
					+ "where template_id='Z01R' and item_id='288')";
		}
		List<Object> list = jdbc.query(sql,new ClzMapper1(clz));
		return list;
	}
	
	
	//----通用类指标 TODO   template_id='Z01R' and item_id='287')";
	public static List<?> getListCommonByItemId(Class<?> clz,JdbcTemplate jdbc,String template_id){
		String sql = "";
		if ("Z01Q".equals(template_id.trim())) {
			sql = "select a.point_id,b.pointname,b.description,a.rank "
					+ "from per_template_point a,per_point b "
					+ "where a.point_id=b.point_id and item_id "
					+ 		"in(select item_id from per_template_item "
					+ "		where template_id='Z01Q' and item_id='281')";
		} else {
			sql = "select a.point_id,b.pointname,b.description,a.rank "
					+ "from per_template_point a,per_point b "
					+ "where a.point_id=b.point_id and item_id "
					+ 		"in(select item_id from per_template_item "
					+ "		where template_id='Z01R' and item_id='287')";
		}
		List<Object> list = jdbc.query(sql,new ClzMapper(clz));
		return list;
	}
	
	
	
	private static final class ClzMapper implements RowMapper<Object> {
		
		private Class<?> clz;
		@SuppressWarnings("unused")
		public ClzMapper() {}

		public ClzMapper(Class<?> clz) {
			this.clz = clz;
		}

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Object o = null;
			try {
				o = clz.newInstance();
				SetParameter.setParameter(o, rs);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			return o;
		}
		
	}
	
	private static final class ClzMapper1 implements RowMapper<Object> {
		
		private Class<?> clz;
		@SuppressWarnings("unused")
		public ClzMapper1() {}
		
		public ClzMapper1(Class<?> clz) {
			this.clz = clz;
		}
		
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Object o = null;
			try {
				o = clz.newInstance();
				SetParameter.setParameter1(o, rs);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			return o;
		}
		
	}
}
