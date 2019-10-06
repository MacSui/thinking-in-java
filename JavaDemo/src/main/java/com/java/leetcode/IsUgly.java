package com.java.leetcode;

import java.util.Scanner;

/**
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 */
public class IsUgly {

    public static boolean isUgly(int num) {
        if (num < 1) return false;
        while(num%2 == 0 ){
            num /=2;
        }
        while(num%3 == 0){
            num /=3;
        }
        while(num%5 ==0){
            num/=5;
        }
        return num == 1;

    }

    public static boolean isUgly2(int num){
        if (num<1) return false;
        if(num==1) return true;
        if (num%2==0) return isUgly2(num/2);
        if (num%3==0) return isUgly2(num/3);
        if (num%5==0) return isUgly2(num/5);
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("请输入num值：");

            int num = scanner.nextInt();
            System.out.println("num="+num);
            System.out.println("isUgly:"+isUgly2(num));
        }
    }


}
