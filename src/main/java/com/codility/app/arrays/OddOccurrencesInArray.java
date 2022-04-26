/**
 * OddOccurrencesInArray.java
 * 
 * @version 1.0
 * 
 * @date 2022. 4. 8.
 * 
 *       A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value,
 *       except for one element that is left unpaired.
 * 
 *       For example, in array A such that:
 * 
 *       A[0] = 9 A[1] = 3 A[2] = 9
 *       A[3] = 3 A[4] = 9 A[5] = 7
 *       A[6] = 9
 *       the elements at indexes 0 and 2 have value 9,
 *       the elements at indexes 1 and 3 have value 3,
 *       the elements at indexes 4 and 6 have value 9,
 *       the element at index 5 has value 7 and is unpaired.
 *       Write a function:
 * 
 *       class Solution { public int solution(int[] A); }
 * 
 *       that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.
 * 
 *       For example, given array A such that:
 * 
 *       A[0] = 9 A[1] = 3 A[2] = 9
 *       A[3] = 3 A[4] = 9 A[5] = 7
 *       A[6] = 9
 *       the function should return 7, as explained in the example above.
 * 
 *       Write an efficient algorithm for the following assumptions:
 * 
 *       N is an odd integer within the range [1..1,000,000];
 *       each element of array A is an integer within the range [1..1,000,000,000];
 *       all but one of the values in A occur an even number of times.
 *       Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
package com.codility.app.arrays;

import java.util.Arrays;

public class OddOccurrencesInArray {

	public static void main(String[] args) {

		OddOccurrencesInArray oddArray = new OddOccurrencesInArray();

		//int[] A = { 2, 2, 3, 3, 4 };
		int[] A = { 4,4,4,4,1111,6,6,2,2 };

		int answer = oddArray.solution(A);
		System.out.println("answer:" + answer);

	}

	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * 
	 * <pre>
	 * 배열 A 에서 홀수로 발생한 하나의 수를 효율적으로 찾을 것
	 * N is an odd integer within the range [1..1,000,000];
	 * each element of array A is an integer within the range [1..1,000,000,000];
	 * 시간복잡도 : O(N**2) 풀이
	 * </pre>
	 * <hr>
	 * 
	 * @param A
	 * @return
	 */
	public int solutionByONNN(int[] A) {

		// 0 부터 끝까지 중복이 나오면 0 으로 치환하고, 나중에 0 을 지움
		for (int i = 0; i < A.length; i++) {

			// 0 부터 n 번째 수까지 n 숫자와 중복되는지 확인
			for (int j = 0; j < i; j++) {

				if (A[i] == A[j]) { // 중복되면
					// 해당 숫자는 제외할 숫자
					System.out.println(Arrays.toString(A));
					A[j] = 0;
					A[i] = 0;
				}
			}
		}

		int answer = 0;
		for (int i : A) {
			if (i != 0) {
				answer = i;
			}
		}

		System.out.println(Arrays.toString(A));

		return answer;

	}

	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * 
	 * <pre>
	* 배열 A 에서 홀수로 발생한 하나의 수를 효율적으로 찾을 것
	* N is an odd integer within the range [1..1,000,000];
	* each element of array A is an integer within the range [1..1,000,000,000];
	* 시간복잡도 : O(N) or O(N*log(N)) 풀이
	 * </pre>
	 * <hr>
	 * 
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {

		int answer = 0;

		if (A.length != 1) {

			// 전체를 정렬하고 정렬 후 바로 다음에 이전 숫자와 동일하게 안나오면 리턴
			Arrays.sort(A);

			//가장 마지막 숫자가 홀로 있을경우를 대비하여, answer 의 초기값은 가장 마지막 숫자로 설정
			answer = A[A.length -1];
			System.out.println(Arrays.toString(A));

			for (int i = 0; i < A.length; i++) {
				if (i % 2 == 1) {
					if (A[i] != A[i - 1]) {
						return A[i-1];
					}
				}

			}
		} else {
			answer = A[0];
		}

		return answer;

	}

}
