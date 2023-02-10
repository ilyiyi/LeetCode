package leetcode.editor.cn;//有一个骰子模拟器会每次投掷的时候生成一个 1 到 6 的随机数。
//
// 不过我们在使用它时有个约束，就是使得投掷骰子时，连续 掷出数字 i 的次数不能超过 rollMax[i]（i 从 1 开始编号）。 
//
// 现在，给你一个整数数组 rollMax 和一个整数 n，请你来计算掷 n 次骰子可得到的不同点数序列的数量。 
//
// 假如两个序列中至少存在一个元素不同，就认为这两个序列是不同的。由于答案可能很大，所以请返回 模 10^9 + 7 之后的结果。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2, rollMax = [1,1,2,2,2,3]
//输出：34
//解释：我们掷 2 次骰子，如果没有约束的话，共有 6 * 6 = 36 种可能的组合。但是根据 rollMax 数组，数字 1 和 2 最多连续出现一次，所
//以不会出现序列 (1,1) 和 (2,2)。因此，最终答案是 36-2 = 34。
// 
//
// 示例 2： 
//
// 输入：n = 2, rollMax = [1,1,1,1,1,1]
//输出：30
// 
//
// 示例 3： 
//
// 输入：n = 3, rollMax = [1,1,1,2,2,3]
//输出：181
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5000 
// rollMax.length == 6 
// 1 <= rollMax[i] <= 15 
// 
// Related Topics 数组 动态规划 
// 👍 131 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution1223 {
    static final int mod = 1000000007;

    public int dieSimulator(int n, int[] rollMax) {
        //dp[i][j][k]表示第i次得到点数j一次的可能结果数
        int[][][] dp = new int[n + 1][6][16];
        for (int j = 0; j < 6; j++) {
            dp[1][j][1] = 1;
        }
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 1; k <= rollMax[j]; k++) {
                    for (int l = 0; l < 6; l++) {
                        //点数和j不同
                        if (l != j) {
                            dp[i][l][1] = (dp[i][l][1] + dp[i - 1][j][k]) % mod;
                        } else if (k + 1 <= rollMax[j]) {
                            dp[i][l][k + 1] = (dp[i][l][k + 1] + dp[i - 1][j][k]) % mod;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j <= rollMax[i]; j++) {
                ans = (ans + dp[n][i][j]) % mod;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
