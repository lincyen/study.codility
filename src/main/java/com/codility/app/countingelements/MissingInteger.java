/**
 * MissingInteger.java
 * 
 * @version 1.0
 * 
 * @date 2022. 4. 18.
 * 
 *       MissingInteger
 * 
 *       Find the smallest positive integer that does not occur in a given sequence.
 * 
 * 
 *       This is a demo task.
 * 
 *       Write a function:
 * 
 *       class Solution { public int solution(int[] A); }
 * 
 *       that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * 
 *       For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * 
 *       Given A = [1, 2, 3], the function should return 4.
 * 
 *       Given A = [−1, −3], the function should return 1.
 * 
 *       Write an efficient algorithm for the following assumptions:
 * 
 *       N is an integer within the range [1..100,000];
 *       each element of array A is an integer within the range [−1,000,000..1,000,000].
 *       Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
package com.codility.app.countingelements;

import java.util.Arrays;

public class MissingInteger {

	public static void main(String[] args) {
		MissingInteger integer = new MissingInteger();

		//int[] A = { 1, 3, 6, 4, 1, 2 }; // 5
		// int[] A = { 1, 2, 3 }; //4
		// int[] A = { -1, -3 }; //1

	 int[] A = {  }; //1
	//	 int[] A = { 1 }; //2
		// int[] A = { -1 }; //1
		// int[] A = { 2 }; // 1
		//int[] A = {4, 5, 6, 2};  //1

		int answer = integer.solution(A);
		System.out.println(answer);

	}

	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * 
	 * <pre>
	 * sequence 상에서 가장 작은 "양" 의 정수를 찾기
	 * </pre>
	 * <hr>
	 * 
	 * <pre>
	 * A = [1, 3, 6, 4, 1, 2]일 때 함수는 5를 반환해야 합니다.
	 * 
	 * A = [1, 2, 3]이 주어지면 함수는 4를 반환해야 합니다.
	 * 
	 * A = [−1, −3]이 주어지면 함수는 1을 반환해야 합니다.
	 * 
	 * A = [2] 이면 3이 아닌 1을 반환해야 함
	 * 
	 * N은 [1..100,000] 범위 내의 정수입니다.
	 * 배열 A의 각 요소는 [−1,000,000..1,000,000] 범위의 정수입니다.
	 * 
	 * 시간복잡도 : O(N) or O(N * log(N))
	 * </pre>
	 * 
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {

		int answer = 1;

		//순서대로 정렬하고
		//음수는 버리고 음수에서 끝나면 1 리턴하고
		//양수가 나오면 비교 시작하고
		//양수 처음이 1 이 아니면 1 리턴하고
		//양수 처음이 1 이면 다음 수와 비교 시작하고
		//양수 처음이 1 이고 다음 수가 없으면 2 리턴하고
		//양수 처음이 아니면 다음수와 비교 하고
		//비교 값이 1 증가 아니면 해당 수에 + 1 리턴하고
		//양수 처음이 아니고 다음수가 없으면 해당수에 + 1 리턴하고
		
		Arrays.sort(A);
		
		int counter = 0;
		for (int i = 0; i < A.length; i++) {
			
			if (A[i] > 0) { // 양수이면
				counter++;
			}
			
			if (counter == 0) {
				// 음수는 버림
			} else if (counter == 1) { //양수 처음이면
				
				if (A[i] == 1) { // 처음이 1 이면
					if (i == A.length - 1) {
						answer = A[i]+1;
					}
				} else { // 처음이 1 이 아니면 1 리턴
					return 1;
				}
			} else if (counter > 1) {
				if (i == A.length - 1) {
					answer = A[i]+1;
				} else {
					if((A[i+1]- A[i]) > 1) {
						return A[i]+1;
					}
				}
			}
		}

		return answer;

	}

}
