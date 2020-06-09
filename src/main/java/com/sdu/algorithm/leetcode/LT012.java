package com.sdu.algorithm.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class LT012 {

  private static String dfs(TreeMap<Integer, String> treeMap, int num) {
    if (num <= 0 ) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    Map.Entry<Integer, String> entry = treeMap.floorEntry(num);
    assert entry != null;
    sb.append(entry.getValue());
    sb.append(dfs(treeMap, num - entry.getKey()));
    return sb.toString();
  }

  private static String intToRoman(int num) {
    TreeMap<Integer, String> map = new TreeMap<>();
    map.put(1, "I");
    map.put(4, "IV");
    map.put(5, "V");
    map.put(9, "IX");
    map.put(10, "X");
    map.put(40, "XL");
    map.put(50, "L");
    map.put(90, "XC");
    map.put(100, "C");
    map.put(400, "CD");
    map.put(500, "D");
    map.put(900, "CM");
    map.put(1000, "M");

    return dfs(map, num);
  }

  private static String intToRoman1(int num) {
    int[] numbers = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    StringBuilder sb = new StringBuilder();
    while (num != 0) {
      // 找小于等于num的最大数值
      for (int i = 0; i < numbers.length; ++i) {
        if (numbers[i] <= num) {
          sb.append(romans[i]);
          num -= numbers[i];
          break;
        }
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(intToRoman(58));
    System.out.println(intToRoman(1994));

    System.out.println(intToRoman1(58));
    System.out.println(intToRoman1(1994));
  }
}
