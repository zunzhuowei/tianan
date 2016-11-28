package com.org.test.keega.utli;

import java.util.Map;

import com.dexcoder.commons.utils.JsonUtil;

public class ChangeOrgJsonString2New {
	/**
	 * 将前端传过来的原始数据转换成一个新的Json数据,也就是去掉[]，分成对象数组
	 * @param data
	 * @return
	 */
	public static final String[] changeOrgJsonString2New(String data){
		data = data.replace("[", "");
		data = data.replace("]", "");
		data = data.replace("},{", "}fixfixfix{");
		String[] datas = data.split("fixfixfix");
		return datas;
	}
	
	/**
	 * 检查传过来的数据的状态，不同的状态分别对应着增删改查，“_state:modified”表示修改；
	 * “_state:added”表示添加；“_state:added”表示removed
	 * @return
	 */
	public static final String check_State(String dataChild){
		Map<String, Object> objectMap = JsonUtil.getJsonToMap(dataChild);
		String str = (String) objectMap.get("_state");
		return str;
	}
	
	public static final Map<String,Object> String2Object(String str){
		Map<String, Object> objectMap = JsonUtil.getJsonToMap(str);
		return objectMap;
	}
}
