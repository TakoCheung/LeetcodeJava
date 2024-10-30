package com.sorting;

public class Quick {
  /*
   * T(N) = a*T(N/b) + O(N^d)
   * 
   * when log(b,a) > d => O(N^log(b,a))
   * when log(b,a) = d => O(N^d * log(2,N))
   * when log(b,a) < d => O(N^d)
   * 
   * Time: O(NlgN) | Space: O(lgN) | Preserve Order: No
   */
  public static void sort(int[] toBeSorted) {
    if (toBeSorted == null || toBeSorted.length < 2) {
      return;
    }
    sort(toBeSorted, 0, toBeSorted.length - 1);
  }
  //T(N) = 2*T(N/2) + O(N) a = 2 b = 2 d = 1 => O(N*lgN)
  private static void sort(int[] toBeSorted, int start, int end){
    if(start < end){
      int randomPivot = start + (int)(Math.random()*(end-start+1));
      Util.swap(toBeSorted, randomPivot, end);
      int[] partition = partition(toBeSorted, start, end);
      sort(toBeSorted, start, partition[0] - 1);//less than partition
      sort(toBeSorted, partition[1] + 1,  end);//greater than partition
    }
  }

  private static int[] partition(int[] toBePartitioned, int left, int right) {
    int leftBoundary = left -1;
    int rightBoundary = right;
    while (left < rightBoundary) {
      if(toBePartitioned[left] < toBePartitioned[right]){
        Util.swap(toBePartitioned, ++leftBoundary, left++);
      }else if(toBePartitioned[left] > toBePartitioned[right]){
        Util.swap(toBePartitioned, --rightBoundary, left);
      }else{
        left++;
      }
    }
    Util.swap(toBePartitioned, rightBoundary, right);
    return new int[]{leftBoundary+1, rightBoundary};
  }
}