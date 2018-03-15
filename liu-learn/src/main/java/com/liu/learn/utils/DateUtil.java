package com.liu.learn.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
/**
 * 日期函数工具类
 * 
 * @author liuyq
 * @version 1.0,2017年11月21日
 */
public class DateUtil {
	public static final String DATE_DIVISION = "-";
	public static final String TIME_PATTERN_DEFAULT = "yyyy-MM-dd HH:mm:ss";
	public static final String TIME_PATTERN_NO_CON = "yyyyMMddHHmmss";
	public static final String DATE_PATTERN_DEFAULT = "yyyy-MM-dd";
	public static final String DATE_PATTERN_DDHHMM = "dd日HH时mm分";
	public static final String DATE_PATTERN_YYYYMMDD = "yyyyMMdd";
	public static final String DATE_PATTERN_YYYYMM = "yyyyMM";
	public static final String DATE_PATTERN_YYYY = "yyyy";
	public static final String DATE_PATTERN_YYMM = "yyyy年MM月";
	public static final String TIME_PATTERN_HHMMSS = "HH:mm:ss";
	public static final int SECOND = 1000;
	public static final int MINUTE = 60000;
	public static final int HOUR = 3600000;
	public static final long DAY = 86400000L;

	public static Date now() {
		Calendar cal = Calendar.getInstance();
		Date currDate = cal.getTime();
		return currDate;
	}

	public static Date nowYearEnd() {
		Calendar cal = Calendar.getInstance();
		cal.set(1, getYear(now()));
		cal.set(2, 11);
		cal.set(5, 31);
		cal.set(11, 23);
		cal.set(12, 59);
		cal.set(13, 59);
		Date currDate = cal.getTime();
		return currDate;
	}

	public static Timestamp nowTimestamp() {
		Calendar cal = Calendar.getInstance();
		return new Timestamp(cal.getTimeInMillis());
	}

	public static String nowString() {
		Calendar cal = Calendar.getInstance();
		Date currDate = cal.getTime();
		return formatDate(currDate);
	}

	public static String nowString(String pattern) {
		Calendar cal = Calendar.getInstance();
		Date currDate = cal.getTime();
		return format(currDate, pattern);
	}

	public static Date parseDate(String dateValue) {
		return parse(dateValue, "yyyy-MM-dd");
	}

	public static void main(String[] args) {
		Double dd = Double.valueOf(31.0D / (double) getDayNumByDate(getDateForMonthFirstDate(new Date()))
				* (double) getDayNumToEOMDef(getDateForMonthFirstDate(new Date())));
		System.out.println(dd);
		System.out.println(getDateEnd(new Date()));
		System.out.println(format(getDateForMonthRemoveOne(parse("201708", "yyyyMM")), "yyyyMM"));
	}

	public static Date parseTime(String dateValue) {
		return parse(dateValue, "yyyy-MM-dd HH:mm:ss");
	}

	public static Date parse(String dateValue, String pattern) {
		if (StringUtils.isEmpty(dateValue)) {
			return null;
		} else {
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

			try {
				return dateFormat.parse(dateValue);
			} catch (ParseException arg3) {
				return null;
			}
		}
	}

	public static String formatDate(Date d) {
		return format(d, "yyyy-MM-dd");
	}

	public static String formatTime(Date t) {
		return format(t, "yyyy-MM-dd HH:mm:ss");
	}

