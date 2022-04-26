package com.codility.app.prefixsums;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PassingCarsTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		PassingCars cars = new PassingCars();
		
		int data1[] = {0, 1, 0, 1, 1}; //5
		int data2[] = {}; //0
		int data3[] = {0}; //0
		int data4[] = {1}; //0
		int data5[] = {1, 1, 1}; //0
		int data6[] = {0, 0, 0}; //0
		int data7[] = {1, 0, 0, 0}; //0
		int data8[] = {0, 1, 1, 1}; //3
//		int data9[] = {0, 1, 0, 1, 0};
//		int data10[] = {0, 1, 0, 1, 1};
		
		assertEquals(cars.solution(data1), 5);
		assertEquals(cars.solution(data2), 0);
		assertEquals(cars.solution(data3), 0);
		assertEquals(cars.solution(data4), 0);
		assertEquals(cars.solution(data5), 0);
		assertEquals(cars.solution(data6), 0);
		assertEquals(cars.solution(data7), 0);
		assertEquals(cars.solution(data8), 3);
//		assertEquals(cars.solution(data9), 5);
//		assertEquals(cars.solution(data10), 5);
	}

}
