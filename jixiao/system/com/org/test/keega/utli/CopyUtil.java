package com.org.test.keega.utli;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.org.test.keega.model.P04;
/**
 * 这个类有错！！！！
 * @author asus_n56
 *
 */
public class CopyUtil {

	public static void copyP04(P04 mudi, P04 yuanlai) {
		String p04001 = mudi.getP0400() + "";
		String p04071 = mudi.getP0407();
		String p04151 = mudi.getP0415();
		String p04BA1 = mudi.getP04BA();
		String p04BC1 = mudi.getP04BC();
		String p04Z91 = mudi.getP04Z9();

		String p04002 = yuanlai.getP0400() + "";
		String p04072 = yuanlai.getP0407();
		String p04152 = yuanlai.getP0415();
		String p04BA2 = yuanlai.getP04BA();
		String p04BC2 = yuanlai.getP04BC();
		String p04Z92 = yuanlai.getP04Z9();

		P04 p = new P04();

		if (p04002 != null && !"".equals(p04002.trim())) {
			p.setP0400(Integer.parseInt(p04002));
		}
		if (p04072 != null && !"".equals(p04072.trim())) {
			p.setP0407(p04072);
		}
		if (p04152 != null && !"".equals(p04152.trim())) {
			p.setP0415(p04152);
		}
		if (p04BA2 != null && !"".equals(p04BA2.trim())) {
			p.setP04BA(p04BA2);
		}
		if (p04BC2 != null && !"".equals(p04BC2.trim())) {
			p.setP04BC(p04BC2);
		}
		if (p04Z92 != null && !"".equals(p04Z92.trim())) {
			p.setP04Z9(p04Z92);
		}

		try {
			BeanUtils.copyProperties(mudi, p);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
