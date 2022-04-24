package com.codility.app.euclideanalgorithm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ChocolatesByNumbersTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		ChocolatesByNumbers byNumbers = new ChocolatesByNumbers();
		
		assertEquals(byNumbers.solution(10, 4), 5);
		assertEquals(byNumbers.solution(4, 2), 2);
		
		
		assertEquals(byNumbers.solution2(10, 4), 5);

		
	}

}
