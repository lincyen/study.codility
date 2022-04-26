/**
 * TapeEquilibrium.java
 * 
 * @version 1.0
 * 
 * @date 2022. 4. 11.
 * 
 *       Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.
 * 
 *       A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
 * 
 *       Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 * 
 *       The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 * 
 *       In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
 * 
 *       For example, consider array A such that:
 * 
 *       A[0] = 3
 *       A[1] = 1
 *       A[2] = 2
 *       A[3] = 4
 *       A[4] = 3
 *       We can split this tape in four places:
 * 
 *       P = 1, difference = |3 − 10| = 7
 *       P = 2, difference = |4 − 9| = 5
 *       P = 3, difference = |6 − 7| = 1
 *       P = 4, difference = |10 − 3| = 7
 *       Write a function:
 * 
 *       class Solution { public int solution(int[] A); }
 * 
 *       that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
 * 
 *       For example, given:
 * 
 *       A[0] = 3
 *       A[1] = 1
 *       A[2] = 2
 *       A[3] = 4
 *       A[4] = 3
 *       the function should return 1, as explained above.
 * 
 *       Write an efficient algorithm for the following assumptions:
 * 
 *       N is an integer within the range [2..100,000];
 *       each element of array A is an integer within the range [−1,000..1,000].
 *       Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
package com.codility.app.timecomplexity;

public class TapeEquilibrium {

	public static void main(String[] args) {

		TapeEquilibrium equilibrium = new TapeEquilibrium();

		// int[] A = { 3, 1, 2, 4, 3 };
		int[] A = { -1000, 1000 };

		int answer = equilibrium.solution(A);
		System.out.println(answer);

	}

	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * 
	 * <pre>
	 * 배열 A[] 의 길이는[2..100,000]
	 * 배열 A 의 요소는 [−1,000..1,000]
	 * 배열 A 중에 아래와 같은 규칙을 가졌을 경우 그 값이 가장 작은 수 구하기
	 * 
	 * P = 1, difference = |3 −   (1+2+4+3)| = 7
	 * P = 2, difference = |(3+1) − (2+4+3)| = 5
	 * P = 3, difference = |(3+1+2) − (4+3)| = 1
	 * P = 4, difference = |(3+1+2+4)   − 3| = 7
	 * 시간복잡도 : O(N)
	 * </pre>
	 * <hr>
	 * 
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {

		int answer = 0;

		int first = 0;
		int last = 0;

		/** 전체 배열의 합을 구해서 해당 원소 위치만큼 제외하며 재 계산 */
		for (int i = 0; i < A.length; i++) {
			last = last + A[i];
		}

		/** 마지막 하나 숫자 전까지 확인 */
		for (int i = 0; i < A.length - 1; i++) {

			first = first + A[i];
			last = last - A[i];
			int result = Math.abs(first - last);

			if (i == 0) {
				answer = result;
			} else {
				if (answer > result) {
					answer = result;
				}
			}
		}

		return answer;
	}

}
