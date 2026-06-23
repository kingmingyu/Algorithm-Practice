import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i : scoville) {
            queue.offer(i);
        }
        
        // 처음부터 테스트를 통과하는 경우
        if(queue.peek() >= K) {
            return 0;
        }
        while(queue.size() > 1) {
            answer++;
            
            int s1 = queue.poll();
            int s2 = queue.poll();
            
            queue.offer(s1 + s2 * 2);
            
            if(queue.peek() >= K) {
                return answer;
            }
        }
        return -1;
    }
}