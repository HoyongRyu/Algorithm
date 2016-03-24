package rhy.sample.common.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtil {

    public static DateTime getCurrentDateTime(){
        return new DateTime();
    }

    public static String getCurrentDateTimeString(String format) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(format);
        return formatter.print(new DateTime());
    }
    
    public static String getCurrentDateTimeString() {
        return getCurrentDateTimeString("yyyyMMddHHmmss");
    }
    
    public static String getCurrentDate(String delimeter) {
        delimeter = delimeter == null ? "" : delimeter;
        return getCurrentDateTimeString("yyyy" + delimeter + "MM" + delimeter + "dd");
    }
    
    public static String getCurrentTime(String delimeter) {
        delimeter = delimeter == null ? "" : delimeter;
        return getCurrentDateTimeString("HH" + delimeter + "mm" + delimeter + "ss");
    }
    
}
