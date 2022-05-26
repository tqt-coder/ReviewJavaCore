package DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

public class DateTimeMain {
    private static final String FORMAT_TYPE = "dd/MM/yyyy";
    static Logger logger = Logger.getLogger(DateTimeMain.class.getName());

    public static void main(String[] args) throws ParseException {

        DateTimeMain dateTimeMain = new DateTimeMain();
        // Plus date with a number
        String result = dateTimeMain.plusDate(new Date("2/2/2022 24:01:05"), 1);
        logger.info(result);

        //Check date in week
//        Date date = dateTimeMain.convertStringToDate("2/2/2022", FORMAT_TYPE);
//        logger.info(String.valueOf(dateTimeMain.checkDateInWeek(date)));

        // Check date with duration
//        Date startDate = dateTimeMain.convertStringToDate("2/2/2022", FORMAT_TYPE);
//        Date endDate = dateTimeMain.convertStringToDate("10/2/2022", FORMAT_TYPE);
//        Date handleDate = dateTimeMain.convertStringToDate("12/2/2022", FORMAT_TYPE);
//        logger.info(String.valueOf(dateTimeMain.checkDateInDuration(startDate, endDate, handleDate)));
    }

    public String formatDate(String inputDate, String typeInitial, String typeFormat) throws ParseException {
        Date date = convertStringToDate(inputDate, typeInitial);
        return convertDateToString(date, typeFormat);
    }

    public String convertDateToString(Date date, String typeFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(typeFormat);
        return simpleDateFormat.format(date);
    }

    public Date convertStringToDate(String str, String typeFormat) throws ParseException {
        return new SimpleDateFormat(typeFormat).parse(str);
    }

    public String plusDate(Date date, int duration) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, duration);

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime dateAfterFormat = LocalDateTime.ofInstant(cal.getTime().toInstant(), ZoneId.systemDefault());

        String formattedDate = dateAfterFormat.format(dateFormat);
        return formattedDate;
    }

    public boolean checkDateInWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dateOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (dateOfWeek >= 1 && dateOfWeek <= 5)
            return true;
        return false;
    }

    public boolean checkDateInDuration(Date startDate, Date endDate, Date handleDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        int startNumber = cal.get(Calendar.DAY_OF_YEAR);
        cal.setTime(endDate);
        int endNumber = cal.get(Calendar.DAY_OF_YEAR);
        cal.setTime(handleDate);
        int checkNumber = cal.get(Calendar.DAY_OF_YEAR);
        if (checkNumber >= startNumber && checkNumber <= endNumber)
            return true;
        return false;
    }
}
