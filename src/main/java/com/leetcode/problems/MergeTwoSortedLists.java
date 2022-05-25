package com.leetcode.problems;

public class MergeTwoSortedLists {

    /**
     * 두개의 정렬된 노드를 하나의 노드로 정렬하기
     * 재귀 호출로 처리(해보려 했으나 실패)
     *
     * The number of nodes in both lists is in the range [0, 50].
     * -100 <= Node.val <= 100
     * Both list1 and list2 are sorted in non-decreasing order.
     *
     * @param list1 {@link ListNode 정렬된 node1}
     * @param list2 {@link ListNode 정렬된 node2}
     * @return 두개의 노드를 정렬한 하나의 node
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode result = new ListNode();

        while (true) {
            if (list1.next != null || list2.next != null) {
                if (list1.val >= list2.val) {
                    result = new ListNode(list2.val, result);
                    System.out.println(result);
                    list2 = list2.next;
                } else {
                    result = new ListNode(list1.val, result);
                    System.out.println(result);
                    list1 = list1.next;
                }
            } else {
                break;
            }
        }

        if (list1.val >= list2.val) {
            result = new ListNode(list2.val, result);
            System.out.println(result);
        } else {
            result = new ListNode(list1.val, result);
            System.out.println(result);
        }

        return result;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists mergeList = new MergeTwoSortedLists();

        //[1, 2, 4] , [1, 3, 4]
        mergeList.mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4)))
                        , new ListNode(1, new ListNode(3, new ListNode(4))));

    }

}

