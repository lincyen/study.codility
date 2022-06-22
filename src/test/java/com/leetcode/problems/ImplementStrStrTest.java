package com.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImplementStrStrTest {

    @Test
    void strStr() {

        assertEquals(new ImplementStrStr().strStr("a", "a"), 0);
        assertEquals(new ImplementStrStr().strStr("hello", "ll"), 2);
        assertEquals(new ImplementStrStr().strStr("aaaaa", "bba"), -1);
        assertEquals(new ImplementStrStr().strStr("", ""), 0);
        assertEquals(new ImplementStrStr().strStr("hello", ""), 0);
        assertEquals(new ImplementStrStr().strStr("hello", "hello123"), -1);
    }
}