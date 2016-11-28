package com.org.test.keega.service;

import org.springframework.stereotype.Service;

/**
 * Created by asus_n56 on 2016/9/19.
 */
@Service("finalService")
public class FinalService {

    //将截断字符串或二进制数据。; nested exception is com.microsoft.sqlserver.jdbc.SQLServerException: 将截断字符串或二进制数据。
    //这个错是由于p04BA字段设置值只有两个字符。input为验证

    public String go2View(String objectSpFlag,String planStatus,String objectid,String mainbodyid,String template_id,String newBody,String scoreStatus) {
        if ("Z01Q".equals(template_id.trim())) {//TODO 如果是管理人员登录
            if ("02".equals(objectSpFlag)) return "/target/showEvaAdmin"; //显示已经填好目标卡的状态的页面，不可编辑
            if ("03".equals(objectSpFlag) && planStatus == null) return "/target/showEvaAdmin"; //TODO........
            //下面这个是考核人在员工填好目标卡之后，可以查看员工目标的界面，所以不可以编辑
            if ("01".equals(objectSpFlag) && !objectid.equals(mainbodyid)) {
                return "/target/showEvaAdmin";//显示已经填好目标卡的状态的页面，不可编辑
            }
//System.out.println(scoreStatus+"<<-----------------scoreStatus");
            //scoreStatus
            if (!checkPlanStatus(planStatus)) {//如果不是评分状态
                return "/target/evaReadyAdmin";//显示资料填写阶段未开启考评
            } else if (ckeckSelfOrOther(objectid, mainbodyid)) {//如果是被考核人登陆，已打开评分状态
                if ("2".equals(scoreStatus)) {
                    return "/target/showEvaAdmin";
                }
                return "/target/evaSelfAdmin";//显示被考评人能填的页面--自评------------------可能要在这里加查看反馈信息
            } else if (!ckeckSelfOrOther(objectid, mainbodyid)) {//如果是评分人登陆，已打开评分状态
                if ("25".equals(newBody.trim())) {//如果是张碧林进来，则显示隐藏的他人评分
                    if ("2".equals(scoreStatus)) {
                        return "/target/showEvaOtherAdmin_hide";
                    }
                    return "/target/evaOtherAdmin_hide";
                } else if("1".equals(newBody.trim())){//如果是金鉴进来，则显示全部打分信息，包括张碧林打的分数。
                    //当金鉴需要修改张碧林打的分数的时候，则是执行更新，（默认进来的时候已经插入张碧林打的分数，但是mainbody_id为金鉴的）
                    if ("2".equals(scoreStatus)) {
                        return "/target/evaOtherAdmin_hou";
                    }
                    return "/target/evaOtherAdmin";
                }

                if ("2".equals(scoreStatus)) {
                    return "/target/evaOtherAdmin_hou";
                }
                return "/target/evaOtherAdmin";//显示考评人能填的页面---他评
            } else {
                return "状态出错！";
            }

        } else {//TODO 如果是普通员工登录
            if ("02".equals(objectSpFlag)) return "/target/showEvaGeneral"; //显示已经填好目标卡的状态的页面，不可编辑
            if ("03".equals(objectSpFlag) && planStatus == null) return "/target/showEvaGeneral"; //TODO........
            //下面这个是考核人在员工填好目标卡之后，可以查看员工目标的界面，所以不可以编辑
            if ("01".equals(objectSpFlag) && !objectid.equals(mainbodyid)) {
                return "/target/showEvaGeneral";//显示已经填好目标卡的状态的页面，不可编辑
            }

            if (!checkPlanStatus(planStatus)) {//如果不是评分状态
                return "/target/evaReadyGeneral";//显示资料填写阶段未开启考评
            } else if (ckeckSelfOrOther(objectid, mainbodyid)) {//如果是被考核人登陆，已打开评分状态
                if ("2".equals(scoreStatus)) {
                    return "/target/showEvaGeneral";
                }
                return "/target/evaSelfGeneral";//显示被考评人能填的页面--自评
            } else if (!ckeckSelfOrOther(objectid, mainbodyid)) {//如果是评分人登陆，已打开评分状态
                if ("25".equals(newBody.trim())) {//如果是张碧林进来，则显示隐藏的他人评分
                    if ("2".equals(scoreStatus)) {
                        return "/target/showEvaOtherGeneral_hide";
                    }
                    return "/target/evaOtherGeneral_hide";
                } else if(!"25".equals(newBody.trim())){//如果是金鉴进来，则显示全部打分信息，包括张碧林打的分数。
                    //当金鉴需要修改张碧林打的分数的时候，则是执行更新，（默认进来的时候已经插入张碧林打的分数，但是mainbody_id为金鉴的）
                    if ("2".equals(scoreStatus)) {
                        return "/target/evaOtherGeneral_hou";
                    }
                    return "/target/evaOtherGeneral";
                }

                if ("2".equals(scoreStatus)) {
                    return "/target/evaOtherGeneral_hou";
                }
                return "/target/evaOtherGeneral";//显示考评人能填的页面---他评
            } else {
                return "状态出错！";
            }
        }
    }

    /**
     * 04表示为评分状态
     * @param planStatus
     * @return
     */
    private boolean checkPlanStatus(String planStatus) {
        return "4".equals(planStatus);
    }

    /**
     * 自己进来
     * @param objectid
     * @param mainbodyid
     * @return
     */
    private boolean ckeckSelfOrOther(String objectid, String mainbodyid) {
        return objectid.trim().equals(mainbodyid.trim());
    }


}
