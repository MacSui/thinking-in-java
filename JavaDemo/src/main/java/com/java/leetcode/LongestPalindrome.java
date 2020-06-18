package com.java.leetcode;

import com.sun.deploy.util.StringUtils;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String str = "cbbd";
        System.out.printf("the longest palindrome of %s is %s \n", str, longestPalindrome(str));
    }

    public static String longestPalindrome(String s){
        if (s==null || s.length()==0){
            return "";
        }
        if (s.length()==1) return s;
        String palindrome = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length()-1; i++) {
            boolean isPalindrome = true;
            String substring = "";
            if (palindrome.length()>0 && i+palindrome.length()<s.length()){
                substring = s.substring(i, i+palindrome.length());
                isPalindrome = isPalindrome(substring);
            }else {

                int count = i+1;
                while (s.indexOf(chars[i], count)>0){
                    isPalindrome = true;
                    substring = s.substring(i, s.indexOf(chars[i], count)+1);
                    if (isPalindrome(substring) && substring.length()>=palindrome.length()){
                        palindrome = substring;
                    }
                    count++;
                }
            }

            if (palindrome.length()<1){
                palindrome = String.valueOf(s.charAt(i));
            }

        }
        return palindrome;
    }

    public static boolean isPalindrome(String substring){
        boolean isPalindrome = true;
        for (int j = 0; j < substring.length() / 2; j++) {
            if (substring.charAt(j) != substring.charAt(substring.length()-j-1)){
                isPalindrome=false;
                break;
            }
        }
        return isPalindrome;
    }


}
