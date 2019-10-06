package com.java.leetcode;

import static jdk.nashorn.internal.objects.NativeMath.min;

/**
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 */
public class nthUglyNumber {


    public static void main(String[] args) {
        int n = 17;
        System.out.printf("the %s ugly number is：%s", n, nthUglyNumber2(n));
    }

    public static int nthUglyNumber(int n){
        int[] dp = new int[n];
        dp[0] = 1;
        int i2=0, i3=0, i5=0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[i2]*2, Math.min(dp[i3]*3, dp[i5]*5));
            if (min ==dp[i2]*2) i2++;
            if (min == dp[i3]*3) i3++;
            if (min == dp[i5]*5) i5++;
            dp[i] = min;
        }
        return dp[n-1];

    }

    public static int nthUglyNumber2(int n){
        int[] dp = new int[n];
        dp[0] = 1;
        int i2=0, i3=0, i5=0;
        int count = 1;
        while(count<n){
            int num2 = dp[i2]*2;
            int num3 = dp[i3]*3;
            int num5 = dp[i5]*5;
            int min = min(num2, num3, num5);
            if (min == num2) i2++;
            if (min == num3) i3++;
            if (min == num5) i5++;
            dp[count++] = min;
        }
        return dp[n-1];
    }

    public static int min(int num2, int num3, int num5){
        int min = num2>num3? num3: num2;
        return min>num5? num5:min;
    }

}
