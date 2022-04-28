package com.leetcode.problems;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TwoSumTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		TwoSum sum = new TwoSum();
		
		assertEquals(Arrays.toString(sum.twoSum(new int[]{2,7,11,5}, 9)), Arrays.toString(new int[] {0,1}));
		assertEquals(Arrays.toString(sum.twoSum(new int[]{3,2,4}, 6)), Arrays.toString(new int[] {1,2}));
		assertEquals(Arrays.toString(sum.twoSum(new int[]{3,3}, 6)), Arrays.toString(new int[] {0,1}));
		assertEquals(Arrays.toString(sum.twoSum(new int[]{3,2,3}, 6)), Arrays.toString(new int[] {0,2}));
		assertEquals(Arrays.toString(sum.twoSum(new int[]{2,5,5,11}, 10)), Arrays.toString(new int[] {1,2}));
	}

}
