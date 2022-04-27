package com.codility.app.binarysearchalgorithm;

import java.util.Arrays;

public class BinarySearch {

	/**
	 * 이진 검색 활용 
	 * @param array 검색할 array
	 * @param key 검색해야 되는 숫자 
	 */
	public void binarySearch(int[] array, int key) {
		
		Arrays.sort(array);
		
		if (array.length == 0) {
			System.out.println("길이가 0");
		} else {			
			int result = binarySearchForRecursion(array, key, 0, array.length -1);
			
			System.out.println("key : " +key + " 의 값은 array[" +result+ "] 에 있습니다.");
			System.out.println("해당 값은 " + array[result] + " 입니다.");
			
			binarySearchForWhile(array, key, 0, array.length-1);
			
			System.out.println("key : " +key + " 의 값은 array[" +result+ "] 에 있습니다.");
			System.out.println("해당 값은 " + array[result] + " 입니다.");
		}
		
		
	}
	
	/**
	 * 
	 * @param array 검색할 array
	 * @param key 검색해야 되는 숫자 
	 * @param minKey array 의 최소값 좌표 
	 * @param maxKey array 의 최대값 좌표 
	 * @return
	 */
	public int binarySearchForRecursion(int[] array, int key, int minKey, int maxKey) {
		int result = -1;
		if (minKey < maxKey) {
			System.out.println("minkey : " + minKey + ", maxkey : " + maxKey);
			int midKey = (minKey + maxKey)/2;
			
			if (key > array[midKey]) {
				
				System.out.println("작은 값 : " + (midKey+1) + " 큰값 : " + maxKey);
				result = binarySearchForRecursion(array, key, midKey+1, maxKey);
			} else if (key < array[midKey]) {
				
				System.out.println("작은 값 : " + minKey + " 큰값 : " + (midKey-1));
				result = binarySearchForRecursion(array, key, minKey, midKey-1);
				
			} else if (key == midKey){
				result = midKey;
			}
			
		} else if(minKey > maxKey){ 
			result = -1;
		} else { //min, max 동일
			result = minKey;
		}
		
		return result;

	}
	
	/**
	 * 
	 * @param array 검색할 array 
	 * @param key 검색해야 되는 숫자 
	 * @param minKey array 의 최소값 
	 * @param maxKey array 의 최대값 
	 * @return
	 */
	public int binarySearchForWhile(int[] array, int key, int minKey, int maxKey) {
		
		int result = 0;
		int midKey = 0;
		while (minKey >= maxKey) {
			midKey = (minKey + maxKey)/2;
			
			if (key > array[midKey]) {
				minKey = midKey -1; 
			} else if (key < array[midKey]) {
				maxKey = midKey+1;
				
			} else if (key == midKey){
				result = midKey;
			}
		}
		
		return result;
	}
}
