package com.example.丢玻璃球;

import java.util.Scanner;

/**
 * 一个100层的大厦，你手中有两个相同的玻璃球。从这个大厦的某一层扔下围棋
 * 子就会碎，用你手中的这两个玻璃围棋子，找出一个最优的策略，来得知那个临界层面。
 * F(N) = min{ max(1(碎了), F(N - 1) + 1(没碎)), max(2, F(N - 2) + 1), max(3, F(N - 3) + 1), …… , max(N - 1, F(1))
 *  设F(n,k)为用k个玻璃球来测试n层大厦的临界层的最少次数，状态转移方程如下：
 *     F(n,k)=min{max{F(r,k-1), F(n-r,k)}+1, 1<=r<=n}
 *     边界条件:F(n,1)=n-1, F(1,k)=F(0,k)=0
 *     状态转移方程可以这样来考虑，假设在n层楼中的第r层抛一次(对应方程中的"+1")，会有两种情况发生：
 *     (1)玻璃球碎，说明在第1到第r层楼中必有一层为临界层，问题转化为一个子问题：求F(r,k-1)
 *     (2)玻璃球不碎，说明临界层在第r+1层到第n层这n-r层楼中，问题转化为子问题:求F(n-r,k)
 *     因为考虑的是最坏情况下抛球策略的所需测试次数的最小值，所以取这两种情况中的较大值，并遍历每一个可能的r，取其最小值即得到F(n,k)。
 */
public class Solution {
    public static void main(String[] args) {
        int N = 0;
        Scanner scanner = new Scanner(System.in);
        while (N < 1) {
            N = scanner.nextInt();
        }

        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; ++i) {
            int min = i;
            for (int j = 1; j < i; ++j) {
                int tmp = Math.max(j, dp[i - j] + 1);
                if (tmp < min) {
                    min = tmp;
                }
            }
            dp[i] = min;
        }

        System.out.println(dp[N]);
    }
}
