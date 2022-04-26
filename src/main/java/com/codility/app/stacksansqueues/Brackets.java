/**
 * Brackets
 * Determine whether a given string of parentheses (multiple types) is properly nested.
 * 
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 * 
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(String S); }
 * 
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 * 
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
package com.codility.app.stacksansqueues;

import java.util.Stack;

public class Brackets {

	public Brackets() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * 
	 * <pre>
	 * (, {, [, ], } ) 로만 이루어져 있음
	 * () 쌍으로 이루어져야 true
	 * 빈값이면 true
	 * true = 1, false = 0;
	 * 스택이 비어 있지 않으면 0
	 * 스택이 비어있고, 로직상 괄호가 열리고 닫힘이 명확해야 1
	 * </pre>
	 * <hr>
	 * 
	 * @param S
	 * @return
	 */
	public int solution(String S) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);

			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return 0;
				}

				char lastC = stack.pop();

				if (lastC != '(' && c == ')') {
					return 0;
				}

				if (lastC != '[' && c == ']') {
					return 0;
				}

				if (lastC != '{' && c == '}') {
					return 0;
				}
			}
		}
		
		if (!stack.isEmpty()) {
			return 0;
		}

		return 1;
	}

}
