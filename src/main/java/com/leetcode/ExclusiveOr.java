package com.leetcode;


public class ExclusiveOr {
  //https://leetcode.com/problems/single-number/
  public int singleNumber(int[] nums) {
    int xor = 0;
    for (int i : nums) {
      xor ^= i;
    }
    return xor;
  }
  //https://leetcode.com/problems/single-number-iii/
  public int[] singleNumber3(int[] nums) {
    int aXorB = 0;
        for (int i : nums) {
            aXorB ^= i;
        }
        System.out.println(Integer.toBinaryString(aXorB));
        int rightMostOne = aXorB & (~aXorB + 1);
        int firstNum = 0;
        for (int cur : nums) {
            if ((cur & rightMostOne) == 1) {
                firstNum ^= cur;
            }
        }
        return new int[] { firstNum, aXorB ^ firstNum };
  }
}
