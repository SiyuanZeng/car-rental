package carrental.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarConversionUtil {
	private static CalendarConversionUtil instance;

	private CalendarConversionUtil() {

	}

	public static CalendarConversionUtil getInstance() {

		if (instance == null) {
			instance = new CalendarConversionUtil();
		}

		return instance;

	}

	public String getCurrentCalendarDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("ddd yyyy MMM dd HH:mm:ss");
		Calendar calendar = new GregorianCalendar(2013, 0, 31);
		String dateString = sdf.format(calendar.getTime());
		return dateString;

	}

}
