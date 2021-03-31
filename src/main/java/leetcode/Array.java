package main.java.leetcode;

import java.util.Arrays;

public class Array {
    /**
     * 斐波那契数列
     * 自下而上
     * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
     */
    public int fib(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int prev = 1;
        int curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = (prev + curr) % 1000000007;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

    /**
     * 斐波那契数列 自上而下
     */
    // public int fib(int n) {
    //     if (n == 0 || n == 1) {
    //         return n;
    //     }
    //     int[] notes = new int[n + 1];
    //     return fib(n, notes);
    // }
    //
    // public int fib(int n, int[] notes) {
    //     if (n == 0 || n == 1) {
    //         return n;
    //     }
    //     int note = notes[n];
    //     if (note != 0) {
    //         return note;
    //     }
    //     notes[n] = (fib(n - 1, notes) + fib(n - 2, notes)) % 1000000007;
    //     return notes[n];
    // }


    /**
     * 零钱兑换
     * 自下而上
     * https://leetcode-cn.com/problems/coin-change/
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // 总金额小于面值
                if (i < coin) {
                    continue;
                }
                // 总金额大于等于面值，则取[总金额-当前面值]结果+1
                memo[i] = Math.min(memo[i], 1 + memo[i - coin]);
            }
        }
        return memo[amount] = memo[amount] == amount + 1 ? -1 : memo[amount];
    }
}
