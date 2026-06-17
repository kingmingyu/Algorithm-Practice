import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        
        Deque<Character> queue = new LinkedList<>();
        
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(cur == '(') {
                queue.offer(cur);
            }
            else {
                if(!queue.isEmpty()) {
                    if(queue.getLast() == '(') {
                        queue.poll();
                    }
                }
                else {
                    return false;
                }
            }
        }

        if(!queue.isEmpty()) {
            return false;
        }
        return true;
    }
}