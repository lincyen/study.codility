/**
 * LongestPassword
 * 
 * Given a string containing words, find the longest word that satisfies specific conditions.
 * 
 * You would like to set a password for a bank account. However, there are three restrictions on the format of the password:
 * 
 * it has to contain only alphanumerical characters (a−z, A−Z, 0−9);
 * there should be an even number of letters;
 * there should be an odd number of digits.
 * You are given a string S consisting of N characters. String S can be divided into words by splitting it at, and removing, the spaces. The goal is to choose the longest word that is a valid
 * password. You can assume that if there are K spaces in string S then there are exactly K + 1 words.
 * 
 * For example, given "test 5 a0A pass007 ?xy1", there are five words and three of them are valid passwords: "5", "a0A" and "pass007". Thus the longest password is "pass007" and its length is 7. Note
 * that neither "test" nor "?xy1" is a valid password, because "?" is not an alphanumerical character and "test" contains an even number of digits (zero).
 * 
 * Write a function:
 * 
 * class Solution { public int solution(String S); }
 * 
 * that, given a non-empty string S consisting of N characters, returns the length of the longest word from the string that is a valid password. If there is no such word, your function should return
 * −1.
 * 
 * For example, given S = "test 5 a0A pass007 ?xy1", your function should return 7, as explained above.
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..200];
 * string S consists only of printable ASCII characters and spaces.
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 * 
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 * 
 * 
 * 가장 긴 비밀번호
 * 
 * 단어가 포함된 문자열이 주어지면 특정 조건을 만족하는 가장 긴 단어를 찾습니다.
 * 
 * 은행 계좌의 비밀번호를 설정하고 싶습니다. 그러나 암호 형식에는 세 가지 제한이 있습니다.
 * 
 * 영숫자 문자(a-z, A-Z, 0-9)만 포함해야 합니다.
 * 짝수의 문자가 있어야 합니다. // there should be an even number of letters;
 * 홀수 숫자가 있어야 합니다. // there should be an odd number of digits.
 * N개의 문자로 구성된 문자열 S가 제공됩니다. 문자열 S는 공백에서 분할하고 제거하여 단어로 나눌 수 있습니다. 목표는 유효한 암호인 가장 긴 단어를 선택하는 것입니다. 문자열 S에 K개의 공백이 있으면 정확히 K + 1개의 단어가 있다고 가정할 수 있습니다.
 * 
 * 예를 들어, "test 5 a0A pass007 ?xy1"이 주어지면 5개의 단어가 있고 그 중 3개는 유효한 암호인 "5", "a0A" 및 "pass007"입니다. 따라서 가장 긴 암호는 "pass007"이고 길이는 7입니다. "test"도 "?xy1"도 유효한 암호가 아닙니다. "?" 영숫자가 아니며 "test"는 짝수 자릿수(영)를 포함합니다.
 * 
 * 함수 작성:
 * 
 * 클래스 솔루션 { 공개 int 솔루션(문자열 S); }
 * 
 * N개의 문자로 구성된 비어 있지 않은 문자열 S가 주어지면 유효한 암호인 문자열에서 가장 긴 단어의 길이를 반환합니다. 그러한 단어가 없으면 함수는 -1을 반환해야 합니다.
 * 
 * 예를 들어 S = "test 5 a0A pass007 ?xy1"이 주어지면 위에서 설명한 대로 함수는 7을 반환해야 합니다.
 * 
 * 다음과 같이 가정합니다.
 * 
 * N은 [1..200] 범위 내의 정수입니다.
 * 문자열 S는 인쇄 가능한 ASCII 문자와 공백으로만 구성됩니다.
 * 솔루션에서 정확성에 중점을 둡니다. 솔루션의 성능은 평가의 초점이 아닙니다.
 * 
 * 저작권 2009–2022 by Codility Limited. 판권 소유. 무단 전재, 출판, 공개를 금합니다.
 */
package com.codility.app.exam;

import java.util.regex.Pattern;

public class LongestPassword {

	public static void main(String[] args) {
		
		LongestPassword longestPassword = new LongestPassword();
		
		
		//int result = longestPassword.solution("test 5 a0A pass007 ?xy1");
		int result = longestPassword.solution("test 5 a0A");
		
		System.out.println("가장 긴 패스워드는? : " + result);
		
	}
	
	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * <pre>
	 * 조건 
	 * 영문자와 숫자만 포함해야 함
	 * 문자는 짝수여야 함
	 * 숫자는 홀수여야 함
	 * </pre>
	 * <hr>
	 * @param S
	 * @return
	 */
	public int solution(String S) {
		int maxLen = -1;
		
		String[] splitPassword = S.split(" ");
		
		for (String str : splitPassword) {
		
			boolean mFlag = true;
			boolean letterFlag = true;
			boolean digitFlag = true;
			
			/** 영문자 or 숫자 포함 여부 확인 */
			if (!Pattern.matches("^[a-zA-Z0-9]*$", str)) {
				mFlag = false;
			}
			
			
			//String letterStr = Pattern.matches("[^0-9]&$", str);
			/** 문자는 짝수여야 함*/
			String letterStr = str.replaceAll("[^a-zA-Z]", "");
			//System.out.println("letterStr : " + letterStr);
			//System.out.print("letterStr : ");
			if (mFlag && letterStr.length() % 2 == 1) {
				//짝수
				letterFlag = false;
			}
			
			/** 숫자는 홀수여야 함*/
			String digitStr = str.replaceAll("[^0-9]", "");
			//System.out.println("digitStr : " + digitStr);
			//System.out.print("digitStr : ");
			if (mFlag && digitStr.length() % 2 == 0) {
				letterFlag = false;
			}
			
			/** 문자의 길이가 짝수여야 함(0은 짝수 취급) */
			/** 숫자의 길이가 홀수여야 함(0은 짝수 취급) */
			
			if (mFlag && letterFlag && digitFlag) {
				maxLen = Math.max(maxLen, str.length());
			}
		}

		return maxLen;
	}

}
