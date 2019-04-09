package com.example.main;

import org.apache.commons.lang.text.StrBuilder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class T {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }


    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        char[] chars = S.toCharArray();
        String ans = "";
        for (char ch : chars) {
            switch (ch) {
                case '(':
                    if (!stack.empty()) {
                        ans = ans.concat(String.valueOf(ch));
                    }
                    stack.push('(');
                    continue;
                case ')':
                    stack.pop();
                    break;
            }
            if (!stack.empty()) {
                ans = ans.concat(String.valueOf(ch));
            }
        }
        return ans;
    }


    public int sumRootToLeaf(TreeNode root) {
        if (root == null)
            return 0;
        return helper(root, 0);
    }

    private int helper(TreeNode root, int curVal) {
        if (root == null)
            return 0;
        int nextVal = 2 * curVal + root.val;

        if (root.left == null && root.right == null) {
            return nextVal;
        }

        int l = helper(root.left, nextVal);
        int r = helper(root.right, nextVal);
        return l + r;
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new LinkedList<>();
        List<String> patternStrList = new LinkedList<>();
        StrBuilder tmp = new StrBuilder();
        for (char ch : pattern.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                patternStrList.add(tmp.toString());
                tmp = new StrBuilder(ch);
            } else {
                tmp.append(ch);
            }
        }
        for (String string : queries) {
            ans.add(isMatch(string, patternStrList));
        }

        return ans;
    }

    private Boolean isMatch(String string, List<String> patternList) {
        int listIndex = -1;
        int strIndex = 0;

        char[] chars = string.toCharArray();
        while (strIndex < string.length()
                && listIndex < patternList.size()) {
            if (Character.isUpperCase(chars[strIndex])) {
                ++listIndex;
                if (listIndex >= patternList.size())
                    return false;
                else {
                    int subIndex = 0;
                    String patStr = patternList.get(listIndex);
                    int patLen = patStr.length();
                    while (strIndex < string.length() && subIndex < patLen) {

                    }

                }
            } else {
                return false;
            }
        }
        return strIndex >= string.length() && listIndex >= patternList.size();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        System.out.println(new T().sumRootToLeaf(root));
    }


}
