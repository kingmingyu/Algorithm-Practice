import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long q1S = 0;
        long q2S = 0;
        
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        
        for(int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q1S += queue1[i];
        }
        for(int i = 0; i < queue2.length; i++) {
            q2.offer(queue2[i]);
            q2S += queue2[i];
        }
        
        if((q1S + q2S) % 2 == 1) return -1;
        if(q1S == q2S) return 0;
        
        int answer = 0;
        while(q1S != q2S) {
            if(q1S > q2S) {
                int curQ1 = q1.poll();
                q1S -= curQ1; q2S += curQ1;
                q2.offer(curQ1);
            }
            else {
                int curQ2 = q2.poll();
                q2S -= curQ2; q1S += curQ2;
                q1.offer(curQ2);
            }
            answer++;
            if(q1.isEmpty() || q2.isEmpty()) return -1;
            if(answer > 2 * (queue1.length + queue2.length)) return -1;
        }
        
        return answer;
    }
}