package spring.timezone.service.Impl;

import spring.timezone.service.TimezoneService;

import java.util.Date;
import java.util.TimeZone;

public class TimezoneServiceImpl implements TimezoneService {
    @Override
    public Date getTimeByTimezone(String city){
        // Get current time at local
        Date date = new Date();
        // Get timezone by the local
        TimeZone local = TimeZone.getDefault();
        // Get timezone by the specified city
        TimeZone locale = TimeZone.getTimeZone(city);
        // Calculate the current time in the specified city
        long locale_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        // Reset the date by locale_time
        date.setTime(locale_time);

        return date;
    }
}
