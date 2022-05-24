package com.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    @Test
    void isValid() {
        assertFalse(new ValidParentheses().isValid("(])"));
        assertTrue(new ValidParentheses().isValid("()"));
        assertTrue(new ValidParentheses().isValid("()[]{}"));
        assertFalse(new ValidParentheses().isValid("(]"));
        assertFalse(new ValidParentheses().isValid("([)]"));
        assertTrue(new ValidParentheses().isValid("{[]}"));

    }
}