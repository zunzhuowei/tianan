package com.org.test.keega.utli;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用来设置JDBCTemplate的select之后的rowmanpper的返回值
 * 
 * @author asus_n56
 *
 */
public class SetParameter {
	/**
	 * 用来设置JDBCTemplate的select之后的rowmanpper的返回值
	 * 
	 * @param o 要设置值的对象
	 * @param rs ResultSet对象
	 */
	public static final void setParameter(Object o, ResultSet rs) {
		Method[] ms = o.getClass().getDeclaredMethods();
		Field[] fs = o.getClass().getDeclaredFields();
		try {
			for (int i = 0; i < ms.length; i++) {
				if (ms[i].getName().startsWith("set")) {
					String paramType = ms[i].getParameterTypes()[0]
							.getSimpleName();// 获取set方法的参数类型
					String methodName = ms[i].getName().substring(3);// 获取方法的名字
					String methodName1 = methodName.substring(0, 1)//将set方法的set后面的第一个字母变成消息，并去掉set
							.toLowerCase() + methodName.substring(1);
					for (int j = 0; j < fs.length; j++) {//遍历对象的字段
						if (fs[j].getName().equals(methodName1)) {//如果对象的字段与set方法却掉set后并把第一个字母转成小写相等
							if (paramType.equals("int")) {//如果set方法的参数类型是Int类型
								ms[i].invoke(o, rs.getInt(fs[j].getName()));// 引援O，使用rs.getxxx相应的field名字
								break;
							}
							if (paramType.equals("String")) {
								ms[i].invoke(o, rs.getString(fs[j].getName()));// 引援O，使用rs.getxxx相应的field名字
								break;
							}
							if (paramType.equals("Number")) {
								ms[i].invoke(o, rs.getDouble(fs[j].getName()));// 引援O，使用rs.getxxx相应的field名字
								break;
							}
							if (paramType.equals("Double")) {
								ms[i].invoke(o, rs.getDouble(fs[j].getName()));// 引援O，使用rs.getxxx相应的field名字
								break;
							}

						}
					}

				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static final void setParameter1(Object o, ResultSet rs) {
		Method[] ms = o.getClass().getDeclaredMethods();
		Field[] fs = o.getClass().getDeclaredFields();
		try {
			for (int i = 0; i < ms.length; i++) {
				if (ms[i].getName().startsWith("set")) {
					String paramType = ms[i].getParameterTypes()[0]
							.getSimpleName();// 获取set方法的参数类型
					String methodName = ms[i].getName().substring(3);// 获取方法的名字
					String methodName1 = methodName.substring(0, 1)//将set方法的set后面的第一个字母变成消息，并去掉set
							.toLowerCase() + methodName.substring(1);
					for (int j = 0; j < fs.length; j++) {//遍历对象的字段
						if (fs[j].getName().equals("rank")) {
							continue;
						}
						if (fs[j].getName().equals(methodName1)) {//如果对象的字段与set方法却掉set后并把第一个字母转成小写相等
							if (paramType.equals("int")) {//如果set方法的参数类型是Int类型
								ms[i].invoke(o, rs.getInt(fs[j].getName()));// 引援O，使用rs.getxxx相应的field名字
								break;
							}
							if (paramType.equals("String")) {
								ms[i].invoke(o, rs.getString(fs[j].getName()));// 引援O，使用rs.getxxx相应的field名字
								break;
							}
							if (paramType.equals("Number")) {
								ms[i].invoke(o, rs.getDouble(fs[j].getName()));// 引援O，使用rs.getxxx相应的field名字
								break;
							}
							if (paramType.equals("Double")) {
								ms[i].invoke(o, rs.getDouble(fs[j].getName()));// 引援O，使用rs.getxxx相应的field名字
								break;
							}
							
						}
					}
					
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}
