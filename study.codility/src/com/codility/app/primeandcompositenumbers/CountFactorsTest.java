package com.codility.app.primeandcompositenumbers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CountFactorsTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		CountFactors factors = new CountFactors();
		
		assertEquals(factors.solution(24), 8);
		assertEquals(factors.solution(16), 5);
		assertEquals(factors.solution(36), 9);
		
		assertEquals(factors.solutionA(24), 8);
		assertEquals(factors.solutionA(16), 5);
		assertEquals(factors.solutionA(36), 9);
		
	}

}
