package com.codility.app.prefixsums;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CountDivTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		
		CountDiv countDiv = new CountDiv();
				
		assertEquals(countDiv.solution(6, 11, 2), 3);
		
		assertEquals(countDiv.solution(0, 0, 1), 1);
		assertEquals(countDiv.solution(0, 10, 3), 4);
		
		assertEquals(countDiv.solution(3, 5, 3), 1);
		
		assertEquals(countDiv.solution(0, 0, 11), 1);
		
	}

}
