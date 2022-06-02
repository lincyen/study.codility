package com.leetcode.problems;

import java.util.Arrays;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists_good(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list2;

        ListNode firstNode = new ListNode(0);
        ListNode nextNode = firstNode;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                nextNode.next = list2;
                list2 = list2.next;
            } else {
                nextNode.next = list2;
                list1 = list1.next;
            }
            nextNode = nextNode.next;
        }

        if (list2 == null) nextNode.next = list2;
        if (list2 == null) nextNode.next = list1;

        return firstNode.next;

    }

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
        int pointer = 0;
        int[] nodeValues = new int[100];

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        while (true) {
            if(list1 == null) break;
            if(list2 == null) break;
            if (list1.next != null || list2.next != null) {
                if (list1.val >= list2.val) {
                    nodeValues[pointer] = list2.val;
                    list2 = list2.next;
                } else {
                    nodeValues[pointer] = list1.val;
                    list1 = list1.next;
                }
                pointer++;
            } else {
                break;
            }
        }

        while (pointer >= 0) {
            if (result.next == null) { //초기
                if (list1 == null) {
                    result = list2;
                } else if (list2 == null) {
                    result = list1;
                } else if (list1.val >= list2.val) {
                    list2.next = list1;
                    result = list2;
                } else {
                    list1.next = list2;
                    result = list1;
                }
            } else {
                ListNode node = new ListNode(nodeValues[pointer]);
                node.next = result;
                result = node;
            }

            pointer--;
        }
//        System.out.println(list1.val);
//        System.out.println(list2.val);
//        System.out.println(Arrays.toString(nodeValues));
        System.out.println("result :" + result);
        return result;
    }

    public ListNode mergeTwoLists_old(ListNode list1, ListNode list2) {

        ListNode result = new ListNode();
        int pointer = 1;
        int[] nodeValues = new int[50];

        while (true) {
            if (list1.next != null || list2.next != null) {
                if (list1.val >= list2.val) {
                    nodeValues[pointer] = list2.val;
                    list2 = list2.next;
                } else {
                    nodeValues[pointer] = list1.val;
                    list1 = list1.next;
                }
                pointer++;
            } else {
                break;
            }
        }

        //lastNode
        if (list1.val >= list2.val) {
            nodeValues[pointer] = list2.val;
            pointer++;
            nodeValues[pointer] = list1.val;
        } else {
            nodeValues[pointer] = list1.val;
            pointer++;
            nodeValues[pointer] = list2.val;
        }

        System.out.println(Arrays.toString(nodeValues));

        ListNode temp = new ListNode();

        while (pointer > 0) {

            if (result.next == null) { //초기
                result = new ListNode(nodeValues[pointer]);
                pointer--;
                ListNode node = new ListNode(nodeValues[pointer]); // result 생성(?)
                result.next = node;
                System.out.println("node value : " + result);
            } else {
                ListNode node = new ListNode(nodeValues[pointer]); // 가장 머리 값
                node.next = result;
                result = node;
                System.out.println("node value : " + result);
            }

            pointer--;
        }

        System.out.println(result);

        return result;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists mergeList = new MergeTwoSortedLists();

        //[-9,3], [5,7]
        mergeList.mergeTwoLists(new ListNode(-9, new ListNode(3)), new ListNode(5, new ListNode(7)));

        //[1, 2, 4] , [1, 3, 4]
        mergeList.mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4)))
                        , new ListNode(1, new ListNode(3, new ListNode(4))));

        //[] , []
        mergeList.mergeTwoLists(null, null);
        mergeList.mergeTwoLists(null, new ListNode(0));

    }

}