package com.codility.app.exam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LongestPasswordTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		//https://app.codility.com/demo/results/trainingD88X8E-WYW/
		assertEquals(new LongestPassword().solution("test 5 a0A pass007 ?xy1"), 7);
		assertEquals(new LongestPassword().solution("1ta"), 3);
		assertEquals(new LongestPassword().solution(""), -1);
		assertEquals(new LongestPassword().solution("??????"), -1);
		assertEquals(new LongestPassword().solution("??????a"), -1);
		assertEquals(new LongestPassword().solution("test a0A"), 3);
		assertEquals(new LongestPassword().solution("W i k ? 5 + a"), 1);
	}

}
