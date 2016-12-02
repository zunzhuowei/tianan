package com.org.test.keega.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.annotation.Resource;

import com.org.test.keega.model.*;
import com.org.test.keega.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/test")
public class FinalController {

    @Resource
    private ITargetService targetService;
    @Resource
    private IP04Service p04Service;
    @Resource
    private ISecondP04Service secondP04Service;
    @Resource
    private IEvalutionService evalutionService;
    @Resource
    private ICommonService commonService;
    @Resource
    private ICommonScoreService commonScoreService;
    @Resource
    private FinalService finalService;
    @Resource
    private IFeedBackService feedBackService;


    //.ftl
    @RequestMapping(value = "/final", method = RequestMethod.GET)//planStatus如果为空或者不为4，那就是分发状态
    public String init(Model model, String objectid, int planid, String mainbodyid, String planStatus,
                       String objectSpFlag, String template_id, String newBody, String scoreStatus, String lastMainBodyId) {
        List<Target> list = this.targetService.findAllDesc1AndId();
        List<P04> t = this.p04Service.listAllP04(planid + "", objectid,template_id);
        List<SecondP04> sps = this.secondP04Service.listAllSecondP04(planid + "", objectid,template_id);
        List<SecondP04AndEva> spaes;
        List<Common2DescAndScore> cdass;
        List<Common2DescAndScore> cdasbpis;
        List<TargetAndP04> targetAndP04 ;
        if (!"2".equals(scoreStatus)) {
            targetAndP04 = this.p04Service.listTargetAndP04(t, evalutionService, targetService, objectid, mainbodyid, planid + "");
            spaes = this.secondP04Service.listSecondP04AndEva(sps, evalutionService, objectid, mainbodyid, planid + "");
            cdass = this.commonService.getListCommonAndScore(commonScoreService, objectid, planid, mainbodyid, template_id, newBody);
            cdasbpis = this.commonService.getListCommonBPIAndScore(commonScoreService, objectid, planid, mainbodyid, template_id);
        } else {//TODO 当已经打完分之后，被考核人登录查看得分时需要获得评分人的mainbodyid；这样子才能查询到评分人的打分。
            if (objectid.equals(mainbodyid)) {//如果是本人登录
                mainbodyid = lastMainBodyId;
                targetAndP04 = this.p04Service.listTargetAndP04(t, evalutionService, targetService, objectid, mainbodyid, planid + "");
                spaes = this.secondP04Service.listSecondP04AndEva(sps, evalutionService, objectid, mainbodyid, planid + "");
                cdass = this.commonService.getListCommonAndScore(commonScoreService, objectid, planid, mainbodyid, template_id, newBody);
                cdasbpis = this.commonService.getListCommonBPIAndScore(commonScoreService, objectid, planid, mainbodyid, template_id);
            } else {//如果是其他人登录
                //mainbodyid = "";//当已经打完分之后，被考核人登录查看得分时需要获得评分人的mainbodyid；这样子才能查询到评分人的打分。
                targetAndP04 = this.p04Service.listTargetAndP04(t, evalutionService, targetService, objectid, mainbodyid, planid + "");
                spaes = this.secondP04Service.listSecondP04AndEva(sps, evalutionService, objectid, mainbodyid, planid + "");
                cdass = this.commonService.getListCommonAndScore(commonScoreService, objectid, planid, mainbodyid, template_id, newBody);
                cdasbpis = this.commonService.getListCommonBPIAndScore(commonScoreService, objectid, planid, mainbodyid, template_id);
            }
        }

        FeedBack feedBack = this.feedBackService.load(planid + "", objectid);
        model.addAttribute("targets", list);//下拉列表
        model.addAttribute("taps", targetAndP04);//p04和下拉列表和evaluation
        model.addAttribute("sapes", spaes);
        model.addAttribute("cdass", cdass);
        model.addAttribute("cdasbpis", cdasbpis);
        model.addAttribute("objectid", objectid);
        model.addAttribute("mainbodyid", mainbodyid);
        model.addAttribute("planid", planid);
        model.addAttribute("template_id",template_id);
        model.addAttribute("feedBack", feedBack);
//      System.out.println("---------------------------------->>>>>/target/final.ftl");
        return finalService.go2View(objectSpFlag, planStatus, objectid, mainbodyid,template_id,newBody,scoreStatus);
    }


