package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Roman2Integer {

    /**
     * 로마 문자열을 받아 아라비아 숫자로 리턴
     * 1 <= 로마자의 길이 <= 15
     * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
     * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
     *
     * 작은 단위가 큰 단위보다 왼쪽에 나온 경우, 큰 단위에서 작은 단위를 뺀다는 뜻 (IV => 5-1 = 4, CM = 1000 - 100 = 900)
     * 따라서 49 는 IL 로 쓸 수 없고 XLIX(50-10)+(10-1) 로 써야 하며, 45 또한 VL(50-5) 가 아닌 XLV((50-10)+5)
     * 99 도 IC(100-1) 로 쓸 수 없고 XCIX((100-10)+(10-1)) 로 써야 한다.
     *
     *
     * 뒤에서부터 String 을 한글자씩 확인하여 확인된 String 보다 그 앞의 문자열의 숫자가 작으면
     * 해당 로마자를 - 해서 처리함
     *
     * @param s 로마 문자열
     * @return {@link Integer 아라비아 숫자로 리턴}
     */
    public int romanToInt(String s) {

        HashMap<String, Integer> romanChar = new HashMap<>();

        romanChar.put("I", 1);
        romanChar.put("V", 5);
        romanChar.put("X", 10);
        romanChar.put("C", 100);
        romanChar.put("L", 50);
        romanChar.put("D", 500);
        romanChar.put("M", 1000);

        int position = s.length() -1;
        int result = 0;

        while(position >= 0) {
            int num;
            if(position > 0) {
                num = romanChar.get(s.substring(position, position+1));
                int preNum = romanChar.get(s.substring(position-1, position));
                if (num > preNum) {
                    num = num - preNum;
                    position--;
                }

            } else {
                num = romanChar.get(s.substring(position, position+1));
            }

            result = result + num;


            position--;
        }

        return result;
    }

    public static void main(String[] args) {
        Roman2Integer r2i = new Roman2Integer();
        r2i.romanToInt("XLV");
    }
}
