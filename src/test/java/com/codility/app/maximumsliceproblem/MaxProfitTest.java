package com.codility.app.maximumsliceproblem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MaxProfitTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		MaxProfit maxProfit = new MaxProfit();

		int[] data1 = {23171, 21011, 21123, 21366, 21013, 21367};
		int[] data2 = {0, -233};
		int[] data3 = {0};
		int[] data4 = {};
		assertEquals(maxProfit.solution(data1), 356);
		assertEquals(maxProfit.solution(data2), 0);
		assertEquals(maxProfit.solution(data3), 0);
		assertEquals(maxProfit.solution(data4), 0);
	}

}
