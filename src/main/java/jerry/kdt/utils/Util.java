package jerry.kdt.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jodd.util.StringUtil;

public class Util {
	public static String nvl(String s,String nvl) {
		return StringUtil.isEmpty(s) ? nvl : s;
	}
	public static Integer nvl(Integer s,Integer nvl) {
		return s==null ? nvl : s;
	}
	/**
	 * Date转化成字符串
	 * @param date 日期
	 * @param format 转化格式
	 * @return 指定格式日期字符串
	 */
	public static String formatDate(Date date,String format) {
		if(date == null){
			return "";
		}
		return new java.text.SimpleDateFormat(format).format(date);
	}
	/**
	 * 任意格式日期转换成指定格式字符串
	 * @param date 任意格式日期字符串
	 * @param format 日期格式
	 * @return 指定格式日期字符串
	 */
	public static String formatDate(String date,String format) {
		try {
			Date datetag = parseDate(date);//DateUtils.parseDate(date, new String[] {"yyyyMMdd" });
			SimpleDateFormat formater = new SimpleDateFormat(format);   
			return formater.format(datetag);
		} catch(Exception e) {
			return String.valueOf(date);
		}
	}
	/**
	 *  字符串转换成DATE
	　* @param date 待转换的日期字符串
	　* @return 日期
	　* @throws ParseException
	　*/
	public static Date parseDate(String date) {
		if(date==null) return null;
		try {
			String parse = date;
			parse = parse.replaceFirst("^[0-9]{4}([^0-9]?)", "yyyy$1");
			parse = parse.replaceFirst("^[0-9]{2}([^0-9]?)", "yy$1");
			parse = parse.replaceFirst("([^0-9]?)[0-9]{1,2}([^0-9]?)", "$1MM$2");
			parse = parse.replaceFirst("([^0-9]?)[0-9]{1,2}( ?)", "$1dd$2");
			parse = parse.replaceFirst("( )[0-9]{1,2}([^0-9]?)", "$1HH$2");
			parse = parse.replaceFirst("([^0-9]?)[0-9]{1,2}([^0-9]?)", "$1mm$2");
			parse = parse.replaceFirst("([^0-9]?)[0-9]{1,2}([^0-9]?)", "$1ss$2");
			DateFormat format = new SimpleDateFormat(parse);
			return format.parse(date);
		} catch(ParseException e) {
			return null;
		} catch(Exception e) {
			return null;
		}
	}
}
