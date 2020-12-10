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
        String sdate="";
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = new Date(System.currentTimeMillis());
        sdate=formatter.format(date);
        System.out.println(sdate+" "+date.toString());
        System.out.println(sdate
//        System.out.println(LocalDateTime.now().toString());
//        System.out.println(ZonedDateTime.now().toString());
//        System.out.println(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));
    }
}
