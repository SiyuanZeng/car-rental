package carrental.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarConversion {
	public String getCurrentCalendarDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		Calendar calendar = new GregorianCalendar(2013,0,31);
		String dateString = sdf.format(calendar.getTime());
		return dateString;

	}

}
