//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 1705 👎 0


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            //栈不为空,且栈顶元素小于当前值
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                //移除栈顶元素
                int curIdx = stack.pop();
                //栈不为空,且栈顶元素等于当前值
                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
                    //移除栈顶元素
                    stack.pop();
                }
                //栈不为空
                if (!stack.isEmpty()) {
                    //取栈顶元素
                    int stackTop = stack.peek();
                    //
                    ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
                }
            }
            stack.add(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] height = {0, 2, 0, 0, 2, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap(height);
        System.out.println(trap);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
