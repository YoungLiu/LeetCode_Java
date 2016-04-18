/*Implement a trie with insert, search, and startsWith methods.

        Note:
        You may assume that all inputs are consist of lowercase letters a-z.*/

package com.computinglife.leetcode.medium;

import java.util.HashMap;

/**
 * Created by youngliu on 2/21/16.
 */
public class ImplementTrie {
    class TrieNode {
        char c;
        boolean isLeaf;
        HashMap<Character, TrieNode> children = new HashMap<>();

        // Initialize your data structure here.
        public TrieNode() {
        }

        public TrieNode(char c) {
            this.c = c;
        }
    }

    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.children;

            if (i == word.length() - 1) {
                t.isLeaf = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);
        if (t != null && t.isLeaf) {
            return true;
        } else {
            return false;
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        HashMap<Character,TrieNode> children = root.children;
        TrieNode t = null;
        for(int i = 0;i<prefix.length();i++){
            if(children.containsKey(prefix.charAt(i))){
                t = children.get(prefix.charAt(i));
                children = t.children;
            }else{
                return false;
            }
        }
        return true;
    }

    private TrieNode searchNode(String str) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (int i = 0; i < str.length(); i++) {
            if (children.containsKey(str.charAt(i))) {
                t = children.get(str.charAt(i));
                children = t.children;
            } else {
                return null;
            }
        }
        return t;
    }
}
