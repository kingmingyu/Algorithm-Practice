import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] prices) {
        
        // 스택, 가격 인덱스
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> stackIdx = new ArrayDeque<>();
        
        int[] answer = new int[prices.length];
        
        // 유지시간 계산
        for(int i = 0; i < prices.length; i++) {
            int cur = prices[i];
            while(!stack.isEmpty() && stack.peek() > cur) {
                int prev = stack.pop();
                int prevIdx = stackIdx.pop();
                answer[prevIdx] = i - prevIdx;
            }
            stack.push(cur);
            stackIdx.push(i);
        }
        
        while(!stack.isEmpty()) {
            int prev = stack.pop();
            int prevIdx = stackIdx.pop();
            answer[prevIdx] = prices.length - prevIdx - 1;
        }
        
        return answer;
    }
}