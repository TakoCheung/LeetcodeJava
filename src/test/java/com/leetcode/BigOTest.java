package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.leetcode.util.ListNode;

public class BigOTest {
  private BigO bigO = new BigO();
  @Test
  public void testFactorial() {
    assertEquals(24, bigO.factorial(4));
    assertEquals(24, bigO.factorial(4, 1));
  }

  @Test
  public void testFibonacci() {
    assertEquals(0, bigO.fibonacci(0));
    assertEquals(1, bigO.fibonacci(1));
    assertEquals(1, bigO.fibonacci(2));
    assertEquals(2, bigO.fibonacci(3));
    assertEquals(3, bigO.fibonacci(4));
    assertEquals(5, bigO.fibonacci(5));
    assertEquals(8, bigO.fibonacci(6));
    assertEquals(8, bigO.fibonacci(6, 0, 1));
  }

  @Test
  public void testPrintAllFibonacciNums() {
    assertEquals("0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 ", bigO.printAllFibonacciNums(17));
  }

  @Test
  public void testPrintAllFibonacciNumsFast() {
    assertEquals("0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 ", bigO.printAllFibonacciNumsFast(17));
  }

  @Test
  public void testMergeTwoLists() {
    ListNode linkedlist1 = new ListNode(1);
    linkedlist1.next = new ListNode(2);
    linkedlist1.next.next = new ListNode(4);

    ListNode linkedlist2 = new ListNode(1);
    linkedlist2.next = new ListNode(3);
    linkedlist2.next.next = new ListNode(4);

    ListNode mergedListNode = bigO.mergeTwoLists(linkedlist1, linkedlist2);
    assertEquals(1, mergedListNode.val);
    assertEquals(1, mergedListNode.next.val);
    assertEquals(2, mergedListNode.next.next.val);
    assertEquals(3, mergedListNode.next.next.next.val);
    assertEquals(4, mergedListNode.next.next.next.next.val);
    assertEquals(4, mergedListNode.next.next.next.next.next.val);
  }

  @Test
  public void testReverseList() {
    ListNode linkedlist1 = new ListNode(1);
    linkedlist1.next = new ListNode(2);
    linkedlist1.next.next = new ListNode(3);
    linkedlist1.next.next.next = new ListNode(4);
    linkedlist1.next.next.next.next = new ListNode(5);

    ListNode ret = bigO.reverseList(linkedlist1);

    assertEquals(5, ret.val);
    assertEquals(4, ret.next.val);
    assertEquals(3, ret.next.next.val);
    assertEquals(2, ret.next.next.next.val);
    assertEquals(1, ret.next.next.next.next.val);
  }
}
