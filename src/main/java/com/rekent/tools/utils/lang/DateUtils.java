package com.rekent.tools.utils.lang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * utils to operate date
 * 
 * @author richard.zhang
 */
public class DateUtils {

	/**
	 * change Date to String according to format
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String toStringByFormat(Date date, String format) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	/**
	 * change String to Date according to format
	 * 
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date toDateByFormat(String date, String format) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.parse(date);
	}

	/**
	 * change origin date time
	 * 
	 * @param date  original date
	 * @param field @param field the calendar field.
	 * @param value amount the amount of date or time to be added to the field.
	 * @return
	 */
	public static Date changeDate(Date date, int field, int value) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, value);
		return calendar.getTime();
	}

	/**
	 * get start date of week
	 * 
	 * @param date
	 * @param firstDayofWeek value the given first day of the week.
	 * @return
	 */
	public static Date startofthisWeek(Date date, int firstDayofWeek) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.setFirstDayOfWeek(firstDayofWeek);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * get end date of week
	 * 
	 * @param date
	 * @param firstDayofWeek value the given first day of the week.
	 * @return
	 */
	public static Date endofthisWeek(Date date, int firstDayofWeek) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.setFirstDayOfWeek(firstDayofWeek);
		// first day of week -> end day of week
		int endDayofWeek = firstDayofWeek;
		if (firstDayofWeek == Calendar.SUNDAY) {
			endDayofWeek = Calendar.SATURDAY;
		} else {
			endDayofWeek = firstDayofWeek - 1;
		}
		calendar.set(Calendar.DAY_OF_WEEK, endDayofWeek);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	/**
	 * start date of month
	 * 
	 * @param date
	 * @return
	 */
	public static Date startofthisMonth(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * end date of month
	 * 
	 * @param date
	 * @return
	 */
	public static Date endOfMonth(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}
}
