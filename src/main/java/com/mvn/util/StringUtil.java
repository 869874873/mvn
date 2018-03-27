package com.mvn.util;

public class StringUtil {
	
	/**
	 * 去掉返回对象中，属性名存在的下划线并按照驼峰法格式化
	 * 
	 * @param str
	 * @return
	 */
	public static String capitalize(String str){
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='_'){
				char charAt = str.charAt(i+1);
				String valueOf = String.valueOf((char)((int)charAt-32));
				str = str.replaceAll("_"+str.charAt(i+1), valueOf);
			}
		}
		return str;
	}
	
	

}
