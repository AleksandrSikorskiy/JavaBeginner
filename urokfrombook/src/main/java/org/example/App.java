package org.example;

/**
 * Hello world!
 *
 */
import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeFormatter;
import java.util.Date;

public class App 
{
    public static void main( String[] args )
    {
        String sdate;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = new Date(System.currentTimeMillis());
        sdate=formatter.format(date).toString();      //01234567890123456789012345
        System.out.println(sdate+" "+date.toString());//2020-12-12 18:54:04.990
        System.out.println(sdate.substring(0,4)+sdate.substring(5,7)+sdate.substring(8,10)+sdate.substring(11,13)+sdate.substring(14,16)+sdate.substring(17,19)+sdate.substring(20,23));
        String s = "01234567890";
        System.out.println(date. .chars(sdate));
        //+sdate.substring(17,18))+sdate.substring(20,22));
//        System.out.println(LocalDateTime.now().toString());
//        System.out.println(ZonedDateTime.now().toString());
//        System.out.println(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));
    }
}
