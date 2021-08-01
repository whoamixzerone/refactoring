package com.company;

public class StringCalculator {

    public int add(String text) {
        if(text == null || text.isEmpty()) {
            return 0;
        }

        if(text.contains(",")) {
            String[] values = text.split(",");
            int sum = 0;
            for (String value : values) {
                sum += Integer.parseInt(value);
            }
            return sum;
        }

        return Integer.parseInt(text);
    }

}
