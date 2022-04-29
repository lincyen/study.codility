/**
 * FirstUnique
 * Find the first unique number in a given sequence.
 * 
 * A non-empty array A consisting of N integers is given. The unique number is the number that occurs exactly once in array A.
 * 
 * For example, the following array A:
 * 
 * A[0] = 4
 * A[1] = 10
 * A[2] = 5
 * A[3] = 4
 * A[4] = 2
 * A[5] = 10
 * contains two unique numbers (5 and 2).
 * 
 * You should find the first unique number in A. In other words, find the unique number with the lowest position in A.
 * 
 * For above example, 5 is in second position (because A[2] = 5) and 2 is in fourth position (because A[4] = 2). So, the first unique number is 5.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty array A of N integers, returns the first unique number in A. The function should return −1 if there are no unique numbers in A.
 * 
 * For example, given:
 * 
 * A[0] = 1
 * A[1] = 4
 * A[2] = 3
 * A[3] = 3
 * A[4] = 1
 * A[5] = 2
 * the function should return 4. There are two unique numbers (4 and 2 occur exactly once). The first one is 4 in position 1 and the second one is 2 in position 5. The function should return 4 bacause
 * it is unique number with the lowest position.
 * 
 * Given array A such that:
 * 
 * A[0] = 6
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * the function should return −1. There is no unique number in A (4 and 6 occur more than once).
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [0..1,000,000,000].
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 * 
 * FirstUnique
 * 주어진 시퀀스에서 첫 번째 고유 번호를 찾습니다.
 * 
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 제공됩니다. 고유 번호는 배열 A에서 정확히 한 번 발생하는 번호입니다.
 * 
 * 예를 들어 다음 배열 A:
 * 
 * A[0] = 4
 * A[1] = 10
 * A[2] = 5
 * A[3] = 4
 * A[4] = 2
 * A[5] = 10
 * 두 개의 고유 숫자(5와 2)를 포함합니다.
 * 
 * A에서 첫 번째 고유 번호를 찾아야 합니다. 즉, A에서 가장 낮은 위치에 있는 고유 번호를 찾습니다.
 * 
 * 위의 예에서 5는 두 번째 위치에 있고(A[2] = 5 때문에) 2는 네 번째 위치에 있습니다(A[4] = 2 때문에). 따라서 첫 번째 고유 번호는 5입니다.
 * 
 * 함수 작성:
 * 
 * 클래스 솔루션 { 공개 int 솔루션(int[] A); }
 * 
 * N 정수의 비어 있지 않은 배열 A가 주어지면 A의 첫 번째 고유 숫자를 반환합니다. 함수는 A에 고유 숫자가 없으면 -1을 반환해야 합니다.
 * 
 * 예를 들면 다음과 같습니다.
 * 
 * A[0] = 1
 * A[1] = 4
 * A[2] = 3
 * A[3] = 3
 * A[4] = 1
 * A[5] = 2
 * 함수는 4를 반환해야 합니다. 두 개의 고유 숫자가 있습니다(4와 2는 정확히 한 번만 나타남). 첫 번째 것은 위치 1에서 4이고 두 번째 것은 위치 5에서 2입니다. 함수는 가장 낮은 위치의 고유한 숫자이기 때문에 4를 반환해야 합니다.
 * 
 * 주어진 배열 A는 다음과 같습니다.
 * 
 * A[0] = 6
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * 함수는 -1을 반환해야 합니다. A에는 고유 번호가 없습니다(4와 6은 두 번 이상 나타납니다).
 * 
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오.
 * 
 * N은 [1..100,000] 범위 내의 정수입니다.
 * 배열 A의 각 요소는 [0..1,000,000,000] 범위의 정수입니다.
 * 저작권 2009–2022 by Codility Limited. 판권 소유. 무단 전재, 출판, 공개를 금합니다.
 */
package com.codility.app.exam;

public class FirstUnique {

	public static void main(String[] args) {
	//	System.out.println(new FirstUnique().solution(new int[]{1,4,3,3,1,2})); 
		System.out.println(new FirstUnique().solution(new int[]{6,4,4,6})); 
	}
	
	public int solution(int[] A) {
		
		int answer = -1;
		int i = 0;
		int j = 1;
		while (i <= j) {
			if (A[i] == A[j]) {
				i++;
				j = i+1;
			} else {
				if (j == A.length -1) {
					answer = A[i];
					break;
				}
				j++;
			}
			
			
		}
		
		return answer;
	}
	

}
