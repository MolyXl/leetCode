package stack;//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1890 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Stack {
    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> pair = new HashMap<>(3);
        pair.put('(', ')');
        pair.put('[', ']');
        pair.put('{', '}');
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (deque.isEmpty()) {
                if(!pair.containsKey(c)){
                    return false;
                }
                deque.add(c);
            } else {
                if (!pair.containsKey(c)) {
                    Character first = deque.getLast();
                    Character character = pair.get(first);
                    if (!character.equals(c)) {
                        return false;
                    }else {
                        deque.removeLast();
                    }
                }else{
                    deque.add(c);
                }
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        boolean valid = isValid("))");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
