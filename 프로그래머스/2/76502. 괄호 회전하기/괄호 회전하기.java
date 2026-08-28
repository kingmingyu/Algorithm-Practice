import java.util.*;
import java.io.*;

class Solution {
    static int cnt = 0;
    public int solution(String s) {
        
        for(int i = 0; i < s.length(); i++) {
            String tc = s.substring(i, s.length()) + s.substring(0, i);
            check(tc);
        }
        
        return cnt;
    }
    
    public static void check(String tc) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0; i < tc.length(); i++) {
            char cur = tc.charAt(i);
            
            if(cur == '(' || cur == '{' || cur == '[') {
                stack.push(cur);
            }
            else {
                if(stack.isEmpty()) return;
                
                if(cur == ')') {
                    if(stack.pop() != '(') {
                        return;
                    }
                }
                else if(cur == '}') {
                    if(stack.pop() != '{') {
                        return;
                    }
                }
                if(cur == ']') {
                    if(stack.pop() != '[') {
                        return;
                    }
                }
            }
        }
        if(stack.isEmpty()) {
            cnt++;
            return;
        }
        else {
            return;
        }
    }
}