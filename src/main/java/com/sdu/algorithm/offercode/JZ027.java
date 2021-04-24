package com.sdu.algorithm.offercode;

import java.util.ArrayList;
import java.util.HashSet;

public class JZ027 {

  private static ArrayList<String> dfs(String str, int[] visited, int pos) {
    if (pos >= str.length()) {
      return null;
    }
    ArrayList<String> ans = new ArrayList<>();
    HashSet<Character> appears = new HashSet<>();
    for (int i = 0; i < str.length(); ++i) {
      if (visited[i] == 1 || !appears.add(str.charAt(i))) {
        continue;
      }
      visited[i] = 1;
      ArrayList<String> res = dfs(str, visited, pos + 1);
      if (res != null) {
        for (String child : res) {
          StringBuilder sb = new StringBuilder();
          sb.append(str.charAt(i));
          sb.append(child);
          ans.add(sb.toString());
        }
      } else {
        ans.add(new String(new char[] {str.charAt(i)}));
      }
      visited[i] = 0;
    }
    return ans;
  }

  private static ArrayList<String> Permutation(String str) {
    return dfs(str, new int[str.length()], 0);
  }

  public static void main(String[] args) {
    ArrayList<String> ans = Permutation("abc");
    System.out.println(ans);
    System.out.println("*******************");

    ArrayList<String> ans1 = Permutation("aa");
    System.out.println(ans1);
  }

}
