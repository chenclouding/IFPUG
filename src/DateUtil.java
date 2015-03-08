/**
 * 
 */
package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author gongbell Aug 31, 2006
 * 
 */
public class DateUtil {

	// 判断两个日期是否在同一周内
	public static boolean isSameWeekDates(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		if (0 == subYear) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
			// 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		}
		return false;
	}

	// 得到date所在周的周一日期
	public static Date getMondayOfThisWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayofweek = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayofweek == 0)
			dayofweek = 7;
		c.add(Calendar.DATE, -dayofweek + 1);
		return c.getTime();
	}

	// 判断date1和date2是否是同一天
	public static boolean isSameDay(Date date1, Date date2) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String d1 = format1.format(date1);
		String d2 = format1.format(date2);
		if (d1.substring(0, 10).equals(d2.substring(0, 10)))
			return true;
		else
			return false;
	}

	public static long minusDate(String strDate1, String strDate2) {
		long longReturn = 999;
		java.sql.Date date1 = null;
		java.sql.Date date2 = null;
		try {
			date1 = java.sql.Date.valueOf(strDate1);
			date2 = java.sql.Date.valueOf(strDate2);
			long thevalue = (long) ((date1.getTime() - date2.getTime())
					/ (1000 * 60 * 60 * 24) + 0.5);
			longReturn = thevalue;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return longReturn;
	}
	public static long minusDate(Date date1, Date date2) {
		long longReturn = 999;
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String d1 = format1.format(date1).substring(0, 10);
		String d2 = format1.format(date2).substring(0, 10);
		 
		java.sql.Date date11 = null;
		java.sql.Date date22 = null;
		try {
			date11 = java.sql.Date.valueOf(d1);
			date22 = java.sql.Date.valueOf(d2);
			long thevalue = (long) ((date11.getTime() - date22.getTime())
					/ (1000 * 60 * 60 * 24));
		 
			longReturn = thevalue+1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return longReturn;
	}
	public static void main(String args[]) {
		Date now = new Date();
		
		System.out.println( minusDate(now,java.sql.Date.valueOf("2006-1-1")));
		
	}
}
