package com.leetcode.problems;

import java.util.Stack;

public class ValidParentheses {

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string
     * is valid.
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     *
     * 1 <= s.length <= 104 s 는 무조건 길이가 1 이상이므로, 1개 글자는 반드시 있음
     * s consists of parentheses only '()[]{}'.
     *
     * 여러개의 가로가 나올 수 있지만, 해당 가로가 다 닫혀야 하므로 각 괄호가 pair 를 이룰 경우만 true
     * (, [, { 로 시작해야 함
     * 열린만큼 닫혀야 함
     * 닫힌 괄호가 열린 순서 반대로 와야 함
     *
     * @param s 검사해야 하는 String
     * @return {@link Boolean 검사 결과}
     */
    public boolean isValid(String s) {

        char[] charArr = new char[s.length()];

        int position = 0; //현재 삽입 position
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                charArr[position] = c;
                position++;
            } else {
                if(position == 0) {
                    return false;
                } else {
                    if (c == ')' && charArr[position -1] == '(') {
                        position--;
                    } else if (c == '}' && charArr[position -1] == '{') {
                        position--;
                    } else if (c == ']' && charArr[position -1] == '[') {
                        position--;
                    } else return false;
                }
            }

        }

        /* position 길이가 0 이 아니면 데이터 있다는 소리이므로 */
        return position == 0;

    }

    /**
     * case 제거, stack char 로 변경
     * @param s 검사해야 하는 String
     * @return {@link Boolean 검사 결과}
     */
    public boolean isValid_char(String s) {

        Stack<Character> stack = new Stack<>(); //메모리 사이즈 줄이려고 character 로 변경
        //별 차이 안나네

        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

        }

        return stack.isEmpty();

    }

    /**
     * case 문 사용 버전
     *
     * @param s 검사해야 하는 String
     * @return {@link Boolean 검사 결과}
     */
    public boolean isValid_longVer(String s) {

        /* String 길이가 홀수는 무조건 실패 */
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i+1);
            switch (str) {
                case "(": case "{": case "[":
                    stack.push(str);

                    break;
                case ")": case "}": case "]":

                    /* stack 이 비어 있으면 실패 */
                    if (stack.empty()) {
                        return false;
                    }

                    String data = stack.pop();

                    switch (data) {
                        case "(": data = ")"; break;
                        case "{": data = "}"; break;
                        case "[": data = "]"; break;
                        default: break;
                    }
                    if (!data.equals(str)) {
                        return false;
                    }
                    break;
                default: break;
            }
        }

        /* stack 이 비어있지 않으면 실패 */
        if (!stack.empty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidParentheses valid = new ValidParentheses();

        valid.isValid("()[]{}");

    }
}
