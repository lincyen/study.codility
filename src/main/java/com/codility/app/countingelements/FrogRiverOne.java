/**
 * FrogRiverOne.java
 * 
 * @version 1.0
 * 
 * @date 2022. 4. 14.
 * 
 *       Find the earliest time when a frog can jump to the other side of a river.
 * 
 *       A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall
 *       from a tree onto the surface of the river.
 * 
 *       You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.
 * 
 *       The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that
 *       is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the
 *       leaves do not change their positions once they fall in the river.
 * 
 *       For example, you are given integer X = 5 and array A such that:
 * 
 *       A[0] = 1
 *       A[1] = 3
 *       A[2] = 1
 *       A[3] = 4
 *       A[4] = 2
 *       A[5] = 3
 *       A[6] = 5
 *       A[7] = 4
 *       In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.
 * 
 *       Write a function:
 * 
 *       class Solution { public int solution(int X, int[] A); }
 * 
 *       that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.
 * 
 *       If the frog is never able to jump to the other side of the river, the function should return −1.
 * 
 *       For example, given X = 5 and array A such that:
 * 
 *       A[0] = 1
 *       A[1] = 3
 *       A[2] = 1
 *       A[3] = 4
 *       A[4] = 2
 *       A[5] = 3
 *       A[6] = 5
 *       A[7] = 4
 *       the function should return 6, as explained above.
 * 
 *       Write an efficient algorithm for the following assumptions:
 * 
 *       N and X are integers within the range [1..100,000];
 *       each element of array A is an integer within the range [1..X].
 *       Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
package com.codility.app.countingelements;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class FrogRiverOne {

	public static void main(String[] args) {

		FrogRiverOne one = new FrogRiverOne();

				int A[] = { 1, 3, 1, 4, 2, 3, 5, 4 };
		 		int X = 5;// 6 

//int A[] = {2, 2, 2, 2, 2};
//int X = 2; //결과 -1
		
//		int A[] = {1};
//		int X = 1; //결과 1

		int answer = one.solution2(X, A);
		System.out.println(answer);
	}

	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * 
	 * <pre>
	 * X+1 까지 가기 위해서 A[] 안의 값들이 모두 늘어설 수 있는 값 찾기
	 * 시간복잡도 : O(N^2)
	 * </pre>
	 * <hr>
	 * 
	 * @param X
	 * @param A
	 * @return
	 */
	public int solution(int X, int[] A) {
		int answer = -1;

		String[] arr = new String[X];
		
		for (int i = 0; i < A.length; i++) {
			
			int j = A[i];
			arr[j-1] = "x"; //첫번째 자리
			boolean flag = Arrays.stream(arr).allMatch(Objects::nonNull);
			
			System.out.println("int i : " + i + "/ A["+i+"] : " + A[i]);
			System.out.println("arr:" + Arrays.deepToString(arr) +"nonNull : "+ flag);
			
			if (flag) {
				return i;
			}
			
		}
		
		return answer;
	}
	
	/**
	 * 
	 * <b class="comment_method">solution2</b><br/>
	 * <pre>
	 * array 에서 꺼내서 set 에 넣으면서 set 의 길이가 X 가 될때까지 체크
	 * set 의 중복 불가능을 이용
	 * 시간복잡도 : O(N)
	 * </pre>
	 * <hr>
	 * @param X
	 * @param A
	 * @return
	 */
	public int solution2(int X, int[] A) {
		int answer = -1;
		
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			
			int j = A[i];
			
			set.add(j);
			
			if (set.size() == X) {
				return i;
			}

			
		}
		
		return answer;
	}

}
