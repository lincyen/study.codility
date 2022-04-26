/**
 * BinaryGap.java
 * 
 * @version 1.0
 * 
 * @date 2022. 4. 5.
 * 
 * 
 *  codility_BinaryGap
 * 
 *  A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
 * 
 *  For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4
 *  and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32
 *  has binary representation 100000 and has no binary gaps.
 * 
 *  Write a function:
 * 
 *  class Solution { public int solution(int N); }
 * 
 *  that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
 * 
 *  For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return
 *  0, because N has binary representation '100000' and thus no binary gaps.
 * 
 *  Write an efficient algorithm for the following assumptions:
 * 
 *  N is an integer within the range [1..2,147,483,647].
 * 
 *  Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
package com.codility.app.iterations;

class BinaryGap {

	public static void main(String[] args) {
		BinaryGap solution = new BinaryGap();

		int answer = solution.solution(74901729);
		System.out.println(answer);

	}

	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * <pre>
	 * TODO 2022. 4. 8. Temporary Comments.
	 * Please enter the English description.
	 * </pre>
	 * <hr>
	 * @param N
	 * @return
	 */
	public int solution(int N) {

		int answer = 0;

		try {
			String binaryStr = Integer.toBinaryString(N);

			System.out.println("2진수:" + binaryStr);

			// 2진수 앞뒤의 0 을 제거하여 1....1 형식으로 만듬
			if (binaryStr.indexOf("1") != -1) {
				binaryStr = binaryStr.substring(binaryStr.indexOf("1"), binaryStr.lastIndexOf("1") + 1);

				System.out.println("binaryStr : " + binaryStr);

				int count = 0;
				// char 에 담아서 하나씩 비교할 준비
				char[] charStr = binaryStr.toCharArray();

				boolean firstOneFlag = false;

				for (int i = 0; i < charStr.length; i++) {
					char c = charStr[i];

					// 제일 처음 1은 버리고
					// 다음 1을 만나면 그동안 쌓은 count 값과 answer 를 비교
					// 0을 만나면 count 증가

					if (c == "1".charAt(0)) {  // 1이 나오면(시작이거나 끝임)

						if (firstOneFlag) { // 끝 1
							if (answer < count) {
								System.out.println("change answer : " + answer + "->" + count);
								answer = count;
							}

							count = 0;
						} else {
							firstOneFlag = true;
						}
					} else {
						count++;
					}
				}
			} else {
				// 0 으로만 되어 있을 경우 0 리턴
				answer = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return answer;

	}

	public void check(String S) {
		try {
			S.indexOf("1");
			S.lastIndexOf("1");
			System.out.println(S.indexOf("1") + ", " + S.lastIndexOf("1"));
			System.out.println(S);

			if (S.indexOf("1") != -1) {
				S = S.substring(S.indexOf("1"), S.lastIndexOf("1") + 1);
			}

			// S = S.split("1", S.indexOf("1"));
			// S = S.split("1", S.lastIndexOf("1"));
			System.out.println(S);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}