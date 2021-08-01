package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    /*
        연습 코드이기때문에 극단적으로 리팩토링한다.
        메서드는 한 가지의 일만 수행하게끔 한다.
     */

    // 리팩토링 전 add 메서드
    public int add_before(String text) {
        if(text == null || text.isEmpty()) {
            return 0;
        }

        if(text.contains(",")) {
            String[] values = text.split(",");
            int sum = 0;
            for (String value : values) {
                sum += Integer.parseInt(value);
            }
        }

        return Integer.parseInt(text);
    }

    /*
       sum 메서드의 경우 메서드안에서 2가지의 일을 수행하고 있다.
       1. sum
       2. 문자열을 숫자형으로 형변환환
    */
    // 리팩토링 한단계 진행
     private int sum_before(String[] values) {
        int sum = 0;
        for (String value : values) {
            sum += Integer.parseInt(value);
        }
        return sum;
    }

    // 리팩토링 두단계 진행(sum 메서드 분리해서 toInts() 생성)
    public int add_before2(String text) {
        if(isBlank(text)) {
            return 0;
        }

        return sum_before(split(text));
    }

    public int add(String text) {
        if(isBlank(text)) {
            return 0;
        }

        return sum(toInts(split(text)));
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            String customDelimeter = m.group(1);
            return m.group(2).split(customDelimeter);
        } else {
            return text.split(",|:");
        }
    }

    private int[] toInts(String[] values) {
         int[] numbers = new int[values.length];
         for(int i=0; i<values.length; ++i) {
             numbers[i] = Integer.parseInt(values[i]);
         }
         return numbers;
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

}
