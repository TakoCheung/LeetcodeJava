package com.leetcode;

import java.util.HashMap;
import java.util.Map;

import com.leetcode.util.ListNode;

public class BigO {
  public int factorial(int n) {// 1^n
    if (n < 0)
      return -1;
    else if (n == 0)
      return 1;
    else
      return n * factorial(n - 1);
  }

  public int fibonacci(int n) {// 2^n
    if (n <= 0)
      return 0;
    else if (n == 1)
      return 1;
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  public int fibonacci(int n, Map<Integer, Integer> hashmap) {// 2^n
    if (n <= 0)
      return 0;
    else if (n == 1)
      return 1;
    else if (hashmap.containsKey(n)) {
      return hashmap.get(n);
    }
    hashmap.put(n, fibonacci(n - 1) + fibonacci(n - 2));
    return hashmap.get(n);
  }

  public String printAllFibonacciNums(int n) { // n * 2^n
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(fibonacci(i) + " ");
    }
    return sb.toString();
  }

  public String printAllFibonacciNumsFast(int n) { // n * 2^n
    Map<Integer, Integer> hashmap = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(fibonacci(i, hashmap) + " ");
    }
    return sb.toString();
  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null || list2 == null) {
      return list1 == null ? list2 : list1;
    }
    ListNode ret = new ListNode();
    ListNode cur = ret;
    while (list1 != null && list2 != null) {
      if (list1.val > list2.val) {
        cur.next = list2;
        list2 = list2.next;
      } else {
        cur.next = list1;
        list1 = list1.next;
      }
      cur = cur.next;
    }
    cur.next = (list1 != null) ? list1 : list2;
    return ret.next;
  }

  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode current = head;

    while (current != null) {
      ListNode next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }

  public ListNode reverseListR(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = reverseListR(head.next);
    ListNode nxt = head.next;
    nxt.next = head;
    head.next = null;
    return newHead;
  }

  public int hammingWeight(int n) {
    int ret = 0;
    for (int i = 0; i < 32; i++) {
      ret += n >> i & 1;
    }
    return ret;
  }

}
