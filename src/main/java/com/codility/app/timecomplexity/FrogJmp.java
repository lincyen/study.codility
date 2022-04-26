/**
 * FrogJmp.java
 * 
 * @version 1.0
 * 
 * @date 2022. 4. 11.
 * 
 *       A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a
 *       fixed distance, D.
 * 
 *       Count the minimal number of jumps that the small frog must perform to reach its target.
 * 
 *       Write a function:
 * 
 *       class Solution { public int solution(int X, int Y, int D); }
 * 
 *       that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.
 * 
 *       For example, given:
 * 
 *       X = 10
 *       Y = 85
 *       D = 30
 *       the function should return 3, because the frog will be positioned as follows:
 * 
 *       after the first jump, at position 10 + 30 = 40
 *       after the second jump, at position 10 + 30 + 30 = 70
 *       after the third jump, at position 10 + 30 + 30 + 30 = 100
 *       Write an efficient algorithm for the following assumptions:
 * 
 *       X, Y and D are integers within the range [1..1,000,000,000];
 *       X ≤ Y.
 *       Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
package com.codility.app.timecomplexity;

public class FrogJmp {


	public static void main(String[] args) {
		
		FrogJmp frogJmp = new FrogJmp();
		
		int X =10;
		int Y =85;
		int D =30;
		
		int answer = frogJmp.solution(X, Y, D);
		System.out.println(answer);
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * <pre>
	 * X 에서 Y 위치로 갈 때 D 만큼 이동할 경우
	 * 이동 가능한 횟수를 구하는 문제
	 * X ≤ Y
	 * 
	 * 시간복잡도 : O(1)
	 * </pre>
	 * <hr>
	 * @param X
	 * @param Y
	 * @param D
	 * @return
	 */
	public int solution(int X, int Y, int D) {
		
		int answer = 0;
		
		double x = (double) X;
		double y = (double) Y;
		double d = (double) D;
		
		answer = (int) Math.ceil((y-x)/d);
		
		return answer;
	}

}
