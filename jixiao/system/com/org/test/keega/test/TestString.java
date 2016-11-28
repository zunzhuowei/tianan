package com.org.test.keega.test;

import com.org.test.keega.dao.FeedBackDao;
import com.org.test.keega.dao.IFeedBackDao;
import com.org.test.keega.model.FeedBack;
import com.org.test.keega.model.P04;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.NumberFormat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:com/global/config/datasource.xml",
        "classpath:com/global/config/freemarker.xml",
        "classpath:com/global/config/spring-mvc.xml"})
public class TestString {//locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml"}


    @Test
    public void test() {
        P04 p = new P04();
        System.out.println(p);
    }

    @Test
    public void test01() {
        String str = "中国四大行噶啥的发生@@发士大夫的沙发斯蒂芬@@爱的色放就打上放上@@大的事发的是@@打算发大水法撒旦法";
        String[] ss = str.split("@@");
        System.out.println(ss.length);
        for (String s : ss) {
            System.out.println(s);
        }
    }

    @Test
    public void testNumberFormart() {
        String a = "20.04003123";
        Double d = Double.parseDouble(a);
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        String num = numberFormat.format(d);
        System.out.println(num);
    }

    /**
     * 这个是网上的使用方法
     */
    @Test
    public void testNumberFormart1() {
        Double myNumber = 23323.3323232323;
        Double test = 0.3434;
        //getInstance()
        //返回当前缺省语言环境的缺省数值格式。
        String myString = NumberFormat.getInstance().format(myNumber);
        System.out.println(myString);
        //getCurrencyInstance()返回当前缺省语言环境的通用格式
        myString = NumberFormat.getCurrencyInstance().format(myNumber);
        System.out.println(myString);
        //getNumberInstance() 返回当前缺省语言环境的通用数值格式。
        myString = NumberFormat.getNumberInstance().format(myNumber);
        System.out.println(myString);

        //getPercentInstance()  返回当前缺省语言环境的百分比格式。
        myString = NumberFormat.getPercentInstance().format(test);
        System.out.println(myString);

        //setMaximumFractionDigits(int) 设置数值的小数部分允许的最大位数。
        //setMaximumIntegerDigits(int)  设置数值的整数部分允许的最大位数。
        //setMinimumFractionDigits(int) 设置数值的小数部分允许的最小位数。
        //setMinimumIntegerDigits(int)  设置数值的整数部分允许的最小位数.
        NumberFormat format = NumberFormat.getInstance();
        format.setMinimumFractionDigits(3);
        format.setMaximumFractionDigits(5);
        format.setMaximumIntegerDigits(10);
        format.setMinimumIntegerDigits(0);
        System.out.println(format.format(2132323213.23266666666));
    }

    @Test
    public void testFeedBack() {//plan_id = 14 and object_id = '00000177'
        IFeedBackDao feedBackDao = new FeedBackDao();
        FeedBack feedBack = feedBackDao.load("14", "00000177");
        System.out.println(feedBack.getId() + "---" + feedBack.getFeedBack());
        //new HashMap<String, String>();

    }

/*
    @Test
    public void testDao() {
        System.out.println(baseDao.queryAllBeansList(P04.class));
    }
*/

}
