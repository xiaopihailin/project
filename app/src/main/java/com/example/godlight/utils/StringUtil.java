package com.example.godlight.utils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	/**
	 * 是否为空
	 * @param strs
	 * @return
     */
	public static boolean isNull(String... strs){
		for(String str:strs){
			if(str==null)return true;
			if(str.trim().equals(""))return true;
			if("null".equals(str.trim())) return true;
			if("NULL".equals(str.trim())) return true;
		}
		return false;
	}

	public static boolean isPhone(String phone) {
		if (isNull(phone))
			return false;
		String regex = "^[1][1,2,3,4,5,6,7,8,9][0-9]{9}$";
		return phone.matches(regex);
	}

	/**
	 * 判断身份证号
	 *
	 * @param identityNum
	 * @return
	 */
	public static boolean isIdentityNum(String identityNum) {

		String str = "^[0-9]{17}([0-9]|X|x)$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(identityNum);

		return m.matches() ;
	}

	/**
	 * 判断中文
	 *
	 * @param string
	 * @return
	 */
	public static boolean isChinese(String string){
		int n = 0;
		for(int i = 0; i < string.length(); i++) {
			n = (int)string.charAt(i);
			if(!(19968 <= n && n <40869)) {
				return false;
			}
		}
		return true;
	}


	//判断email格式是否正确
	public static boolean isEmail(String email) {
		String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);

		return m.matches();
	}

	
	public static int getInt(String str, int defaultValue) {
		int result = defaultValue;
		try {
			result = Integer.parseInt(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static float getFloat(String str, float defaultValue) {
		float result = defaultValue;
		try {
			result = Float.parseFloat(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static long getLong(String str, long defaultValue) {
		long result = defaultValue;
		try {
			result = Long.parseLong(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static double getDouble(String str, double defaultValue) {
		double result = defaultValue;
		try {
			result = Double.parseDouble(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * 获取传入时间与当前时间的天数差
	 */
	public static int getTimeSpan(Long time) {

		if (time.equals(""))
			return 0;

		int day = 0;
		try {
			Date today = new Date();
			Date lastday = new Date(time);
			day = (int) ((today.getTime() - lastday.getTime()) / (24 * 60 * 60 * 1000));
		} catch (Exception e) {
		}

		return day;
	}

	public static boolean getIsUserName(String name) {
		boolean result = true;
		if ("".equals(name) || name.length() < 2 || name.length() > 10) {
			result = false;
		}
		return result;
	}

	public static String str2Url(String msg) {

		String url = "https";
		String[] str = msg.split(url);
		char c;
		for (int i = 0; i < str[1].length(); i++) {
			c = str[1].charAt(i);
			if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || c == '/' || c == '.' || c == '&' || c == ':' || c == '_' || c == '=' || (c >= '0' && c <= '9') || c == '-' || c == '%') {
				url += c;
			} else {
				break;
			}

		}
		return url;
	}

}
