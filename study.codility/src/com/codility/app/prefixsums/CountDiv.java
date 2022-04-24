/**
 * CountDiv.java
 * 
 * @version 1.0
 * 
 * @date 2022. 4. 19.
 * 
 *       CountDiv
 * 
 *       Compute number of integers divisible by k in range [a..b].
 * 
 * 
 *       Write a function:
 * 
 *       class Solution { public int solution(int A, int B, int K); }
 * 
 *       that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
 * 
 *       { i : A ≤ i ≤ B, i mod K = 0 }
 * 
 *       For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 * 
 *       Write an efficient algorithm for the following assumptions:
 * 
 *       A and B are integers within the range [0..2,000,000,000];
 *       K is an integer within the range [1..2,000,000,000];
 *       A ≤ B.
 *       Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
package com.codility.app.prefixsums;

public class CountDiv {

	public static void main(String[] args) {

		CountDiv countDiv = new CountDiv();
		// int answer = countDiv.solution(6, 11, 2);
		int answer = countDiv.solution(0, 0, 11);
		System.out.println(answer);

	}

	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * 
	 * <pre>
	 * A 와 B 사이에 K 로 나눴을 경우 0 이 나오는 수의 갯수
	A and B are integers within the range [0..2,000,000,000];
	K is an integer within the range [1..2,000,000,000];
	 * </pre>
	 * <hr>
	 * 
	 * @param A
	 * @param B
	 * @param K
	 * @return
	 */
	public int solutionA(int A, int B, int K) {
		int answer = 0;
		System.out.println("================================");
		for (int i = A; i < B; i++) {
			System.out.println("A=" + i + ", B=" + B + ", "+ i+"%" +K+ "= " + i % K);
			if (i % K == 0) {
				answer++;
			}
		}

		return answer;
	}

	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * <pre>
	 * 1번) B 보다 작고 0 보다 큰 수 중에서 K 로 나눈 몫의 갯수를 구하고
	 * 2번) A 보다 작고 0 보다 큰 수 중에서 K 로 나눈 몫의 갯수를 구하고
	 * 1 번과 2번의 차를 구하면 배열 안에서 K 로 나눈 수의 갯수를 구할 수 있음
	 * 만일 A 가 나누어 떨어지면(A%K = 0) A 도 대상에 포함되므록 + 1 
	 * </pre>
	 * <hr>
	 * @param A
	 * @param B
	 * @param K
	 * @return
	 */
	public int solution(int A, int B, int K) {
		if (A%K == 0) {
			return B/K - A/K +1;
		} else {
			return B/K - A/K;
		}
	}

}
