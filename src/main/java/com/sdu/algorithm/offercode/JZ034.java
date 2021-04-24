package com.sdu.algorithm.offercode;

public class JZ034 {

  private static int FirstNotRepeatingChar(String str) {
    if(str == null || str.length() == 0) {
      return -1;
    }
    int[] count = new int[256];
    for(int i = 0; i < str.length(); i++) {
      count[str.charAt(i)]++;
    }

    for(int i = 0; i < str.length(); i++) {
      if(count[str.charAt(i)] == 1) {
        return i;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(FirstNotRepeatingChar(null));
    System.out.println(FirstNotRepeatingChar("IamIbm"));
    System.out.println(FirstNotRepeatingChar("IbmIbm"));
  }

}
