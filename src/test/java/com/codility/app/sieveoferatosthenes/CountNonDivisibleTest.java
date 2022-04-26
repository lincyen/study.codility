package com.codility.app.sieveoferatosthenes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CountNonDivisibleTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		CountNonDivisible divisible = new CountNonDivisible();
		
		assertEquals(Arrays.toString(divisible.solution(new int [] {3,1,2,3,6})), Arrays.toString(new int[]{2,4,3,2,0}));
	}

}
