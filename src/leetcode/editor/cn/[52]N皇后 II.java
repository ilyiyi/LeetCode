package leetcode.editor.cn;
//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 回溯 
// 👍 412 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] g;
    int ans = 0;

    public static void main(String[] args) {
        System.out.println(new Solution().totalNQueens(8));
    }

    public int totalNQueens(int n) {
        g = new int[n][n];
        dfs(n, 0);
        return ans;
    }

    public void dfs(int n, int row) {
        if (row == n) {
            ans++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (check(row,col,n)) {
                g[row][col] = 1;
                dfs(n,row+1);
                g[row][col] = 0;
            }
        }
    }

    public boolean check(int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (g[i][col] == 1) {
                return false;
            }
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 1 && Math.abs(i - row) == Math.abs(j - col)) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
