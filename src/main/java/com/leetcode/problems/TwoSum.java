/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * 
 * 정수 배열 nums와 정수 대상이 주어지면 두 숫자의 인덱스를 반환하여 대상에 합산되도록 합니다.
 * 
 * 각 입력에 정확히 하나의 솔루션이 있다고 가정할 수 있으며 동일한 요소를 두 번 사용할 수 없습니다.
 * 
 * 어떤 순서로든 답변을 반환할 수 있습니다.
 * 유효한 대답은 하나만 존재합니다.
 * 
 * O(n2) 시간 복잡도보다 작은 알고리즘을 생각해낼 수 있습니까?
 * 
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * 
 * 
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * 
 * 
 * 경우의 수 : (n*n-1)/2
 * }
 */
package com.leetcode.problems;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum sum = new TwoSum();
		
		sum.twoSum(new int[]{3,2,3}, 6);
	}

	public int[] x_twoSum(int[] nums, int target) {
		int[] result = new int[2];

		for (int i = 0; i < nums.length; i++) {
			int j = i+1;
			if ((nums.length - 1) > j) {
				if ((nums[i] + nums[j]) == target) {
					result[0] = i;
					result[1] = j;
					break;
				} else {
			//		j++;
				}
			}			
		}

		return result;

	}
	
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];

		int i = 0;
		int j = i+1;
		
		while (i < j) {
			
			if (nums[i] + nums[j] == target) {
				result[0] = i;
				result[1] = j;
				break;
			} else {
				if(j >= nums.length -1) {
					i++;
					j=i+1;
				} else {
					j++;
				}
			}
		}

		return result;

	}

}
