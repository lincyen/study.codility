package com.leetcode.problems;

public class ImplementStrStr {
    
    /**
     * <pre>
     *     대상 문자열에서 검색하려는 문자열의 일치하는 수를 리턴하는 문제
     *     1 <= haystack.length, needle.length <= 104
     * haystack and needle consist of only lowercase English characters.
     * </pre>
     * @param haystack {@link String 대상 문자열}
     * @param needle {@link String 검색하려는 문자열}
     * @return 일치하는 문자열의 개수
     */
    public int strStr(String haystack, String needle) {

        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;

        /* haystack 과 neddle 의 길이가 같을 경우 때문에 + 1 을 함 */
        for (int i = 0; i < haystack.length() + 1 - needle.length(); i++) {
            String s =  haystack.substring(i, i + needle.length());

            if (s.equals(needle)) return i;
        }

        return -1;

    }

}
