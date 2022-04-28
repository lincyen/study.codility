/**
 * 최소공배수
 */
package io.github.lincyen.algorithm;

public class LCM {
	
	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * <pre>
	 * x 와 y 의 최소공배수 구하기
	 * </pre>
	 * <hr>
	 * @param x
	 * @param y
	 * @return
	 */
	public int solution(int x, int y) {
		return Math.abs(x*y)/gcd(x, y);
	}
	
	public int gcd(int x, int y) {
		
		int bigNum = 0;
		int smallNum = 0;
		
		if (x > y) {
			bigNum = x;
			smallNum = y;
		} else {
			bigNum = y;
			smallNum = x;
		}
		
		// 큰숫자를 작은숫자로 나눈 나머지를 계산
		int r = bigNum % smallNum;
		// 나머지가 0이면 작은숫자가 최대공약수이므로 작은숫자 리턴
		if (r == 0) {
			return smallNum;
		} else {
			// 나머지가 0 이상이면 재귀형태로 호출
			// 이때 파라미터는 작은숫자와 나머지를 넣어줌
			return solution(smallNum, r);
		}
		
	}

}
