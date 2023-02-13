package ro.sda.andrei.service;

import org.springframework.stereotype.Service;

@Service
public class PriceCalculator {

    public double calculatePrice(CalculationParameters calculationParameters) {
        double result = 0;
        result = calculationParameters.getNumberOfAdults()*calculationParameters.getPrice4Adult();
        result =  calculationParameters.getNumberOfKids()*calculationParameters.getPrice4Kid() + result;
        result = calculationParameters.getNumberOfDays() * result;

        if (calculationParameters.getNumberOfDays()<7){
            result= result * 1;
        }

        if (calculationParameters.getNumberOfDays()>7){
            result= result * 0.9;
        }


        return result;
    }


}
