/**
 * PermCheck.java
 * 
 * @version 1.0
 * 
 * @date 2022. 4. 14.
 * 
 *       PermCheck
 *       Check whether array A is a permutation.
 * 
 *       A non-empty array A consisting of N integers is given.
 * 
 *       A permutation is a sequence containing each element from 1 to N once, and only once.
 * 
 *       For example, array A such that:
 * 
 *       A[0] = 4
 *       A[1] = 1
 *       A[2] = 3
 *       A[3] = 2
 *       is a permutation, but array A such that:
 * 
 *       A[0] = 4
 *       A[1] = 1
 *       A[2] = 3
 *       is not a permutation, because value 2 is missing.
 * 
 *       The goal is to check whether array A is a permutation.
 * 
 *       Write a function:
 * 
 *       class Solution { public int solution(int[] A); }
 * 
 *       that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
 * 
 *       For example, given array A such that:
 * 
 *       A[0] = 4
 *       A[1] = 1
 *       A[2] = 3
 *       A[3] = 2
 *       the function should return 1.
 * 
 *       Given array A such that:
 * 
 *       A[0] = 4
 *       A[1] = 1
 *       A[2] = 3
 *       the function should return 0.
 * 
 *       Write an efficient algorithm for the following assumptions:
 * 
 *       N is an integer within the range [1..100,000];
 *       each element of array A is an integer within the range [1..1,000,000,000].
 *       Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
package com.codility.app.countingelements;

import java.util.Arrays;

public class PermCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermCheck check = new PermCheck();
		
		//		int A[] = {4,1,3,2}; //1
		
		// int A[] = {4,1,3}; //0
		
		// int A[] = {2};
		int A[] = {1};
		
		int answer = check.solution(A);
		System.out.println(answer);
	}

	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * <pre>
	 * 순열 체크 문제
	 * 순열이면 1을 반환, 순열이 아니면 0 을 반환
	 * 순열 : 1부터 N 까지 각 요소를 한번만 포함해야 함
	 * 시간복잡도 : O(N) or O(N * log(N))
	 * </pre>
	 * <hr>
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
		int answer = 1;
		
		Arrays.sort(A);
		
		if (A[0] != 1) {
			return 0;
		} else {
			for (int i = 1; i < A.length; i++) {
				if (A[i] - A[i-1] != 1) {
					return 0;
				}
			}
		}
		
		return answer;
	}

}
