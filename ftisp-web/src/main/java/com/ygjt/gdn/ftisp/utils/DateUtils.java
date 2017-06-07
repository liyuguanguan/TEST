package com.ygjt.gdn.ftisp.utils;

import com.alibaba.fastjson.JSONException;
import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DateUtils {
	public static final String dateFormatyyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
	public static final String DATEFORMATYYYYMMDD = "yyyy-MM-dd";
	public static final Integer DAY_START_FLAG = 0;
	public static final Integer DAY_END_FLAG = 1;

	public static String getDateYYYYMMDD() {
		return dateTime("yyyyMMdd");
	}

	/**
	 * 日期时间生产源
	 *
	 * @param format
	 * @return
	 */
	public static String dateTime(String format) {
		Date date = null;
		SimpleDateFormat sdf = null;
		try {
			date = new Date();
			sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} catch (Exception e) {
			return null;
		} finally {
			date = null;
			sdf = null;
		}
	}

	/**
	 * 根据字符串转成标准格式的日期
	 *
	 * @param str
	 * @return
	 */
	public static Date getDateYYYYMMdd(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;

	}

	/**
	 *
	 * @param dateStr
	 * @param format
     * @return
     */
	public static Date getDate(String dateStr, String format)
	{
		SimpleDateFormat dateformat = new SimpleDateFormat(format);
		try
		{
			dateformat.setLenient(false);
			return dateformat.parse(dateStr);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static Date getDate(String strVal){
		String format = "yyyyMMdd";
		String strDate = strVal.substring(0,8);
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			return (Date) dateFormat.parse(strDate);
		} catch (ParseException e) {
			throw new JSONException("can not cast to Date, value : " + strDate);
		}

	}

	public static Date addHour(Date date,int num){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar now = Calendar.getInstance();
		now.add(Calendar.HOUR,num);
		Date newDate = now.getTime();
		return newDate;
	}
	public static Date addSecond(Date date,int num){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar now = Calendar.getInstance();
		now.add(Calendar.SECOND,num);
		Date newDate = now.getTime();
		return newDate;
	}
	public static Date addDay(Date date,int num){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE,num);
		Date newDate = now.getTime();
		return newDate;
	}

	public static Date getDate(Date date, int flag) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		//时分秒（毫秒数）
		long millisecond = hour*60*60*1000 + minute*60*1000 + second*1000;
		//凌晨00:00:00
		cal.setTimeInMillis(cal.getTimeInMillis()-millisecond);
		if (flag == 0) {
			return cal.getTime();
		} else if (flag == 1) {
			//凌晨23:59:59
			cal.setTimeInMillis(cal.getTimeInMillis()+23*60*60*1000 + 59*60*1000 + 59*1000);
		}
		return cal.getTime();
	}

	public static void main(String[] args) {
			ExecutorService executor = Executors.newFixedThreadPool(100);
			try {
				for (int i = 0; i < 10000; i++) {
					executor.execute(new Runnable() {
						@Override
						public void run() {
							System.out.println(UUID.randomUUID().toString());
						}
					});
				}
			} catch (Exception e) {
				System.out.println("异常：" + e);
			}finally{
				executor.shutdown();
				while(!executor.isTerminated()){

				}
			}
	}

	public static boolean checkDate(String value, String formatStr) {
		boolean convertSuccess = true;
		//为空不校验
		if (StringUtils.isBlank(value)) {
			return false;
		}
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		try {
			// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format.setLenient(false);
			format.parse(value);
		} catch (Exception e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			convertSuccess = false;
		}
		return convertSuccess;
	}

	public static boolean isCodeExpire(Date date) {
		long time = date.getTime();
		long nowTime = new Date().getTime();
		if(nowTime-time>0){
			return true;
		}else{
			return false;
		}
	}
}