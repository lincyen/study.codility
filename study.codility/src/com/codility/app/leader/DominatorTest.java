package com.codility.app.leader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DominatorTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		Dominator dominator = new Dominator();
		
		int[] data1 = {3,4,3,2,3,-1,3,3};
		int[] data2 = {12345};
		int[] data3 = {2, 1, 1, 3};
		assertEquals(dominator.solution(data1), 4);
		assertEquals(dominator.solution(data2), 0);
		assertEquals(dominator.solution(data3), 2);
		 
	}

}
