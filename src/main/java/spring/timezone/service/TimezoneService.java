package spring.timezone.service;

import java.util.Date;

public interface TimezoneService {
    Date getTimeByTimezone(String city);
}
