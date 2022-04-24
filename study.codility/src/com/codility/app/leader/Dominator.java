/**
 * Dominator
 * Find an index of an array such that its value occurs at more than half of indices in the array.
 * 
 * An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.
 * 
 * For example, consider array A such that
 * 
 * A[0] = 3 A[1] = 4 A[2] = 3
 * A[3] = 2 A[4] = 3 A[5] = -1
 * A[6] = 3 A[7] = 3
 * The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 * 
 * Write a function
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.
 * 
 * For example, given array A such that
 * 
 * A[0] = 3 A[1] = 4 A[2] = 3
 * A[3] = 2 A[4] = 3 A[5] = -1
 * A[6] = 3 A[7] = 3
 * the function may return 0, 2, 4, 6 or 7, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
package com.codility.app.leader;

import java.util.HashMap;

public class Dominator {

	public Dominator() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Dominator dominator = new Dominator();

		int A[] = {3,4,3,2,3,-1,3,3};
		int answer = dominator.solution(A);
		System.out.println(answer);
	}

	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * 
	 * <pre>
	 * 배열 안에서 가장 많은 수의 값 위치값을 반환하기
	 * 
	 * 없으면 -1 반환
	 * 
	 * 맵에 넣고 해당 값이 중간값보다 크면 해당 위치를 반환
	 * </pre>
	 * <hr>
	 * 
	 * @param A
	 * @return
	 */

	public int solution(int[] A) {

		/** 리더 위치 **/
		int standard = (A.length / 2) ;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < A.length; i++) {
			if (map.containsKey(A[i])) {
				
				map.put(A[i], map.get(A[i])+1);
				System.out.println("i:"+i+",standard:"+standard+", value : "+map.get(A[i]));
				System.out.println("map : "+map.toString());
				if (standard < map.get(A[i])) {
					return i;
				}
			} else {
				map.put(A[i], 1);
				
				System.out.println("i:"+i+",standard:"+standard+", value : "+map.get(A[i]));
				System.out.println("map : "+map.toString());
				if (standard < map.get(A[i])) {
					return i;
				}
			}
		}

		return -1;
	}

}
