package com.excel.function;

import java.util.Arrays;

public class Forecast {

    public static void main(String[] args) {
        Forecast forecast = new Forecast();

        double[] arr = new double[]{1.0, 7.0};
        double[] arr2 = new double[]{1.0, 10.0};

        double result = forecast.getForecastValue(arr, arr2, 6);

        System.out.println("forecast value: " + result);
    }

    /**
     * Get forecast value
     *
     * @param x_Values  X Array Values
     * @param y_Values  Y Array Values
     *
     * @param number    Number To Forecast
     *
     * @return Forecast Value
     */
    double getForecastValue(double[] x_Values, double[] y_Values, double number){
        double x_Avg = 0.0;
        double y_Avg = 0.0;
        double tempTop = 0.0;
        double tempBottom = 0.0;

        x_Avg =  Arrays.stream(x_Values).sum() / x_Values.length;
        y_Avg = Arrays.stream(y_Values).sum() / y_Values.length;

        for (int i = 0; i < y_Values.length; i++)
        {
            double x_Value = x_Values[i];
            double y_Value = y_Values[i];

            tempTop += (x_Value - x_Avg) * (y_Value - y_Avg);
            tempBottom += Math.pow(x_Value - x_Avg,  2.0);
        }

        double tempDivision = tempTop / tempBottom;
        double avgResult  = y_Avg - tempDivision * x_Avg;
        double forecastValue = avgResult + tempDivision * number;

        return forecastValue;
    }
}
