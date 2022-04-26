/**
 * PermMissingElem.java
 * 
 * @version 1.0
 * 
 * @date 2022. 4. 11.
 * 
 *       An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 * 
 *       Your goal is to find that missing element.
 * 
 *       Write a function:
 * 
 *       class Solution { public int solution(int[] A); }
 * 
 *       that, given an array A, returns the value of the missing element.
 * 
 *       For example, given array A such that:
 * 
 *       A[0] = 2
 *       A[1] = 3
 *       A[2] = 1
 *       A[3] = 5
 *       the function should return 4, as it is the missing element.
 * 
 *       Write an efficient algorithm for the following assumptions:
 * 
 *       N is an integer within the range [0..100,000];
 *       the elements of A are all distinct;
 *       each element of array A is an integer within the range [1..(N + 1)].
 *       Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
package com.codility.app.timecomplexity;

import java.util.Arrays;

public class PermMissingElem {

	public static void main(String[] args) {

		PermMissingElem elem = new PermMissingElem();

		//int[] A = { 1,2,3 }; //4
		int[] A = { 1,2,4 }; //3
		//빈칸이면 1
		//int[] A = {3,2 }; //-> 1 나와야 함 
		//{2,3,4} -> 1 나와야 함
		
		int answer = elem.solution(A);
		System.out.println(answer);

	}

	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * <pre>
	 * 배열 A 에서 빠진 수 찾기
	 * 숫자는 순서대로 되어 있음
	 * 배열의 길이가 없으면 1이 빠진 경우
	 * 배열의 길이가 있고, 시작이 1이 아니면 1이 빠짐
	 * 배열의 길이가 있고, 시작이 1이면 마지막까지 빠진 숫자 확인
	 * 시간복잡도 : O(N) or O(N * log(N))
	 * </pre>
	 * <hr>
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {

		int answer = 0;
		
		if (A.length != 0) {
			
			Arrays.sort(A);
			
			if (A[0] == 1) {
				answer = A[A.length-1]+1;
				
				for (int i = 1; i < A.length; i++) {
					if (A[i] - A[i-1] != 1) {
						return A[i]-1; 
					}
				}
				
				
			} else {
				answer = 1;
			}
			
		} else {
			answer = 1;
		}
		
		return answer;
	}
}
