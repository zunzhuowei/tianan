package com.org.test.keega.utli;

import com.dexcoder.commons.utils.JsonUtil;
import com.org.test.keega.model.Target;
import com.org.test.keega.service.ITargetService;

public class AddTargetJson2P04Json {
	/**
	 * 将p04获得到的json，找出target中对应的id，查找出对应的id，然后转换成json，并添加到p04的json中。
	 * 
	 * @param p04Json
	 *            p04json字符串
	 * @param targetService
	 *            targetService,用来load对应的target的id。
	 * @return
	 */
	public static String p04AddTargetJson(String p04Json,ITargetService targetService) {
		p04Json = p04Json.replace("p04BA", "desc1");
		String [] p04ss = p04Json.split("}");
		String newJson = "";
		for (int j = 0; j < p04ss.length; j++) {
			String subjson = "";
			String [] ss = p04ss[j].split(",");
			for (int i = 0; i < ss.length; i++) {
				if (ss[i].contains("\"desc1\":")) {
					String strValue = ss[i].replace("\"", "").replace("desc1", "").replace(":", "");
					if (!"".equals(strValue.trim())) {
						Target target = targetService.load(strValue);//TODO
						String targetJson = JsonUtil.object2json(target);
						subjson = ",\"zhibiao\":\"非量化类指标\""+ targetJson.substring(targetJson.indexOf(","));
					}else {
						subjson = ",\"zhibiao\":\"非量化类指标\"}";
					}
				}
			}
			newJson += p04ss[j]+subjson;
		}
		return newJson;
	}

}
