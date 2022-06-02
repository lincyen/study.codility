package com.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromSortedArrayTest {

    @Test
    void removeDuplicates() {
        assertEquals(new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[] {}), 0);
        assertEquals(new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[] {1,1,2}), 2);
        assertEquals(new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}), 5);
    }
}