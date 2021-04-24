package com.sdu.algorithm.leetcode;

public class LT208 {

  private static class TrieNode {
    char val;
    // 标识是否有结束的单词
    boolean hasWord;
    TrieNode[] children;

    TrieNode(char val) {
      this.val = val;
      this.children = new TrieNode[26];
    }
  }

  private static class Trie {

    TrieNode[] root;

    Trie() {
      root = new TrieNode[26];
    }

    private static void buildTrie(TrieNode[] roots, String word, int start) {
      char c = word.charAt(start);
      int pos = c - 'a';
      if (roots[pos] == null) {
        roots[pos] = new TrieNode(c);
      }
      if (start + 1 < word.length()) {
        buildTrie(roots[pos].children, word, start + 1);
      } else {
        roots[pos].hasWord = true;
      }
    }

    void insert(String word) {
      buildTrie(root, word, 0);
    }

    private static boolean childrenEmpty(TrieNode[] children) {
      for (TrieNode child : children) {
        if (child != null) {
          return false;
        }
      }
      return true;
    }

    private static boolean dfs(TrieNode[] roots, String word, int start, boolean prefixMatch) {
      int pos = word.charAt(start) - 'a';
      TrieNode cur = roots[pos];
      if (cur == null) {
        return false;
      }
      if (start + 1 < word.length()) {
        return dfs(roots[pos].children, word, start + 1, prefixMatch);
      }

      if (prefixMatch) {
        return true;
      }

      if (roots[pos].hasWord) {
        return true;
      }

      return childrenEmpty(roots[pos].children);
    }

    boolean search(String word) {
      return dfs(root, word, 0, false);
    }

    boolean startsWith(String prefix) {
      return dfs(root, prefix, 0, true);
    }

  }

  public static void main(String[] args) {
    Trie trie = new Trie();

    trie.insert("apple");
    System.out.println(trie.search("apple"));
    System.out.println(trie.search("app"));
    System.out.println(trie.startsWith("app"));

    trie.insert("app");
    System.out.println(trie.search("app"));

  }

}
