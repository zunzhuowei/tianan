package com.org.test.keega.utli;
import java.util.List;

import com.dexcoder.commons.utils.JsonUtil;
import com.org.test.keega.model.P04;
import com.org.test.keega.model.Target;
import com.org.test.keega.service.ITargetService;
import com.org.test.keega.service.P04Service;

public class ExecuteHandler {
	
	//@Resource private IP04Service p04Service;
	
	/**
	 * 处理前端传过来的内容，是插入还是更新还是删除
	 * @param state 标识符，不同的状态对应着更新删除插入
	 * @param dataChild 传过来的子数据
	 */
	public static final void executeHandler(String state,String dataChild,ITargetService targetService){
		/**
		 * 将浏览器提交过来的json字符串转换成Map集合
		 */
		if (state.equals("modified")) {
			Target u = JasonMap2Object.jasonMap2Object(dataChild, targetService);
			targetService.update(u);
		}
		if (state.equals("added")) {
			Target u = JasonMap2Object.jasonMap2Object(dataChild, targetService);
			/*P04 p = new P04();
			p.setP04BA(u.getDesc1());
			new P04Service().add(p);//在添加目标的时候，同时需要在P04表中添加对应目标的的desc1的字段名和目标的id*/
			targetService.add(u);
		}
		if (state.equals("removed")) {
			Target u = JasonMap2Object.jasonMap2Object(dataChild, targetService);
			targetService.delete(u.getId());
		}
	}
	
	
	/**
	 * 判断是输出用户列表还是模糊查询。
	 * @param key 模糊查询的关键字；如果关键字为null，则输出用户列表
	 * @param targetService
	 * @return
	 */
	public static final String FindOrList(String key,ITargetService targetService){
		/**
		 * 将对象转换成Json字符串，然后返回到浏览器
		 */
		if (key==null) {//没有查询条件的时候查询全部用户
			List<Target> users = targetService.listAllTarget();
			String jsonStr = JsonUtil.list2json(users);
			return jsonStr;
		}else {//有查询条件的时候，根据用户名字模糊查询
			List<Target> users = targetService.findByDesc1(key);
			String jsonStr = JsonUtil.list2json(users);
			return jsonStr;
		}
	}
}
