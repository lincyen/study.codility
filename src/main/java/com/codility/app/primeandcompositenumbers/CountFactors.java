/**
 * CountFactors
 * Count factors of given number n.
 * 
 * A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.
 * 
 * For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int N); }
 * 
 * that, given a positive integer N, returns the number of its factors.
 * 
 * For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..2,147,483,647].
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
package com.codility.app.primeandcompositenumbers;

public class CountFactors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * <b class="comment_method">solutionA</b><br/>
	 * <pre>
	 * 시간복잡도를 고려하지 않은 답
	 * 시간복잡도 : O(N)
	 * </pre>
	 * <hr>
	 * @param N
	 * @return
	 */
	public int solutionA(int N) {

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			System.out.println("N : " + N + ", i : " + i);
			if (N % i == 0) { // 나눈 값이 0 이면
				answer++;
			}
			System.out.println("answer : " + answer);
		}
		
		return answer;
	}

	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * 
	 * <pre>
	 * N = D*M 이 되는 D 와 M 의 수를 구하라
	 * N, D 가 양의 정수이니, M 도 양의정수
	 * M * D 의 중간은 M * M 이 N 인 경우이므로,M 의 2승
	 * log2 로 중간값을 중간까지만 * 나누어지는 수를 구하면 / 그 수에 * 2 해주면 됨
	 * log2 값이 정수면 자기 자신도 포함되기 때문에 + 1 을 함
	 * 시간복잡도 : O(sqrt(N))
	 * </pre>
	 * <hr>
	 * 
	 * @param N
	 * @return
	 */
	public int solution(int N) {

		int answer = 0;
		for (int i = 1; i < Math.sqrt(N); i++) {
			//System.out.println("N : " + N + ", i : " + i);

			if (N % i == 0) { // 나눈 값이 0 이면
				answer++;
			}
			//System.out.println("answer : " + answer);
		}

		// 절반만 했으니까 앞뒤로 두배를 곱함
		answer = answer * 2;

		if (Math.sqrt(N) % 1 == 0) {
			answer++;
		}

		return answer;

	}

}
