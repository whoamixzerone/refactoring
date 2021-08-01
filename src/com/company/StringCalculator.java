package com.company;

public class StringCalculator {

    public int add(String text) {
        if(text == null || text.isEmpty()) {
            return 0;
        }

        String[] values = text.split(",");
        int sum = 0;
        for (String value : values) {
            sum += Integer.parseInt(value);
        }
        return sum;
    }

    // 1단계 리팩토링
    public int add_refact1(String text) {
        if(text == null || text.isEmpty()) {
            return 0;
        }

        // 숫자 하나일 때 "," 없이 split 해도 숫자 하나를 반환하므로
        // if, 숫자형으로 형변환하고 반환하는게 필요없음
        //if(text.contains(",")) {
        String[] values = text.split(",");
        int sum = 0;
        for (String value : values) {
            sum += Integer.parseInt(value);
        }
        return sum;
        //}

        //return Integer.parseInt(text);
    }
}
