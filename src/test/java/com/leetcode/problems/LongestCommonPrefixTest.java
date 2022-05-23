package com.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    @Test
    void longestCommonPrefix() {

        LongestCommonPrefix lComnPrefix = new LongestCommonPrefix();

        assertEquals(lComnPrefix.longestCommonPrefix(new String[] {"flower","flow","flight"}), "fl");
        assertEquals(lComnPrefix.longestCommonPrefix(new String[] {"fl","flow","flight"}), "fl");
        assertEquals(lComnPrefix.longestCommonPrefix(new String[] {"dog","racecar","car"}), "");
        assertEquals(lComnPrefix.longestCommonPrefix(new String[] {}), "");
        assertEquals(lComnPrefix.longestCommonPrefix(new String[] {"a"}), "a");
        assertEquals(lComnPrefix.longestCommonPrefix(new String[] {"a", "a", "a"}), "a");
        assertEquals(lComnPrefix.longestCommonPrefix(new String[] {"longestCommonPrefix"}), "longestCommonPrefix");

        assertEquals(lComnPrefix.longestCommonPrefix(new String[] {"reflower","flow","flight"}), "");
    }
}