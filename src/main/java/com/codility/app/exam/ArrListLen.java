/**
 * https://app.codility.com/demo/results/training4D8JXJ-UQG/
 * 
 * ArrListLen
 * Compute length of a single-link list encoded in an array.
 * 
 * A non-empty array A consisting of N integers is given.
 * 
 * Array A represents a linked list. A list is constructed from this array as follows:
 * 
 * the first node (the head) is located at index 0;
 * the value of a node located at index K is A[K];
 * if the value of a node is −1 then it is the last node of the list;
 * otherwise, the successor of a node located at index K is located at index A[K] (you can assume that A[K] is a valid index, that is 0 ≤ A[K] < N).
 * For example, for array A such that:
 * 
 * A[0] = 1
 * A[1] = 4
 * A[2] = -1
 * A[3] = 3
 * A[4] = 2
 * 
 * 
 * the following list is constructed:
 * 
 * the first node (the head) is located at index 0 and has a value of 1;
 * the second node is located at index 1 and has a value of 4;
 * the third node is located at index 4 and has a value of 2;
 * the fourth node is located at index 2 and has a value of −1.
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty array A consisting of N integers, returns the length of the list constructed from A in the above manner.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 1
 * A[1] = 4
 * A[2] = -1
 * A[3] = 3
 * A[4] = 2
 * the function should return 4, as explained in the example above.
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..200,000];
 * each element of array A is an integer within the range [−1..N-1];
 * it will always be possible to construct the list and its length will be finite.
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 * 
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 * 
 * 도착 목록Len
 * 배열로 인코딩된 단일 링크 목록의 길이를 계산합니다.
 * 
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 제공됩니다.
 * 
 * 배열 A는 연결 목록을 나타냅니다. 목록은 다음과 같이 이 배열에서 구성됩니다.
 * 
 * 첫 번째 노드(헤드)는 인덱스 0에 있습니다.
 * 인덱스 K에 있는 노드의 값은 A[K]입니다.
 * 노드의 값이 -1이면 목록의 마지막 노드입니다.
 * 그렇지 않으면 인덱스 K에 있는 노드의 후속 노드는 인덱스 A[K]에 있습니다(A[K]가 유효한 인덱스, 즉 0 ≤ A[K] < N이라고 가정할 수 있음).
 * 예를 들어 다음과 같은 배열 A의 경우:
 * 
 * A[0] = 1
 * A[1] = 4
 * A[2] = -1
 * A[3] = 3
 * A[4] = 2
 * 
 * 
 * 다음 목록이 구성됩니다.
 * 
 * 첫 번째 노드(헤드)는 인덱스 0에 있고 값이 1입니다.
 * 두 번째 노드는 인덱스 1에 있고 값이 4입니다.
 * 세 번째 노드는 인덱스 4에 있으며 값이 2입니다.
 * 네 번째 노드는 인덱스 2에 위치하며 값이 -1입니다.
 * 함수 작성:
 * 
 * 클래스 솔루션 { 공개 int 솔루션(int[] A); }
 * 
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 주어지면 위의 방식으로 A에서 구성된 목록의 길이를 반환합니다.
 * 
 * 예를 들어, 주어진 배열 A는 다음과 같습니다.
 * 
 * A[0] = 1
 * A[1] = 4
 * A[2] = -1
 * A[3] = 3
 * A[4] = 2
 * 함수는 위의 예에서 설명한 대로 4를 반환해야 합니다.
 * 
 * 다음과 같이 가정합니다.
 * 
 * N은 [1..200,000] 범위 내의 정수입니다.
 * 배열 A의 각 요소는 [−1..N-1] 범위 내의 정수입니다.
 * 목록을 구성하는 것은 항상 가능하며 그 길이는 유한합니다.
 * 솔루션에서 정확성에 중점을 둡니다. 솔루션의 성능은 평가의 초점이 아닙니다.
 * 
 * 저작권 2009–2022 by Codility Limited. 판권 소유. 무단 전재, 출판, 공개를 금합니다.
 */
package com.codility.app.exam;

public class ArrListLen {

	public static void main(String[] args) {
		ArrListLen arrListLen = new ArrListLen();
		
		int[] A = {1,4,0,-1,3,2};
		int len = arrListLen.solution(A);
		System.out.println(len);
	}
	
	/**
	 * 
	 * <b class="comment_method">solution</b><br/>
	 * <pre>
	 * 주어진 배열 A 의 원소가 다음 배열의 좌표인데, 그 결과값이 -1 이 될때까지의 값을 구할 것
	 * </pre>
	 * <hr>
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
		
		int i = 0;
		int count = 1;
		while (true) {
			if (A[i] == -1) {
				break;
			} else {
				i = A[i];
				count++;				
			}
		}

		return count;
	}
}
