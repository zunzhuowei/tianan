package com.org.test.keega.utli;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 * 基于jdbcTemplate的添加时的工具;
 * 插入语句已在这里写好。当要添加一个实体类的时候，直接使用AddUtil.add(o,jdbcTemplate)就好
 * @author asus_n56
 *
 */
public class AddUtil {
	
	/*@Resource
	private JdbcDao jdbc;*/
	
	/**
	 * 特别注意：添加的表名为 对象的名才能使用
	 * @param o 要添加的对象
	 * @param jdbcTemplate Spring的jdbcTemplate
	 */
	public static final void add(Object o ,JdbcTemplate jdbcTemplate){
		Method[] ms = o.getClass().getDeclaredMethods();
		Field[] fs = o.getClass().getDeclaredFields();
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> listStr = new ArrayList<String>();
		
		try {
			for (int i = 0; i < ms.length; i++) {
				if (ms[i].getName().startsWith("get")) {
					for (int j = 0; j < fs.length; j++) {
						if (fs[j].getName().equals(ms[i].getName().substring(3).substring(0, 1).toLowerCase()+ms[i].getName().substring(4))) {
							map.put(fs[j].getName(), ms[i].invoke(o));//将相应的字段名作为key，值是对象get出来的值
							listStr.add(fs[j].getName());//把所有的字段都放到list中
							break;
						}
					}
				}
			}
			
			if (map.containsKey("p0400")) {
				map.remove("p0400"); //TODO 这个用于不是自增id的时候
				Integer in = jdbcTemplate.queryForObject(" select MAX(p0400) from P04 ", Integer.class);
				if (in==null) {
					in = 0;
				}
				map.put("p0400", in+1);
			}
			
			String s = "(";//字段
			String v = "(";//值
			for (int i = 0; i < map.size(); i++) {
				if (!listStr.get(i).equals("id")) {//id不能插入
					s += ""+listStr.get(i)+",";
					v +="'"+map.get(listStr.get(i))+"',";
				}
			}
			
			String ss = s.substring(0, s.length()-1)+")";//把最后一个逗号给去掉
			String vv = v.substring(0,v.length()-1)+")";//把最后一个逗号给去掉
			String sql = "insert into "+o.getClass().getSimpleName()+" "+ss+" values "+vv+"";
			sql = sql.replace("id,", "");
			jdbcTemplate.execute(sql);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	
	public static final void addP04(Object o ,JdbcTemplate jdbcTemplate){
		Method[] ms = o.getClass().getDeclaredMethods();
		Field[] fs = o.getClass().getDeclaredFields();
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> listStr = new ArrayList<String>();
		
		try {
			for (int i = 0; i < ms.length; i++) {
				if (ms[i].getName().startsWith("get")) {
					for (int j = 0; j < fs.length; j++) {
						if (fs[j].getName().equals(ms[i].getName().substring(3).substring(0, 1).toLowerCase()+ms[i].getName().substring(4))) {
							map.put(fs[j].getName(), ms[i].invoke(o));//将相应的字段名作为key，值是对象get出来的值
							listStr.add(fs[j].getName());//把所有的字段都放到list中
							break;
						}
					}
				}
			}
			Integer in1 = null;
			if (map.containsKey("p0400")) {
				map.remove("p0400"); //TODO 这个用于不是自增id的时候
				Integer in = jdbcTemplate.queryForObject(" select MAX(p0400) from P04 ", Integer.class);
				if (in == null) {
					in = 0;
				}
				in1 = in + 1;
				map.put("p0400", in + 1);
			}
			
			String s = "(";//字段
			String v = "(";//值
			for (int i = 0; i < map.size(); i++) {
				if (!listStr.get(i).equals("id")) {//id不能插入
					s += ""+listStr.get(i)+",";
					v +="'"+map.get(listStr.get(i))+"',";
				}
			}
			s += "P0401"+" ,";
			v += "'"+in1+"'" + " ,";
			String ss = s.substring(0, s.length()-1)+")";//把最后一个逗号给去掉
			String vv = v.substring(0,v.length()-1)+")";//把最后一个逗号给去掉
			String sql = "insert into "+o.getClass().getSimpleName()+" "+ss+" values "+vv+"";
			//sql = sql.replace("id,", "");
			jdbcTemplate.execute(sql);
		} catch (DataAccessException  e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static final void addSecondP04(Object o ,JdbcTemplate jdbcTemplate){
		Method[] ms = o.getClass().getDeclaredMethods();
		Field[] fs = o.getClass().getDeclaredFields();
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> listStr = new ArrayList<String>();
		
		try {
			for (int i = 0; i < ms.length; i++) {
				if (ms[i].getName().startsWith("get")) {
					for (int j = 0; j < fs.length; j++) {
						if (fs[j].getName().equals(ms[i].getName().substring(3).substring(0, 1).toLowerCase()+ms[i].getName().substring(4))) {
							map.put(fs[j].getName(), ms[i].invoke(o));//将相应的字段名作为key，值是对象get出来的值
							listStr.add(fs[j].getName());//把所有的字段都放到list中
							break;
						}
					}
				}
			}
			Integer in1 = null;
			if (map.containsKey("p0400")) {
				map.remove("p0400"); //TODO 这个用于不是自增id的时候
				Integer in = jdbcTemplate.queryForObject(" select MAX(p0400) from P04 ", Integer.class);
				if (in==null) {
					in = 0;
				}
				in1 = in + 1;
				map.put("p0400", in+1);
			}
			
			String s = "(";//字段
			String v = "(";//值
			for (int i = 0; i < map.size(); i++) {
				if (!listStr.get(i).equals("id")) {//id不能插入
					s += ""+listStr.get(i)+",";
					v +="'"+map.get(listStr.get(i))+"',";
				}
			}
			s += "P0401"+" ,";
			v += "'"+in1+"'" + " ,";
			String ss = s.substring(0, s.length()-1)+")";//把最后一个逗号给去掉
			String vv = v.substring(0,v.length()-1)+")";//把最后一个逗号给去掉
			String sql = "insert into "+"p04"+" "+ss+" values "+vv+"";
			//sql = sql.replace("id,", "");
			jdbcTemplate.execute(sql);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	
	public static final void addEvalution(Object o ,JdbcTemplate jdbcTemplate){
		Method[] ms = o.getClass().getDeclaredMethods();
		Field[] fs = o.getClass().getDeclaredFields();
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> listStr = new ArrayList<String>();
		
		try {
			for (int i = 0; i < ms.length; i++) {
				if (ms[i].getName().startsWith("get")) {
					for (int j = 0; j < fs.length; j++) {
						if (fs[j].getName().equals(ms[i].getName().substring(3).substring(0, 1).toLowerCase()+ms[i].getName().substring(4))) {
							map.put(fs[j].getName(), ms[i].invoke(o));//将相应的字段名作为key，值是对象get出来的值
							listStr.add(fs[j].getName());//把所有的字段都放到list中
							break;
						}
					}
				}
			}
			
			if (map.containsKey("id")) {
				map.remove("id"); //TODO 这个用于不是自增id的时候
				Integer in = jdbcTemplate.queryForObject(" select MAX(id) from per_target_evaluation ", Integer.class);
				if (in==null) {
					in = 0;
				}
				map.put("id", in+1);
			}
			
			String s = "(";//字段
			String v = "(";//值
			for (int i = 0; i < map.size(); i++) {
				s += ""+listStr.get(i)+",";
				v +="'"+map.get(listStr.get(i))+"',";
				//if (!listStr.get(i).equals("id")) {//id不能插入
				//	s += ""+listStr.get(i)+",";
				//	v +="'"+map.get(listStr.get(i))+"',";
				//}
			}
			
			String ss = s.substring(0, s.length()-1)+")";//把最后一个逗号给去掉
			String vv = v.substring(0,v.length()-1)+")";//把最后一个逗号给去掉
			String sql = "insert into "+"per_target_evaluation"+" "+ss+" values "+vv+"";
			//sql = sql.replace("id,", "");
//System.out.println(sql);
			jdbcTemplate.execute(sql);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	public static final void addCommonSorce(Object o ,JdbcTemplate jdbcTemplate,int plan_id){
		Method[] ms = o.getClass().getDeclaredMethods();
		Field[] fs = o.getClass().getDeclaredFields();
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> listStr = new ArrayList<String>();
		
		try {
			for (int i = 0; i < ms.length; i++) {
				if (ms[i].getName().startsWith("get")) {
					for (int j = 0; j < fs.length; j++) {
						if (fs[j].getName().equals(ms[i].getName().substring(3).substring(0, 1).toLowerCase()+ms[i].getName().substring(4))) {
							map.put(fs[j].getName(), ms[i].invoke(o));//将相应的字段名作为key，值是对象get出来的值
							listStr.add(fs[j].getName());//把所有的字段都放到list中
							break;
						}
					}
				}
			}
			
			if (map.containsKey("id")) {
				map.remove("id"); //TODO 这个用于不是自增id的时候
				Integer in = jdbcTemplate.queryForObject(" select MAX(id) from per_table_"+plan_id+" ", Integer.class);
				if (in==null) {
					in = 0;
				}
				map.put("id", in+1);
			}
			
			String s = "(";//字段
			String v = "(";//值
			for (int i = 0; i < map.size(); i++) {
				s += ""+listStr.get(i)+",";
				v +="'"+map.get(listStr.get(i))+"',";
				//if (!listStr.get(i).equals("id")) {//id不能插入
				//	s += ""+listStr.get(i)+",";
				//	v +="'"+map.get(listStr.get(i))+"',";
				//}
			}
			
			String ss = s.substring(0, s.length()-1)+")";//把最后一个逗号给去掉
			String vv = v.substring(0,v.length()-1)+")";//把最后一个逗号给去掉
			String sql = "insert into "+"per_table_"+plan_id+""+" "+ss+" values "+vv+"";
			sql = sql.replace("null", "0");
			//sql = sql.replace("id,", "");
			//System.out.println(sql);
			jdbcTemplate.execute(sql);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
}
