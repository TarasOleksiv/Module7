import java.util.*;
import java.text.*;

public class TestDate {

    public static void main(String args[]) {
        Date dateNow = new Date();
        //SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd/MM/yyyy");

        //System.out.println("Текущая дата " + formatForDateNow.format(dateNow));
        String str = args.length == 0 ? "04/08/2017" : args[0];

        Date parsingDate;
        try {
            parsingDate = formatForDateNow.parse(str);
            System.out.println(parsingDate);
        }catch (ParseException e) {
            System.out.println("Нераспаршена с помощью " + formatForDateNow);
        }
        //System.out.println("дата " + formatForDateNow.parse(str));
    }
}