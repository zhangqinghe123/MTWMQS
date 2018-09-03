package com.qianxx.qztaxi.common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

public class DateUtil {

	final static public String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	final static public String LONG_DEFAULT_FORMAT = "yyyyMMddHHmmss";

	public static Timestamp getSystemTime() {
		return new Timestamp(System.currentTimeMillis());
	}
	
	public static long getLongSystemTime() {
		DateFormat df = new SimpleDateFormat(LONG_DEFAULT_FORMAT);
		return Long.valueOf(df.format(new Date()));
	}
	
	public static long getLongSystemTime(Timestamp date) {
		DateFormat df = new SimpleDateFormat(LONG_DEFAULT_FORMAT);
		return Long.valueOf(df.format(date));
	}

	public static Integer subDays(Timestamp from, Timestamp to) {
		if (from == null || to == null) {
			return 0;
		}

		Long time = (to.getTime() - from.getTime()) + 24 * 60 * 60 * 1000;

		return (int) (time / (24 * 60 * 60 * 1000));
	}

	public static boolean compareByMins(Timestamp from, Timestamp to, int mins) {
		if (from == null || to == null) {
			return true;
		}

		return (to.getTime() - from.getTime()) >= mins * 60 * 1000;
	}

	public static boolean compareByDays(Timestamp from, Timestamp to, int days) {
		if (from == null || to == null) {
			return true;
		}

		return (to.getTime() - from.getTime()) >= days * 24 * 60 * 60 * 1000;
	}

	/**
	 * 获取时间0秒
	 */
	public static Timestamp getMinStart(Timestamp time) {
		Calendar tempCal = Calendar.getInstance();

		tempCal.setTime(time);

		Calendar retCal = Calendar.getInstance();

		retCal.set(tempCal.get(Calendar.YEAR), tempCal.get(Calendar.MONTH), tempCal.get(Calendar.DAY_OF_MONTH),
				tempCal.get(Calendar.HOUR_OF_DAY), tempCal.get(Calendar.MINUTE), 0);

		return new Timestamp(retCal.getTimeInMillis());
	}

