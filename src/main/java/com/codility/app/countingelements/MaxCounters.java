/**
 * MaxCounters.java
 * 
 * @version 1.0
 * 
 * @date 2022. 4. 14.
 * 
 *       MaxCounters
 *       Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all counters to current maximum.
 * 
 *       You are given N counters, initially set to 0, and you have two possible operations on them:
 * 
 *       increase(X) − counter X is increased by 1,
 *       max counter − all counters are set to the maximum value of any counter.
 *       A non-empty array A of M integers is given. This array represents consecutive operations:
 * 
 *       if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 *       if A[K] = N + 1 then operation K is max counter.
 *       For example, given integer N = 5 and array A such that:
 * 
 *       A[0] = 3
 *       A[1] = 4
 *       A[2] = 4
 *       A[3] = 6
 *       A[4] = 1
 *       A[5] = 4
 *       A[6] = 4
 *       the values of the counters after each consecutive operation will be:
 * 
 *       (0, 0, 1, 0, 0)
 *       (0, 0, 1, 1, 0)
 *       (0, 0, 1, 2, 0)
 *       (2, 2, 2, 2, 2)
 *       (3, 2, 2, 2, 2)
 *       (3, 2, 2, 3, 2)
 *       (3, 2, 2, 4, 2)
 *       The goal is to calculate the value of every counter after all operations.
 * 
 *       Write a function:
 * 
 *       class Solution { public int[] solution(int N, int[] A); }
 * 
 *       that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.
 * 
 *       Result array should be returned as an array of integers.
 * 
 *       For example, given:
 * 
 *       A[0] = 3
 *       A[1] = 4
 *       A[2] = 4
 *       A[3] = 6
 *       A[4] = 1
 *       A[5] = 4
 *       A[6] = 4
 *       the function should return [3, 2, 2, 4, 2], as explained above.
 * 
 *       Write an efficient algorithm for the following assumptions:
 * 
 *       N and M are integers within the range [1..100,000];
 *       each element of array A is an integer within the range [1..N + 1].
 *       Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
package com.codility.app.countingelements;

import java.util.Arrays;

public class MaxCounters {

	public static void main(String[] args) {

		int N = 5;
		int[] A = {3,4,4,6,1,4,4}; //3, 2, 2, 4, 2
		
		//int N = 1;
		//int[] A = {1,1,1,2}; //3
		
		//int N = 10;
		//int[] A = {1,1,1,10}; //[3, 0, 0, 0, 0, 0, 0, 0, 0, 1]
		
		//int N = 10;
		//int[] A = {1,1,1,1,1,1,1,1,1,1,1,1,11,11,11,11,11,11,11,11}; //[3, 0, 0, 0, 0, 0, 0, 0, 0, 1]
		
		MaxCounters counters = new MaxCounters();
		
		int[] answer1 = counters.solutionA(N, A);
		System.out.println("A:" + Arrays.toString(answer1));
		
		int[] answer2 = counters.solutionB(N, A);
		System.out.println("B:" + Arrays.toString(answer2));
		
	}

	/**
	 * 
	 * <b class="comment_method">solutionA</b><br/>
	 * <pre>
	 * 반복문 수행하면서 maxCounter 를 증가시키고, 증가시킨 max counter 를 fill 로 채우는 방식
	 * 77% 점수 획득
	 * </pre>
	 * <hr>
	 * @param N
	 * @param A
	 * @return
	 */
	public int[] solutionA(int N, int[] A) {
		int[] answer = new int[N];
		
		int maxCounter = 0;
		
		for (int i = 0; i < A.length; i++) {
			int j = A[i];
			
			if (j <= N) {
				answer[j-1] = answer[j-1]+1;
				if (answer[j-1] >= maxCounter) {
					maxCounter = answer[j-1]; 
				}
			} else {
				Arrays.fill(answer, maxCounter);
			}
			System.out.println(i + "번째 : "+Arrays.toString(answer));
			
		}
		
		
		return answer;
	}
	
	/**
	 * 
	 * <b class="comment_method">solutionB</b><br/>
	 * <pre>
	 * 속도 개선을 위해 max counter 를 구성하되, fill 로직을 최종 1회만 수행하는 방법
	 * 시간복잡도 : O(N+M)
	 * </pre>
	 * <hr>
	 * @param N
	 * @param A
	 * @return
	 */
	public int[] solutionB(int N, int[] A) {
		int[] answer = new int[N];
		
		int maxCounter = 0; //현재 최대 counter
		int triggerNumber = 0; //원래 fill 해야 됐던 데이터
		
		for (int i = 0; i < A.length; i++) {
			int j = A[i];
			
			if (j <= N) { //Array A 의 해당 값이 N 보다 작거나 같을 경우(+1 카운트 실행)
				
				if (answer[j-1] >= triggerNumber) { //triggerNumber 보다 크거나 같을 경우(이미 트리거 이상으로 +1 만 진행)
					answer[j-1] = answer[j-1]+1;
				} else { 
					answer[j-1] = triggerNumber+1;
				}
				
				//maxCounter 보다 크거나 같으면 maxCounter 변경
				if (answer[j-1] >= maxCounter) {
					maxCounter = answer[j-1]; 
				}
			} else {
				//Arrays.fill(answer, maxCounter);
				//예비 데이터에 증가분을 씀
				triggerNumber = maxCounter;
			}
			System.out.println(i + "번째 : "+Arrays.toString(answer));
			
		}
		
		for (int i = 0; i < answer.length; i++) {
			if (answer[i] < triggerNumber) {
				answer[i] = triggerNumber;
			}
		}
		
		
		return answer;
	}

}
