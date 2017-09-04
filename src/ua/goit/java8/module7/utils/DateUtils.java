package ua.goit.java8.module7.utils;

/**
 * Created by t.oleksiv on 04/09/2017.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Calendar calendar = Calendar.getInstance();

    public Date convertStringToDate(String string) throws ParseException {
        calendar.setTime(dateFormat.parse(string));
        Date newDate = calendar.getTime();
        return newDate;
    }

    public Boolean datesComparing(Date dateExpiration, Date date) {
        if (dateExpiration.getTime() < date.getTime()) {
            return true;
        } else {
            return false;
        }
    }

    public Date getDateExpiration(String dateDelivery, int plusDay) throws ParseException {
        calendar.setTime(dateFormat.parse(dateDelivery));
        calendar.add(Calendar.DAY_OF_MONTH, plusDay);
        Date newDate = calendar.getTime();
        return newDate;
    }

    public SimpleDateFormat getDateFormat(){
        return dateFormat;
    }

}