package com.qianxx.qztaxi.common.util;

import java.lang.Character.UnicodeBlock;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class StringUtil {

	private static double EARTH_RADIUS = 6378.137;

	public static String toString(Object obj) {
		if (obj == null) {
			return "null";
		}
		return String.valueOf(obj);
	}

	public static String htmlEncode(String target) {
		StringBuffer stringbuffer = new StringBuffer();
		int j = target.length();
		for (int i = 0; i < j; i++) {
			char c = target.charAt(i);
			switch (c) {
			case 60:
				stringbuffer.append("<");
				break;
			case 62:
				stringbuffer.append(">");
				break;
			case 38:
				stringbuffer.append("&");
				break;
			case 34:
				stringbuffer.append("\"");
				break;
			case 169:
				stringbuffer.append("©");
				break;
			case 174:
				stringbuffer.append("®");
				break;
			case 165:
				stringbuffer.append("¥");
				break;
			case 8364:
				stringbuffer.append("€");
				break;
			case 8482:
				stringbuffer.append("™");
				break;
			case 13:
				if (i < j - 1 && target.charAt(i + 1) == 10) {
					stringbuffer.append("<br>");
					i++;
				}
				break;
			case 32:
				if (i < j - 1 && target.charAt(i + 1) == ' ') {
					stringbuffer.append("  ");
					i++;
					break;
				}
			default:
				stringbuffer.append(c);
				break;
			}
		}
		return new String(stringbuffer.toString());
	}

	public static String getName(String nickName, String sex) {

		String name = "";
		name += nickName == null ? "" : nickName;
		name += "0".equals(sex) ? "女士" : ("1".equals(sex) ? "先生" : "");

		return name;
	}

	public static String getCalled(String sex) {
		return "0".equals(sex) ? "她" : "他";
	}


	public static String getPlaceName(String prov, String city, String dist) {
		StringBuffer ret = new StringBuffer();

		ret.append(prov);
		ret.append(city);
		ret.append(dist);

		return ret.toString();
	}

	public static String getTimeStringMMDDHH(Timestamp target) {
		if (target == null) {
			return "";
		}

		SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日HH点mm分");

		return sdf.format(target);
	}

	public static String getTimeStringMMDDHHmm(Timestamp target) {
		if (target == null) {
			return "";
		}

		SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日HH:mm");

		return sdf.format(target);
	}

	@SuppressWarnings("static-access")
	public static String getTimeTodayOrTomorrow(Timestamp target) {
		Date today = new Date();// 取系统时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(today);
		calendar.add(calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
		Date tomorrow = calendar.getTime();
		calendar.add(calendar.DATE, 2);// 把日期往后增加一天.整数往后推,负数往前移动
		Date three = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat(" HH:mm");
		String hour = sdf1.format(target);
		String todayStr = sdf.format(today);
		String tomorrowStr = sdf.format(tomorrow);
		String threeStr = sdf.format(three);
		String targetStr = sdf.format(target);
		if (todayStr.equals(targetStr)) {
			return "今天" + hour;
		} else if (tomorrowStr.equals(targetStr)) {
			return "明天" + hour;
		} else if (threeStr.equals(targetStr)) {
			return "后天" + hour;
		}
		return targetStr + hour;
	}

	// 在车牌号中间2位加星表示
	public static String toStarPlateNum(String str) {
		if (StringUtils.isEmpty(str)) {
			return "";
		}
		String[] strs = str.trim().split("");
		if (strs.length < 5) {
			return str;
		}
		StringBuffer ret = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			if (i == 3 || i == 4) {
				ret.append("*");
			} else {
				ret.append(strs[i]);
			}
		}
		return ret.toString();
	}

	public static String toStarKey(String str, int startIdx) {
		if (StringUtils.isEmpty(str)) {
			return "";
		}
		// 保持开始3位，其余用*替代
		String[] strs = str.trim().split("");
		if (strs.length < startIdx) {
			return str;
		}
		StringBuffer ret = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			if (i < startIdx) {
				ret.append(strs[i]);
			} else {
				ret.append("*");
			}
		}
		return ret.toString();
	}

	public static String toCommaConnect(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		StringBuffer retBuffer = new StringBuffer();
		for (String s : strs) {
			retBuffer.append(s);
			retBuffer.append(", ");
		}
		return retBuffer.substring(0, retBuffer.length() - 2);
	}

	public static String toCommaConnect(List<String> strs) {
		if (strs == null || strs.size() == 0) {
			return "";
		}
		StringBuffer retBuffer = new StringBuffer();
		for (String s : strs) {
			retBuffer.append(s);
			retBuffer.append(", ");
		}
		return retBuffer.substring(0, retBuffer.length() - 2);
	}

	public static boolean isNotBlank(String s) {
		if (s != null && s.length() > 0) {
			return true;
		}
		return false;
	}

	public String gbk2utf8(String gbk) {
		String l_temp = GBK2Unicode(gbk);
		l_temp = unicodeToUtf8(l_temp);
		return l_temp;
	}

	public String utf82gbk(String utf) {
		String l_temp = utf8ToUnicode(utf);
		l_temp = Unicode2GBK(l_temp);
		return l_temp;
	}

	public static String GBK2Unicode(String str) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			char chr1 = (char) str.charAt(i);
			if (!isNeedConvert(chr1)) {
				result.append(chr1);
				continue;
			}
			result.append("\\u" + Integer.toHexString((int) chr1));
		}
		return result.toString();
	}

	public static String Unicode2GBK(String dataStr) {
		int index = 0;
		StringBuffer buffer = new StringBuffer();
		int li_len = dataStr.length();
		while (index < li_len) {
			if (index >= li_len - 1 || !"\\u".equals(dataStr.substring(index, index + 2))) {
				buffer.append(dataStr.charAt(index));
				index++;
				continue;
			}
			String charStr = "";
			charStr = dataStr.substring(index + 2, index + 6);
			char letter = (char) Integer.parseInt(charStr, 16);
			buffer.append(letter);
			index += 6;
		}
		return buffer.toString();
	}

	public static boolean isNeedConvert(char para) {
		return ((para & (0x00FF)) != para);
	}

	public static String utf8ToUnicode(String inStr) {
		char[] myBuffer = inStr.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < inStr.length(); i++) {
			UnicodeBlock ub = UnicodeBlock.of(myBuffer[i]);
			if (ub == UnicodeBlock.BASIC_LATIN) {
				sb.append(myBuffer[i]);
			} else if (ub == UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
				int j = (int) myBuffer[i] - 65248;
				sb.append((char) j);
			} else {
				short s = (short) myBuffer[i];
				String hexS = Integer.toHexString(s);
				String unicode = "\\u" + hexS;
				sb.append(unicode.toLowerCase());
			}
		}
		return sb.toString();
	}

	public static String unicodeToUtf8(String theString) {
		char aChar;
		if (theString == null) {
			return "";
		}
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't')
						aChar = 't';
					else if (aChar == 'r')
						aChar = 'r';
					else if (aChar == 'n')
						aChar = 'n';
					else if (aChar == 'f')
						aChar = 'f';
					outBuffer.append(aChar);
				}
			} else
				outBuffer.append(aChar);
		}
		return outBuffer.toString();
	}

	public static String getSubstring(String content, String beginLabel, String endLabel) {
		int findBegin = content.indexOf(beginLabel);
		if (findBegin != -1) {
			int findEnd = content.indexOf(endLabel, findBegin);
			if (findEnd != -1) {
				return content.substring(findBegin + beginLabel.length(), findEnd);
			}
		}
		return "";
	}

	public static String getEncoding(String str) {
		String encode = "ISO-8859-1";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) { // 判断是不是ISO-8859-1
				String s1 = encode;
				return s1;
			}
		} catch (Exception exception1) {
		}
		encode = "UTF-8";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) { // 判断是不是UTF-8
				String s2 = encode;
				return s2;
			}
		} catch (Exception exception2) {
		}
		encode = "GBK";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) { // 判断是不是GBK
				String s3 = encode;
				return s3;
			}
		} catch (Exception exception3) {
		}
		encode = "GB2312";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) { // 判断是不是GB2312
				String s = encode;
				return s; // 是的话，返回“GB2312“，以下代码同理
			}
		} catch (Exception exception) {
		}
		return ""; // 如果都不是，说明输入的内容不属于常见的编码格式。
	}

	public static String match(String regex, String content, int group) {
		Pattern compile = Pattern.compile(regex);
		Matcher matcher = compile.matcher(content);
		if (matcher.find()) {
			return matcher.group(group);
		}
		return "";
	}

	public static Integer getUserId(HttpServletRequest request) {
		Object userId = request.getAttribute("userId");
		return null != userId ? Integer.valueOf(String.valueOf(userId)) : null;
	}
	
	public static String getTransactionId(HttpServletRequest request) {
		Object token = request.getHeader("token");
		return null != token ? String.valueOf(String.valueOf(token)) : DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMddHHmmssSSS") + RandomStringUtils.randomNumeric(4);
	}

	/**
	 * 根据两个位置的经纬度，来计算两地的距离（单位为KM） 参数为String类型
	 * 
	 * @param lat1Str
	 *            用户经度
	 * @param lng1Str
	 *            用户纬度
	 * @param lat2Str
	 *            商家经度
	 * @param lng2Str
	 *            商家纬度
	 * @return
	 */
	public static String getDistance(String lat1Str, String lng1Str, String lat2Str, String lng2Str) {
		Double lat1 = Double.parseDouble(lat1Str);
		Double lng1 = Double.parseDouble(lng1Str);
		Double lat2 = Double.parseDouble(lat2Str);
		Double lng2 = Double.parseDouble(lng2Str);
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double difference = radLat1 - radLat2;
		double mdifference = rad(lng1) - rad(lng2);
		double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(difference / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(mdifference / 2), 2)));
		distance = distance * EARTH_RADIUS;
		distance = Math.round(distance * 10000) / 10000;
		String distanceStr = distance + "";
		distanceStr = distanceStr.substring(0, distanceStr.indexOf("."));

		return distanceStr;
	}

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	public static Boolean checkMobile(String mobile) {
		Boolean check = true;
		// 中国电信:133,153,180,181,189,177;
		if (mobile.length() == 11) {
		} else {
			check = false;
		}
		return check;
	}

	// 四舍五入
	public static double getDoubleValue(double value, int digit) {
		if (digit < 0) {
			return 0;
		}
		BigDecimal bd = new BigDecimal(Double.toString(value)).setScale(digit, BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}

	// 判断是否包含表情
	// 判别是否包含Emoji表情
	public static boolean containsEmoji(String str) {
		int len = str.length();
		for (int i = 0; i < len; i++) {
			if (isEmojiCharacter(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	private static boolean isEmojiCharacter(char codePoint) {
		return !((codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) || (codePoint == 0xD)
				|| ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
				|| ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF)));
	}

	public static String getValue(Map<String, Object> map, String key) {
		Object o = map.get(key);
		return o != null ? String.valueOf(o) : "";
	}

	// 将数字转化为大写
	public static String numToUpper(int num) {
		String u[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
		// String u[] = { "〇", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
		char[] str = String.valueOf(num).toCharArray();
		String rstr = "";
		for (int i = 0; i < str.length; i++) {
			rstr = rstr + u[Integer.parseInt(str[i] + "")];
		}
		return rstr;
	}
	
	/**
	 * 判断字符串是否都是数字
	 * @param s
	 * @return
	 */
	public final static boolean isNumeric(String s) {
		if (org.apache.commons.lang.StringUtils.isNotBlank(s)) {
			return s.matches("^[0-9]*$");
		}
		return false;
	}

}