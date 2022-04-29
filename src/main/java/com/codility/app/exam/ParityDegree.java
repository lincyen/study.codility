/**
 * https://app.codility.com/demo/results/training38KNH4-TH5/
 * 
 * ParityDegree
 * Find the highest power of 2 that divides N.
 * 
 * A positive integer N is given. The goal is to find the highest power of 2 that divides N. In other words, we have to find the maximum K for which N modulo 2^K is 0.
 * 
 * For example, given integer N = 24 the answer is 3, because 2^3 = 8 is the highest power of 2 that divides N.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int N); }
 * 
 * that, given a positive integer N, returns the highest power of 2 that divides N.
 * 
 * For example, given integer N = 24, the function should return 3, as explained above.
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..1,000,000,000].
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 * 
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 * 
 * ParityDegree
 * N을 나누는 2의 가장 큰 거듭제곱을 찾으십시오.
 * 
 * 양의 정수 N이 제공됩니다. 목표는 N을 나누는 2의 가장 높은 거듭제곱을 찾는 것입니다. 즉, N modulo 2^K가 0인 최대 K를 찾아야 합니다.
 * 
 * 예를 들어, 주어진 정수 N = 24에서 답은 3입니다. 왜냐하면 2^3 = 8은 N을 나누는 2의 가장 높은 거듭제곱이기 때문입니다.
 * 
 * 함수 작성:
 * 
 * 클래스 솔루션 { 공개 int 솔루션(int N); }
 * 
 * 양의 정수 N이 주어지면 N을 나누는 2의 가장 높은 거듭제곱을 반환합니다.
 * 
 * 예를 들어, 주어진 정수 N = 24, 함수는 위에서 설명한 대로 3을 반환해야 합니다.
 * 
 * 다음과 같이 가정합니다.
 * 
 * N은 [1..1,000,000,000] 범위의 정수입니다.
 * 솔루션에서 정확성에 중점을 둡니다. 솔루션의 성능은 평가의 초점이 아닙니다.
 * 
 * 저작권 2009–2022 by Codility Limited. 판권 소유. 무단 전재, 출판, 공개를 금합니다.
 */
package com.codility.app.exam;

public class ParityDegree {

	public static void main(String[] args) {

		int answer = new ParityDegree().solution(24);
		System.out.println(answer);
		
		int answer2 = new ParityDegree().solution(48);
		System.out.println(answer2);

	}

	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * 
	 * <pre>
	 * N%2^k == 0 인 가장 큰 k 찾기
	 * </pre>
	 * <hr>
	 * 
	 * @param N
	 * @return
	 */
	public int solution(int N) {
		return divides(0, N);
		
	}

	private int divides(int count, int num) {
		if (num % 2 != 0) {
			return count++;
		} else {
			count++;
			return divides(count, num / 2);
		}
	}

}
