package ro.sda.andrei.service;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class CalculationParameters {
    private int numberOfDays;
    private double price4Adult;
    private double price4Kid;
    private int numberOfAdults;
    private int numberOfKids;
    private Date departureDate;

}
