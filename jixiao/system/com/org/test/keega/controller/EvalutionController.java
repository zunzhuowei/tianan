package com.org.test.keega.controller;

import com.org.test.keega.model.CommonScore;
import com.org.test.keega.model.Evaluation;
import com.org.test.keega.model.FeedBack;
import com.org.test.keega.service.ICommonScoreService;
import com.org.test.keega.service.IEvalutionService;
import com.org.test.keega.service.IFeedBackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value="/eva")
public class EvalutionController {
	
	@Resource private IEvalutionService evalutionSerivce;
	@Resource private ICommonScoreService commonScoreService;
	@Resource private IFeedBackService feedBackService;
	

	@RequestMapping(value="/saveEva",method=RequestMethod.POST)
	public @ResponseBody String save(String sp_flag,String objectid,String planid){
		//TODO 这个提交评分之后进来的页面，提交的时候把被评分人与评分人传来？还是自动保存的时候把评分人和被评分人传过来？
		evalutionSerivce.submitEva(sp_flag, objectid, planid);
		if ("02".equals(sp_flag)) {
			return "提交成功！";
		}else if ("07".equals(sp_flag)) {
			return "退回考核！";
		}else {
			return "审核通过！";
		}
		
	}

//(int plan_id, String object_id, String mainbody_id, int p0400, String score, String amount, String degree_id, String reasons, String stdScore)
	@RequestMapping(value="/autoSave1",method=RequestMethod.POST)//value表示自评或者他评的值，name表示自评或者他评对应的name
	public @ResponseBody String autoSave1(String value,String name,String changeRowId
			,String objectid,String planid,String mainbodyid){//sScore表示自评，oScore表示他评
//System.out.println("value:"+value+"----"+"name:"+name+"-----changeRowId:"+changeRowId+"----objectid:"+objectid
//		+"----planid:"+planid+"-----mainbodyid:"+mainbodyid);
		if ("".equals(value.trim())) {
			return null;
		}else {
			Evaluation e = null;
			if ("sScore".equals(name)) {
				e = this.evalutionSerivce.loadSelfByP0400(changeRowId, mainbodyid, objectid,planid);
				if (e != null) {
					e.setScore(value);
					this.evalutionSerivce.update(e, mainbodyid, objectid, planid);
				}else {
					Evaluation ee= new Evaluation(Integer.parseInt(planid), objectid, mainbodyid,Integer.parseInt(changeRowId) , value,"1" , "A", "", "0");
					this.evalutionSerivce.add(ee);
				}
			}else {
				e = this.evalutionSerivce.loadSelfByP0400(changeRowId, mainbodyid, objectid,planid);
				if (e != null) {
					e.setScore(value);
					this.evalutionSerivce.update(e, mainbodyid, objectid, planid);
				}else {
					Evaluation ee= new Evaluation(Integer.parseInt(planid), objectid, mainbodyid,Integer.parseInt(changeRowId) , value,"1" , "A", "", "0");
					this.evalutionSerivce.add(ee);
				}
			}
			return null;
		}
	}
	
	@RequestMapping(value="/autoSave2",method=RequestMethod.POST)
	public @ResponseBody String autoSave2(String value,String name,String changeRowId1
			,String objectid,String planid,String mainbodyid){
//System.out.println("value:"+value+"----"+"name:"+name+"-----changeRowId1:"+changeRowId1+"----objectid:"+objectid
//				+"----planid:"+planid+"-----mainbodyid:"+mainbodyid);
		if ("".equals(value.trim())) {
			return null;
		}else {
			Evaluation e;
			if ("sScore".equals(name)) {
				e = this.evalutionSerivce.loadSelfByP0400(changeRowId1, mainbodyid, objectid,planid);
				if (e != null) {
					e.setScore(value);
					this.evalutionSerivce.update(e, mainbodyid, objectid, planid);
				}else {
					Evaluation ee= new Evaluation(Integer.parseInt(planid), objectid, mainbodyid,Integer.parseInt(changeRowId1) , value,"1" , "A", "", "0");
					this.evalutionSerivce.add(ee);
				}
			}else {
				e = this.evalutionSerivce.loadSelfByP0400(changeRowId1, mainbodyid, objectid,planid);
				if (e != null) {
					e.setScore(value);
					this.evalutionSerivce.update(e, mainbodyid, objectid, planid);
				}else {
					Evaluation ee= new Evaluation(Integer.parseInt(planid), objectid, mainbodyid,Integer.parseInt(changeRowId1) , value,"1" , "A", "", "0");
					this.evalutionSerivce.add(ee);
				}
			}
			return null;
		}
	}
	
	@RequestMapping(value="/saveScore",method=RequestMethod.POST)
	public @ResponseBody String autoSaveScore(String scoreValue,String score,
			String objectid,String mainbodyid,int planid ,String pointid){
//System.out.println("scoreValue:"+scoreValue+"--score:"+score+"--objectId:"+objectid+"---mainbodyid:"+mainbodyid+"---planid:"+planid+"---pointid:"+pointid);
		//当金鉴进来的时候，mainbodyid不是张碧林了，所以查询不出来有金鉴的评分。所以会选择插入分数。
		CommonScore commonScore = this.commonScoreService.getCommonScoreByPointId(pointid, planid, objectid,mainbodyid);
		if (commonScore == null) {
			//(String object_id, String mainbody_id, String score, String amount, String point_id,String degree_id)
			this.commonScoreService.add(new CommonScore(objectid, mainbodyid, scoreValue, "1", pointid, "A"), planid);
		} else {
			commonScore.setScore(scoreValue);
			this.commonScoreService.update(commonScore, pointid, objectid, planid,mainbodyid);//TODO应该还有Mianbodyid才知道更新谁的评分--已修改
		}
		return null;
	}


	@ResponseBody
	@RequestMapping(value = "/saveFeedBack",method = RequestMethod.POST)
	public String saveFeedBack(String value,String objectId,String planId) {
		if (value != null || !"".equals(value)) {
			FeedBack feedBack = new FeedBack();
			feedBack.setFeedBack(value);
			this.feedBackService.update(feedBack, planId, objectId);
		}
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/targetRecall",method = RequestMethod.GET)
	public void targetRecall(@RequestParam(name = "objectId") String objectId,
							 @RequestParam(name = "planId") String planId) {
		//System.out.println(objectId + "----" + planId);
		evalutionSerivce.targetRecall(objectId, planId);
	}

	@ResponseBody
	@RequestMapping(value = "/resultConfirm", method = RequestMethod.GET)
	public void resultConfirm(@RequestParam(name = "objectId") String objectId,
							  @RequestParam(name = "planId") String planId) {
		evalutionSerivce.resultConfirm(objectId, planId);
	}

	//查看考核确认情况
	@RequestMapping(value = "/showConfirm",method = RequestMethod.GET)
	public String showConfirmResult() {
		return "/target/confirmResult";
	}

	//searchType 00表示查询未确认的，01表示查询已经确认的，02表示查询所有。
	@ResponseBody
	@RequestMapping(value = "/giveConfirm", method = RequestMethod.POST)
	public String giveConfirmResult(@RequestParam(name = "key",defaultValue = "") String key,
									@RequestParam(name = "searchType",defaultValue = "02") String searchType) {
		//System.out.println(evalutionSerivce.showConfirmResult(key,searchType));
		return evalutionSerivce.showConfirmResult(key,searchType);
	}

}
