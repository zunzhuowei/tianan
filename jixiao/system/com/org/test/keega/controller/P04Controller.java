package com.org.test.keega.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dexcoder.commons.utils.JsonUtil;
import com.org.test.keega.model.P04;
import com.org.test.keega.model.Target;
import com.org.test.keega.service.IP04Service;
import com.org.test.keega.service.ITargetService;
import com.org.test.keega.utli.AddTargetJson2P04Json;
import com.org.test.keega.utli.ChangeOrgJsonString2New;
import com.org.test.keega.utli.ExecuteHandlerP04;

@Controller
@RequestMapping(value="/p04")
public class P04Controller {
	
	@Resource
	private ITargetService targetService;
	@Resource
	private IP04Service p04Service;
	
	/**
	 * 进入页面
	 * @param m
	 * @return
	 */
	@RequestMapping(value="/table",method=RequestMethod.GET)
	public String Go2Table(Model m){
		return "/target/table";
	};
	
	/**
	 * 这个是初始化数据表,如果本来是没有评价过的，也就是没有数据，返回空
	 * @return
	 */
	@RequestMapping(value="/InitTable",method=RequestMethod.POST)
	public @ResponseBody String initTable(){
			//List<P04> t = this.p04Service.listAllP04();
			//String s = JsonUtil.object2json(t);
			/**
			 * 将上述获得到s，即Json,添加到target的对象的json字符串。
			 */
			//s = AddTargetJson2P04Json.p04AddTargetJson(s,targetService);
			//return s;
		return null;
	};
	

	/**
	 * 触发下拉列表之后，发送过来的请求。
	 * @param targetdescid
	 * @return
	 */
	@RequestMapping(value="/returnTable",method=RequestMethod.POST)
	public @ResponseBody String returnTable(String targetdescid){
		/**
		 * 当选择下拉列表之后，触发onvaluechanged，传送查询参数过来
		 */
		Target t = this.targetService.load(targetdescid);
		String s = JsonUtil.object2json(t);
		return s;
	};
	
	/**
	 * 初始化下拉列表数值
	 * @return
	 */
	@RequestMapping(value="/InitSelect",method=RequestMethod.GET)
	public @ResponseBody String InitSelectTarget(){
		List<Target> list = this.targetService.findAllDesc1AndId();
		String s = JsonUtil.list2json(list);
		return s;
	}
	
	/**
	 * 保存对数据的增删改
	 * @param target
	 * @return
	 */
	@RequestMapping(value="/saveTarget",method=RequestMethod.POST)
	public @ResponseBody String saveTarget(String target){
		if (target != null && !target.equals("[]")) {
			String[] dataChild = ChangeOrgJsonString2New
					.changeOrgJsonString2New(target);
			for (int i = 0; i < dataChild.length; i++) {
				String state = ChangeOrgJsonString2New
						.check_State(dataChild[i]);
				/**
				 * 如果不包含以下任意字段的的json，直接跳过，不处理。
				 */
				if (!dataChild[i].contains("p0407")||!dataChild[i].contains("p04BC")
						||!dataChild[i].contains("p0415")||!dataChild[i].contains("p04Z9")) {
					continue;
				}
				/**
				 * 这里是将获取的数据进行相应的操作。如：增加，删除，修改。
				 */
				ExecuteHandlerP04.executeHandler(state, dataChild[i], p04Service); 
			}
		}
		/**
		 * 保存数据之后，应该回到所填的所有评价的列表，即查询功能
		 */
		String returnJson = ExecuteHandlerP04.FindOrList(null, p04Service);
		return returnJson;
	}
	
}
