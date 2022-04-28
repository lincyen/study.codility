/**
 * 최대공약수
 */
package io.github.lincyen.algorithm;

public class GCD {
	
	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * <pre>
	 * x 와 y 의 최대공약수 구하기
	 * 유클리드 호제법
	 * 
	 * 두 수가 주어졌을 때, 최대 공약수를 구하는 문제
	 * 숫자 24 의 약수 : 1, 2, 3, 4, 6, 8, 12, 24
	 * 숫자  6 의 약수 : 1, 2, 3,    6
	 * 
	 * 두 수의 최대공약수 6
	 * 
	 * 24%6 == 0 이면 작은 수인 6이 최대 공약수가 되며,
	 * 큰숫자를 작은 숫자로 나눠 그 값이 0 이 되면 최대공약수
	 * 
	 * 아닌 경우 작은수와 위의 나머지로 다시 나누어 구함
	 * 
	 * 재귀호출을 사용해야 함
	 * 
	 * </pre>
	 * <hr>
	 * @param x
	 * @param y
	 * @return
	 */
	public int solution(int x, int y) {
		
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
