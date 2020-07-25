package com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        String str = "20-7-25 下午3:02";
        Date parse = sdf.parse(str);
        System.out.println(parse);

        SimpleDateFormat sdf1 =new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
        String format1 = sdf1.format(date);
        System.out.println(format1);

        Date parse1 = sdf1.parse(format1);
        System.out.println(parse1);

    }
}
