package com.leetcode.problems;

import java.util.Arrays;

public class RemoveElement {

    /**
     * <pre>
     *     다시한번 앞뒤로 풀어 봄
     *     result 는 - 가 될 수 있어 pointer 리턴
     *     pointer 증가는 값 올라갈때만 수행
     * </pre>
     * @param nums 여러 숫자가 있는 배열
     * @param val 삭제해야 하는 숫자
     * @return 중복되는 숫자가 아닌 값의 숫자
     */
    public int removeElement(int[] nums, int val) {
        int pointer = 0;
        int result = nums.length - 1;

        while(pointer <= result) {
            if(nums[pointer] == val){
                if(nums[result] != val) {
                    nums[pointer] = nums[result];
                }
                result--;
            } else {
                pointer++;
            }
        }
        return pointer;
    }

    /**
     * <pre>
     *     nums 에서 val 값을 제거한 나머지 숫자를 리턴
     *     O(1) 을 만족하도록 기존 array 의 값을 변경해야 합니다.
     *
     *     0 <= nums.length <= 100
     *     0 <= nums[i] <= 50
     *     0 <= val <= 100
     *
     * </pre>
     * @param nums 여러 숫자가 있는 배열
     * @param val 삭제해야 하는 숫자
     * @return 중복되는 숫자가 아닌 값의 숫자
     */
    public int removeElement_answer(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int result = 0;

        for (int i : nums) {
            if (i != val) {
                nums[result] = i;
                result++;
            }
        }

        return result;

    }

    /**
     * <pre>
     *     nums 에서 val 값을 제거한 나머지 숫자를 리턴
     *     O(1) 을 만족하도록 기존 array 의 값을 변경해야 합니다.
     *
     *     0 <= nums.length <= 100
     *     0 <= nums[i] <= 50
     *     0 <= val <= 100
     *
     *     뒤에서 오니까 == 일 경우 오류나서 앞에부터 가는 걸로 변경
     * </pre>
     * @param nums 여러 숫자가 있는 배열
     * @param val 삭제해야 하는 숫자
     * @return 중복되는 숫자가 아닌 값의 숫자
     */
    public int removeElement_fail(int[] nums, int val) {

        if (nums.length == 0) return 0;

        int result = nums.length;
        int pointer = 0;
        while (pointer >= result - 1) {

            if (nums[pointer] == val) {
                if (nums[result - 1] == val) {
                    result--;
                }
                nums[pointer] = nums[result];
                result--;
            }
            System.out.println(Arrays.toString(nums));
            pointer++;
        }

        System.out.println("result : " + result);
        return result;
    }

    public static void main(String[] args) {
        new RemoveElement().removeElement(new int[] {1}, 1);
    }
}
