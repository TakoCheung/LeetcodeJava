package com.leetcode;

import java.util.HashMap;
import java.util.Map;

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
    else if (hashmap.containsKey(n)){
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

}