	// 取得系统时间前1天的系统时间
	public static Timestamp getOneDayBefore(Timestamp now) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(now);
		// cal.add(Calendar.DATE, -7);
		// 由7天变为1天
		cal.add(Calendar.DATE, 0);
		Date time = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return Timestamp.valueOf(sdf.format(time));
	}

	// 取得系统时间前7天的系统时间
	public static Timestamp getSevenDayBefore(Timestamp now) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(now);
		cal.add(Calendar.DATE, -6);
		Date time = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return Timestamp.valueOf(sdf.format(time));
	}

	public static String TimeToString(Timestamp t) {
		if (t != null) {
			String s = t.toString();
			return s.substring(0, s.lastIndexOf("."));
		}
		return "";
	}

	public static String TimeToForMat(Timestamp t) {
		if (t != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日 h:m");
			return sdf.format(t);
		}
		return "";
	}

	public static String TimeToForD(Timestamp t) {
		if (t != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
			return sdf.format(t);
		}
		return "";
	}

	public static String TimeToForDay(Timestamp t) {
		if (t != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("M月d日");
			return sdf.format(t);
		}
		return "";
	}

	public static String parseTime(long time) {
		Date dt = new Date(time);
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return fmt.format(dt);
	}
	
	public static String parseTime(long time, String format) {
		Date dt = new Date(time);
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		return fmt.format(dt);
	}

	public static String getNowyyyyMMddHHmmssSSS() {
		Timestamp ts = getSystemTime();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return fmt.format(ts);
	}

	public static String getDEFAULT(Timestamp t) {
		SimpleDateFormat fmt = new SimpleDateFormat(DEFAULT_FORMAT);
		return fmt.format(t);
	}

	public static String getNowyyyyMMddHHmmss() {
		Timestamp ts = getSystemTime();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return fmt.format(ts);
	}
	public static long getNowInt() {
		Timestamp ts = getSystemTime();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		return Long.parseLong(fmt.format(ts));
	}

	public static long parseTime(String time) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		try {
			return fmt.parse(time).getTime();
		} catch (ParseException e) {
			return 0;
		}
	}

	static public String getCurrentDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static Date getDateAfter(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		return now.getTime();
	}

	public static String translateDate(Long time) {
		long oneDay = 24 * 60 * 60 * 1000;
		Calendar current = Calendar.getInstance();
		Calendar today = Calendar.getInstance(); // 今天

		today.set(Calendar.YEAR, current.get(Calendar.YEAR));
		today.set(Calendar.MONTH, current.get(Calendar.MONTH));
		today.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
		// Calendar.HOUR——12小时制的小时数 Calendar.HOUR_OF_DAY——24小时制的小时数
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);

		Date dt = new Date(time);
		SimpleDateFormat fmt = new SimpleDateFormat("hh:mm:ss");
		String dtStr = fmt.format(dt);

		long todayStartTime = today.getTimeInMillis();

		if (time >= todayStartTime && time < todayStartTime + oneDay) { // today
			return "今天" + dtStr;
		} else if (time >= todayStartTime + oneDay && time < todayStartTime + oneDay * 2) { // yesterday
			return "明天" + dtStr;
		} else if (time >= todayStartTime + oneDay * 2 && time < todayStartTime + oneDay * 3) { // the
																								// day
																								// before
																								// yesterday
			return "后天" + dtStr;
		} else if (time > todayStartTime + oneDay) { // future
			return "将来某一天";
		} else {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(time);
			return dateFormat.format(date);
		}
	}

	/**
	 * 某个参考时间点往前推N天N小时N分钟N秒
	 *
	 * @param date
	 *            参考时间(如果参考时间为空,则默认为默认时区和语言环境的当前时间)
	 * @param day
	 *            (-day往前推day天,+day往后推day天)
	 * @param hours
	 *            (-hours往前推hours小时,+day往后推hours小时)
	 * @param minute
	 *            (-minute往前推minute分钟,+minute往后推minute分钟)
	 * @param second
	 *            (-second往前推second秒,+second往后推second秒)
	 * @return 返回 yyyy-MM-dd 格式的时间字符串
	 */
	@SuppressWarnings("static-access")
	public static Date dateAddToTime(Date date, int day, int hours, int minute, int second) {
		Calendar calendar = Calendar.getInstance();
		try {
			if (date != null) {
				calendar.setTime(date);
			}
			calendar.add(calendar.DATE, day);
			calendar.add(calendar.HOUR, hours);
			calendar.add(calendar.MINUTE, minute);
			calendar.add(calendar.SECOND, second);
			return calendar.getTime();
		} catch (Exception e) {
			return date;
		}
	}

	public static boolean compareByDay(Timestamp from, Timestamp to, int days) {
		if (from == null || to == null) {
			return true;
		}
		if (to.getTime() > from.getTime()) {
			return false;
		}
		return (Math.abs(to.getTime() - from.getTime())) >= days * 24 * 60 * 60 * 1000;
	}

	/**
	 * 把字符串日期转换为f指定格式的Data对象
	 *
	 * @param strDate
	 *            ,f
	 * @return
	 */
	public static Date format(String strDate, String f) {
		Date d = null;
		if ("".equals(strDate))
			return null;
		else
			try {
				d = getFormatter(f).parse(strDate);
			} catch (ParseException pex) {
				return null;
			}
		return d;
	}

	/**
	 * 获取一个简单的日期格式化对象
	 *
	 * @return 一个简单的日期格式化对象
	 */
	private static SimpleDateFormat getFormatter(String parttern) {
		return new SimpleDateFormat(parttern, Locale.CHINA);
	}
	
	public static String LongToDate(long date) {
		String simpdate=String.valueOf(date);
		String dateformat=simpdate.substring(0, 4)+"-"+simpdate.substring(4, 6)+"-"+simpdate.substring(6, 8)+" "+simpdate.substring(8, 10)+":"+simpdate.substring(10, 12)+":"+simpdate.substring(12, 14);
		return dateformat;
	}
	
	/**
	 * 时间转字符串
	 * @param date 日期
	 * @param format 格式
	 * @return String
	 */
	public static String date2str(Date date, String format) {
		if (null == date){
			return "";
		}
		if (StringUtils.isBlank(format)) {
			format = DEFAULT_FORMAT;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	public static String getYesterdayString(String format){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(cal.getTime());
	}
}
