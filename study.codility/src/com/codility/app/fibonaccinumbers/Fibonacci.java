/**
 * Fibonacci.java 
 * 
 * @version 1.0
 * 
 * @date 2022. 4. 25.
 * 
 * copyright(c) 2022 www.nicepay.co.kr
 */
package net.nicepay.codility.fibonaccinumbers;

/**
 * <b>Fibonacci</b>
 * 
 * <pre>
 * 1 1 2 3 5 8 .. 앞의 수를 더해서 뒷 수를 만드는 수열을 피보나치라고 함
 * 1 -> 1
 * 1 -> 1
 * 2 -> 1 + 1
 * 3 -> 1 + (1+1)
 * 5 -> (1+1) + (1 + (1 + 1))
 * 
 * 순으로 진행됨
 * </pre>
 * <hr>
 *
 * @version 1.0 2022. 4. 25.
 * 
 * @author 1
 * 
 */
public class Fibonacci {


	public static void main(String[] args) {
		int fiboPrint = 10; 
		for (int i = 1; i <= fiboPrint; i++) {
			System.out.println("i번째 피보나치 : " + new Fibonacci().pibonacci(i));
		} 

	}
	
	private int pibonacci(int number) {
		int result = 0;
		if (number <= 1) {
			result = number;
		} else {
			result = pibonacci(number - 2) + pibonacci(number -1);
		}
		
		return result;
	}

}
