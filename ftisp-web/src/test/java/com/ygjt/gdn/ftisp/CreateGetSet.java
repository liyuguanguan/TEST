package com.ygjt.gdn.ftisp;


import com.ygjt.gdn.ftisp.mail.model.RegisterData;
import com.ygjt.gdn.ftisp.model.EmailCodeDo;
import com.ygjt.gdn.ftisp.utils.mail.EmailMessage;

import java.lang.reflect.Field;

public class CreateGetSet {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		createStr(EmailCodeDo.class,"emailCodeDo");
	}

	public static void createStr(Class o,String paramName) {
		Field[] list = o.getDeclaredFields();
		for (Field field : list) {
			String name = field.getName();
			if ("serialVersionUID".equals(name)) {
				continue;
			}
				System.out.println(paramName+".set" + name.substring(0, 1).toUpperCase()
						+ name.substring(1) + "(\"1\");");
		}
	}

	public static void createGetSetStr(Class o,String paramName) {
		Field[] list = o.getDeclaredFields();
		for (Field field : list) {
			String name = field.getName();
			if ("serialVersionUID".equals(name)) {
				continue;
			}
			int index = name.indexOf("_");
			String str = "";
			String str1 = "";
			String str2 = "";
			if (index > 0) {
				str = name.replaceFirst("_", "");
				str1 = str.substring(index, index + 1).toUpperCase();

				str2 = str.substring(0, 1).toUpperCase()
						+ str.substring(1, index) + str1
						+ str.substring(index + 1);
			} else {
				str2 = name.substring(0, 1).toUpperCase() + name.substring(1);
			}
			System.out.println(paramName+".set" + name.substring(0, 1).toUpperCase()
					+ name.substring(1) + "(h.get" + str2 + "());");
		}
	}
}
