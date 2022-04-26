/**
 * MaxProfit
 * 
 * Given a log of stock prices compute the maximum possible earning.
 * 
 * An array A consisting of N integers is given. It contains daily prices of a stock share for a period of N consecutive days. If a single share was bought on day P and sold on day Q, where 0 ≤ P ≤ Q
 * < N, then the profit of such transaction is equal to A[Q] − A[P], provided that A[Q] ≥ A[P]. Otherwise, the transaction brings loss of A[P] − A[Q].
 * 
 * For example, consider the following array A consisting of six elements such that:
 * 
 * A[0] = 23171
 * A[1] = 21011
 * A[2] = 21123
 * A[3] = 21366
 * A[4] = 21013
 * A[5] = 21367
 * If a share was bought on day 0 and sold on day 2, a loss of 2048 would occur because A[2] − A[0] = 21123 − 23171 = −2048. If a share was bought on day 4 and sold on day 5, a profit of 354 would
 * occur because A[5] − A[4] = 21367 − 21013 = 354. Maximum possible profit was 356. It would occur if a share was bought on day 1 and sold on day 5.
 * 
 * Write a function,
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A consisting of N integers containing daily prices of a stock share for a period of N consecutive days, returns the maximum possible profit from one transaction during this
 * period. The function should return 0 if it was impossible to gain any profit.
 * 
 * For example, given array A consisting of six elements such that:
 * 
 * A[0] = 23171
 * A[1] = 21011
 * A[2] = 21123
 * A[3] = 21366
 * A[4] = 21013
 * A[5] = 21367
 * the function should return 356, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..400,000];
 * each element of array A is an integer within the range [0..200,000].
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
package com.codility.app.maximumsliceproblem;

public class MaxProfit {

	public static void main(String[] args) {
		MaxProfit profit = new MaxProfit();
		
		//profit.kadanesAlgorithm();
		int[] data1 = {23171, 21011, 21123, 21366, 21013, 21367};
		profit.solution(data1);
	}

	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * <pre>
	 * 시간복잡도 : O(N)
	 * </pre>
	 * <hr>
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
		
		if (A.length == 1 || A.length == 0) {
			return 0;
		}
		//해당 최소값에서 현재값을 제외한 값을 localMax 값으로 함
		int localMax = 0;
		int globalMax = 0;
		int minPrice = A[0]; //최소값
		
		for (int i = 0; i < A.length; i++) {
			System.out.println("정보 minPrice : "+ minPrice + " : A["+ i + "] : "+ A[i] +", localMax :" + localMax + ", globalMax :" + globalMax);
			//반복문을 수행하면서 입력된 값중에 최소 값을 찾아서 minPrice 를 구함
			minPrice = Math.min(minPrice, A[i]);
			System.out.println("minPrice : " + minPrice);
			//지금 값과 최소값 사이의 부분차를 구하기 => 해당 값이 최대-최소가 되므로 가장 큰 profit 이 됨
			localMax = A[i] - minPrice;
			System.out.println("localMax : " + localMax);
			
			//부분차가 전역 차이보다 크면 전역 차이 값을 변경
			globalMax = Math.max(localMax, globalMax);			
			System.out.println("globalMax : " + globalMax);
			System.out.println("============================");
			
		}
		
		if (globalMax < 0) {
			globalMax = 0;
		}
		
		
		return globalMax;
	}
	

	/**
	 * 
	 * <b class="comment_method">kadanesAlgorithm</b><br/>
	 * 
	 * <pre>
	 * Kadane’s Algorithm(카데인 알고리즘)
	 * 카데인 알고리즘은 i 부분합을 한번 구하면 다음 부분합은 해당 부분합 + 해당 수로 결정 가능하다는 것을 기준으로 함
	 * 시간복잡도 : O(N)
	 * </pre>
	 * <hr>
	 * 
	 * @param A
	 * @return
	 */
	public void kadanesAlgorithm() {
		
		int A[] = {2, 1, -3, 4, -1, 2, 1, -5, 4};
		int maxValue = 0;
		int localMax = 0;
		
		for (int i = 0; i < A.length; i++) {
			localMax = Math.max(A[i], localMax + A[i]);
			System.out.println("A["+i+"] 에서 가장 큰 부분합은 " + localMax + "입니다.");
			if (localMax > maxValue) {
				maxValue = localMax;
				System.out.println("현재 가장 큰 부분합은" + maxValue + "입니다.");
			}
		}
		
		System.out.println("가장 큰 부분합은 : " +maxValue+ "입니다.");
		
	}

}
