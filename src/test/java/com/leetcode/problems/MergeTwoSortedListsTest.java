package com.leetcode.problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsTest {

    @Test
    void mergeTwoLists() {
        MergeTwoSortedLists mergeList = new MergeTwoSortedLists();

        assertEquals(mergeList.mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4)))
                , new ListNode(1, new ListNode(3, new ListNode(4))))
                , new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4)))))));
        assertEquals(mergeList.mergeTwoLists(new ListNode(), new ListNode()), new ListNode());
        assertEquals(mergeList.mergeTwoLists(new ListNode(), new ListNode(0)), new ListNode(0));

    }
}