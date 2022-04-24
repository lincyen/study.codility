package com.codility.app.stacksansqueues;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BracketsTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		Brackets brackets = new Brackets();
		
		assertEquals(brackets.solution("{}"), 1);
		assertEquals(brackets.solution(""), 1);
		assertEquals(brackets.solution("]"), 0);
		assertEquals(brackets.solution("(({)"), 0);
	}

}
