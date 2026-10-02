import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            
            if(cur == '(') {
                stack.push(cur);
            }
            else {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
                else return false;
            }
        }
        
        if(stack.isEmpty()) return true;
        return false;
    }
}