package com.leetcode.problems;

public class RemoveDuplicatesFromSortedArray {

    /**
     * 배열에서 중복되는 숫자가 아닌 값의 수를 리턴
     * @param nums 중복된 수가 있는 숫자 배열
     * @return 중복되는 숫자가 아닌 값
     */
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;

        int result = 1;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[result] = nums[i];
                result++;
            }
        }

        return result;
    }

}
