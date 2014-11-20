package com.dio.courses.abakhtiozin.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by AA on 25.10.2014.
 */
public class CurrencyCalculator {

    public double getResult() {
        return result;
    }

    private double result;

    public CurrencyCalculator(double value, double currencyRate) {
        BigDecimal bd = new BigDecimal(value * currencyRate);
        this.result = bd.setScale(2,BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }
    public CurrencyCalculator(double value, double currencyRate, double baseCurrencyRate) {
        BigDecimal bd = new BigDecimal(value * baseCurrencyRate/currencyRate);
        this.result = bd.setScale(2,BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }
}
