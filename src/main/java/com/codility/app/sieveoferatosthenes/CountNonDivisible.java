/**
 * 에라토스테네스의 체 (Sieve of Eratosthenes) 문제
 * 
 * CountNonDivisible
 * Calculate the number of elements of an array that are not divisors of each element.
 * 
 * You are given an array A consisting of N integers.
 * 
 * For each number A[i] such that 0 ≤ i < N, we want to count the number of elements of the array that are not the divisors of A[i]. We say that these elements are non-divisors.
 * 
 * For example, consider integer N = 5 and array A such that:
 * 
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 3
 * A[4] = 6
 * For the following elements:
 * 
 * A[0] = 3, the non-divisors are: 2, 6,
 * A[1] = 1, the non-divisors are: 3, 2, 3, 6,
 * A[2] = 2, the non-divisors are: 3, 3, 6,
 * A[3] = 3, the non-divisors are: 2, 6,
 * A[4] = 6, there aren't any non-divisors.
 * Write a function:
 * 
 * class Solution { public int[] solution(int[] A); }
 * 
 * that, given an array A consisting of N integers, returns a sequence of integers representing the amount of non-divisors.
 * 
 * Result array should be returned as an array of integers.
 * 
 * For example, given:
 * 
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 3
 * A[4] = 6
 * the function should return [2, 4, 3, 2, 0], as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..50,000];
 * each element of array A is an integer within the range [1..2 * N].
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited..
 */
package com.codility.app.sieveoferatosthenes;

import java.util.Arrays;

public class CountNonDivisible {

	public static void main(String[] args) {
		CountNonDivisible countNonDivisible = new CountNonDivisible();
		
		System.out.println(Arrays.toString(countNonDivisible.solutionB(new int [] {3,1,2,3,6})));
		
		
		//countNonDivisible.eratosthenes();

	}
	
	public int[] solution(int[] A) {
		
		int[] answer = new int[A.length];
		/*
		 * 
		 * 
		 * //약수가 모여있는 수를 구함
		 * int[] div = new int[A.length*2 + 1]; //N 의 수는 1 부터 N*2 까지 이므로 전체 숫자가 몇개씩 있는지 만들어 둠
		 * 
		 * //A 길이만큼 반복
		 * for (int i = 0; i < A.length; i++) {
		 * int count = 0;
		 * for (int j = 1; j < div.length; j++) {
		 * if (A[i] % j == 0) {
		 * count = div[j];
		 * System.out.println(div[j]);
		 * }
		 * }
		 * }
		 **/ 
		 return answer;
		 
	}
	
	public int[] solutionB(int[] A) {
		int[] cnt = new int[A.length * 2 + 1];
		int[] p = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			cnt[A[i]]++;
		}
		for (int i = 0; i < A.length; i++) { //배열 전체의 길이 만큼
			for (int j = 1; j <= Math.sqrt(A[i]); j++) {
				if (A[i] / j == j) {
					p[i] += cnt[j];
				} else {
					p[i] += (cnt[j] + cnt[A[i] / j]);  //1 + 
				}
			}
		}
		int[] ans = new int[A.length];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = A.length - p[i];
		}
		return ans;

	}

	public int[] solutionA(int[] A) {

		int[] result = new int[A.length];
		
		// Initializing array, element's range is [1, 2 * N]
		int[] divisors = new int[(A.length * 2) + 1];
		for (int idx = 0; idx < A.length; idx++) {
			divisors[A[idx]]++;
		}
		
		for (int i = 0; i < A.length; i++) {
			int count = 0;
			for (int idx2 = 1; idx2 * idx2 <= A[i]; idx2++) {
				// Common factor
				if (A[i] % idx2 == 0) { //약수인가요?
					count += divisors[idx2];
					// Not square root
					if (A[i] / idx2 != idx2) { // 이해가 안됨 //자기자신을 의미하나??
						count += divisors[A[i] / idx2];
					}
				}
			}
			result[i] = A.length - count;
		}

		return result;
	}
	
	/**
	 * 
	 * <b class="comment_method">eratosthenes</b><br/>
	 * <pre>
	 * 에라토스테네스의 체 알고리즘
	 * </pre>
	 * <hr>
	 */
	public void eratosthenes() {
		int n = 100;
		boolean[] arr = new boolean[n+1];
		
		Arrays.fill(arr, true); // 모두 true 로 초기화 
		
		for (int i = 2; i < Math.sqrt(n); i++) { // 1은 소수가 아니므로 2부터 확인, log 값까지만 구하면 됨
			// i 가 소수인 경우
			if (arr[i] == true) { // 소수이거나 아직 체크되지 않은 수 => arr[i] 의 true 값
				int j = 2;
				// j 는 그 수에 곱해서 소수가 되는지 확인 용도(2부터 시작)
				//System.out.println("i :" + i  + ", j :" + j + ", 구하려는 수의 끝(n) : " + n);
				while (i * j <= n) { //소수 구하려는 값이 100 범위 안에 있을 경우
					arr[i*j] = false;
					j += 1;
					//System.out.println("arr[" + i + " * " + j + "]  는 소수X");
				}
			}
			
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == true) {
				System.out.print(i + " ");
			}
		}
	}

}
