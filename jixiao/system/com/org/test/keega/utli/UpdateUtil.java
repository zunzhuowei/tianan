package com.org.test.keega.utli;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 * 用于更新的工具
 * @author asus_n56
 *
 */
public class UpdateUtil {
	/**
	 * 更新的表名为 对象的名
	 * @param o 要更新的对象
	 * @param jdbcTemplate Spring的jdbcTemplate
	 */
	public static final void update(Object o ,JdbcTemplate jdbcTemplate){
		Method[] ms = o.getClass().getDeclaredMethods();
		Field[] fs = o.getClass().getDeclaredFields();
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> listStr = new ArrayList<String>();
		try {
			for (int i = 0; i < ms.length; i++) {
				if (ms[i].getName().startsWith("get")) {
					for (int j = 0; j < fs.length; j++) {
						if (fs[j].getName().equals(ms[i].getName().substring(3).substring(0, 1).toLowerCase()+ms[i].getName().substring(4))) {
							map.put(fs[j].getName(), ms[i].invoke(o));
							listStr.add(fs[j].getName());
							break;
						}
					}
				}
			}
			String s = "";
			for (int i = 0; i < map.size(); i++) {
				if (map.get(listStr.get(i)) != null) {
					s += ""+listStr.get(i)+" = '"+map.get(listStr.get(i))+"' ,";
				}
			}
			String ss = s.substring(0, s.length()-1);//把最后一个逗号给去掉
			String sql = "update "+o.getClass().getSimpleName()+" set "+ss+" where id = "+o.getClass().getMethod("getId").invoke(o)+"";
			sql = sql.replace("id = '"+o.getClass().getMethod("getId").invoke(o)+"' ,", "");
			sql = sql.replace(",id = '"+o.getClass().getMethod("getId").invoke(o)+"'", "");
			jdbcTemplate.execute(sql);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 更新的表名为 对象的名
	 * @param o 要更新的对象
	 * @param jdbcTemplate Spring的jdbcTemplate
	 */
	public static final void updateP0400(Object o ,JdbcTemplate jdbcTemplate){
		Method[] ms = o.getClass().getDeclaredMethods();
		Field[] fs = o.getClass().getDeclaredFields();
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> listStr = new ArrayList<String>();
		try {
			for (int i = 0; i < ms.length; i++) {
				if (ms[i].getName().startsWith("get")) {
					for (int j = 0; j < fs.length; j++) {
						if (fs[j].getName().equals(ms[i].getName().substring(3).substring(0, 1).toLowerCase()+ms[i].getName().substring(4))) {
							map.put(fs[j].getName(), ms[i].invoke(o));
							listStr.add(fs[j].getName());
							break;
						}
					}
				}
			}
			String s = "";
			for (int i = 0; i < map.size(); i++) {
				if (map.get(listStr.get(i)) != null) {
					s += ""+listStr.get(i)+" = '"+map.get(listStr.get(i))+"' ,";
				}
			}
			String ss = s.substring(0, s.length()-1);//把最后一个逗号给去掉
			String sql = "update "+o.getClass().getSimpleName()+" set "+ss+" where p0400 = "+o.getClass().getMethod("getP0400").invoke(o)+"";
			sql = sql.replace("p0400 = '"+o.getClass().getMethod("getP0400").invoke(o)+"' ,", "");
			sql = sql.replace(",p0400 = '"+o.getClass().getMethod("getP0400").invoke(o)+"'", "");
//System.out.println(sql);
			jdbcTemplate.execute(sql);
		} catch (DataAccessException  e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public static final void updateSecondP0400(Object o ,JdbcTemplate jdbcTemplate){
		Method[] ms = o.getClass().getDeclaredMethods();
		Field[] fs = o.getClass().getDeclaredFields();
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> listStr = new ArrayList<String>();
		try {
			for (int i = 0; i < ms.length; i++) {
				if (ms[i].getName().startsWith("get")) {
					for (int j = 0; j < fs.length; j++) {
						if (fs[j].getName().equals(ms[i].getName().substring(3).substring(0, 1).toLowerCase()+ms[i].getName().substring(4))) {
							map.put(fs[j].getName(), ms[i].invoke(o));
							listStr.add(fs[j].getName());
							break;
						}
					}
				}
			}
			String s = "";
			for (int i = 0; i < map.size(); i++) {
				if (map.get(listStr.get(i)) != null) {
					s += ""+listStr.get(i)+" = '"+map.get(listStr.get(i))+"' ,";
				}
			}
			String ss = s.substring(0, s.length()-1);//把最后一个逗号给去掉
			String sql = "update "+"p04"+" set "+ss+" where p0400 = "+o.getClass().getMethod("getP0400").invoke(o)+"";
			sql = sql.replace("p0400 = '"+o.getClass().getMethod("getP0400").invoke(o)+"' ,", "");
			sql = sql.replace(",p0400 = '"+o.getClass().getMethod("getP0400").invoke(o)+"'", "");
//System.out.println(sql);
			jdbcTemplate.execute(sql);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	//修改自评 TODO 未用
	public static final void updateEvaluation(Object o ,JdbcTemplate jdbcTemplate,String mainbodyid,String objectid,String planid){
		Method[] ms = o.getClass().getDeclaredMethods();
		Field[] fs = o.getClass().getDeclaredFields();
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> listStr = new ArrayList<String>();
		try {
			for (int i = 0; i < ms.length; i++) {
				if (ms[i].getName().startsWith("get")) {
					for (int j = 0; j < fs.length; j++) {
						if (fs[j].getName().equals(ms[i].getName().substring(3).substring(0, 1).toLowerCase()+ms[i].getName().substring(4))) {
							map.put(fs[j].getName(), ms[i].invoke(o));
							listStr.add(fs[j].getName());
							break;
						}
					}
				}
			}
			String s = "";
			for (int i = 0; i < map.size(); i++) {
				if (map.get(listStr.get(i)) != null) {
					s += ""+listStr.get(i)+" = '"+map.get(listStr.get(i))+"' ,";
				}
			}
			String ss = s.substring(0, s.length()-1);
			//把最后一个逗号给去掉,String mainbodyid,String objectid,String planid
			String sql = "update "+"per_target_evaluation "+" set "+ss+" where "
					+ "object_id = '"+objectid+"' and mainbody_id = '"+mainbodyid+"' and plan_id = '"+planid+"' and p0400 = '"+o.getClass().getMethod("getP0400").invoke(o)+"'";
			sql = sql.replace("id = '"+o.getClass().getMethod("getId").invoke(o)+"' ,", "");
			sql = sql.replace(",id = '"+o.getClass().getMethod("getId").invoke(o)+"'", "");
System.out.println(sql);
			jdbcTemplate.execute(sql);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	//修改他评 TODO 未用
	public static final void updateEvaluationOther(Object o ,JdbcTemplate jdbcTemplate){
		Method[] ms = o.getClass().getDeclaredMethods();
		Field[] fs = o.getClass().getDeclaredFields();
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> listStr = new ArrayList<String>();
		try {
			for (int i = 0; i < ms.length; i++) {
				if (ms[i].getName().startsWith("get")) {
					for (int j = 0; j < fs.length; j++) {
						if (fs[j].getName().equals(ms[i].getName().substring(3).substring(0, 1).toLowerCase()+ms[i].getName().substring(4))) {
							map.put(fs[j].getName(), ms[i].invoke(o));
							listStr.add(fs[j].getName());
							break;
						}
					}
				}
			}
			String s = "";
			for (int i = 0; i < map.size(); i++) {
				if (map.get(listStr.get(i)) != null) {
					s += ""+listStr.get(i)+" = '"+map.get(listStr.get(i))+"' ,";
				}
			}
			String ss = s.substring(0, s.length()-1);//把最后一个逗号给去掉
			String sql = "update "+"per_target_evaluation "+" set "+ss+" where per_target_evaluation.object_id != per_target_evaluation.mainbody_id and p0400 = '"+o.getClass().getMethod("getP0400").invoke(o)+"'";
			sql = sql.replace("id = '"+o.getClass().getMethod("getId").invoke(o)+"' ,", "");
			sql = sql.replace(",id = '"+o.getClass().getMethod("getId").invoke(o)+"'", "");
//System.out.println(sql);
			jdbcTemplate.execute(sql);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public static final void updateCommonScore(Object o ,String point_id,String object_id,int plan_id,String mainbodyid,JdbcTemplate jdbcTemplate) throws SecurityException {
		Method[] ms = o.getClass().getDeclaredMethods();
		Field[] fs = o.getClass().getDeclaredFields();
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> listStr = new ArrayList<String>();
		try {
			for (int i = 0; i < ms.length; i++) {
				if (ms[i].getName().startsWith("get")) {
					for (int j = 0; j < fs.length; j++) {
						if (fs[j].getName().equals(ms[i].getName().substring(3).substring(0, 1).toLowerCase()+ms[i].getName().substring(4))) {
							map.put(fs[j].getName(), ms[i].invoke(o));
							listStr.add(fs[j].getName());
							break;
						}
					}
				}
			}
			String s = "";
			for (int i = 0; i < map.size(); i++) {
				if (map.get(listStr.get(i)) != null) {
					s += ""+listStr.get(i)+" = '"+map.get(listStr.get(i))+"' ,";
				}
			}
			String ss = s.substring(0, s.length()-1);//把最后一个逗号给去掉
			String sql = "update "+"per_table_"+plan_id+" "+" set "+ss+" where per_table_"+plan_id+".object_id = '"+object_id+"' and per_table_"+plan_id+".point_id = '"+point_id+"' and per_table_"+plan_id+".mainbody_id = '"+mainbodyid+"'";
			sql = sql.replace("id = '"+o.getClass().getMethod("getId").invoke(o)+"' ,", "");
			sql = sql.replace(",id = '"+o.getClass().getMethod("getId").invoke(o)+"'", "");
//System.out.println(sql);
			jdbcTemplate.execute(sql);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
