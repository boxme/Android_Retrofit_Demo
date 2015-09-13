package com.desmond.android_retrofit_demo.rest.utils;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by desmond on 13/9/15.
 */
public class DateTimeUtility {

    /**
     * Convert date from yyyy-MM-dd to dd MMM yyyy
     */
    public static String convertDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'", Locale.getDefault());

        if (!TextUtils.isEmpty(date)) {
            try {
                Date formattedDate = format.parse(date);
                return new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).format(formattedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return "-";
    }

    /**
     * Convert PST date to dd MMM yyyy
     * @param date format is 02:00:00 Jan 22, 2015 PST
     * @return
     */
    public static String convertPSTDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("HH':'mm':'ss MMM dd',' yyyy");
        date = date.substring(0, 21);

        try {
            Date formattedDate = format.parse(date);
            return new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).format(formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "-";
    }

    /**
     * Convert time to 8:32pm
     */
    public static String convertTime(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));

        try {
            Date formattedDate = format.parse(date);
            return new SimpleDateFormat("dd MMMM hh:mm a").format(formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "-";
    }
}
