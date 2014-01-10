package carrental.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateAndTimeConversionUtil {

	private static DateAndTimeConversionUtil instance;

	private DateAndTimeConversionUtil() {

	}

	public static DateAndTimeConversionUtil getInstance() {

		if (instance == null) {
			instance = new DateAndTimeConversionUtil();
		}

		return instance;

	}

	public String timeTwelveHourToString(LocalTime localTime) {
		DateTimeFormatter parser1 = DateTimeFormat.forPattern("H:mm aa");
        return parser1.print(localTime);
	}

	public String dateToString(Date date) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("E dd MMM yyyy");
		String dateString = sdf.format(date);
		return dateString;

	}

	public Date editableGridStringToDate(String dateString) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(date); // Tue Aug 31 10:20:56 SGT 1982
		return date;
	}

	public Date getCurrentDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); // 2013/10/15 16:16:39
		return date;
	}

	public Date datePlusDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, days);
		Date newDate = cal.getTime();

		return newDate;
	}

	public Date datePlusMonth(Date date, int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, month);
		Date newDate = cal.getTime();

		return newDate;
	}

}
