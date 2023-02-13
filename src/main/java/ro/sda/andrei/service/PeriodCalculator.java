package ro.sda.andrei.service;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class PeriodCalculator {

    private Integer numberOfDays;

    private Date departureDate;

    public PeriodCalculator() {
    }

    public PeriodCalculator(Integer numberOfDays, Date departureDate) {
        this.numberOfDays = numberOfDays;
        this.departureDate = departureDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Date calculatePeriod(Date departureDate, Integer numberOfDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(departureDate);
        calendar.add(Calendar.DAY_OF_WEEK, numberOfDays);
        return calendar.getTime();
    }
}
