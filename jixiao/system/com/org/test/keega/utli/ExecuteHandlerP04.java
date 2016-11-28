package com.org.test.keega.utli;
import java.util.List;

import com.dexcoder.commons.utils.JsonUtil;
import com.org.test.keega.model.P04;
import com.org.test.keega.service.IP04Service;

public class ExecuteHandlerP04 {
	
	/**
	 * 处理前端传过来的内容，是插入还是更新还是删除
	 * @param state 标识符，不同的状态对应着更新删除插入
	 * @param dataChild 传过来的子数据
	 */
	public static final void executeHandler(String state,String dataChild,IP04Service p04Service){
		/**
		 * 将浏览器提交过来的json字符串转换成Map集合
		 */
		if (state.equals("modified")) {
			P04 u = JasonMap2Object.jasonMap2ObjectP04(dataChild, p04Service);
			p04Service.update(u);
		}
		if (state.equals("added")) {
			P04 u = JasonMap2Object.jasonMap2ObjectP04(dataChild, p04Service);
			p04Service.add(u);
		}
		if (state.equals("removed")) {
			P04 u = JasonMap2Object.jasonMap2ObjectP04(dataChild, p04Service);
			p04Service.delete(u.getP0400());
		}
	}
	
	
	/**
	 * 判断是输出用户列表还是模糊查询。
	 * @param key 模糊查询的关键字；如果关键字为null，则输出用户列表
	 * @param p04Service
	 * @return
	 */
	public static final String FindOrList(String key,IP04Service p04Service){//这个暂时未用
		/**
		 * 将对象转换成Json字符串，然后返回到浏览器
		 */
		if (key==null) {//没有查询条件的时候查询全部用户
			//List<Target> users = targetService.listAllTarget();
			//String jsonStr = JsonUtil.list2json(users);
			//return jsonStr;
			return null;
		}else {//有查询条件的时候，根据用户名字模糊查询
			//List<P04> users = p04Service.listAllP04();p04Service.l
			//String jsonStr = JsonUtil.list2json(users);
			//return jsonStr;
			return null;
		}
	}
}