    //下拉列表控制
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public Target selectTarget(String selectId) {
        return this.targetService.selectTarget(selectId);
    }

    @RequestMapping(value = "/autoSave", method = RequestMethod.POST)
    @ResponseBody
    public String autoSave(String value, String name, String changeRowId) throws InvocationTargetException {
//System.out.println("value:"+value+"----name:"+name+"-----chengeRowId:"+changeRowId);
        P04 p = this.p04Service.load(changeRowId);
        Method[] ms = p.getClass().getDeclaredMethods();
        try {
            for (Method m : ms) {
                if (m.getName().startsWith("set") && m.getName().substring(3).equals(name)) {
                    if ("P0415".equals(name.trim())) {
                        Double d = Double.parseDouble(value);
                        double dd = d/100;
                        m.invoke(p,dd+"");//将权重的值转成小数点
                    } else {
                        m.invoke(p, value);
                    }

                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        this.p04Service.update(p);
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Target addNullTarget(String item_id, String a0100, String planid) {
//System.out.println("item_id:"+item_id+"------>"+"a0100:"+a0100+"-------->planid:"+planid);
        InitClass ic = this.p04Service.getInitClassByA0100(a0100);
        P04 p = new P04();
        p.setP04BK("");
        p.setP0415("0");
        p.setP0407("");
        p.setP04BA("");
        p.setP04BC("");
        p.setP04Z9("");
        p.setItem_id(item_id);
        p.setPlan_id(planid);
        p.setFromflag("2");
        p.setA0100(ic.getA0100());
        p.setA0101(ic.getA0101());
        p.setB0110(ic.getB0110());
        p.setE0122(ic.getE0122());
        p.setE01A1(ic.getE01A1());
        p.setNbase(ic.getNBASE());
        this.p04Service.add(p);
        return new Target();
    }

    @RequestMapping(value = "/deleteRow", method = RequestMethod.POST)
    @ResponseBody
    public String deleteRow(String deleteId) {
        if (deleteId != null && !"".equals(deleteId.trim())) {
            int id = Integer.parseInt(deleteId);
            this.p04Service.delete(id);
            this.evalutionService.delete(deleteId);//TODO 删除行的时候应该把分数也删除掉
        }
        return null;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/secondAdd", method = RequestMethod.POST)
    @ResponseBody
    public SecondP04 addNullSecondTarget(String item_id, String a0100, String planid) {
        SecondP04 sp = new SecondP04();
        sp.setP0407("");
        sp.setP0415("0");
        sp.setP04BA("");
        sp.setP04BC("");
        sp.setP04BB("");
        sp.setP04Z9("");
        InitClass ic = this.p04Service.getInitClassByA0100(a0100);
        sp.setPlan_id(planid);
        sp.setItem_id(item_id);
        sp.setFromflag("2");
        sp.setA0100(ic.getA0100());
        sp.setA0101(ic.getA0101());
        sp.setB0110(ic.getB0110());
        sp.setE0122(ic.getE0122());
        sp.setE01A1(ic.getE01A1());
        sp.setNbase(ic.getNBASE());
        this.secondP04Service.add(sp);
        return null;
    }

    @RequestMapping(value = "/autoSaveSecond", method = RequestMethod.POST)
    @ResponseBody
    public String autoSaveSecond(String value, String name, String changeRowId) {
        SecondP04 p = this.secondP04Service.load(changeRowId);
        Method[] ms = p.getClass().getDeclaredMethods();
        try {
            for (Method m : ms) {
                if (m.getName().startsWith("set") && m.getName().substring(3).equals(name)) {
                    if ("P0415".equals(name.trim())) {
                        Double d = Double.parseDouble(value);
                        double dd = d/100;
                        m.invoke(p,dd+"");//将权重的值转成小数点
                    } else {
                        m.invoke(p, value);
                    }
                }
            }
        } catch (IllegalAccessException  e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        this.secondP04Service.update(p);
        return null;
    }

    @RequestMapping(value = "/deleteSecondRow", method = RequestMethod.POST)
    @ResponseBody
    public String deleteSecondRow(String deleteId) {
        if (deleteId != null && !"".equals(deleteId.trim())) {
            this.secondP04Service.delete(deleteId);
        }
        return null;
    }

}
