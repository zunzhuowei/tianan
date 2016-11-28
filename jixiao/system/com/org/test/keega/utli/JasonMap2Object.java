package com.org.test.keega.utli;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import com.dexcoder.commons.utils.JsonUtil;
import com.org.test.keega.model.P04;
import com.org.test.keega.model.Target;
import com.org.test.keega.service.IP04Service;
import com.org.test.keega.service.ITargetService;


public class JasonMap2Object {
	
	/**
	 * 针对target,即：desc1,2,3,4,5,6
	 * @param data
	 * @param targetService
	 * @return
	 */
	public static final Target jasonMap2Object(String data,
			ITargetService targetService) {
		if (data != null) {
			data = data.replace("[", "");
			data = data.replace("]", "");
			data = data.replace("},{", "}fixfixfix{");
			String[] datas = data.split("fixfixfix");
			Target u = new Target();
			Target user = null;
			for (int i = 0; i < datas.length; i++) {// datas表示多个对象字符串
				Map<String, Object> objectMap = JsonUtil.getJsonToMap(datas[i]);
				for (int j = 0; j < objectMap.size(); j++) {
					Set<String> sets = objectMap.keySet();// 所有的键
					for (String set : sets) {// set是指键的String字符串
						if (set.equals("desc1")) {
							u.setDesc1((String) objectMap.get(set));
						}
						if (set.equals("desc2")) {
							u.setDesc2((String) objectMap.get(set));
						}
						if (set.equals("desc3")) {
							u.setDesc3((String) objectMap.get(set));
						}
						if (set.equals("desc4")) {
							u.setDesc4((String) objectMap.get(set));
						}
						if (set.equals("desc5")) {
							u.setDesc5((String) objectMap.get(set));
						}
						if (set.equals("desc6")) {
							u.setDesc6((String) objectMap.get(set));
						}
						
						if (set.equals("id")) {
							String s = objectMap.get(set) + "";
							int iii = Integer.parseInt(s);
							u.setId(iii);
						}

					}
				}
				if (objectMap.containsKey("id")) {
					String s = objectMap.get("id") + "";
					user = targetService.load(s);
					//int iii = Integer.parseInt(s);
					//user = targetService.load(iii);// 
					try {
						BeanUtils.copyProperties(user, u);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					
				}else {
					return u;
				}
			}
			return user;
		} else {
			return null;
		}
	}
	
	
	/**
	 * 针对P04
	 * @param data
	 * @param targetService
	 * @return
	 */
	public static final P04 jasonMap2ObjectP04(String data,
			IP04Service p04Service) {
		if (data != null) {
			data = data.replace("[", "");
			data = data.replace("]", "");
			data = data.replace("},{", "}fixfixfix{");
			String[] datas = data.split("fixfixfix");
			P04 u = new P04();
			P04 user = null;
			for (int i = 0; i < datas.length; i++) {// datas表示多个对象字符串
				Map<String, Object> objectMap = JsonUtil.getJsonToMap(datas[i]);
				for (int j = 0; j < objectMap.size(); j++) {
					Set<String> sets = objectMap.keySet();// 所有的键
					Iterator<String> it = sets.iterator();
					while(it.hasNext()){
						String set = it.next();
						if (set.equals("desc1")) {//TODO 这个由于table.ftl里面对应的是desc1，所以这里用这个p04BA取不到值
							u.setP04BA((String) objectMap.get(set));
						}
						if (set.equals("p0407")) {
							u.setP0407((String) objectMap.get(set));
						}
						if (set.equals("p04BC")) {
							u.setP04BC((String) objectMap.get(set));
						}
						if (set.equals("p0415")) {
							u.setP0415((String)objectMap.get(set));
						}
						if (set.equals("p04Z9")) {
							u.setP04Z9((String) objectMap.get(set));
						}
						
						if (set.equals("p0400")) {
							String s = objectMap.get(set) + "";
							int iii = Integer.parseInt(s);
							u.setP0400(iii);
						}
					}
					/*for (String set : sets) {// set是指键的String字符串
						if (set.equals("p04BA")) {
							u.setP04BA((String) objectMap.get(set));
						}
						if (set.equals("p0407")) {
							u.setP0407((String) objectMap.get(set));
						}
						if (set.equals("p04BC")) {
							u.setP04BC((String) objectMap.get(set));
						}
						if (set.equals("p0415")) {
							u.setP0415((Double)objectMap.get(set));
						}
						if (set.equals("p04Z9")) {
							u.setP04Z9((String) objectMap.get(set));
						}
						
						if (set.equals("p0400")) {
							String s = objectMap.get(set) + "";
							int iii = Integer.parseInt(s);
							u.setP0400(iii);
						}
						
					}*/
				}
				if (objectMap.containsKey("p0400")) {
					String s = objectMap.get("p0400") + "";
					user = p04Service.load(s);
					try {
						BeanUtils.copyProperties(user, u);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					
				}else {
					return u;
				}
			}
			return user;//TODO 这里返回空。所有出现空指针
		} else {
			return null;
		}
	}
	
	
}
