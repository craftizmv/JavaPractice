package DateUtils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateUtils {

    static String test = "\"%7B%22event_info%22%3A%7B%22event_reporting_timestamp%22%3A%222018" +
            "-25-06+04%3A25%3A56%22%2C%22event_name%22%3A%22storage_connected_on_upgrade%22%2C%22attributes%22%3A%7B%22make%22%3A%22Western+Digital%22%2C%22model%22%3A%22Elements+25A2%22%2C%22serial_no%22%3A%22575851314542363446525A34%22%2C%22total_capacity%22%3A%22492209639424%22%2C%22available_capacity%22%3A%22467116564480%22%2C%22connected_usb_port%22%3A%22high_speed_port%22%2C%22is_during_upgrade%22%3Atrue%7D%7D%2C%22header%22%3A%7B%22box_uuid%22%3A%22AREYDD002" +
            "55A%22%2C%22box_firmware_version%22%3A%227.0%22%2C%22finder_id%22%3A%22%22%2C%22event_category%22%3A%22system_info%22%7D%7D\"";

    static String test2 = "%7B%22event_info%22:%7B%22event_reporting_timestamp%22:%222018-02-13%2012:55:26%22,%22event_name%22:%22tuner_disconnected%22,%22attributes%22:%7B%22make%22:%22hauppauge%22,%22vendor_id%22:%228256%22,%22product_id%22:%2245348%22,%22num_of_tuners%22:%220%22,%22is_during_upgrade%22:false%7D%7D,%22header%22:%7B%22app_version%22:%222.1.7%22,%22box_serial_number%22:%22dd8ccb68%22,%22box_firmware_version%22:%227.0%22,%22finder_id%22:%22%22,%22event_category%22:%22system_info%22%7D%7D";


    static Long temp = System.nanoTime();
    static int temp2 = Math.abs(temp.intValue());

    static int gsh = Integer.MAX_VALUE;
    static int jd = gsh + 3;


    public static String getCurrentDateTime() {
        DateTime now = new DateTime(DateTimeZone.UTC);
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

        long millis = now.getMillis();
        DateTime time = new DateTime(millis, DateTimeZone.UTC);
        DateTimeFormatter formatter2 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Formatter : " + formatter2.print(time));


        return formatter.print(now);
    }

    public static String getCurrentTimeZoneOffset() {
        DateTimeZone tz = DateTimeZone.getDefault();
        Long instant = DateTime.now().getMillis();

        String name = tz.getName(instant);

        System.out.println("TZ Name is " + name);

        long offsetInMilliseconds = tz.getOffset(instant);
        long hours = TimeUnit.MILLISECONDS.toHours(offsetInMilliseconds);

        long minutes = TimeUnit.MILLISECONDS.toMinutes(offsetInMilliseconds);
        System.out.println("MInutes " + minutes);
        String offset = Long.toString(hours);

        return name + " (" + offset + " Hours)";
        // Example: "Mountain Standard Time (-7 Hours)"
    }

    /**
     * This method returns the present selected timezone in GMT.
     *
     * @return timezone selected in the OS/
     */
    public static String getCurrentTimezoneOffset() {

        TimeZone tz = TimeZone.getDefault();
        Calendar cal = GregorianCalendar.getInstance(tz);
        int offsetInMillis = tz.getOffset(cal.getTimeInMillis());

        String offset = String.format("%02d:%02d", Math.abs(offsetInMillis / 3600000), Math.abs((offsetInMillis / 60000) % 60));
        offset = (offsetInMillis >= 0 ? "GMT+" : "GMT-") + offset;

        return offset;
    }

    /**
     * Returns date time format as 5:00p or 1:00a
     * to indicate the start and end time of an asset.
     *
     * @return String representing the formatted date/time
     * format.
     */
    private static void getAssetTimeFormatted() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mma");
        String dateStr = simpleDateFormat.format(new Date());
        StringBuilder stringBuilder = new StringBuilder(dateStr);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        char character = Character.toLowerCase(stringBuilder.charAt(stringBuilder.length() - 1));
        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), Character.toString(character));
    }

    public static void main(String[] args) {
        /*Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = format.format(date);
        System.out.println("CurrentDate is : " + currentDate);



        Calendar cal = Calendar.getInstance();
        TimeZone tz = cal.getTimeZone();

        System.out.println("TZ isssss " + tz.getDisplayName(false,TimeZone.SHORT));

        System.out.println(getCurrentTimeZoneOffset());

        TimeZone timeZone = TimeZone.getDefault();
        System.out.println("Timezone isSSSSSSSS : " + timeZone.getDisplayName(false, TimeZone.SHORT));

        System.out.println("Current Date Time Joda is : " + getCurrentDateTime());

        try {
            String encode = URLEncoder.encode(currentDate, "UTF-8");


            System.out.println("Encoded Date is : " + encode);

            String encode1 = URLEncoder.encode("Mayank+ Verma Singh", "UTF-8").replaceAll("\\+", "%20");
            System.out.println("Encoded Date is : " + encode1);

            System.out.println("Test Data is : " + test.replaceAll("\\+", "%20"));

            String decodedData = URLDecoder.decode(test.replaceAll("\\+", "%20"), "UTF-8");

            System.out.println("Decoded Data : " + decodedData);



            String decodedData2 = URLDecoder.decode(test2,"UTF-8");
            System.out.println(" Decoded Data 2 is : " + decodedData2);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println("Time is : " + temp + " Converted is : " + temp2);

        System.out.println("GSH is " + gsh + " JD is : " + jd);*/

        getAssetTimeFormatted();

    }
}
