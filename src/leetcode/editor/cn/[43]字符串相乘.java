package leetcode.editor.cn;
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
// Related Topics 数学 字符串 模拟 
// 👍 1140 👎 0


import java.math.BigDecimal;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution43 {

    public static void main(String[] args) {
//        System.out.println(new Solution().add("1368", "9120"));
//        System.out.println(new Solution43().mul("342340596", 6));
//        System.out.println(new Solution().multiply("123", "456"));
//        System.out.println(new BigDecimal("311213123").multiply(new BigDecimal("2132")));
//        System.out.println();
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        String ans = "0";
        StringBuilder t = new StringBuilder();
        for (int i = m - 1; i >= 0; i--) {
            int k = num1.charAt(i) - '0';
            System.out.println(ans);
            ans = add(ans, mul(num2, k) + t.toString());
            System.out.println(ans);
            t.append("0");
        }
        return ans;
    }

    public String mul(String num1, int k) {
        int n = num1.length();
        StringBuilder ans = new StringBuilder();
        int cin = 0;
        for (int i = n - 1; i >= 0; i--) {
            int num = num1.charAt(i) - '0';
            ans.insert(0, (num * k + cin) % 10);
            cin = (num * k + cin) / 10;
        }
        if (cin > 0) {
            ans.insert(0, cin);
        }
//        System.out.println(ans.toString());
        return ans.toString();
    }

    public String add(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int i = m - 1, j = n - 1;
        //表示进位
        int cin = 0;
        //记录结果
        StringBuilder ans = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int x = num1.charAt(i) - '0';
            int y = num2.charAt(j) - '0';
            ans.insert(0, (x + y + cin) % 10);
            cin = (x + y + cin) / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            int x = num1.charAt(i) - '0';
            ans.insert(0, (x + cin) % 10);

            cin = (x + cin) / 10;

            i--;
        }
        while (j >= 0) {
            int y = num2.charAt(j) - '0';
            ans.insert(0, (y + cin) % 10);
            cin = (y + cin) / 10;
            j--;
        }
        if (cin > 0) {
            ans.insert(0, cin);
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
