package rhy.sample.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date getCurrentDateTime(){
        return new Date();
    }

    public static String getCurrentDateTimeString(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date());
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
