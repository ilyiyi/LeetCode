package leetcode.editor.cn;
//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
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
// Related Topics 数组 回溯 
// 👍 1630 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution51 {

    List<List<String>> ans = new ArrayList<>();
    char[][] g;


    public static void main(String[] args) {
        System.out.println(new Solution51().solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        g = new char[n][n];
        for (char[] chars : g) {
            Arrays.fill(chars, '.');
        }
        dfs(n, 0);
        return ans;
    }


    public void dfs(int n, int row) {
        if (row == n) {
            ans.add(temp(g));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (check(row, col, n)) {
                g[row][col] = 'Q';
                dfs(n, row + 1);
                g[row][col] = '.';
            }
        }
    }

    public boolean check(int row, int col, int n) {
        //第一行可以直接放，从第二行开始要判断是否可以放
        for (int i = 0; i < row; i++) {
            if (g[i][col] == 'Q') {
                return false;
            }
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 'Q' && Math.abs(i - row) == Math.abs(j - col)) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<String> temp(char[][] g) {
        List<String> path = new ArrayList<>();
        for (char[] arr : g) {
            path.add(new String(arr));
        }
        return path;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
