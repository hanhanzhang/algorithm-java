package com.sdu.algorithm.string;

public class LT415 {

  private static String addStrings(String num1, String num2) {
    if (num1 == null || num1.isEmpty()) {
      return num2;
    }
    if (num2 == null || num2.isEmpty()) {
      return num1;
    }

    char[] sums = new char[Math.max(num1.length(), num2.length()) + 1];

    int len1 = num1.length();
    int len2 = num2.length();
    int pos = sums.length - 1;
    int carry = 0;

    int i = 1;
    for (; ; ++i) {
      int np1 = len1 - i;
      int np2 = len2 - i;
      if (np1 < 0 || np2 < 0) {
        break;
      }
      int temp = num1.charAt(np1) + num2.charAt(np2) - 2 * '0' + carry;
      sums[pos--] = (char) (temp % 10 + '0');
      carry = temp / 10;
    }

    if (len1 - i < 0 && len2 -i < 0) {
      if (carry > 0) {
        sums[0] = (char) (carry + '0');
      }
    } else {
      String remain = len1 - i < 0 ? num2 : num1;
      int len = remain.length();
      for (; ; ++i) {
        int np = len - i;
        if (np < 0) {
          break;
        }
        int temp = remain.charAt(np) - '0' + carry;
        sums[pos--] = (char) (temp % 10 + '0');
        carry = temp / 10;
      }
      if (carry > 0) {
        sums[0] = (char) (carry + '0');
      }
    }

    return carry > 0 ? new String(sums)
                     : new String(sums, 1, sums.length - 1);
  }

  public static void main(String[] args) {
    System.out.println(addStrings("12", "23"));
    System.out.println(addStrings("12", "99"));
  }

}
