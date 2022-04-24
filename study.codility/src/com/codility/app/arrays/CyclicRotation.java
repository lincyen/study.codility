/**
 * CyclicRotation.java
 * 
 * @version 1.0
 * 
 * @date 2022. 4. 8.
 * 
 *       An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For
 *       example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
 * 
 *       The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
 * 
 *       Write a function:
 * 
 *       class Solution { public int[] solution(int[] A, int K); }
 * 
 *       that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
 * 
 *       For example, given
 * 
 *       A = [3, 8, 9, 7, 6]
 *       K = 3
 *       the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 * 
 *       [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 *       [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 *       [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 *       For another example, given
 * 
 *       A = [0, 0, 0]
 *       K = 1
 *       the function should return [0, 0, 0]
 * 
 *       Given
 * 
 *       A = [1, 2, 3, 4]
 *       K = 4
 *       the function should return [1, 2, 3, 4]
 * 
 *       Assume that:
 * 
 *       N and K are integers within the range [0..100];
 *       each element of array A is an integer within the range [−1,000..1,000].
 *       In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 * 
 *       Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
package com.codility.app.arrays;

import java.util.Arrays;

public class CyclicRotation {

	public static void main(String[] args) {
		
		CyclicRotation rotation = new CyclicRotation();
		
		int[] A = {3, 8, 9, 7, 6};
		int K = 9;
		
		int[] answer = rotation.solution(A, K);
		System.out.println(Arrays.toString(answer));

	}
	
	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * <pre>
	 * 배열 A 를 K 번 회전시킨 결과 answer 를 구할 것
	 * </pre>
	 * <hr>
	 * @param A
	 * @param K
	 * @return
	 */
	public int[] solution(int[] A, int K) {
		
		int[ ] answer = new int[A.length];
		

		for (int i = 0; i < A.length; i++) {
			
			int x = i+K;

			//길이 넘어가는 애들 체크
			if (x >= A.length) {
				//넘어가는 애들은 자름
				System.out.println("x:"+ x +", Alength:" + A.length);
				x = x%A.length;
				System.out.println("["+i+"]번째 자리 숫자 ["+A[i]+"]는 길이 넘어감 그래서 ["+x+"] 자리로 이동");
			} else {
				System.out.println("["+i+"]번째 자리 숫자 ["+A[i]+"]는 "+K+" 만큼 이동해서 ["+x+"] 자리로 이동");
				
			}

			answer[x] = A[i];
			
			System.out.println(Arrays.toString(answer));
		}
		
		return answer;
	}
	
	
}
