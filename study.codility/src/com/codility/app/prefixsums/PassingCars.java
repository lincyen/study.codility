/**
 * PassingCars.java
 * 
 * @version 1.0
 * 
 * @date 2022. 4. 19.
 * 
 *       PassingCars
 *       Count the number of passing cars on the road.
 * 
 * 
 *       A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
 * 
 *       Array A contains only 0s and/or 1s:
 * 
 *       0 represents a car traveling east,
 *       1 represents a car traveling west.
 *       The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.
 * 
 *       For example, consider array A such that:
 * 
 *       A[0] = 0
 *       A[1] = 1
 *       A[2] = 0
 *       A[3] = 1
 *       A[4] = 1
 *       We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
 * 
 *       Write a function:
 * 
 *       class Solution { public int solution(int[] A); }
 * 
 *       that, given a non-empty array A of N integers, returns the number of pairs of passing cars.
 * 
 *       The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
 * 
 *       For example, given:
 * 
 *       A[0] = 0
 *       A[1] = 1
 *       A[2] = 0
 *       A[3] = 1
 *       A[4] = 1
 *       the function should return 5, as explained above.
 * 
 *       Write an efficient algorithm for the following assumptions:
 * 
 *       N is an integer within the range [1..100,000];
 *       each element of array A is an integer that can have one of the following values: 0, 1.
 *       Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
package com.codility.app.prefixsums;

public class PassingCars {

	public static void main(String[] args) {
		PassingCars cars = new PassingCars();
		int[] A = { 0, 1, 0, 1, 1 }; // 5
		// int[] A = {};

		int answer = cars.solution(A);
		System.out.println(answer);

	}

	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * 
	 * <pre>
	 * 배열 안에서 그 쌍이 0 <= P < Q < N 인 포인트 좌표의 수를 구해서 리턴
	 * 그 수가 1,000,000,000 개를 넘어가면 -1 을 리턴
	 * 
	 * 
	 * 	int data1[] = {0, 1, 0, 1, 1}; //5
		int data2[] = {}; //0
		int data3[] = {0}; //0
		int data4[] = {1}; //0
		int data5[] = {1, 1, 1}; //0
		int data6[] = {0, 0, 0}; //0`					
		int data7[] = {1, 0, 0, 0}; //0
		int data8[] = {0, 1, 1, 1}; //3
	 * 
	 * </pre>
	 * <hr>
	 * 뒤부터 preSum 을 수행한 array 를 만들고
	 * 해당 array 에서 0 이 있는 위치의 숫자의 합을 구함
	 * 
	 * 전체 For 문을 모두 수행해야 하기 때문에 앞에서부터 시작 필요
	 * @param A
	 * @return
	 */
	public int solutionA(int[] A) {
		int answer = 0;

		int[] sumArray = new int[A.length];

		for (int i = A.length - 1; i >= 0; i--) {

			if (i == A.length - 1) {
				sumArray[i] = A[i];
			} else {
				sumArray[i] = sumArray[i + 1] + A[i];
			}

			if (1000000000 < sumArray[i] ) {
				return -1;
			}

			if (A[i] == 0) {
				answer = answer + sumArray[i];
			}

			// System.out.println(Arrays.toString(sumArray));
		}

		return answer;
	}
	
	public int solution(int[] A) {
		int answer = 0;
		
		//1의 합을 구함
		int countOne = 0;
		for (int i : A) {
			countOne = countOne + i;
		}
		
		// 1의 합을 구한 값에서 0 이 나오면 해당 값을 answer 에 등록하고, 1 이 아니몬 1의 합의 값을 줄임
		// answer 가 1000000000 이 넘으면 -1 을 리턴하고 종료
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				answer = answer + countOne;
				if (1000000000 < answer) {
					return -1;
				}
			} else {
				countOne--;
			}
		}
		
		return answer;
	}



}
