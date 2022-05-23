package com.leetcode.problems;

public class LongestCommonPrefix {

    /**
     * Arrays 안의 문자열 중 가장 긴 문자열 찾기
     *
     * 배열의 첫번째 요소와 다른 요소간에 indexof 연산을 반복해 가장 큰 값을 찾은 후, 그중 가장 작은 수만큼 리턴
     *
     * String 의 길이는 무조건 1개 이상, length 는 0 부터 시작
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] consists of only lower-case English letters.
     *
     * @param strs 가장 긴 접두사를 찾기 위한 String 모음
     * @return 동일한 prefix String
     */
    public String longestCommonPrefix(String[] strs) {

        String result = "";

        if(strs.length > 0) {

            String firstStr = strs[0]; // 비교할 기본 텍스트
            int maxValue = firstStr.length(); //기본텍스트의 길이 해당 값이 같을 수 있는 최고 길이 값이 된다.

            if (strs.length != 1) {
                for (int i = 0; i < strs.length; i++) {
                    int position = 0;  // 글자 비교 위치
                    int compareValue = 0; // 동일한 문자의 위치 값

                //    System.out.println("Strings : " + strs[i]);
                    while (position <= Math.min(strs[i].length(), firstStr.length()) - 1) {
                        String firstSubStr = firstStr.substring(position, position+1);
                        String strsSubStr = strs[i].substring(position, position+1);

                        //두 글자가 같으면 compareValue 증가, Position 증가
                        if (firstSubStr.equals(strsSubStr)) {
                            compareValue++;
                            position++;
                        } else {
                            break;
                        }

                    }

                    //compareValue 와 maxValue 를 비교해 더 작은 값을 maxValue 로 설정
                    if(compareValue < maxValue) {
                        maxValue = compareValue;
                    }

                }

                //maxValue 가 0 이 아닌 경우, maxValue 만큼 substring
                if(maxValue != 0) {
                    result = firstStr.substring(0, maxValue);
                }

            } else {
                result = firstStr;
            }


        }

        return result;
    }

    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();

        String result = prefix.longestCommonPrefix(new String[] {"flower","flow","flight"});
        //String result = prefix.longestCommonPrefix(new String[] {"a", "a", "a"});

        System.out.println(result);

    }
}
