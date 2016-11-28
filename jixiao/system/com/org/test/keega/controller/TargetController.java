package com.org.test.keega.controller;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dexcoder.commons.utils.JsonUtil;
import com.org.test.keega.model.Target;
import com.org.test.keega.service.ITargetService;
import com.org.test.keega.utli.ChangeOrgJsonString2New;
import com.org.test.keega.utli.ExecuteHandler;

@Controller
@RequestMapping(value="/target")
public class TargetController {
	
	@Resource
	private ITargetService targetService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public void list(){

	}
	
	@RequestMapping(value="/InitDatas",method=RequestMethod.POST)
	public @ResponseBody String InitDatas(String key){
		if (key!=null&&!"".equals(key.trim())) {
			String ss = ExecuteHandler.FindOrList(key, targetService);
			return ss;
		}else {
			List<Target> list = this.targetService.listAllTarget();
			String s = JsonUtil.list2json(list);
			return s;
		}
	}
	
	@RequestMapping(value="/saveTarget",method=RequestMethod.POST)
	public @ResponseBody String saveTarget(String target){
		if (target != null && !target.equals("[]")) {
			String[] dataChild = ChangeOrgJsonString2New
					.changeOrgJsonString2New(target);
			for (int i = 0; i < dataChild.length; i++) {
				String state = ChangeOrgJsonString2New
						.check_State(dataChild[i]);
				ExecuteHandler.executeHandler(state, dataChild[i], targetService); //TODO 暂时注释
			}
		}
		String returnJson = ExecuteHandler.FindOrList(null, targetService);
		return returnJson;
	}
	
	@RequestMapping(value="/datagrid")
	public void datagrid(){}
}