	public static String format(Date d, String pattern) {
		if (d == null) {
			return null;
		} else {
			SimpleDateFormat dateFromat = new SimpleDateFormat(pattern);
			return dateFromat.format(d);
		}
	}

	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(5, days);
		return cal.getTime();
	}

	public static Date addMonths(Date date, int months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(2, months);
		return cal.getTime();
	}

	public static Date addYear(Date date, int year) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(1, year);
		return cal.getTime();
	}

	public static int daysBetween(Date date1, Date date2) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		long time1 = cal.getTimeInMillis();
		cal.setTime(date2);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / 86400000L;
		return Integer.parseInt(String.valueOf(between_days));
	}

	public static Date getDateBeforTwelveMonth() {
		Calendar cal = Calendar.getInstance();
		cal.set(5, 1);
		cal.set(11, 0);
		cal.set(12, 0);
		cal.set(13, 0);
		cal.add(2, -12);
		return cal.getTime();
	}

	public static Date addDate(String date) {
		if (date == null) {
			return null;
		} else {
			Date tmpDate = parse(date, "yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(tmpDate);
			cal.add(5, 1);
			return cal.getTime();
		}
	}

	public static int getWeekOfDate(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(7) - 1;
		if (w < 0) {
			w = 0;
		}

		return w;
	}

	public static String getCurrentMouDateStr() {
		Calendar cal = Calendar.getInstance();
		cal.set(5, 1);
		return format(cal.getTime(), "yyyy-MM-dd");
	}

	public static Date getDateBegin(Date dt) {
		Calendar cal = Calendar.getInstance();
		if (dt != null) {
			cal.setTime(dt);
		}

		cal.set(11, 0);
		cal.set(12, 0);
		cal.set(13, 0);
		return cal.getTime();
	}

	public static Date getDateEnd(Date dt) {
		Calendar cal = Calendar.getInstance();
		if (dt != null) {
			cal.setTime(dt);
		}

		cal.set(11, 23);
		cal.set(12, 59);
		cal.set(13, 59);
		return cal.getTime();
	}

	public static Date getDateForMonthAddOne(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(c.get(1), c.get(2) + 1, 1);
		Date nextDate = c.getTime();
		return nextDate;
	}

	public static Date getDateForMonthAddNew(Date date, int month) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(c.get(1), c.get(2) + month, c.get(5));
		Date nextDate = c.getTime();
		return nextDate;
	}

	public static Date getDateForMonthRemoveOne(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(2, -1);
		c.set(5, c.getActualMaximum(5));
		return c.getTime();
	}

	public static int yearsBetween(Date date1, Date date2) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		int year1 = cal.get(1);
		int month1 = cal.get(2) + 1;
		cal.setTime(date2);
		int year2 = cal.get(1);
		int month2 = cal.get(2) + 1;
		int yearBetween = year2 - year1;
		int monthBetween = month2 - month1;
		int betweenMonths = monthBetween + yearBetween * 12;
		return betweenMonths / 12;
	}

	public static int yearsBetweenExactDate(Date date1, Date date2) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		int year1 = cal.get(1);
		cal.setTime(date2);
		int year2 = cal.get(1);
		int yearBetween = year2 - year1;
		Date date3 = addYear(date1, yearBetween);
		return yearBetween > 0 ? (date3.after(date2) ? yearBetween - 1 : yearBetween)
				: (yearBetween < 0 ? (date3.before(date2) ? yearBetween + 1 : yearBetween) : yearBetween);
	}

	public static Date getDateForYearAddOne(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(c.get(1) + 1, c.get(2), c.get(5));
		Date nextYear = c.getTime();
		return nextYear;
	}

	public static Date getDateForMonth(Date date, int month) {
		if (date == null) {
			return null;
		} else {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			if (month == 0) {
				if (c.get(1) >= 2014) {
					c.add(2, 12);
				} else {
					c.add(2, 6);
				}
			} else {
				c.add(2, month);
			}

			Date nextYear = c.getTime();
			return nextYear;
		}
	}

	public static String getDiffCalendar(Date targetDate, Date baseDate) {
		if (targetDate == null) {
			return "";
		} else {
			Calendar target = Calendar.getInstance();
			target.setTime(targetDate);
			Calendar now = Calendar.getInstance();
			if (baseDate != null) {
				now.setTime(baseDate);
			}

			int targetYear = target.get(1);
			int nowYear = now.get(1);
			int targetMonth = target.get(2);
			int nowMonth = now.get(2);
			int years = nowYear - targetYear;
			if (years < 0) {
				return "";
			} else {
				int months = nowMonth - targetMonth;
				if (months < 0) {
					--years;
					months += 12;
				}

				String age = "";
				if (years > 0) {
					age = years + "年";
				}

				if (months > 0) {
					age = age + months + "月";
				}

				if (months == 0) {
					age = age + "整";
				}

				return age;
			}
		}
	}

	public static int getMonthsBetween(Date date1, Date date2) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		int year1 = cal.get(1);
		int month1 = cal.get(2) + 1;
		cal.setTime(date2);
		int year2 = cal.get(1);
		int month2 = cal.get(2) + 1;
		int yearBetween = year2 - year1;
		int monthBetween = month2 - month1;
		int betweenMonths = monthBetween + yearBetween * 12;
		return betweenMonths;
	}

	public static int getMonth(Date date) {
		return getFromDate(date, 2);
	}

	public static int getYear(Date date) {
		return getFromDate(date, 1);
	}

	public static int getFromDate(Date date, int field) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(field);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Integer> getCurrentThreeYear() {
		int currentYear = Integer.parseInt(nowString("yyyy"));
		ArrayList yearList = new ArrayList();
		yearList.add(Integer.valueOf(currentYear));
		yearList.add(Integer.valueOf(currentYear - 1));
		yearList.add(Integer.valueOf(currentYear - 2));
		return yearList;
	}

	public static Date getDateForMonthFirstDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(5, 1);
		return c.getTime();
	}

	public static Date getDateForMonthLastDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(5, c.getActualMaximum(5));
		return c.getTime();
	}

	public static String getYearStartDate() {
		String newYearDate = formatDate(now());
		newYearDate = newYearDate.substring(0, 4) + "-01-01";
		return newYearDate;
	}

	public static String dateToStr(Date date) {
		if (date == null) {
			return "";
		} else {
			String str = formatDate(date);
			str = str.replaceAll("\\D", "");
			return str;
		}
	}

	public static Date getDateFromStr(String s) {
		return parse(s, "yyyyMMdd");
	}

	public static int compareDate(Date date1, Date date2) {
		if (date1 != null && date2 != null) {
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			cal1.setTime(getDateFromStr(dateToStr(date1)));
			cal2.setTime(getDateFromStr(dateToStr(date2)));
			return cal1.compareTo(cal2);
		} else {
			return -1;
		}
	}

	public static boolean orgDateLtDate(Date orgDate, Date date) {
		return compareDate(orgDate, date) == -1;
	}

	public static boolean orgDateGtDate(Date orgDate, Date date) {
		return compareDate(orgDate, date) == 1;
	}

	public static boolean orgDateEqDate(Date orgDate, Date date) {
		return compareDate(orgDate, date) == 0;
	}

	public static Date parseToDate(String x) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
		Date date = null;
		System.out.println("x:" + x);

		try {
			date = sdf.parse(x);
		} catch (ParseException arg3) {
			arg3.printStackTrace();
		}

		return date;
	}

	public static int getDayNumByDate(Date date) {
		Calendar a = Calendar.getInstance();
		a.setTime(date);
		a.set(5, 1);
		a.roll(5, -1);
		int maxDate = a.get(5);
		return maxDate;
	}

	public static int getDayNumToEOM(Date date, Boolean isInclude) {
		if (isInclude == null) {
			isInclude = Boolean.valueOf(true);
		}

		Calendar curCa = Calendar.getInstance();
		curCa.setTime(date);
		int curDayNum = curCa.get(5);
		Calendar lastCa = Calendar.getInstance();
		lastCa.setTime(getDateForMonthLastDate(date));
		int lastDayNum = lastCa.get(5);
		int inc = isInclude.booleanValue() ? 1 : 0;
		return curDayNum == lastDayNum ? 1 : lastDayNum - curDayNum + inc;
	}

	public static int getDayNumToEOMDef(Date date) {
		return getDayNumToEOM(date, Boolean.valueOf(true));
	}

	public static int getSecondsBetween(Date date1, Date date2) {
		int second1 = (int) date1.getTime();
		int second2 = (int) date2.getTime();
		return Math.abs(second1 - second2);
	}
}