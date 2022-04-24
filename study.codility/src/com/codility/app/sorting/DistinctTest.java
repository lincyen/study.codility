package com.codility.app.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DistinctTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		Distinct distinct = new Distinct();
		
		int[] data1 = {2, 1, 1, 2, 3, 1};
		assertEquals(distinct.solution(data1), 3);
	}

}
