/**
 * 
 * ChocolatesByNumbers
 * There are N chocolates in a circle. Count the number of chocolates you will eat.
 * 
 * Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle, numbered from 0 to N − 1.
 * 
 * You start to eat the chocolates. After eating a chocolate you leave only a wrapper.
 * 
 * You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle, and eat the following one.
 * 
 * More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N (remainder of division).
 * 
 * You stop eating when you encounter an empty wrapper.
 * 
 * For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.
 * 
 * The goal is to count the number of chocolates that you will eat, following the above rules.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int N, int M); }
 * 
 * that, given two positive integers N and M, returns the number of chocolates that you will eat.
 * 
 * For example, given integers N = 10 and M = 4. the function should return 5, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N and M are integers within the range [1..1,000,000,000].
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
package com.codility.app.euclideanalgorithm;

public class ChocolatesByNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChocolatesByNumbers numbers = new ChocolatesByNumbers();
		
		numbers.solution(10, 4);
	}
	
	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * <pre>
	 * 전체 길이 N
	 * 이동해야 되는 길이 M
	 * 현재 포인트 x
	 * 다음 이동해야 되는 포인트는 (x+M)%N
	 * </pre>
	 * <hr>
	 * @param N
	 * @param M
	 * @return
	 */
	public int solution(int N, int M) {
		
		//System.out.println((0+M)%N);
		//System.out.println((4+M)%N);
		//System.out.println((8+M)%N);
		//System.out.println((2+M)%N);
		//System.out.println((6+M)%N);
		
		//유클리드 호제법으로 풀어야 함
		
		int count = position(1, 0, N, M);
		//System.out.println(count);
		
		
		return count;
	}
	
	/**
	 * 
	 * <b class="comment_method">position</b><br/>
	 * <pre>
	 * 시간복잡도 : O(N+M)
	 * </pre>
	 * <hr>
	 * @param count 결과값
	 * @param x 현재 포인트
	 * @param n 전체 길이
	 * @param m 이동해야 되는 길이
	 * @return
	 */
	public int position(int count, int x, int n, int m) {
		if ((x + m) % n == 0) {//이동한 길이를 전체 길이로 나눈 나머지가 0 이 되면 이동 값을 1 증가시키고 종료
			return count++;
		} else {
			// 이동한 길이를 전체 길이로 나눈 나머지가 0 이 아니면 이동 값을 1 증가시키고 재귀호출
			x = (x + m) % n;
			count++;
			return position(count, x, n, m);
		}
		
	}
	
	/**
	 * 
	 * <b class="comment_method">solution2</b><br/>
	 * <pre>
	 * N M 의 최대공약수의 배수
	 * 
	 * 시간복잡도 : O(N)
	 * </pre>
	 * <hr>
	 * @param N
	 * @param M
	 * @return
	 */
	public int solution2(int N, int M) {
		return (N/eucd(N, M));
	}
	

	/**
	 * 
	 * <b class="comment_method">eucd</b><br/>
	 * 
	 * <pre>
	 * 유클리드 호제법 구현 메서드
	 * 
	 * 두 수가 주어졌을 때, 최대 공약수를 구하는 문제
	 * 숫자 24 의 약수 : 1, 2, 3, 4, 6, 8, 12, 24
	 * 숫자  6 의 약수 : 1, 2, 3,    6
	 * 
	 * 두 수의 최대공약수 6
	 * 
	 * 24%6 == 0 이면 작은 수인 6이 최대 공약수가 되며,
	 * 
	 * 아닌 경우 작은수와 위의 나머지로 다시 나누어 구함
	 * 
	 * 재귀호출을 사용해야 함
	 * </pre>
	 * <hr>
	 * 
	 * @param bn
	 *            큰 숫자
	 * @param sn
	 *            작은 숫자
	 * @return 큰 숫자를 작은숫자로 나눈 값이 0이면 작은숫자 리턴, 아니면 재귀형태로 자신을 호출
	 */
	public int eucd(int bn, int sn) {
		// 큰숫자를 작은숫자로 나눈 나머지를 계산
		int r = bn % sn;
		// 나머지가 0이면 작은숫자가 최대공약수이므로 작은숫자 리턴
		if (r == 0) {
			return sn;
		} else {
			// 나머지가 0 이상이면 재귀형태로 호출
			// 이때 파라미터는 작은숫자와 나머지를 넣어줌
			return eucd(sn, r);
		}
	}

}
