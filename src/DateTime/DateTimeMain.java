package DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Logger;

public class DateTimeMain {
    private static final String FORMAT_TYPE = "dd/MM/yyyy";
    static Logger logger = Logger.getLogger(DateTimeMain.class.getName());

    public static void main(String[] args) throws ParseException {

        DateTimeMain dateTimeMain = new DateTimeMain();
        // Plus date with a number
//        Date result = dateTimeMain.plusDate(null, 0, "YEAR");
//        logger.info(result.toString());

        //Check date in week
//        Date date = dateTimeMain.convertStringToDate("2/2/2022", FORMAT_TYPE);
//        logger.info(String.valueOf(dateTimeMain.checkDateInWeek(date)));

        // Check date with duration
//        Date startDate = dateTimeMain.convertStringToDate("2/2/2023", FORMAT_TYPE);
//        Date endDate = dateTimeMain.convertStringToDate("10/2/2024", FORMAT_TYPE);
//        Date handleDate = dateTimeMain.convertStringToDate("12/2/2023", FORMAT_TYPE);
//        logger.info(String.valueOf(dateTimeMain.checkDateInDuration(startDate, endDate, handleDate)));
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String date1 = "23/12/2022 23:22:45";
        dateTimeMain.initialAndFinalDate(format.parse(date1));
//
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

    public Date plusDate(Date date, int duration, String field) throws ParseException {
        Calendar cal = Calendar.getInstance();
        Optional<Date> newDate = Optional.ofNullable(date);
        Date t = newDate.orElse(new Date());
        try {
            cal.setTime(t);
            switch (field) {
                case "DATE":
                    cal.add(Calendar.DATE, duration);
                    break;
                case "MONTH":
                    cal.add(Calendar.MONTH, duration);
                    break;
                case "YEAR":
                    cal.add(Calendar.YEAR, duration);
                    break;

            }

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime dateAfterFormat = LocalDateTime.ofInstant(cal.getTime().toInstant(), ZoneId.systemDefault());

            String formattedDate = dateAfterFormat.format(dateFormat);
            return convertStringToDate(formattedDate, "dd/MM/yyyy HH:mm:ss");
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
        return new Date();
    }

    public boolean checkDateInWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dateOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (dateOfWeek >= 1 && dateOfWeek <= 5) {
            return true;
        }
        return false;
    }

    public boolean checkDateInDuration(Date startDate, Date endDate, Date handleDate) {
        Optional<Date> startDateNew = Optional.ofNullable(startDate);
        Date startDateVal = startDateNew.orElse(new Date());
        Optional<Date> endDateNew = Optional.ofNullable(endDate);
        Date endDateVal = endDateNew.orElse(new Date());
        Optional<Date> handleDateNew = Optional.ofNullable(handleDate);
        Date handleDateVal = handleDateNew.orElse(new Date());

        long startNumber = startDateVal.getTime();
        long endDateNumber = endDateVal.getTime();
        long handleDateNumber = handleDateVal.getTime();

        if (handleDateNumber >= startNumber && handleDateNumber <= endDateNumber) {
            return true;
        }
        return false;

    }

    public void caclDurationTwoDay(String firstDate, String secondDate) {
        try {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date firstDateVal = format.parse(firstDate.toString());
            Date secondDateVal = format.parse(secondDate.toString());

            long unixTimeFirst = firstDateVal.getTime();
            long unixTimeSecond = secondDateVal.getTime();
            long period = Math.abs(unixTimeFirst - unixTimeSecond);
            logger.info(String.valueOf(period / (24 * 3600 * 1000)));
        } catch (Exception e) {
            logger.info(e.toString());
        }


    }

    public int compareTwoDates(Date date1, Date date2) {
        Long number1 = date1.getTime();
        Long number2 = date2.getTime();
        return number1.compareTo(number2);
    }

    public void initialAndFinalDate(Date date) {


        try{
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date startDate = calendar.getTime();

            DateFormat formatDate= new SimpleDateFormat("dd/MM/yyyy 23:59:59");
            String stringDate = formatDate.format(date);
            Date endDate = formatDate.parse(stringDate);
            System.out.println(endDate);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
