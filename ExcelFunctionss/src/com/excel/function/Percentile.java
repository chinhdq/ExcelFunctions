package com.excel.function;

import java.util.*;

public class Percentile {

    public static void main(String[] args) {
        Percentile percentile = new Percentile();

        List<Double> values = new ArrayList<>();
        values.add(1432.0);
        values.add(1680.0);
        values.add(2017.0);
        values.add(2587.0);
        values.add(987.0);

        double[] arr = new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};

        Map result = percentile.getPercentiles(values, arr);

        System.out.println("percentiles: " + result);
    }

    /**
     * Get map of Percentiles
     *
     * @param values List Of Values Given
     * @param points Double array points
     *
     * @return Map Of Percentiles
     */
    Map getPercentiles(List<Double> values, double[] points) {
        if (values == null || values.isEmpty())
            return null;

        Collections.sort(values);
        Map percentiles = new HashMap();

        for (double point : points) {
            double percentPoint = (point - 1) / 10;
            double average = (percentPoint * (values.size() - 1));

            int index = (int) average;
            double firstNumber = values.get(index);
            double secondNumber = values.get(index + 1);
            double decimalPercentile = average - index;

            double percentile = decimalPercentile * (secondNumber - firstNumber) + firstNumber;
            percentiles.put(percentile, point);
        }

        return percentiles;
    }
}
