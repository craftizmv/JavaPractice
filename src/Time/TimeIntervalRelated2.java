package Time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeIntervalRelated2 {

    public static boolean isTimeBetweenTwoTime(String argStartTime,
                                               String argEndTime, String argCurrentTime) throws ParseException {
        String reg = "^([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
        //
        if (argStartTime.matches(reg) && argEndTime.matches(reg)
                && argCurrentTime.matches(reg)) {
            boolean valid = false;
            // Start Time
            java.util.Date startTime = new SimpleDateFormat("HH:mm:ss")
                    .parse(argStartTime);
            Calendar startCalendar = Calendar.getInstance();

            Date today = startCalendar.getTime();

            System.out.println(" Today : " + today);

            startCalendar.setTimeInMillis(System.currentTimeMillis());
            startCalendar.setTime(startTime);

            // Current Time
            java.util.Date currentTime = new SimpleDateFormat("HH:mm:ss")
                    .parse(argCurrentTime);
            Calendar currentCalendar = Calendar.getInstance();
            currentCalendar.setTimeInMillis(System.currentTimeMillis());
            currentCalendar.setTime(currentTime);

            // End Time
            java.util.Date endTime = new SimpleDateFormat("HH:mm:ss")
                    .parse(argEndTime);
            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTimeInMillis(System.currentTimeMillis());
            endCalendar.setTime(endTime);


            if (currentCalendar.before(startCalendar)) {
                System.out.println(" Before the start calender");
            } else if (currentCalendar.after(endCalendar)) {
                System.out.println(" After the end calender");
            } else {
                System.out.println(" Lies btwn the calender ");
            }

            return valid;

        } else {
            throw new IllegalArgumentException(
                    "Not a valid time, expecting HH:MM:SS format");
        }

    }

    public static void main(String[] args) {
        /*String startTime = "23:00:00";
        String endTime = "02:00:00";
        String currentTime = "01:40:01";*/

        /*try {
            isTimeBetweenTwoTime(startTime, endTime, currentTime);
        } catch (ParseException e) {
            System.out.println(" Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }*/


        Date endTime = null;
        try {

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getCurrentDate());
            stringBuilder.append("01:31:00");

            endTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                    .parse(stringBuilder.toString());

            Calendar endCalendar = Calendar.getInstance();
//            endCalendar.setTimeInMillis(System.currentTimeMillis());
//            endCalendar.set(Calendar.HOUR_OF_DAY, 01);
//            endCalendar.set(Calendar.MINUTE, 31);
//            endCalendar.set(Calendar.SECOND, 00);

            endCalendar.setTime(endTime);


            System.out.println(endCalendar.getTime());

            getCurrentDate();

            dateExp();

        } catch (ParseException e) {
            System.out.println("Exception Occurred.");
            e.printStackTrace();
        }

    }

    public static String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
        Date date = new Date();
//        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
        return dateFormat.format(date);
    }


    public static void dateExp(){

        String initialTime = "03:00";
        //Convert the initial time to calender Instance
        Date initialDate = null;
        try {
            initialDate = new SimpleDateFormat("HH:mm", Locale.US).parse(initialTime);
            Calendar initialTimeCalender = Calendar.getInstance();
            initialTimeCalender.setTime(initialDate);

            System.out.println(" Initial Date is : " + initialDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

