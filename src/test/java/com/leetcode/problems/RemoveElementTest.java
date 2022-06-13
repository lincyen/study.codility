package com.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveElementTest {

    @Test
    void removeElement() {

        //Input: nums = [1], val = 1
        //Output: 0, nums = [1]
        assertEquals(new RemoveElement().removeElement(new int[] {1}, 1), 0);

        assertEquals(new RemoveElement().removeElement(new int[] {}, 0), 0);

        //Input: nums = [3,2,2,3], val = 3
        //Output: 2, nums = [2,2,_,_]
        assertEquals(new RemoveElement().removeElement(new int[] {3,2,2,3}, 3), 2);

        //Input: nums = [0,1,2,2,3,0,4,2], val = 2
        //Output: 5, nums = [0,1,4,0,3,_,_,_]
        assertEquals(new RemoveElement().removeElement(new int[] {0,1,2,2,3,0,4,2}, 2), 5);
    }
}